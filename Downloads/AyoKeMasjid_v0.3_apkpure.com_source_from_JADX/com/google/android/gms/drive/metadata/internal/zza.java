package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.Collection;

public class zza implements Creator<AppVisibleCustomProperties> {
    static void zza(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appVisibleCustomProperties.mVersionCode);
        zzb.zzc(parcel, 2, appVisibleCustomProperties.zzaki, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdy(x0);
    }

    public AppVisibleCustomProperties zzbK(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    collection = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, CustomProperty.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AppVisibleCustomProperties[] zzdy(int i) {
        return new AppVisibleCustomProperties[i];
    }
}
