package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzd implements Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.mVersionCode);
        zzb.zzc(parcel, 2, parcelableEventList.zzoP, false);
        zzb.zza(parcel, 3, parcelableEventList.zzamv, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzamw);
        zzb.zzb(parcel, 5, parcelableEventList.zzamx, false);
        zzb.zza(parcel, 6, parcelableEventList.zzamy, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzea(x0);
    }

    public ParcelableEventList zzcl(Parcel parcel) {
        boolean z = false;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list2 = zza.zzc(parcel, zzai, ParcelableEvent.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = zza.zzC(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    parcelableChangeInfo = (ParcelableChangeInfo) zza.zza(parcel, zzai, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableEventList(i, list2, dataHolder, z, list, parcelableChangeInfo);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ParcelableEventList[] zzea(int i) {
        return new ParcelableEventList[i];
    }
}
