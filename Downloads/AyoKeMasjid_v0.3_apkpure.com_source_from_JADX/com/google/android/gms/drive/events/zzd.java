package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzd implements Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.mVersionCode);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzaho);
        zzb.zza(parcel, 3, changesAvailableOptions.zzahp);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzahq, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzco(x0);
    }

    public ChangesAvailableOptions zzaG(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzc(parcel, zzai, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChangesAvailableOptions(i2, i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChangesAvailableOptions[] zzco(int i) {
        return new ChangesAvailableOptions[i];
    }
}
