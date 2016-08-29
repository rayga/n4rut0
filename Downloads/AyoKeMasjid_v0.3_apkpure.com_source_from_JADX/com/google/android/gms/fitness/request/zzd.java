package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzd implements Creator<DataDeleteRequest> {
    static void zza(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataDeleteRequest.zzkH());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataDeleteRequest.getVersionCode());
        zzb.zza(parcel, 2, dataDeleteRequest.zzrw());
        zzb.zzc(parcel, 3, dataDeleteRequest.getDataSources(), false);
        zzb.zzc(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        zzb.zzc(parcel, 5, dataDeleteRequest.getSessions(), false);
        zzb.zza(parcel, 6, dataDeleteRequest.zzsd());
        zzb.zza(parcel, 7, dataDeleteRequest.zzse());
        zzb.zza(parcel, 8, dataDeleteRequest.zzsc(), false);
        zzb.zza(parcel, 9, dataDeleteRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeH(x0);
    }

    public DataDeleteRequest zzcO(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        String str = null;
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
                    list = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    list2 = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list3 = zza.zzc(parcel, zzai, Session.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
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
            return new DataDeleteRequest(i, j, j2, list, list2, list3, z, z2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataDeleteRequest[] zzeH(int i) {
        return new DataDeleteRequest[i];
    }
}
