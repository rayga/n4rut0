package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzbk implements Creator<StorageInfoResponse> {
    static void zza(StorageInfoResponse storageInfoResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, storageInfoResponse.versionCode);
        zzb.zzc(parcel, 2, storageInfoResponse.statusCode);
        zzb.zza(parcel, 3, storageInfoResponse.zzbaQ);
        zzb.zzc(parcel, 4, storageInfoResponse.zzbaS, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlh(x0);
    }

    public StorageInfoResponse zzhW(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        List list = null;
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
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzc(parcel, zzai, PackageStorageInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StorageInfoResponse(i2, i, j, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public StorageInfoResponse[] zzlh(int i) {
        return new StorageInfoResponse[i];
    }
}
