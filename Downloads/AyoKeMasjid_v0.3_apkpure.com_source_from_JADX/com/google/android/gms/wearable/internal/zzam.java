package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzam implements Creator<GetCloudSyncSettingResponse> {
    static void zza(GetCloudSyncSettingResponse getCloudSyncSettingResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getCloudSyncSettingResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncSettingResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncSettingResponse.enabled);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkS(x0);
    }

    public GetCloudSyncSettingResponse zzhH(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
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
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetCloudSyncSettingResponse(i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetCloudSyncSettingResponse[] zzkS(int i) {
        return new GetCloudSyncSettingResponse[i];
    }
}