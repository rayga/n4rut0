package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzi implements Creator<WalletObjectMessage> {
    static void zza(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, walletObjectMessage.getVersionCode());
        zzb.zza(parcel, 2, walletObjectMessage.zzaYE, false);
        zzb.zza(parcel, 3, walletObjectMessage.body, false);
        zzb.zza(parcel, 4, walletObjectMessage.zzaYH, i, false);
        zzb.zza(parcel, 5, walletObjectMessage.zzaYI, i, false);
        zzb.zza(parcel, 6, walletObjectMessage.zzaYJ, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzks(x0);
    }

    public WalletObjectMessage zzhk(Parcel parcel) {
        UriData uriData = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        UriData uriData2 = null;
        TimeInterval timeInterval = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzai, TimeInterval.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    uriData2 = (UriData) zza.zza(parcel, zzai, UriData.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    uriData = (UriData) zza.zza(parcel, zzai, UriData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new WalletObjectMessage(i, str2, str, timeInterval, uriData2, uriData);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public WalletObjectMessage[] zzks(int i) {
        return new WalletObjectMessage[i];
    }
}
