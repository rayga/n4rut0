package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    static void zza(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        zzb.zza(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        zzb.zza(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        zzb.zza(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        zzb.zza(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        zzb.zza(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        zzb.zzc(parcel, 8, turnBasedMatchEntity.getStatus());
        zzb.zzc(parcel, 10, turnBasedMatchEntity.getVariant());
        zzb.zzc(parcel, 11, turnBasedMatchEntity.getVersion());
        zzb.zza(parcel, 12, turnBasedMatchEntity.getData(), false);
        zzb.zzc(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        zzb.zza(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        zzb.zza(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        zzb.zza(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, turnBasedMatchEntity.getVersionCode());
        zzb.zza(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        zzb.zzc(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        zzb.zza(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        zzb.zza(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgg(x0);
    }

    public TurnBasedMatchEntity zzdY(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    gameEntity = (GameEntity) zza.zza(parcel, zzai, GameEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    arrayList = zza.zzc(parcel, zzai, ParticipantEntity.CREATOR);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    bArr2 = zza.zzr(parcel, zzai);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case Place.TYPE_CAR_DEALER /*17*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    i6 = zza.zzg(parcel, zzai);
                    break;
                case Place.TYPE_CAR_REPAIR /*19*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CASINO /*21*/:
                    str7 = zza.zzo(parcel, zzai);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public TurnBasedMatchEntity[] zzgg(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
