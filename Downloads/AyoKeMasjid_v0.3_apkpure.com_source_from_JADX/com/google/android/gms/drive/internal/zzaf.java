package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzaf implements Creator<FileUploadPreferencesImpl> {
    static void zza(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fileUploadPreferencesImpl.mVersionCode);
        zzb.zzc(parcel, 2, fileUploadPreferencesImpl.zzajj);
        zzb.zzc(parcel, 3, fileUploadPreferencesImpl.zzajk);
        zzb.zza(parcel, 4, fileUploadPreferencesImpl.zzajl);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcO(x0);
    }

    public FileUploadPreferencesImpl zzba(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FileUploadPreferencesImpl[] zzcO(int i) {
        return new FileUploadPreferencesImpl[i];
    }
}
