package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzpm.zza;

@Deprecated
public class zzpl implements zza {
    private final zzpm zzaKC;
    private boolean zzaKD;

    public zzpl(Context context, int i) {
        this(context, i, null);
    }

    public zzpl(Context context, int i, String str) {
        this(context, i, str, null, true);
    }

    public zzpl(Context context, int i, String str, String str2, boolean z) {
        this.zzaKC = new zzpm(context, i, str, str2, this, z, context != context.getApplicationContext() ? context.getClass().getName() : "OneTimePlayLogger");
        this.zzaKD = true;
    }

    private void zzyz() {
        if (!this.zzaKD) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void send() {
        zzyz();
        this.zzaKC.start();
        this.zzaKD = false;
    }

    public void zza(String str, byte[] bArr, String... strArr) {
        zzyz();
        this.zzaKC.zzb(str, bArr, strArr);
    }

    public void zzh(PendingIntent pendingIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + pendingIntent);
    }

    public void zzyA() {
        this.zzaKC.stop();
    }

    public void zzyB() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }
}
