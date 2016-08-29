package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, closeContentsRequest.zzahR, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzahV, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzahT);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcz(x0);
    }

    public CloseContentsRequest zzaQ(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Contents contents = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            Boolean bool2;
            Contents contents2;
            int zzg;
            int zzai = zza.zzai(parcel);
            int i3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzai);
                    zzai = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    Boolean bool3 = bool;
                    contents2 = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    zzai = i;
                    bool2 = bool3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    contents2 = contents;
                    zzg = i2;
                    i3 = i;
                    bool2 = zza.zzd(parcel, zzai);
                    zzai = i3;
                    break;
                case Barcode.PHONE /*4*/:
                    zzai = zza.zzg(parcel, zzai);
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzai = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            contents = contents2;
            bool = bool2;
            i = zzai;
        }
        if (parcel.dataPosition() == zzaj) {
            return new CloseContentsRequest(i2, contents, bool, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CloseContentsRequest[] zzcz(int i) {
        return new CloseContentsRequest[i];
    }
}
