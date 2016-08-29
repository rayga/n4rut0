package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzb implements Creator<Contents> {
    static void zza(Contents contents, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, contents.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, contents.zzabN, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, contents.zzagq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, contents.zzagr);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, contents.zzags, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, contents.zzagt);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, contents.zzrL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzax(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcb(x0);
    }

    public Contents zzax(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Contents[] zzcb(int i) {
        return new Contents[i];
    }
}
