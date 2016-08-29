package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbv implements Creator<UpdateMetadataRequest> {
    static void zza(UpdateMetadataRequest updateMetadataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, updateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, updateMetadataRequest.zzahP, i, false);
        zzb.zza(parcel, 3, updateMetadataRequest.zzahQ, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdv(x0);
    }

    public UpdateMetadataRequest zzbH(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaj) {
            DriveId driveId2;
            int zzg;
            MetadataBundle metadataBundle2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzai);
                    metadataBundle2 = metadataBundle3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    metadataBundle2 = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new UpdateMetadataRequest(i, driveId, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UpdateMetadataRequest[] zzdv(int i) {
        return new UpdateMetadataRequest[i];
    }
}
