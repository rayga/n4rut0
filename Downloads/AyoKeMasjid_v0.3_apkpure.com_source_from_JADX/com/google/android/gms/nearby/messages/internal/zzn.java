package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzn implements Creator<UnsubscribeRequest> {
    static void zza(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, unsubscribeRequest.mVersionCode);
        zzb.zza(parcel, 2, unsubscribeRequest.zzyq(), false);
        zzb.zza(parcel, 3, unsubscribeRequest.zzyp(), false);
        zzb.zza(parcel, 4, unsubscribeRequest.zzaKh, i, false);
        zzb.zzc(parcel, 5, unsubscribeRequest.zzaKi);
        zzb.zza(parcel, 6, unsubscribeRequest.zzaCr, false);
        zzb.zza(parcel, 7, unsubscribeRequest.zzaKe, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziu(x0);
    }

    public UnsubscribeRequest zzfG(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UnsubscribeRequest(i2, iBinder2, iBinder, pendingIntent, i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UnsubscribeRequest[] zziu(int i) {
        return new UnsubscribeRequest[i];
    }
}
