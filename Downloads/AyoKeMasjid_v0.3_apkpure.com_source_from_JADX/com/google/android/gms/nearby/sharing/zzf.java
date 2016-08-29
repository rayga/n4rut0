package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzf implements Creator<ViewableItem> {
    static void zza(ViewableItem viewableItem, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, viewableItem.getVersionCode());
        zzb.zza(parcel, 2, viewableItem.zzyv(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziy(x0);
    }

    public ViewableItem zzfK(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ViewableItem(i, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ViewableItem[] zziy(int i) {
        return new ViewableItem[i];
    }
}
