package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zze implements Creator<GetInstrumentsResponse> {
    static void zza(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getInstrumentsResponse.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsResponse.zzaXK, false);
        zzb.zza(parcel, 3, getInstrumentsResponse.zzaXL, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkd(x0);
    }

    public GetInstrumentsResponse zzgY(Parcel parcel) {
        String[] strArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bArr = zza.zzs(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetInstrumentsResponse(i, strArr, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetInstrumentsResponse[] zzkd(int i) {
        return new GetInstrumentsResponse[i];
    }
}
