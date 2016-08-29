package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, driveId.mVersionCode);
        zzb.zza(parcel, 2, driveId.zzagC, false);
        zzb.zza(parcel, 3, driveId.zzagD);
        zzb.zza(parcel, 4, driveId.zzagn);
        zzb.zzc(parcel, 5, driveId.zzagE);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcc(x0);
    }

    public DriveId zzay(Parcel parcel) {
        long j = 0;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DriveId[] zzcc(int i) {
        return new DriveId[i];
    }
}
