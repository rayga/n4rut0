package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzl implements Creator<LocationRequestUpdateData> {
    static void zza(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, locationRequestUpdateData.zzaCZ);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequestUpdateData.getVersionCode());
        zzb.zza(parcel, 2, locationRequestUpdateData.zzaDa, i, false);
        zzb.zza(parcel, 3, locationRequestUpdateData.zzvS(), false);
        zzb.zza(parcel, 4, locationRequestUpdateData.mPendingIntent, i, false);
        zzb.zza(parcel, 5, locationRequestUpdateData.zzvT(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzex(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgS(x0);
    }

    public LocationRequestUpdateData zzex(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 1;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    locationRequestInternal = (LocationRequestInternal) zza.zza(parcel, zzai, LocationRequestInternal.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    iBinder = zza.zzp(parcel, zzai);
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder2, pendingIntent, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LocationRequestUpdateData[] zzgS(int i) {
        return new LocationRequestUpdateData[i];
    }
}
