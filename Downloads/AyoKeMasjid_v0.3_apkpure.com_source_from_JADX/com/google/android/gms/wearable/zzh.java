package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Creator<PutDataRequest> {
    static void zza(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, putDataRequest.mVersionCode);
        zzb.zza(parcel, 2, putDataRequest.getUri(), i, false);
        zzb.zza(parcel, 4, putDataRequest.zzCr(), false);
        zzb.zza(parcel, 5, putDataRequest.getData(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkv(x0);
    }

    public PutDataRequest zzhn(Parcel parcel) {
        byte[] bArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzaj) {
            Bundle bundle2;
            Uri uri2;
            int zzg;
            byte[] bArr2;
            int zzai = zza.zzai(parcel);
            byte[] bArr3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = zza.zzg(parcel, zzai);
                    bArr2 = bArr3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case Barcode.PHONE /*4*/:
                    uri2 = uri;
                    zzg = i;
                    bArr3 = bArr;
                    bundle2 = zza.zzq(parcel, zzai);
                    bArr2 = bArr3;
                    break;
                case Barcode.PRODUCT /*5*/:
                    bArr2 = zza.zzr(parcel, zzai);
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new PutDataRequest(i, uri, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PutDataRequest[] zzkv(int i) {
        return new PutDataRequest[i];
    }
}
