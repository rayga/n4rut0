package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR;
    private final int mVersionCode;
    private final String zzaoB;
    private final Long zzazi;
    private final Uri zzazk;
    private final Long zzazl;
    private BitmapTeleporter zzazm;

    static {
        CREATOR = new SnapshotMetadataChangeCreator();
    }

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        boolean z = true;
        this.mVersionCode = versionCode;
        this.zzaoB = description;
        this.zzazl = playedTimeMillis;
        this.zzazm = coverImage;
        this.zzazk = coverImageUri;
        this.zzazi = progressValue;
        if (this.zzazm != null) {
            if (this.zzazk != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzazk != null) {
            if (this.zzazm != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this(5, description, playedTimeMillis, coverImage, coverImageUri, progressValue);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.zzazm == null ? null : this.zzazm.zznQ();
    }

    public Uri getCoverImageUri() {
        return this.zzazk;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public Long getPlayedTimeMillis() {
        return this.zzazl;
    }

    public Long getProgressValue() {
        return this.zzazi;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.zza(this, out, flags);
    }

    public BitmapTeleporter zzvc() {
        return this.zzazm;
    }
}
