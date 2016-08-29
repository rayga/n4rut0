package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zze implements Creator<CancelPendingActionsRequest> {
    static void zza(CancelPendingActionsRequest cancelPendingActionsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, cancelPendingActionsRequest.mVersionCode);
        zzb.zzb(parcel, 2, cancelPendingActionsRequest.zzahv, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcw(x0);
    }

    public CancelPendingActionsRequest zzaN(Parcel parcel) {
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
            return new CancelPendingActionsRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CancelPendingActionsRequest[] zzcw(int i) {
        return new CancelPendingActionsRequest[i];
    }
}
