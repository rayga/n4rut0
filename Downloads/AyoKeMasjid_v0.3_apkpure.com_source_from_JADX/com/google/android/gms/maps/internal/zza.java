package com.google.android.gms.maps.internal;

import com.google.android.gms.drive.events.CompletionEvent;

public final class zza {
    public static Boolean zza(byte b) {
        switch (b) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return Boolean.FALSE;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte zze(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
