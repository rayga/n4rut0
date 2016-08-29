package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.List;

public class zzb implements Creator<MessageFilter> {
    static void zza(MessageFilter messageFilter, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, messageFilter.zzyo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, messageFilter.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzil(x0);
    }

    public MessageFilter zzfy(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzai, MessageType.CREATOR);
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
            return new MessageFilter(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MessageFilter[] zzil(int i) {
        return new MessageFilter[i];
    }
}
