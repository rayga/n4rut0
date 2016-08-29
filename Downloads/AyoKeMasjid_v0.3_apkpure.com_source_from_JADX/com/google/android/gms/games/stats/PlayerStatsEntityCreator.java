package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class PlayerStatsEntityCreator implements Creator<PlayerStatsEntity> {
    static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, playerStatsEntity.zzvd());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerStatsEntity.getVersionCode());
        zzb.zza(parcel, 2, playerStatsEntity.zzve());
        zzb.zzc(parcel, 3, playerStatsEntity.zzvf());
        zzb.zzc(parcel, 4, playerStatsEntity.zzvg());
        zzb.zzc(parcel, 5, playerStatsEntity.zzvh());
        zzb.zza(parcel, 6, playerStatsEntity.zzvi());
        zzb.zza(parcel, 7, playerStatsEntity.zzvj());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgq(x0);
    }

    public PlayerStatsEntity zzeg(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzaj = zza.zzaj(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    f4 = zza.zzl(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    f3 = zza.zzl(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    f = zza.zzl(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlayerStatsEntity(i4, f4, f3, i3, i2, i, f2, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlayerStatsEntity[] zzgq(int i) {
        return new PlayerStatsEntity[i];
    }
}
