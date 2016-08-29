package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;

public final class PlatformType {
    private PlatformType() {
    }

    public static String zzfQ(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "ANDROID";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "IOS";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
