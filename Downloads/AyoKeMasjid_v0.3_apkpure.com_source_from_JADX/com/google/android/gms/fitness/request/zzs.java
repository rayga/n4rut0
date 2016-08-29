package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzs implements Creator<SensorRegistrationRequest> {
    static void zza(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sensorRegistrationRequest.getDataSource(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sensorRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sensorRegistrationRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, sensorRegistrationRequest.zzst(), false);
        zzb.zzc(parcel, 4, sensorRegistrationRequest.zzaqj);
        zzb.zzc(parcel, 5, sensorRegistrationRequest.zzaqk);
        zzb.zza(parcel, 6, sensorRegistrationRequest.zzrP());
        zzb.zza(parcel, 7, sensorRegistrationRequest.zzsq());
        zzb.zza(parcel, 8, sensorRegistrationRequest.zzso(), i, false);
        zzb.zza(parcel, 9, sensorRegistrationRequest.zzsp());
        zzb.zzc(parcel, 10, sensorRegistrationRequest.getAccuracyMode());
        zzb.zzc(parcel, 11, sensorRegistrationRequest.zzsr(), false);
        zzb.zza(parcel, 12, sensorRegistrationRequest.zzss());
        zzb.zza(parcel, 13, sensorRegistrationRequest.zzsc(), false);
        zzb.zza(parcel, 14, sensorRegistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeV(x0);
    }

    public SensorRegistrationRequest zzdc(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    list = zza.zzc(parcel, zzai, LocationRequest.CREATOR);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    j4 = zza.zzi(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str = zza.zzo(parcel, zzai);
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
            return new SensorRegistrationRequest(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4, iBinder2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SensorRegistrationRequest[] zzeV(int i) {
        return new SensorRegistrationRequest[i];
    }
}
