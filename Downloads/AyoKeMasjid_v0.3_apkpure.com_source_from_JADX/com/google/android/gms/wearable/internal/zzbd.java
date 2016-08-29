package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzbd implements Creator<PackageStorageInfo> {
    static void zza(PackageStorageInfo packageStorageInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, packageStorageInfo.versionCode);
        zzb.zza(parcel, 2, packageStorageInfo.packageName, false);
        zzb.zza(parcel, 3, packageStorageInfo.label, false);
        zzb.zza(parcel, 4, packageStorageInfo.zzbaQ);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlc(x0);
    }

    public PackageStorageInfo zzhR(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PackageStorageInfo(i, str2, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PackageStorageInfo[] zzlc(int i) {
        return new PackageStorageInfo[i];
    }
}
