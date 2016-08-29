package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzao implements Creator<GetConfigsResponse> {
    static void zza(GetConfigsResponse getConfigsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getConfigsResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigsResponse.statusCode);
        zzb.zza(parcel, 3, getConfigsResponse.zzbay, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkU(x0);
    }

    public GetConfigsResponse zzhJ(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ConnectionConfiguration[] connectionConfigurationArr = null;
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
                    connectionConfigurationArr = (ConnectionConfiguration[]) zza.zzb(parcel, zzai, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetConfigsResponse(i2, i, connectionConfigurationArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetConfigsResponse[] zzkU(int i) {
        return new GetConfigsResponse[i];
    }
}
