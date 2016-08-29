package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzln;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR;
    private final int mVersionCode;
    private final boolean zzAn;
    private final String zzSX;
    private final String zzahh;
    private final String zzaoB;
    private final String zzaqT;
    private final String zzaqU;
    private final String zzaqV;
    private final Uri zzaqW;
    private final Uri zzaqX;
    private final Uri zzaqY;
    private final boolean zzaqZ;
    private final boolean zzara;
    private final String zzarb;
    private final int zzarc;
    private final int zzard;
    private final int zzare;
    private final boolean zzarf;
    private final boolean zzarg;
    private final String zzarh;
    private final String zzari;
    private final String zzarj;
    private final boolean zzark;
    private final boolean zzarl;
    private final String zzarm;
    private final boolean zzarn;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdC(x0);
        }

        public GameEntity zzdC(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzor()) || DowngradeableSafeParcel.zzcj(GameEntity.class.getCanonicalName())) {
                return super.zzdC(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(7, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    static {
        CREATOR = new GameEntityCreatorCompat();
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor, boolean hasGamepadSupport) {
        this.mVersionCode = versionCode;
        this.zzSX = applicationId;
        this.zzahh = displayName;
        this.zzaqT = primaryCategory;
        this.zzaqU = secondaryCategory;
        this.zzaoB = description;
        this.zzaqV = developerName;
        this.zzaqW = iconImageUri;
        this.zzarh = iconImageUrl;
        this.zzaqX = hiResImageUri;
        this.zzari = hiResImageUrl;
        this.zzaqY = featuredImageUri;
        this.zzarj = featuredImageUrl;
        this.zzaqZ = playEnabledGame;
        this.zzara = instanceInstalled;
        this.zzarb = instancePackageName;
        this.zzarc = gameplayAclStatus;
        this.zzard = achievementTotalCount;
        this.zzare = leaderboardCount;
        this.zzarf = realTimeEnabled;
        this.zzarg = turnBasedEnabled;
        this.zzAn = muted;
        this.zzark = identitySharingConfirmed;
        this.zzarl = snapshotsEnabled;
        this.zzarm = themeColor;
        this.zzarn = hasGamepadSupport;
    }

    public GameEntity(Game game) {
        this.mVersionCode = 7;
        this.zzSX = game.getApplicationId();
        this.zzaqT = game.getPrimaryCategory();
        this.zzaqU = game.getSecondaryCategory();
        this.zzaoB = game.getDescription();
        this.zzaqV = game.getDeveloperName();
        this.zzahh = game.getDisplayName();
        this.zzaqW = game.getIconImageUri();
        this.zzarh = game.getIconImageUrl();
        this.zzaqX = game.getHiResImageUri();
        this.zzari = game.getHiResImageUrl();
        this.zzaqY = game.getFeaturedImageUri();
        this.zzarj = game.getFeaturedImageUrl();
        this.zzaqZ = game.zzsK();
        this.zzara = game.zzsM();
        this.zzarb = game.zzsN();
        this.zzarc = game.zzsO();
        this.zzard = game.getAchievementTotalCount();
        this.zzare = game.getLeaderboardCount();
        this.zzarf = game.isRealTimeMultiplayerEnabled();
        this.zzarg = game.isTurnBasedMultiplayerEnabled();
        this.zzAn = game.isMuted();
        this.zzark = game.zzsL();
        this.zzarl = game.areSnapshotsEnabled();
        this.zzarm = game.getThemeColor();
        this.zzarn = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzw.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzsK()), Boolean.valueOf(game.zzsM()), game.zzsN(), Integer.valueOf(game.zzsO()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzsL()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.equal(game2.getApplicationId(), game.getApplicationId()) && zzw.equal(game2.getDisplayName(), game.getDisplayName()) && zzw.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzw.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzw.equal(game2.getDescription(), game.getDescription()) && zzw.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzw.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzw.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzw.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(game2.zzsK()), Boolean.valueOf(game.zzsK())) && zzw.equal(Boolean.valueOf(game2.zzsM()), Boolean.valueOf(game.zzsM())) && zzw.equal(game2.zzsN(), game.zzsN()) && zzw.equal(Integer.valueOf(game2.zzsO()), Integer.valueOf(game.zzsO())) && zzw.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(game2.zzsL()), Boolean.valueOf(game.zzsL()));
            if (zzw.equal(valueOf, Boolean.valueOf(z)) && zzw.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzw.equal(game2.getThemeColor(), game.getThemeColor()) && zzw.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzw.zzu(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zzsK())).zzg("InstanceInstalled", Boolean.valueOf(game.zzsM())).zzg("InstancePackageName", game.zzsN()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.zzarl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzard;
    }

    public String getApplicationId() {
        return this.zzSX;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public String getDeveloperName() {
        return this.zzaqV;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaqV, dataOut);
    }

    public String getDisplayName() {
        return this.zzahh;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzahh, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.zzaqY;
    }

    public String getFeaturedImageUrl() {
        return this.zzarj;
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

    public int getLeaderboardCount() {
        return this.zzare;
    }

    public String getPrimaryCategory() {
        return this.zzaqT;
    }

    public String getSecondaryCategory() {
        return this.zzaqU;
    }

    public String getThemeColor() {
        return this.zzarm;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasGamepadSupport() {
        return this.zzarn;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzAn;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzarf;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzarg;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (zzos()) {
            dest.writeString(this.zzSX);
            dest.writeString(this.zzahh);
            dest.writeString(this.zzaqT);
            dest.writeString(this.zzaqU);
            dest.writeString(this.zzaoB);
            dest.writeString(this.zzaqV);
            dest.writeString(this.zzaqW == null ? null : this.zzaqW.toString());
            dest.writeString(this.zzaqX == null ? null : this.zzaqX.toString());
            if (this.zzaqY != null) {
                str = this.zzaqY.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzaqZ ? 1 : 0);
            if (!this.zzara) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.zzarb);
            dest.writeInt(this.zzarc);
            dest.writeInt(this.zzard);
            dest.writeInt(this.zzare);
            return;
        }
        GameEntityCreator.zza(this, dest, flags);
    }

    public boolean zzsK() {
        return this.zzaqZ;
    }

    public boolean zzsL() {
        return this.zzark;
    }

    public boolean zzsM() {
        return this.zzara;
    }

    public String zzsN() {
        return this.zzarb;
    }

    public int zzsO() {
        return this.zzarc;
    }
}
