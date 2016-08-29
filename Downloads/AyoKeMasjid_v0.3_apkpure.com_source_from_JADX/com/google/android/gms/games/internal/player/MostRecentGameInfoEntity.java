package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR;
    private final int mVersionCode;
    private final String zzawL;
    private final String zzawM;
    private final long zzawN;
    private final Uri zzawO;
    private final Uri zzawP;
    private final Uri zzawQ;

    static {
        CREATOR = new MostRecentGameInfoEntityCreator();
    }

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.mVersionCode = versionCode;
        this.zzawL = gameId;
        this.zzawM = gameName;
        this.zzawN = activityTimestampMillis;
        this.zzawO = gameIconImageUri;
        this.zzawP = gameHiResIconImageUri;
        this.zzawQ = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.mVersionCode = 2;
        this.zzawL = info.zzuG();
        this.zzawM = info.zzuH();
        this.zzawN = info.zzuI();
        this.zzawO = info.zzuJ();
        this.zzawP = info.zzuK();
        this.zzawQ = info.zzuL();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzuG(), mostRecentGameInfo.zzuH(), Long.valueOf(mostRecentGameInfo.zzuI()), mostRecentGameInfo.zzuJ(), mostRecentGameInfo.zzuK(), mostRecentGameInfo.zzuL());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.equal(mostRecentGameInfo2.zzuG(), mostRecentGameInfo.zzuG()) && zzw.equal(mostRecentGameInfo2.zzuH(), mostRecentGameInfo.zzuH()) && zzw.equal(Long.valueOf(mostRecentGameInfo2.zzuI()), Long.valueOf(mostRecentGameInfo.zzuI())) && zzw.equal(mostRecentGameInfo2.zzuJ(), mostRecentGameInfo.zzuJ()) && zzw.equal(mostRecentGameInfo2.zzuK(), mostRecentGameInfo.zzuK()) && zzw.equal(mostRecentGameInfo2.zzuL(), mostRecentGameInfo.zzuL());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzu(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzuG()).zzg("GameName", mostRecentGameInfo.zzuH()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzuI())).zzg("GameIconUri", mostRecentGameInfo.zzuJ()).zzg("GameHiResUri", mostRecentGameInfo.zzuK()).zzg("GameFeaturedUri", mostRecentGameInfo.zzuL()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuM();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MostRecentGameInfoEntityCreator.zza(this, out, flags);
    }

    public String zzuG() {
        return this.zzawL;
    }

    public String zzuH() {
        return this.zzawM;
    }

    public long zzuI() {
        return this.zzawN;
    }

    public Uri zzuJ() {
        return this.zzawO;
    }

    public Uri zzuK() {
        return this.zzawP;
    }

    public Uri zzuL() {
        return this.zzawQ;
    }

    public MostRecentGameInfo zzuM() {
        return this;
    }
}
