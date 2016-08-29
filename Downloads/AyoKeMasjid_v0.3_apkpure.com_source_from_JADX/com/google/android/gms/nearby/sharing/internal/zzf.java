package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzf implements Creator<ProvideContentRequest> {
    static void zza(ProvideContentRequest provideContentRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, provideContentRequest.versionCode);
        zzb.zza(parcel, 2, provideContentRequest.zzaKq, false);
        zzb.zza(parcel, 3, provideContentRequest.zzyx(), false);
        zzb.zzc(parcel, 4, provideContentRequest.zzaKs, false);
        zzb.zza(parcel, 5, provideContentRequest.zzaKt);
        zzb.zza(parcel, 6, provideContentRequest.zzyp(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziz(x0);
    }

    public ProvideContentRequest zzfL(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder3 = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzc(parcel, zzai, SharedContent.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ProvideContentRequest(i, iBinder3, iBinder2, list, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ProvideContentRequest[] zziz(int i) {
        return new ProvideContentRequest[i];
    }
}
