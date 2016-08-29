package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzc implements Creator<GetBuyFlowInitializationTokenResponse> {
    static void zza(GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getBuyFlowInitializationTokenResponse.getVersionCode());
        zzb.zza(parcel, 2, getBuyFlowInitializationTokenResponse.zzaXI, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkb(x0);
    }

    public GetBuyFlowInitializationTokenResponse zzgW(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetBuyFlowInitializationTokenResponse(i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetBuyFlowInitializationTokenResponse[] zzkb(int i) {
        return new GetBuyFlowInitializationTokenResponse[i];
    }
}
