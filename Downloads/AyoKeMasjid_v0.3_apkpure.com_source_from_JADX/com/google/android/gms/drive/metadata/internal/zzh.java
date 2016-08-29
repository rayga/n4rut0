package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzh implements Creator<MetadataBundle> {
    static void zza(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, metadataBundle.mVersionCode);
        zzb.zza(parcel, 2, metadataBundle.zzakm, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdA(x0);
    }

    public MetadataBundle zzbM(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MetadataBundle(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MetadataBundle[] zzdA(int i) {
        return new MetadataBundle[i];
    }
}
