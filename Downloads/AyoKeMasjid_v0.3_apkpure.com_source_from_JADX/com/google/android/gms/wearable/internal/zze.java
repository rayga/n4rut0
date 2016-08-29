package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<AmsEntityUpdateParcelable> {
    static void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, amsEntityUpdateParcelable.mVersionCode);
        zzb.zza(parcel, 2, amsEntityUpdateParcelable.zzCu());
        zzb.zza(parcel, 3, amsEntityUpdateParcelable.zzCv());
        zzb.zza(parcel, 4, amsEntityUpdateParcelable.getValue(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzky(x0);
    }

    public AmsEntityUpdateParcelable zzhq(Parcel parcel) {
        byte b = (byte) 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        byte b2 = (byte) 0;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    b2 = zza.zze(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    b = zza.zze(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AmsEntityUpdateParcelable(i, b2, b, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AmsEntityUpdateParcelable[] zzky(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}
