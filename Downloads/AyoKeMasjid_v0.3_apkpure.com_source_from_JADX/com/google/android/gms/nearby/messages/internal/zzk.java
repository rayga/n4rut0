package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.vision.barcode.Barcode;

public class zzk implements Creator<PublishRequest> {
    static void zza(PublishRequest publishRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, publishRequest.mVersionCode);
        zzb.zza(parcel, 2, publishRequest.zzaKc, i, false);
        zzb.zza(parcel, 3, publishRequest.zzaKd, i, false);
        zzb.zza(parcel, 4, publishRequest.zzyp(), false);
        zzb.zza(parcel, 5, publishRequest.zzaCr, false);
        zzb.zza(parcel, 6, publishRequest.zzaKe, false);
        zzb.zza(parcel, 7, publishRequest.zzaJJ);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzir(x0);
    }

    public PublishRequest zzfD(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        IBinder iBinder = null;
        Strategy strategy = null;
        MessageWrapper messageWrapper = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    messageWrapper = (MessageWrapper) zza.zza(parcel, zzai, MessageWrapper.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    strategy = (Strategy) zza.zza(parcel, zzai, Strategy.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PublishRequest(i, messageWrapper, strategy, iBinder, str2, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PublishRequest[] zzir(int i) {
        return new PublishRequest[i];
    }
}
