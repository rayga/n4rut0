package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    static void zza(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, invitationEntity.getGame(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        zzb.zza(parcel, 2, invitationEntity.getInvitationId(), false);
        zzb.zza(parcel, 3, invitationEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, invitationEntity.getInvitationType());
        zzb.zza(parcel, 5, invitationEntity.getInviter(), i, false);
        zzb.zzc(parcel, 6, invitationEntity.getParticipants(), false);
        zzb.zzc(parcel, 7, invitationEntity.getVariant());
        zzb.zzc(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgb(x0);
    }

    public InvitationEntity zzdT(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    participantEntity = (ParticipantEntity) zza.zza(parcel, zzai, ParticipantEntity.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    arrayList = zza.zzc(parcel, zzai, ParticipantEntity.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    i = zza.zzg(parcel, zzai);
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public InvitationEntity[] zzgb(int i) {
        return new InvitationEntity[i];
    }
}
