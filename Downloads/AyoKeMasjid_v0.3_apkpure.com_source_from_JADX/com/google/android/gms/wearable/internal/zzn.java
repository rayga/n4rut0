package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzn implements Creator<ChannelImpl> {
    static void zza(ChannelImpl channelImpl, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, channelImpl.mVersionCode);
        zzb.zza(parcel, 2, channelImpl.getToken(), false);
        zzb.zza(parcel, 3, channelImpl.getNodeId(), false);
        zzb.zza(parcel, 4, channelImpl.getPath(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkE(x0);
    }

    public ChannelImpl zzhu(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
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
            return new ChannelImpl(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChannelImpl[] zzkE(int i) {
        return new ChannelImpl[i];
    }
}
