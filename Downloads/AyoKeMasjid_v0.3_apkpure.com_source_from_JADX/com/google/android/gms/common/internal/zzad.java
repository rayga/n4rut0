package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzad implements Creator<ValidateAccountRequest> {
    static void zza(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, validateAccountRequest.mVersionCode);
        zzb.zzc(parcel, 2, validateAccountRequest.zzoS());
        zzb.zza(parcel, 3, validateAccountRequest.zzacC, false);
        zzb.zza(parcel, 4, validateAccountRequest.zzoT(), i, false);
        zzb.zza(parcel, 5, validateAccountRequest.zzoU(), false);
        zzb.zza(parcel, 6, validateAccountRequest.getCallingPackage(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbG(x0);
    }

    public ValidateAccountRequest zzah(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzai, Scope.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ValidateAccountRequest[] zzbG(int i) {
        return new ValidateAccountRequest[i];
    }
}
