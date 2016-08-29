package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzaq implements Creator<GetDataItemResponse> {
    static void zza(GetDataItemResponse getDataItemResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getDataItemResponse.versionCode);
        zzb.zzc(parcel, 2, getDataItemResponse.statusCode);
        zzb.zza(parcel, 3, getDataItemResponse.zzbaA, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkW(x0);
    }

    public GetDataItemResponse zzhL(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DataItemParcelable dataItemParcelable = null;
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
                    dataItemParcelable = (DataItemParcelable) zza.zza(parcel, zzai, DataItemParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetDataItemResponse(i2, i, dataItemParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetDataItemResponse[] zzkW(int i) {
        return new GetDataItemResponse[i];
    }
}
