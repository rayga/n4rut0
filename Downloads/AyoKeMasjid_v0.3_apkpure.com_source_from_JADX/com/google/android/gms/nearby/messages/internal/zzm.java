package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzm implements Creator<UnpublishRequest> {
    static void zza(UnpublishRequest unpublishRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, unpublishRequest.mVersionCode);
        zzb.zza(parcel, 2, unpublishRequest.zzaKc, i, false);
        zzb.zza(parcel, 3, unpublishRequest.zzyp(), false);
        zzb.zza(parcel, 4, unpublishRequest.zzaCr, false);
        zzb.zza(parcel, 5, unpublishRequest.zzaKe, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzit(x0);
    }

    public UnpublishRequest zzfF(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        IBinder iBinder = null;
        MessageWrapper messageWrapper = null;
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
                    iBinder = zza.zzp(parcel, zzai);
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
            return new UnpublishRequest(i, messageWrapper, iBinder, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UnpublishRequest[] zzit(int i) {
        return new UnpublishRequest[i];
    }
}
