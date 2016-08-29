package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    static void zza(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerLevelInfo.getVersionCode());
        zzb.zza(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        zzb.zza(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        zzb.zza(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfA(x0);
    }

    public PlayerLevelInfo zzdF(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    playerLevel2 = (PlayerLevel) zza.zza(parcel, zzai, PlayerLevel.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    playerLevel = (PlayerLevel) zza.zza(parcel, zzai, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlayerLevelInfo[] zzfA(int i) {
        return new PlayerLevelInfo[i];
    }
}
