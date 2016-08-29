package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR;
    private final int mVersionCode;
    private int zzUS;
    private String zzagU;
    private String zzaoB;
    private Uri zzaqW;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdP(x0);
        }

        public GameBadgeEntity zzdP(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzor()) || DowngradeableSafeParcel.zzcj(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzdP(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    static {
        CREATOR = new GameBadgeEntityCreatorCompat();
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.mVersionCode = versionCode;
        this.zzUS = type;
        this.zzagU = title;
        this.zzaoB = description;
        this.zzaqW = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.mVersionCode = 1;
        this.zzUS = gameBadge.getType();
        this.zzagU = gameBadge.getTitle();
        this.zzaoB = gameBadge.getDescription();
        this.zzaqW = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzw.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzw.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzw.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzw.zzu(gameBadge).zzg("Type", Integer.valueOf(gameBadge.getType())).zzg("Title", gameBadge.getTitle()).zzg("Description", gameBadge.getDescription()).zzg("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuu();
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public Uri getIconImageUri() {
        return this.zzaqW;
    }

    public String getTitle() {
        return this.zzagU;
    }

    public int getType() {
        return this.zzUS;
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

    public void writeToParcel(Parcel dest, int flags) {
        if (zzos()) {
            dest.writeInt(this.zzUS);
            dest.writeString(this.zzagU);
            dest.writeString(this.zzaoB);
            dest.writeString(this.zzaqW == null ? null : this.zzaqW.toString());
            return;
        }
        GameBadgeEntityCreator.zza(this, dest, flags);
    }

    public GameBadge zzuu() {
        return this;
    }
}
