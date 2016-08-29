package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzae implements Creator<FetchThumbnailRequest> {
    static void zza(FetchThumbnailRequest fetchThumbnailRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fetchThumbnailRequest.mVersionCode);
        zzb.zza(parcel, 2, fetchThumbnailRequest.zzahP, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcL(x0);
    }

    public FetchThumbnailRequest zzaZ(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FetchThumbnailRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FetchThumbnailRequest[] zzcL(int i) {
        return new FetchThumbnailRequest[i];
    }
}
