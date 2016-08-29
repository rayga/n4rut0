package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zza implements Creator<AppContentReceivedResult> {
    static void zza(AppContentReceivedResult appContentReceivedResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appContentReceivedResult.getVersionCode());
        zzb.zza(parcel, 2, appContentReceivedResult.zzyr(), i, false);
        zzb.zzc(parcel, 3, appContentReceivedResult.getStatusCode());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziv(x0);
    }

    public AppContentReceivedResult zzfH(Parcel parcel) {
        int i = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        Uri uri = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            Uri uri2;
            int zzg;
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    int i3 = i;
                    uri2 = uri;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    zzai = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    Uri uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    zzai = i;
                    uri2 = uri3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzai = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    uri2 = uri;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    zzai = i;
                    uri2 = uri;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            uri = uri2;
            i = zzai;
        }
        if (parcel.dataPosition() == zzaj) {
            return new AppContentReceivedResult(i2, uri, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AppContentReceivedResult[] zziv(int i) {
        return new AppContentReceivedResult[i];
    }
}
