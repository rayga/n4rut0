package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzm implements Creator<NotifyTransactionStatusRequest> {
    static void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, notifyTransactionStatusRequest.mVersionCode);
        zzb.zza(parcel, 2, notifyTransactionStatusRequest.zzaWi, false);
        zzb.zzc(parcel, 3, notifyTransactionStatusRequest.status);
        zzb.zza(parcel, 4, notifyTransactionStatusRequest.zzaXs, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjV(x0);
    }

    public NotifyTransactionStatusRequest zzgQ(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NotifyTransactionStatusRequest[] zzjV(int i) {
        return new NotifyTransactionStatusRequest[i];
    }
}
