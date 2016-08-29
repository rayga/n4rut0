package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.messages.Message;

public class zzf implements Creator<MessageWrapper> {
    static void zza(MessageWrapper messageWrapper, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, messageWrapper.zzaJS, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, messageWrapper.versionCode);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziq(x0);
    }

    public MessageWrapper zzfC(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Message message = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    message = (Message) zza.zza(parcel, zzai, Message.CREATOR);
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
            return new MessageWrapper(i, message);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MessageWrapper[] zziq(int i) {
        return new MessageWrapper[i];
    }
}
