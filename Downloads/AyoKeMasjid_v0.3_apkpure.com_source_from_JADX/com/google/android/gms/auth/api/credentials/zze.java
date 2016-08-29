package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zze implements Creator<PasswordSpecification> {
    static void zza(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, passwordSpecification.zzRq, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, passwordSpecification.mVersionCode);
        zzb.zzb(parcel, 2, passwordSpecification.zzRr, false);
        zzb.zza(parcel, 3, passwordSpecification.zzRs, false);
        zzb.zzc(parcel, 4, passwordSpecification.zzRt);
        zzb.zzc(parcel, 5, passwordSpecification.zzRu);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzax(x0);
    }

    public PasswordSpecification zzH(Parcel parcel) {
        List list = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list2 = zza.zzC(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzB(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PasswordSpecification(i3, str, list2, list, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PasswordSpecification[] zzax(int i) {
        return new PasswordSpecification[i];
    }
}
