package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzbg implements Creator<OnResourceIdSetResponse> {
    static void zza(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onResourceIdSetResponse.getVersionCode());
        zzb.zzb(parcel, 2, onResourceIdSetResponse.zzqD(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdi(x0);
    }

    public OnResourceIdSetResponse zzbu(Parcel parcel) {
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
            return new OnResourceIdSetResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnResourceIdSetResponse[] zzdi(int i) {
        return new OnResourceIdSetResponse[i];
    }
}
