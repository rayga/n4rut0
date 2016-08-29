package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzm implements Creator<ParcelableGeofence> {
    static void zza(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, parcelableGeofence.getRequestId(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, parcelableGeofence.getVersionCode());
        zzb.zza(parcel, 2, parcelableGeofence.getExpirationTime());
        zzb.zza(parcel, 3, parcelableGeofence.zzvU());
        zzb.zza(parcel, 4, parcelableGeofence.getLatitude());
        zzb.zza(parcel, 5, parcelableGeofence.getLongitude());
        zzb.zza(parcel, 6, parcelableGeofence.zzvV());
        zzb.zzc(parcel, 7, parcelableGeofence.zzvW());
        zzb.zzc(parcel, 8, parcelableGeofence.getNotificationResponsiveness());
        zzb.zzc(parcel, 9, parcelableGeofence.zzvX());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzey(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgV(x0);
    }

    public ParcelableGeofence zzey(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    s = zza.zzf(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    d = zza.zzm(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    d2 = zza.zzm(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    f = zza.zzl(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    i4 = zza.zzg(parcel, zzai);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ParcelableGeofence[] zzgV(int i) {
        return new ParcelableGeofence[i];
    }
}
