package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzi implements Creator<PlacePhotoResult> {
    static void zza(PlacePhotoResult placePhotoResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placePhotoResult.getStatus(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, placePhotoResult.mVersionCode);
        zzb.zza(parcel, 2, placePhotoResult.zzaDG, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhd(x0);
    }

    public PlacePhotoResult zzeF(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            BitmapTeleporter bitmapTeleporter2;
            Status status2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    bitmapTeleporter2 = bitmapTeleporter;
                    status2 = status3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bitmapTeleporter2 = (BitmapTeleporter) zza.zza(parcel, zzai, BitmapTeleporter.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    BitmapTeleporter bitmapTeleporter3 = bitmapTeleporter;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    bitmapTeleporter2 = bitmapTeleporter3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    bitmapTeleporter2 = bitmapTeleporter;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            bitmapTeleporter = bitmapTeleporter2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlacePhotoResult(i, status, bitmapTeleporter);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlacePhotoResult[] zzhd(int i) {
        return new PlacePhotoResult[i];
    }
}
