package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzp extends OutputStream {
    private volatile zzl zzaZZ;
    private final OutputStream zzbab;

    /* renamed from: com.google.android.gms.wearable.internal.zzp.1 */
    class C08481 implements zzt {
        final /* synthetic */ zzp zzbac;

        C08481(zzp com_google_android_gms_wearable_internal_zzp) {
            this.zzbac = com_google_android_gms_wearable_internal_zzp;
        }

        public void zzb(zzl com_google_android_gms_wearable_internal_zzl) {
            this.zzbac.zzc(com_google_android_gms_wearable_internal_zzl);
        }
    }

    public zzp(OutputStream outputStream) {
        this.zzbab = (OutputStream) zzx.zzv(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzl com_google_android_gms_wearable_internal_zzl = this.zzaZZ;
        if (com_google_android_gms_wearable_internal_zzl == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzl.zzaZP, com_google_android_gms_wearable_internal_zzl.zzaZQ);
    }

    public void close() throws IOException {
        try {
            this.zzbab.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzbab.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzbab.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer) throws IOException {
        try {
            this.zzbab.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzbab.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzt zzCD() {
        return new C08481(this);
    }

    void zzc(zzl com_google_android_gms_wearable_internal_zzl) {
        this.zzaZZ = com_google_android_gms_wearable_internal_zzl;
    }
}
