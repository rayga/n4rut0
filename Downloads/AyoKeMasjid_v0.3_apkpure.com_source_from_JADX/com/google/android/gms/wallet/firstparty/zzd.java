package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzd implements Creator<GetInstrumentsRequest> {
    static void zza(GetInstrumentsRequest getInstrumentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getInstrumentsRequest.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsRequest.zzaXJ, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkc(x0);
    }

    public GetInstrumentsRequest zzgX(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iArr = zza.zzu(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetInstrumentsRequest(i, iArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetInstrumentsRequest[] zzkc(int i) {
        return new GetInstrumentsRequest[i];
    }
}
