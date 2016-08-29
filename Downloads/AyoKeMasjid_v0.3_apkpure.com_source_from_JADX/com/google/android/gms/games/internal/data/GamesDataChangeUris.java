package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    public static final Uri zzawA;
    public static final Uri zzawB;
    private static final Uri zzawz;

    static {
        zzawz = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        zzawA = zzawz.buildUpon().appendPath("invitations").build();
        zzawB = zzawz.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
    }
}
