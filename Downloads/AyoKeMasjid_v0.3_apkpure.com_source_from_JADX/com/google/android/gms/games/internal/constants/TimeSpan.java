package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;

public final class TimeSpan {
    private TimeSpan() {
        throw new AssertionError("Uninstantiable");
    }

    public static String zzfQ(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "DAILY";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "WEEKLY";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
