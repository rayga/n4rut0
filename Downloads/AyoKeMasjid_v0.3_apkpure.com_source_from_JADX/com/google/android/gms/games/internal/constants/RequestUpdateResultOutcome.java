package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;

public final class RequestUpdateResultOutcome {
    private RequestUpdateResultOutcome() {
    }

    public static boolean isValid(int outcome) {
        switch (outcome) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return true;
            default:
                return false;
        }
    }
}
