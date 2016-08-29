package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
    static void zza(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, achievementEntity.getAchievementId(), false);
        zzb.zzc(parcel, 2, achievementEntity.getType());
        zzb.zza(parcel, 3, achievementEntity.getName(), false);
        zzb.zza(parcel, 4, achievementEntity.getDescription(), false);
        zzb.zza(parcel, 5, achievementEntity.getUnlockedImageUri(), i, false);
        zzb.zza(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        zzb.zza(parcel, 7, achievementEntity.getRevealedImageUri(), i, false);
        zzb.zza(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        zzb.zzc(parcel, 9, achievementEntity.zzsV());
        zzb.zza(parcel, 10, achievementEntity.zzsW(), false);
        zzb.zza(parcel, 11, achievementEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 12, achievementEntity.getState());
        zzb.zzc(parcel, 13, achievementEntity.zzsX());
        zzb.zza(parcel, 14, achievementEntity.zzsY(), false);
        zzb.zza(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 16, achievementEntity.getXpValue());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, achievementEntity.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfB(x0);
    }

    public AchievementEntity zzdG(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    uri2 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzai, PlayerEntity.CREATOR);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str7 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    j2 = zza.zzi(parcel, zzai);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AchievementEntity[] zzfB(int i) {
        return new AchievementEntity[i];
    }
}
