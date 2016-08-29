package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, changeEvent.mVersionCode);
        zzb.zza(parcel, 2, changeEvent.zzags, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzahm);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcm(x0);
    }

    public ChangeEvent zzaE(Parcel parcel) {
        int i = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            DriveId driveId2;
            int zzg;
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    zzai = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzai = i;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzai = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
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
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChangeEvent[] zzcm(int i) {
        return new ChangeEvent[i];
    }
}
