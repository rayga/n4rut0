package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class zzc implements Creator<LabelValueRow> {
    static void zza(LabelValueRow labelValueRow, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, labelValueRow.getVersionCode());
        zzb.zza(parcel, 2, labelValueRow.zzaYv, false);
        zzb.zza(parcel, 3, labelValueRow.zzaYw, false);
        zzb.zzc(parcel, 4, labelValueRow.zzaYx, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhe(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkm(x0);
    }

    public LabelValueRow zzhe(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList zzpM = zzli.zzpM();
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    zzpM = zza.zzc(parcel, zzai, LabelValue.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LabelValueRow(i, str2, str, zzpM);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LabelValueRow[] zzkm(int i) {
        return new LabelValueRow[i];
    }
}
