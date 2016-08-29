package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void zza(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, snapshotMetadataChangeEntity.getVersionCode());
        zzb.zza(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        zzb.zza(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 5, snapshotMetadataChangeEntity.zzvc(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataChangeEntity.getProgressValue(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzee(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgn(x0);
    }

    public SnapshotMetadataChangeEntity zzee(Parcel parcel) {
        Long l = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Uri uri = null;
        BitmapTeleporter bitmapTeleporter = null;
        Long l2 = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    l2 = zza.zzj(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, zzai, BitmapTeleporter.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    l = zza.zzj(parcel, zzai);
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
            return new SnapshotMetadataChangeEntity(i, str, l2, bitmapTeleporter, uri, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SnapshotMetadataChangeEntity[] zzgn(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
