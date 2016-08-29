package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzh implements Creator<ListSubscriptionsResult> {
    static void zza(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, listSubscriptionsResult.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsResult.getStatus(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfq(x0);
    }

    public ListSubscriptionsResult zzdw(Parcel parcel) {
        Status status = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzai, Subscription.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ListSubscriptionsResult[] zzfq(int i) {
        return new ListSubscriptionsResult[i];
    }
}
