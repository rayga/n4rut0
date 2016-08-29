package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;

public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String zzfQ(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "PUBLIC";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
