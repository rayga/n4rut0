package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    static void zza(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, zInvitationCluster.zzuA(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, zInvitationCluster.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfW(x0);
    }

    public ZInvitationCluster zzdQ(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    arrayList = zza.zzc(parcel, zzai, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ZInvitationCluster[] zzfW(int i) {
        return new ZInvitationCluster[i];
    }
}
