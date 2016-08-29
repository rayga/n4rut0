package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzav implements Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        zzb.zza(parcel, 2, onContentsResponse.zzaiD, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzajI);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcX(x0);
    }

    public OnContentsResponse zzbj(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            Contents contents2;
            int zzg;
            boolean z2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    boolean z3 = z;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzai);
                    z2 = z3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    Contents contents3 = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z2 = zza.zzc(parcel, zzai);
                    contents2 = contents;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    z2 = z;
                    contents2 = contents;
                    zzg = i;
                    break;
            }
            i = zzg;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnContentsResponse[] zzcX(int i) {
        return new OnContentsResponse[i];
    }
}
