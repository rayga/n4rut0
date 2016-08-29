package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbd implements Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.mVersionCode);
        zzb.zza(parcel, 2, onListParentsResponse.zzajU, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdf(x0);
    }

    public OnListParentsResponse zzbr(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnListParentsResponse[] zzdf(int i) {
        return new OnListParentsResponse[i];
    }
}
