package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentCardEntity.getVersionCode());
        zzb.zzc(parcel, 2, appContentCardEntity.zztl(), false);
        zzb.zzc(parcel, 3, appContentCardEntity.zzta(), false);
        zzb.zza(parcel, 4, appContentCardEntity.zztb(), false);
        zzb.zzc(parcel, 5, appContentCardEntity.zztm());
        zzb.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzb.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzb.zza(parcel, 10, appContentCardEntity.zztn(), false);
        zzb.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzb.zzc(parcel, 12, appContentCardEntity.zzto());
        zzb.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzb.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfE(x0);
    }

    public AppContentCardEntity zzdJ(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    arrayList = zza.zzc(parcel, zzai, AppContentActionEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    arrayList2 = zza.zzc(parcel, zzai, AppContentAnnotationEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    arrayList3 = zza.zzc(parcel, zzai, AppContentConditionEntity.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str6 = zza.zzo(parcel, zzai);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AppContentCardEntity[] zzfE(int i) {
        return new AppContentCardEntity[i];
    }
}
