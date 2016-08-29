package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    static void zza(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, snapshotContentsEntity.zzqh(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotContentsEntity.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzec(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgl(x0);
    }

    public SnapshotContentsEntity zzec(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    contents = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SnapshotContentsEntity(i, contents);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SnapshotContentsEntity[] zzgl(int i) {
        return new SnapshotContentsEntity[i];
    }
}
