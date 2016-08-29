package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final Creator<SnapshotEntity> CREATOR;
    private final int mVersionCode;
    private final SnapshotMetadataEntity zzazf;
    private final SnapshotContentsEntity zzazg;

    static {
        CREATOR = new SnapshotEntityCreator();
    }

    SnapshotEntity(int versionCode, SnapshotMetadata metadata, SnapshotContentsEntity contents) {
        this.mVersionCode = versionCode;
        this.zzazf = new SnapshotMetadataEntity(metadata);
        this.zzazg = contents;
    }

    public SnapshotEntity(SnapshotMetadata metadata, SnapshotContentsEntity contents) {
        this(2, metadata, contents);
    }

    private boolean isClosed() {
        return this.zzazg.isClosed();
    }

    static boolean zza(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return zzw.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && zzw.equal(snapshot2.getSnapshotContents(), snapshot.getSnapshotContents());
    }

    static int zzb(Snapshot snapshot) {
        return zzw.hashCode(snapshot.getMetadata(), snapshot.getSnapshotContents());
    }

    static String zzc(Snapshot snapshot) {
        return zzw.zzu(snapshot).zzg("Metadata", snapshot.getMetadata()).zzg("HasContents", Boolean.valueOf(snapshot.getSnapshotContents() != null)).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Snapshot freeze() {
        return this;
    }

    public SnapshotMetadata getMetadata() {
        return this.zzazf;
    }

    public SnapshotContents getSnapshotContents() {
        return isClosed() ? null : this.zzazg;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotEntityCreator.zza(this, out, flags);
    }
}
