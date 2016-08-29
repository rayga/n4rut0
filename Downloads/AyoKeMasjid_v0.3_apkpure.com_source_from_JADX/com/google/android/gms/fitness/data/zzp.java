package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzp implements Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, session.zzkH());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, session.getVersionCode());
        zzb.zza(parcel, 2, session.zzrw());
        zzb.zza(parcel, 3, session.getName(), false);
        zzb.zza(parcel, 4, session.getIdentifier(), false);
        zzb.zza(parcel, 5, session.getDescription(), false);
        zzb.zzc(parcel, 7, session.zzru());
        zzb.zza(parcel, 8, session.zzrF(), i, false);
        zzb.zza(parcel, 9, session.zzrN(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzez(x0);
    }

    public Session zzcG(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int zzaj = zza.zzaj(parcel);
        Application application = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    application = (Application) zza.zza(parcel, zzai, Application.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    l = zza.zzj(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Session(i2, j2, j, str3, str2, str, i, application, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Session[] zzez(int i) {
        return new Session[i];
    }
}
