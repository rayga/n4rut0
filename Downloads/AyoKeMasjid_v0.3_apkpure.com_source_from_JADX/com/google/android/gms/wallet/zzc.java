package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzc implements Creator<CountrySpecification> {
    static void zza(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, countrySpecification.getVersionCode());
        zzb.zza(parcel, 2, countrySpecification.zzFF, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjL(x0);
    }

    public CountrySpecification zzgG(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CountrySpecification(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CountrySpecification[] zzjL(int i) {
        return new CountrySpecification[i];
    }
}
