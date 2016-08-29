package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzln;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Creator<AchievementEntity> CREATOR;
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzUS;
    private final String zzaoB;
    private final String zzarS;
    private final Uri zzarT;
    private final String zzarU;
    private final Uri zzarV;
    private final String zzarW;
    private final int zzarX;
    private final String zzarY;
    private final PlayerEntity zzarZ;
    private final int zzasa;
    private final String zzasb;
    private final long zzasc;
    private final long zzasd;

    static {
        CREATOR = new AchievementEntityCreator();
    }

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.mVersionCode = versionCode;
        this.zzarS = achievementId;
        this.zzUS = type;
        this.mName = name;
        this.zzaoB = description;
        this.zzarT = unlockedImageUri;
        this.zzarU = unlockedImageUrl;
        this.zzarV = revealedImageUri;
        this.zzarW = revealedImageUrl;
        this.zzarX = totalSteps;
        this.zzarY = formattedTotalSteps;
        this.zzarZ = player;
        this.mState = state;
        this.zzasa = currentSteps;
        this.zzasb = formattedCurrentSteps;
        this.zzasc = lastUpdatedTimestamp;
        this.zzasd = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzarS = achievement.getAchievementId();
        this.zzUS = achievement.getType();
        this.mName = achievement.getName();
        this.zzaoB = achievement.getDescription();
        this.zzarT = achievement.getUnlockedImageUri();
        this.zzarU = achievement.getUnlockedImageUrl();
        this.zzarV = achievement.getRevealedImageUri();
        this.zzarW = achievement.getRevealedImageUrl();
        this.zzarZ = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzasc = achievement.getLastUpdatedTimestamp();
        this.zzasd = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzarX = achievement.getTotalSteps();
            this.zzarY = achievement.getFormattedTotalSteps();
            this.zzasa = achievement.getCurrentSteps();
            this.zzasb = achievement.getFormattedCurrentSteps();
        } else {
            this.zzarX = 0;
            this.zzarY = null;
            this.zzasa = 0;
            this.zzasb = null;
        }
        zzb.zzr(this.zzarS);
        zzb.zzr(this.zzaoB);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zzg = zzw.zzu(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzarS;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzY(z);
        return zzsX();
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzY(z);
        return zzsY();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzY(z);
        zzln.zzb(this.zzasb, dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzY(z);
        return zzsW();
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzY(z);
        zzln.zzb(this.zzarY, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzasc;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzln.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzarZ;
    }

    public Uri getRevealedImageUri() {
        return this.zzarV;
    }

    public String getRevealedImageUrl() {
        return this.zzarW;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzY(z);
        return zzsV();
    }

    public int getType() {
        return this.zzUS;
    }

    public Uri getUnlockedImageUri() {
        return this.zzarT;
    }

    public String getUnlockedImageUrl() {
        return this.zzarU;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getXpValue() {
        return this.zzasd;
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
        AchievementEntityCreator.zza(this, dest, flags);
    }

    public int zzsV() {
        return this.zzarX;
    }

    public String zzsW() {
        return this.zzarY;
    }

    public int zzsX() {
        return this.zzasa;
    }

    public String zzsY() {
        return this.zzasb;
    }
}
