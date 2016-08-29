package com.google.android.gms.cast.internal;

import com.bumptech.glide.load.Key;
import com.google.android.gms.common.api.Api.zzc;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public final class zzk {
    public static final zzc<zze> zzQf;
    public static final String zzXs;
    public static final String zzXt;
    public static final Charset zzXu;

    static {
        zzQf = new zzc();
        zzXs = zzf.zzbM("com.google.cast.receiver");
        zzXt = zzf.zzbM("com.google.cast.tp.connection");
        Charset charset = null;
        try {
            charset = Charset.forName(Key.STRING_CHARSET_NAME);
        } catch (IllegalCharsetNameException e) {
        } catch (UnsupportedCharsetException e2) {
        }
        zzXu = charset;
    }
}
