package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SafeKeyGenerator {
    private final LruCache<Key, String> loadIdToSafeHash;

    SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE);
    }

    public String getSafeKey(Key key) {
        String safeKey;
        synchronized (this.loadIdToSafeHash) {
            safeKey = (String) this.loadIdToSafeHash.get(key);
        }
        if (safeKey == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                key.updateDiskCacheKey(messageDigest);
                safeKey = Util.sha256BytesToHex(messageDigest.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.loadIdToSafeHash) {
                this.loadIdToSafeHash.put(key, safeKey);
            }
        }
        return safeKey;
    }
}
