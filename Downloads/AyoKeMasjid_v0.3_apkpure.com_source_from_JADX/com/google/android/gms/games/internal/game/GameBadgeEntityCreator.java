package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    static void zza(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, gameBadgeEntity.getType());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameBadgeEntity.getVersionCode());
        zzb.zza(parcel, 2, gameBadgeEntity.getTitle(), false);
        zzb.zza(parcel, 3, gameBadgeEntity.getDescription(), false);
        zzb.zza(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfT(x0);
    }

    public GameBadgeEntity zzdP(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GameBadgeEntity[] zzfT(int i) {
        return new GameBadgeEntity[i];
    }
}
