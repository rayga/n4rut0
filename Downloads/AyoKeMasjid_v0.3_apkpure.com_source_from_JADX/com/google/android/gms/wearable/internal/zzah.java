package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzah implements Creator<GetCapabilityResponse> {
    static void zza(GetCapabilityResponse getCapabilityResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, getCapabilityResponse.statusCode);
        zzb.zza(parcel, 3, getCapabilityResponse.zzbas, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkN(x0);
    }

    public GetCapabilityResponse zzhC(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        CapabilityInfoParcelable capabilityInfoParcelable = null;
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
                    capabilityInfoParcelable = (CapabilityInfoParcelable) zza.zza(parcel, zzai, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetCapabilityResponse(i2, i, capabilityInfoParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetCapabilityResponse[] zzkN(int i) {
        return new GetCapabilityResponse[i];
    }
}
