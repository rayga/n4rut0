package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, response.mVersionCode);
        zzb.zza(parcel, 1, response.zzPv, i, false);
        zzb.zzc(parcel, 2, response.zzPw, false);
        zzb.zza(parcel, 3, response.zzPx, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzai(x0);
    }

    public Response[] zzai(int i) {
        return new Response[i];
    }

    public Response zzx(Parcel parcel) {
        String[] strArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzai = zza.zzai(parcel);
            String[] strArr3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = zza.zzc(parcel, zzai, UsageInfo.CREATOR);
                    strArr2 = strArr3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    strArr2 = zza.zzA(parcel, zzai);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    strArr2 = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new Response(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }
}
