package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void zza(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, participantEntity.getParticipantId(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        zzb.zza(parcel, 2, participantEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, participantEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        zzb.zzc(parcel, 5, participantEntity.getStatus());
        zzb.zza(parcel, 6, participantEntity.zztD(), false);
        zzb.zza(parcel, 7, participantEntity.isConnectedToRoom());
        zzb.zza(parcel, 8, participantEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 9, participantEntity.getCapabilities());
        zzb.zza(parcel, 10, participantEntity.getResult(), i, false);
        zzb.zza(parcel, 11, participantEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, participantEntity.getHiResImageUrl(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgc(x0);
    }

    public ParticipantEntity zzdU(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzai, PlayerEntity.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    participantResult = (ParticipantResult) zza.zza(parcel, zzai, ParticipantResult.CREATOR);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    str5 = zza.zzo(parcel, zzai);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ParticipantEntity[] zzgc(int i) {
        return new ParticipantEntity[i];
    }
}
