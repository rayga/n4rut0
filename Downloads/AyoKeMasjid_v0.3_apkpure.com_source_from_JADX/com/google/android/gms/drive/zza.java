package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<ChangeSequenceNumber> {
    static void zza(ChangeSequenceNumber changeSequenceNumber, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, changeSequenceNumber.mVersionCode);
        zzb.zza(parcel, 2, changeSequenceNumber.zzagm);
        zzb.zza(parcel, 3, changeSequenceNumber.zzagn);
        zzb.zza(parcel, 4, changeSequenceNumber.zzago);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzca(x0);
    }

    public ChangeSequenceNumber zzaw(Parcel parcel) {
        long j = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChangeSequenceNumber(i, j3, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChangeSequenceNumber[] zzca(int i) {
        return new ChangeSequenceNumber[i];
    }
}
