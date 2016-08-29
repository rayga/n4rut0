package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzap implements Creator<GetConnectedNodesResponse> {
    static void zza(GetConnectedNodesResponse getConnectedNodesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getConnectedNodesResponse.versionCode);
        zzb.zzc(parcel, 2, getConnectedNodesResponse.statusCode);
        zzb.zzc(parcel, 3, getConnectedNodesResponse.zzbaz, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkV(x0);
    }

    public GetConnectedNodesResponse zzhK(Parcel parcel) {
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
                    list = zza.zzc(parcel, zzai, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetConnectedNodesResponse(i2, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetConnectedNodesResponse[] zzkV(int i) {
        return new GetConnectedNodesResponse[i];
    }
}
