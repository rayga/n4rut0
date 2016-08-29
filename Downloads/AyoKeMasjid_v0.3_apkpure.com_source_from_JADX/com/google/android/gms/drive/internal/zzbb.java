package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbb implements Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.mVersionCode);
        zzb.zza(parcel, 2, onFetchThumbnailResponse.zzajS, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdd(x0);
    }

    public OnFetchThumbnailResponse zzbp(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnFetchThumbnailResponse[] zzdd(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
