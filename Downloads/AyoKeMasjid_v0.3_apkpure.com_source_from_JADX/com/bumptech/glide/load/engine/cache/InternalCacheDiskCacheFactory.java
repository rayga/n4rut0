package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import java.io.File;

public final class InternalCacheDiskCacheFactory implements Factory {
    private final Context context;
    private final String diskCacheName;
    private final int diskCacheSize;

    public InternalCacheDiskCacheFactory(Context context, int diskCacheSize) {
        this(context, null, diskCacheSize);
    }

    public InternalCacheDiskCacheFactory(Context context, String diskCacheName, int diskCacheSize) {
        this.context = context;
        this.diskCacheName = diskCacheName;
        this.diskCacheSize = diskCacheSize;
    }

    public DiskCache build() {
        File cacheDir;
        DiskCache diskCache = null;
        if (this.diskCacheName != null) {
            cacheDir = Glide.getPhotoCacheDir(this.context, this.diskCacheName);
        } else {
            cacheDir = Glide.getPhotoCacheDir(this.context);
        }
        if (cacheDir != null) {
            diskCache = DiskLruCacheWrapper.get(cacheDir, this.diskCacheSize);
        }
        if (diskCache == null) {
            return new DiskCacheAdapter();
        }
        return diskCache;
    }
}
