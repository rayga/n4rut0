package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    static void zza(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, snapshotEntity.getMetadata(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotEntity.getVersionCode());
        zzb.zza(parcel, 3, snapshotEntity.getSnapshotContents(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzed(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgm(x0);
    }

    public SnapshotEntity zzed(Parcel parcel) {
        SnapshotContentsEntity snapshotContentsEntity = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            SnapshotContentsEntity snapshotContentsEntity2;
            SnapshotMetadata snapshotMetadata2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) zza.zza(parcel, zzai, SnapshotMetadataEntity.CREATOR);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    Object obj = snapshotMetadataEntity;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    snapshotContentsEntity2 = (SnapshotContentsEntity) zza.zza(parcel, zzai, SnapshotContentsEntity.CREATOR);
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    SnapshotContentsEntity snapshotContentsEntity3 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = zza.zzg(parcel, zzai);
                    snapshotContentsEntity2 = snapshotContentsEntity3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata2;
            snapshotContentsEntity = snapshotContentsEntity2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SnapshotEntity(i, snapshotMetadata, snapshotContentsEntity);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SnapshotEntity[] zzgm(int i) {
        return new SnapshotEntity[i];
    }
}
