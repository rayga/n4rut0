package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<FitnessSensorServiceRequest> {
    static void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, fitnessSensorServiceRequest.getDataSource(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fitnessSensorServiceRequest.getVersionCode());
        zzb.zza(parcel, 2, fitnessSensorServiceRequest.zzst(), false);
        zzb.zza(parcel, 3, fitnessSensorServiceRequest.zzrP());
        zzb.zza(parcel, 4, fitnessSensorServiceRequest.zzsJ());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfv(x0);
    }

    public FitnessSensorServiceRequest zzdB(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FitnessSensorServiceRequest[] zzfv(int i) {
        return new FitnessSensorServiceRequest[i];
    }
}
