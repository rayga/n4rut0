package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzf implements Creator<CheckResourceIdsExistRequest> {
    static void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        zzb.zzb(parcel, 2, checkResourceIdsExistRequest.zzqD(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcx(x0);
    }

    public CheckResourceIdsExistRequest zzaO(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzC(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CheckResourceIdsExistRequest[] zzcx(int i) {
        return new CheckResourceIdsExistRequest[i];
    }
}
