package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzv implements Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionReadRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        zzb.zza(parcel, 3, sessionReadRequest.zzkH());
        zzb.zza(parcel, 4, sessionReadRequest.zzrw());
        zzb.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        zzb.zza(parcel, 7, sessionReadRequest.zzsw());
        zzb.zza(parcel, 8, sessionReadRequest.zzsh());
        zzb.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        zzb.zza(parcel, 10, sessionReadRequest.zzsc(), false);
        zzb.zza(parcel, 11, sessionReadRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeZ(x0);
    }

    public SessionReadRequest zzdf(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        IBinder iBinder = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    list2 = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    list3 = zza.zzC(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str3 = zza.zzo(parcel, zzai);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3, iBinder, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SessionReadRequest[] zzeZ(int i) {
        return new SessionReadRequest[i];
    }
}
