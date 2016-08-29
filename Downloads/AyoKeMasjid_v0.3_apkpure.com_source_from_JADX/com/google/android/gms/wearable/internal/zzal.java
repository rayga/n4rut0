package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzal implements Creator<GetCloudSyncOptInStatusResponse> {
    static void zza(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInStatusResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInStatusResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInStatusResponse.zzbav);
        zzb.zza(parcel, 4, getCloudSyncOptInStatusResponse.zzbaw);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkR(x0);
    }

    public GetCloudSyncOptInStatusResponse zzhG(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
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
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetCloudSyncOptInStatusResponse(i2, i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetCloudSyncOptInStatusResponse[] zzkR(int i) {
        return new GetCloudSyncOptInStatusResponse[i];
    }
}
