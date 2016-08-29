package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbm implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, removeEventListenerRequest.zzags, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzafk);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdn(x0);
    }

    public RemoveEventListenerRequest zzbz(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            DriveId driveId2;
            int zzg;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzai);
                    zzai = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzai = i;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzai = zza.zzg(parcel, zzai);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzai = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzai;
        }
        if (parcel.dataPosition() == zzaj) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public RemoveEventListenerRequest[] zzdn(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
