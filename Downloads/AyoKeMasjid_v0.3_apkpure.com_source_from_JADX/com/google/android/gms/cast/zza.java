package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zza implements Creator<ApplicationMetadata> {
    static void zza(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, applicationMetadata.getVersionCode());
        zzb.zza(parcel, 2, applicationMetadata.getApplicationId(), false);
        zzb.zza(parcel, 3, applicationMetadata.getName(), false);
        zzb.zzc(parcel, 4, applicationMetadata.getImages(), false);
        zzb.zzb(parcel, 5, applicationMetadata.zzSY, false);
        zzb.zza(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        zzb.zza(parcel, 7, applicationMetadata.zzlM(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaH(x0);
    }

    public ApplicationMetadata zzR(Parcel parcel) {
        Uri uri = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, WebImage.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ApplicationMetadata[] zzaH(int i) {
        return new ApplicationMetadata[i];
    }
}
