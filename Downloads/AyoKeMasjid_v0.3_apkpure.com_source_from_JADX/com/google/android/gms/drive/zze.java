package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zze implements Creator<DrivePreferences> {
    static void zza(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, drivePreferences.mVersionCode);
        zzb.zza(parcel, 2, drivePreferences.zzagG);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcd(x0);
    }

    public DrivePreferences zzaz(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DrivePreferences(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DrivePreferences[] zzcd(int i) {
        return new DrivePreferences[i];
    }
}
