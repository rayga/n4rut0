package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzy implements zzbh {
    private int zzMQ;

    public zzy() {
        this.zzMQ = 5;
    }

    public void m23e(String message) {
        if (this.zzMQ <= 6) {
            Log.e("GoogleTagManager", message);
        }
    }

    public void setLogLevel(int logLevel) {
        this.zzMQ = logLevel;
    }

    public void m24v(String message) {
        if (this.zzMQ <= 2) {
            Log.v("GoogleTagManager", message);
        }
    }

    public void zzaC(String str) {
        if (this.zzMQ <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void zzaD(String str) {
        if (this.zzMQ <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzaE(String str) {
        if (this.zzMQ <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzb(String str, Throwable th) {
        if (this.zzMQ <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzd(String str, Throwable th) {
        if (this.zzMQ <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
