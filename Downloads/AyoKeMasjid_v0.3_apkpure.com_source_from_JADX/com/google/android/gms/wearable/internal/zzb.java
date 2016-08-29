package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzb implements Creator<AddListenerRequest> {
    static void zza(AddListenerRequest addListenerRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addListenerRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addListenerRequest.zzCt(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addListenerRequest.zzaZr, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addListenerRequest.zzaZs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addListenerRequest.zzaZt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzho(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkw(x0);
    }

    public AddListenerRequest zzho(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    intentFilterArr = (IntentFilter[]) zza.zzb(parcel, zzai, IntentFilter.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AddListenerRequest(i, iBinder, intentFilterArr, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AddListenerRequest[] zzkw(int i) {
        return new AddListenerRequest[i];
    }
}
