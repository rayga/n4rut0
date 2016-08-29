package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    static void zza(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, gameRequestEntity.getGame(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestEntity.getVersionCode());
        zzb.zza(parcel, 2, gameRequestEntity.getSender(), i, false);
        zzb.zza(parcel, 3, gameRequestEntity.getData(), false);
        zzb.zza(parcel, 4, gameRequestEntity.getRequestId(), false);
        zzb.zzc(parcel, 5, gameRequestEntity.getRecipients(), false);
        zzb.zzc(parcel, 7, gameRequestEntity.getType());
        zzb.zza(parcel, 9, gameRequestEntity.getCreationTimestamp());
        zzb.zza(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        zzb.zza(parcel, 11, gameRequestEntity.zzvb(), false);
        zzb.zzc(parcel, 12, gameRequestEntity.getStatus());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgj(x0);
    }

    public GameRequestEntity zzeb(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    gameEntity = (GameEntity) zza.zza(parcel, zzai, GameEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzai, PlayerEntity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    arrayList = zza.zzc(parcel, zzai, PlayerEntity.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i3 = zza.zzg(parcel, zzai);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GameRequestEntity[] zzgj(int i) {
        return new GameRequestEntity[i];
    }
}
