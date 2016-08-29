package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.DiskLruCache.Editor;
import com.bumptech.glide.disklrucache.DiskLruCache.Value;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator;

    static {
        wrapper = null;
    }

    public static synchronized DiskCache get(File directory, int maxSize) {
        DiskCache diskCache;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(directory, maxSize);
            }
            diskCache = wrapper;
        }
        return diskCache;
    }

    protected DiskLruCacheWrapper(File directory, int maxSize) {
        this.directory = directory;
        this.maxSize = maxSize;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, VALUE_COUNT, VALUE_COUNT, (long) this.maxSize);
        }
        return this.diskLruCache;
    }

    public File get(Key key) {
        File result = null;
        try {
            Value value = getDiskCache().get(this.safeKeyGenerator.getSafeKey(key));
            if (value != null) {
                result = value.getFile(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to get from disk cache", e);
            }
        }
        return result;
    }

    public void put(Key key, Writer writer) {
        Editor editor;
        try {
            editor = getDiskCache().edit(this.safeKeyGenerator.getSafeKey(key));
            if (editor != null) {
                if (writer.write(editor.getFile(0))) {
                    editor.commit();
                }
                editor.abortUnlessCommitted();
            }
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to put to disk cache", e);
            }
        } catch (Throwable th) {
            editor.abortUnlessCommitted();
        }
    }

    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e);
            }
        }
    }
}
