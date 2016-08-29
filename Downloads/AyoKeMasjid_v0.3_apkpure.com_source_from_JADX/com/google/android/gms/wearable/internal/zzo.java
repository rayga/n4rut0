package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzo extends InputStream {
    private final InputStream zzaZY;
    private volatile zzl zzaZZ;

    /* renamed from: com.google.android.gms.wearable.internal.zzo.1 */
    class C08471 implements zzt {
        final /* synthetic */ zzo zzbaa;

        C08471(zzo com_google_android_gms_wearable_internal_zzo) {
            this.zzbaa = com_google_android_gms_wearable_internal_zzo;
        }

        public void zzb(zzl com_google_android_gms_wearable_internal_zzl) {
            this.zzbaa.zza(com_google_android_gms_wearable_internal_zzl);
        }
    }

    public zzo(InputStream inputStream) {
        this.zzaZY = (InputStream) zzx.zzv(inputStream);
    }

    private int zzkF(int i) throws ChannelIOException {
        if (i == -1) {
            zzl com_google_android_gms_wearable_internal_zzl = this.zzaZZ;
            if (com_google_android_gms_wearable_internal_zzl != null) {
                throw new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzl.zzaZP, com_google_android_gms_wearable_internal_zzl.zzaZQ);
            }
        }
        return i;
    }

    public int available() throws IOException {
        return this.zzaZY.available();
    }

    public void close() throws IOException {
        this.zzaZY.close();
    }

    public void mark(int readlimit) {
        this.zzaZY.mark(readlimit);
    }

    public boolean markSupported() {
        return this.zzaZY.markSupported();
    }

    public int read() throws IOException {
        return zzkF(this.zzaZY.read());
    }

    public int read(byte[] buffer) throws IOException {
        return zzkF(this.zzaZY.read(buffer));
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzkF(this.zzaZY.read(buffer, byteOffset, byteCount));
    }

    public void reset() throws IOException {
        this.zzaZY.reset();
    }

    public long skip(long byteCount) throws IOException {
        return this.zzaZY.skip(byteCount);
    }

    zzt zzCD() {
        return new C08471(this);
    }

    void zza(zzl com_google_android_gms_wearable_internal_zzl) {
        this.zzaZZ = (zzl) zzx.zzv(com_google_android_gms_wearable_internal_zzl);
    }
}
