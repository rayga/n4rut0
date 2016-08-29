package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzq implements Creator<ChannelReceiveFileResponse> {
    static void zza(ChannelReceiveFileResponse channelReceiveFileResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, channelReceiveFileResponse.versionCode);
        zzb.zzc(parcel, 2, channelReceiveFileResponse.statusCode);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkG(x0);
    }

    public ChannelReceiveFileResponse zzhv(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
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
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChannelReceiveFileResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChannelReceiveFileResponse[] zzkG(int i) {
        return new ChannelReceiveFileResponse[i];
    }
}
