package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<FrameMetadataParcel> {
    static void zza(FrameMetadataParcel frameMetadataParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, frameMetadataParcel.versionCode);
        zzb.zzc(parcel, 2, frameMetadataParcel.width);
        zzb.zzc(parcel, 3, frameMetadataParcel.height);
        zzb.zzc(parcel, 4, frameMetadataParcel.id);
        zzb.zza(parcel, 5, frameMetadataParcel.zzaVY);
        zzb.zzc(parcel, 6, frameMetadataParcel.rotation);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjI(x0);
    }

    public FrameMetadataParcel zzgD(Parcel parcel) {
        int i = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FrameMetadataParcel(i5, i4, i3, i2, j, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FrameMetadataParcel[] zzjI(int i) {
        return new FrameMetadataParcel[i];
    }
}
