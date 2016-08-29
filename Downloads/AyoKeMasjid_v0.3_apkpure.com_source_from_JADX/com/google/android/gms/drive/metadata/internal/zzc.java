package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, customProperty.mVersionCode);
        zzb.zza(parcel, 2, customProperty.zzakk, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdz(x0);
    }

    public CustomProperty zzbL(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < zzaj) {
            CustomPropertyKey customPropertyKey2;
            int zzg;
            String str2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = zza.zzg(parcel, zzai);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzai, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
            }
            i = zzg;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CustomProperty[] zzdz(int i) {
        return new CustomProperty[i];
    }
}
