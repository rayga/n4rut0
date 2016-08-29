package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appContentActionEntity.zzta(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentActionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentActionEntity.zztb(), false);
        zzb.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzb.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzb.zza(parcel, 8, appContentActionEntity.zzsZ(), i, false);
        zzb.zza(parcel, 9, appContentActionEntity.zztc(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfC(x0);
    }

    public AppContentActionEntity zzdH(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    arrayList = zza.zzc(parcel, zzai, AppContentConditionEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zza.zza(parcel, zzai, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, appContentAnnotationEntity, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AppContentActionEntity[] zzfC(int i) {
        return new AppContentActionEntity[i];
    }
}
