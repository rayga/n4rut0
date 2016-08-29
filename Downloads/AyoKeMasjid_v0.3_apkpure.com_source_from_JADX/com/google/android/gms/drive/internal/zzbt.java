package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbt implements Creator<UnsubscribeResourceRequest> {
    static void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, unsubscribeResourceRequest.mVersionCode);
        zzb.zza(parcel, 2, unsubscribeResourceRequest.zzahP, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdt(x0);
    }

    public UnsubscribeResourceRequest zzbF(Parcel parcel) {
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
            return new UnsubscribeResourceRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UnsubscribeResourceRequest[] zzdt(int i) {
        return new UnsubscribeResourceRequest[i];
    }
}
