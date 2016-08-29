package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzln;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR;
    private final int mVersionCode;
    private final String zzWn;
    private final String zzagU;
    private final String zzahh;
    private final Uri zzaqW;
    private final Uri zzaqX;
    private final long zzarC;
    private final int zzarD;
    private final long zzarE;
    private final MostRecentGameInfoEntity zzarF;
    private final PlayerLevelInfo zzarG;
    private final boolean zzarH;
    private final boolean zzarI;
    private final String zzarh;
    private final String zzari;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdD(x0);
        }

        public PlayerEntity zzdD(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzor()) || DowngradeableSafeParcel.zzcj(PlayerEntity.class.getCanonicalName())) {
                return super.zzdD(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(12, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true, false);
        }
    }

    static {
        CREATOR = new PlayerEntityCreatorCompat();
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible, boolean hasDebugAccess) {
        this.mVersionCode = versionCode;
        this.zzWn = playerId;
        this.zzahh = displayName;
        this.zzaqW = iconImageUri;
        this.zzarh = iconImageUrl;
        this.zzaqX = hiResImageUri;
        this.zzari = hiResImageUrl;
        this.zzarC = retrievedTimestamp;
        this.zzarD = isInCircles;
        this.zzarE = lastPlayedWithTimestamp;
        this.zzagU = title;
        this.zzarH = isProfileVisible;
        this.zzarF = mostRecentGameInfo;
        this.zzarG = playerLevelInfo;
        this.zzarI = hasDebugAccess;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean isPlusEnabled) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        this.mVersionCode = 12;
        this.zzWn = isPlusEnabled ? player.getPlayerId() : null;
        this.zzahh = player.getDisplayName();
        this.zzaqW = player.getIconImageUri();
        this.zzarh = player.getIconImageUrl();
        this.zzaqX = player.getHiResImageUri();
        this.zzari = player.getHiResImageUrl();
        this.zzarC = player.getRetrievedTimestamp();
        this.zzarD = player.zzsS();
        this.zzarE = player.getLastPlayedWithTimestamp();
        this.zzagU = player.getTitle();
        this.zzarH = player.isProfileVisible();
        MostRecentGameInfo zzsT = player.zzsT();
        if (zzsT != null) {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzsT);
        }
        this.zzarF = mostRecentGameInfoEntity;
        this.zzarG = player.getLevelInfo();
        this.zzarI = player.zzsR();
        if (isPlusEnabled) {
            zzb.zzr(this.zzWn);
        }
        zzb.zzr(this.zzahh);
        zzb.zzY(this.zzarC > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.equal(player2.getPlayerId(), player.getPlayerId()) && zzw.equal(player2.getDisplayName(), player.getDisplayName()) && zzw.equal(Boolean.valueOf(player2.zzsR()), Boolean.valueOf(player.zzsR())) && zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzw.equal(player2.getTitle(), player.getTitle()) && zzw.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzsR()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    static String zzc(Player player) {
        return zzw.zzu(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzsR())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.zzahh;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzahh, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.zzaqX;
    }

    public String getHiResImageUrl() {
        return this.zzari;
    }

    public Uri getIconImageUri() {
        return this.zzaqW;
    }

    public String getIconImageUrl() {
        return this.zzarh;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzarE;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzarG;
    }

    public String getPlayerId() {
        return this.zzWn;
    }

    public long getRetrievedTimestamp() {
        return this.zzarC;
    }

    public String getTitle() {
        return this.zzagU;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzagU, dataOut);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isProfileVisible() {
        return this.zzarH;
    }

    public String toString() {
        return zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (zzos()) {
            dest.writeString(this.zzWn);
            dest.writeString(this.zzahh);
            dest.writeString(this.zzaqW == null ? null : this.zzaqW.toString());
            if (this.zzaqX != null) {
                str = this.zzaqX.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.zzarC);
            return;
        }
        PlayerEntityCreator.zza(this, dest, flags);
    }

    public boolean zzsR() {
        return this.zzarI;
    }

    public int zzsS() {
        return this.zzarD;
    }

    public MostRecentGameInfo zzsT() {
        return this.zzarF;
    }
}
