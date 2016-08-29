package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzb.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, playerEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzb.zzc(parcel, 6, playerEntity.zzsS());
        zzb.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzb.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 14, playerEntity.getTitle(), false);
        zzb.zza(parcel, 15, playerEntity.zzsT(), i, false);
        zzb.zza(parcel, 16, playerEntity.getLevelInfo(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        zzb.zza(parcel, 19, playerEntity.zzsR());
        zzb.zza(parcel, 18, playerEntity.isProfileVisible());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfy(x0);
    }

    public PlayerEntity zzdD(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
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
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    uri2 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zza.zza(parcel, zzai, MostRecentGameInfoEntity.CREATOR);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    playerLevelInfo = (PlayerLevelInfo) zza.zza(parcel, zzai, PlayerLevelInfo.CREATOR);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    z2 = zza.zzc(parcel, zzai);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlayerEntity[] zzfy(int i) {
        return new PlayerEntity[i];
    }
}
