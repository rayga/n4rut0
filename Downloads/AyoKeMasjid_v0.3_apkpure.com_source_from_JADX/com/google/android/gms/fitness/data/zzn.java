package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzn implements Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzanB);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, rawDataPoint.mVersionCode);
        zzb.zza(parcel, 2, rawDataPoint.zzanC);
        zzb.zza(parcel, 3, rawDataPoint.zzanD, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzaow);
        zzb.zzc(parcel, 5, rawDataPoint.zzaox);
        zzb.zza(parcel, 6, rawDataPoint.zzanF);
        zzb.zza(parcel, 7, rawDataPoint.zzanG);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzew(x0);
    }

    public RawDataPoint zzcE(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    valueArr = (Value[]) zza.zzb(parcel, zzai, Value.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    j4 = zza.zzi(parcel, zzai);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public RawDataPoint[] zzew(int i) {
        return new RawDataPoint[i];
    }
}
