package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzm implements Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, partialDriveId.mVersionCode);
        zzb.zza(parcel, 2, partialDriveId.zzagC, false);
        zzb.zza(parcel, 3, partialDriveId.zzagD);
        zzb.zzc(parcel, 4, partialDriveId.zzagE);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdC(x0);
    }

    public PartialDriveId zzbO(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        int i2 = -1;
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
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PartialDriveId(i, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PartialDriveId[] zzdC(int i) {
        return new PartialDriveId[i];
    }
}
