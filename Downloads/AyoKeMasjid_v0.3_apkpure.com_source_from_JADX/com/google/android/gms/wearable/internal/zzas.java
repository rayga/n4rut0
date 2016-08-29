package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzas implements Creator<GetLocalNodeResponse> {
    static void zza(GetLocalNodeResponse getLocalNodeResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getLocalNodeResponse.versionCode);
        zzb.zzc(parcel, 2, getLocalNodeResponse.statusCode);
        zzb.zza(parcel, 3, getLocalNodeResponse.zzbaC, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkY(x0);
    }

    public GetLocalNodeResponse zzhN(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        NodeParcelable nodeParcelable = null;
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
                    nodeParcelable = (NodeParcelable) zza.zza(parcel, zzai, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetLocalNodeResponse(i2, i, nodeParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetLocalNodeResponse[] zzkY(int i) {
        return new GetLocalNodeResponse[i];
    }
}
