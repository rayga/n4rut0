package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzln;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR;
    private final int mVersionCode;
    private final String zzagU;
    private final String zzaoB;
    private final String zzasZ;
    private final GameEntity zzaxY;
    private final Uri zzazk;
    private final PlayerEntity zzazn;
    private final String zzazo;
    private final long zzazp;
    private final long zzazq;
    private final float zzazr;
    private final String zzazs;
    private final boolean zzazt;
    private final long zzazu;

    static {
        CREATOR = new SnapshotMetadataEntityCreator();
    }

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName, boolean changePending, long progressValue) {
        this.mVersionCode = versionCode;
        this.zzaxY = game;
        this.zzazn = owner;
        this.zzasZ = snapshotId;
        this.zzazk = coverImageUri;
        this.zzazo = coverImageUrl;
        this.zzazr = coverImageAspectRatio;
        this.zzagU = title;
        this.zzaoB = description;
        this.zzazp = lastModifiedTimestamp;
        this.zzazq = playedTime;
        this.zzazs = uniqueName;
        this.zzazt = changePending;
        this.zzazu = progressValue;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.mVersionCode = 5;
        this.zzaxY = new GameEntity(snapshotMetadata.getGame());
        this.zzazn = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzasZ = snapshotMetadata.getSnapshotId();
        this.zzazk = snapshotMetadata.getCoverImageUri();
        this.zzazo = snapshotMetadata.getCoverImageUrl();
        this.zzazr = snapshotMetadata.getCoverImageAspectRatio();
        this.zzagU = snapshotMetadata.getTitle();
        this.zzaoB = snapshotMetadata.getDescription();
        this.zzazp = snapshotMetadata.getLastModifiedTimestamp();
        this.zzazq = snapshotMetadata.getPlayedTime();
        this.zzazs = snapshotMetadata.getUniqueName();
        this.zzazt = snapshotMetadata.hasChangePending();
        this.zzazu = snapshotMetadata.getProgressValue();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzw.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()));
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzw.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzw.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzw.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzw.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzw.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzw.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzw.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzw.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzw.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzw.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzw.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzw.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue()));
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzw.zzu(snapshotMetadata).zzg("Game", snapshotMetadata.getGame()).zzg("Owner", snapshotMetadata.getOwner()).zzg("SnapshotId", snapshotMetadata.getSnapshotId()).zzg("CoverImageUri", snapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zzg("Description", snapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zzg("UniqueName", snapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzazr;
    }

    public Uri getCoverImageUri() {
        return this.zzazk;
    }

    public String getCoverImageUrl() {
        return this.zzazo;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public Game getGame() {
        return this.zzaxY;
    }

    public long getLastModifiedTimestamp() {
        return this.zzazp;
    }

    public Player getOwner() {
        return this.zzazn;
    }

    public long getPlayedTime() {
        return this.zzazq;
    }

    public long getProgressValue() {
        return this.zzazu;
    }

    public String getSnapshotId() {
        return this.zzasZ;
    }

    public String getTitle() {
        return this.zzagU;
    }

    public String getUniqueName() {
        return this.zzazs;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasChangePending() {
        return this.zzazt;
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
        SnapshotMetadataEntityCreator.zza(this, out, flags);
    }
}
