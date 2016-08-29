package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, mostRecentGameInfoEntity.zzuG(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, mostRecentGameInfoEntity.getVersionCode());
        zzb.zza(parcel, 2, mostRecentGameInfoEntity.zzuH(), false);
        zzb.zza(parcel, 3, mostRecentGameInfoEntity.zzuI());
        zzb.zza(parcel, 4, mostRecentGameInfoEntity.zzuJ(), i, false);
        zzb.zza(parcel, 5, mostRecentGameInfoEntity.zzuK(), i, false);
        zzb.zza(parcel, 6, mostRecentGameInfoEntity.zzuL(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfY(x0);
    }

    public MostRecentGameInfoEntity zzdR(Parcel parcel) {
        Uri uri = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    uri3 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    uri2 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MostRecentGameInfoEntity[] zzfY(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
