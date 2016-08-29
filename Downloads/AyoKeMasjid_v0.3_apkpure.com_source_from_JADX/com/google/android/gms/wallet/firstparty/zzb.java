package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzb implements Creator<GetBuyFlowInitializationTokenRequest> {
    static void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getBuyFlowInitializationTokenRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getBuyFlowInitializationTokenRequest.zzaXG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, getBuyFlowInitializationTokenRequest.zzaXH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzka(x0);
    }

    public GetBuyFlowInitializationTokenRequest zzgV(Parcel parcel) {
        byte[] bArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bArr2 = zza.zzr(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetBuyFlowInitializationTokenRequest(i, bArr2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetBuyFlowInitializationTokenRequest[] zzka(int i) {
        return new GetBuyFlowInitializationTokenRequest[i];
    }
}
