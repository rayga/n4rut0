package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzc implements Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        zzb.zza(parcel, 3, sharedContent.getUri(), false);
        zzb.zza(parcel, 8, sharedContent.zzyt(), i, false);
        zzb.zza(parcel, 9, sharedContent.zzyu(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzix(x0);
    }

    public SharedContent zzfJ(Parcel parcel) {
        LocalContent[] localContentArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ViewableItem[] viewableItemArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            ViewableItem[] viewableItemArr2;
            String str2;
            int zzg;
            LocalContent[] localContentArr2;
            int zzai = zza.zzai(parcel);
            LocalContent[] localContentArr3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    localContentArr3 = localContentArr;
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = zza.zzg(parcel, zzai);
                    localContentArr2 = localContentArr3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzg = i;
                    ViewableItem[] viewableItemArr3 = viewableItemArr;
                    str2 = zza.zzo(parcel, zzai);
                    localContentArr2 = localContentArr;
                    viewableItemArr2 = viewableItemArr3;
                    break;
                case Barcode.URL /*8*/:
                    str2 = str;
                    zzg = i;
                    localContentArr3 = localContentArr;
                    viewableItemArr2 = (ViewableItem[]) zza.zzb(parcel, zzai, ViewableItem.CREATOR);
                    localContentArr2 = localContentArr3;
                    break;
                case Barcode.WIFI /*9*/:
                    localContentArr2 = (LocalContent[]) zza.zzb(parcel, zzai, LocalContent.CREATOR);
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    localContentArr2 = localContentArr;
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = i;
                    break;
            }
            i = zzg;
            str = str2;
            viewableItemArr = viewableItemArr2;
            localContentArr = localContentArr2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SharedContent(i, str, viewableItemArr, localContentArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SharedContent[] zzix(int i) {
        return new SharedContent[i];
    }
}
