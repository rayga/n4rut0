package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzaz implements Creator<MessageEventParcelable> {
    static void zza(MessageEventParcelable messageEventParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, messageEventParcelable.mVersionCode);
        zzb.zzc(parcel, 2, messageEventParcelable.getRequestId());
        zzb.zza(parcel, 3, messageEventParcelable.getPath(), false);
        zzb.zza(parcel, 4, messageEventParcelable.getData(), false);
        zzb.zza(parcel, 5, messageEventParcelable.getSourceNodeId(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkZ(x0);
    }

    public MessageEventParcelable zzhO(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        byte[] bArr = null;
        String str2 = null;
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
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    bArr = zza.zzr(parcel, zzai);
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
            return new MessageEventParcelable(i2, i, str2, bArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MessageEventParcelable[] zzkZ(int i) {
        return new MessageEventParcelable[i];
    }
}
