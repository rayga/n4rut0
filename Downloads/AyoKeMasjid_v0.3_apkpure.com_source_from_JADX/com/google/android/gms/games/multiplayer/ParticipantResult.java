package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult implements SafeParcelable {
    public static final Creator<ParticipantResult> CREATOR;
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int mVersionCode;
    private final String zzatI;
    private final int zzayj;
    private final int zzayk;

    static {
        CREATOR = new ParticipantResultCreator();
    }

    public ParticipantResult(int versionCode, String participantId, int result, int placing) {
        this.mVersionCode = versionCode;
        this.zzatI = (String) zzx.zzv(participantId);
        zzx.zzY(MatchResult.isValid(result));
        this.zzayj = result;
        this.zzayk = placing;
    }

    public ParticipantResult(String participantId, int result, int placing) {
        this(MATCH_RESULT_LOSS, participantId, result, placing);
    }

    public int describeContents() {
        return MATCH_RESULT_WIN;
    }

    public String getParticipantId() {
        return this.zzatI;
    }

    public int getPlacing() {
        return this.zzayk;
    }

    public int getResult() {
        return this.zzayj;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        ParticipantResultCreator.zza(this, out, flags);
    }
}
