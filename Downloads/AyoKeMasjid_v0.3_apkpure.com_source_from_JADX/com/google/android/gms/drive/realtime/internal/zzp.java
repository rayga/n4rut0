package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

public class zzp implements Creator<ParcelableChangeInfo> {
    static void zza(ParcelableChangeInfo parcelableChangeInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableChangeInfo.mVersionCode);
        zzb.zza(parcel, 2, parcelableChangeInfo.zzXR);
        zzb.zzc(parcel, 3, parcelableChangeInfo.zzoP, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdU(x0);
    }

    public ParcelableChangeInfo zzcf(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzc(parcel, zzai, ParcelableEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableChangeInfo(i, j, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ParcelableChangeInfo[] zzdU(int i) {
        return new ParcelableChangeInfo[i];
    }
}
