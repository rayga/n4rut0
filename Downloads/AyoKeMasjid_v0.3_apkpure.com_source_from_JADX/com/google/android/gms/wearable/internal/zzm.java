package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzm implements Creator<ChannelEventParcelable> {
    static void zza(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, channelEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, channelEventParcelable.zzaZR, i, false);
        zzb.zzc(parcel, 3, channelEventParcelable.type);
        zzb.zzc(parcel, 4, channelEventParcelable.zzaZP);
        zzb.zzc(parcel, 5, channelEventParcelable.zzaZQ);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzht(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkD(x0);
    }

    public ChannelEventParcelable zzht(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzai, ChannelImpl.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChannelEventParcelable[] zzkD(int i) {
        return new ChannelEventParcelable[i];
    }
}
