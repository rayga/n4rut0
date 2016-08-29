package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzp implements Creator<PaymentMethodTokenizationParameters> {
    static void zza(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, paymentMethodTokenizationParameters.getVersionCode());
        zzb.zzc(parcel, 2, paymentMethodTokenizationParameters.zzaXv);
        zzb.zza(parcel, 3, paymentMethodTokenizationParameters.zzaXw, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjY(x0);
    }

    public PaymentMethodTokenizationParameters zzgT(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PaymentMethodTokenizationParameters(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PaymentMethodTokenizationParameters[] zzjY(int i) {
        return new PaymentMethodTokenizationParameters[i];
    }
}
