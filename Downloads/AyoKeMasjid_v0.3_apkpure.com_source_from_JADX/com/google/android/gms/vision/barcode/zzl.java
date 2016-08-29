package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.UrlBookmark;

public class zzl implements Creator<UrlBookmark> {
    static void zza(UrlBookmark urlBookmark, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, urlBookmark.versionCode);
        zzb.zza(parcel, 2, urlBookmark.title, false);
        zzb.zza(parcel, 3, urlBookmark.url, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjB(x0);
    }

    public UrlBookmark zzgx(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
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
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UrlBookmark(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UrlBookmark[] zzjB(int i) {
        return new UrlBookmark[i];
    }
}
