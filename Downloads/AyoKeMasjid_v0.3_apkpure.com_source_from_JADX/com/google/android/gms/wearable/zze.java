package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<Asset> {
    static void zza(Asset asset, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, asset.mVersionCode);
        zzb.zza(parcel, 2, asset.getData(), false);
        zzb.zza(parcel, 3, asset.getDigest(), false);
        zzb.zza(parcel, 4, asset.zzaYL, i, false);
        zzb.zza(parcel, 5, asset.uri, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkt(x0);
    }

    public Asset zzhl(Parcel parcel) {
        Uri uri = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Asset[] zzkt(int i) {
        return new Asset[i];
    }
}
