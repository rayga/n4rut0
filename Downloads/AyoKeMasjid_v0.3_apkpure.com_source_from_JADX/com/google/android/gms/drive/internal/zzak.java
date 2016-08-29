package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzak implements Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.mVersionCode);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzajr, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzxf);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcT(x0);
    }

    public GetPermissionsResponse zzbf(Parcel parcel) {
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
                    list = zza.zzc(parcel, zzai, Permission.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetPermissionsResponse(i2, list, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetPermissionsResponse[] zzcT(int i) {
        return new GetPermissionsResponse[i];
    }
}
