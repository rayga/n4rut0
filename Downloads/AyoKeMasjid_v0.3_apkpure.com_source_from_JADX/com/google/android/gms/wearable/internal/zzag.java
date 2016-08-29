package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzag implements Creator<GetAllCapabilitiesResponse> {
    static void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getAllCapabilitiesResponse.versionCode);
        zzb.zzc(parcel, 2, getAllCapabilitiesResponse.statusCode);
        zzb.zzc(parcel, 3, getAllCapabilitiesResponse.zzbar, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkM(x0);
    }

    public GetAllCapabilitiesResponse zzhB(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
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
                    list = zza.zzc(parcel, zzai, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetAllCapabilitiesResponse(i2, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetAllCapabilitiesResponse[] zzkM(int i) {
        return new GetAllCapabilitiesResponse[i];
    }
}
