package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbf implements Creator<OnLoadRealtimeResponse> {
    static void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onLoadRealtimeResponse.mVersionCode);
        zzb.zza(parcel, 2, onLoadRealtimeResponse.zzpr);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdh(x0);
    }

    public OnLoadRealtimeResponse zzbt(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnLoadRealtimeResponse[] zzdh(int i) {
        return new OnLoadRealtimeResponse[i];
    }
}
