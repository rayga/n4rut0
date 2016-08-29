package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzk implements Creator<TrustedDevicesRequest> {
    static void zza(TrustedDevicesRequest trustedDevicesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, trustedDevicesRequest.versionCode);
        zzb.zza(parcel, 2, trustedDevicesRequest.zzaKw, false);
        zzb.zza(parcel, 3, trustedDevicesRequest.zzaKx, false);
        zzb.zza(parcel, 4, trustedDevicesRequest.zzyp(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziC(x0);
    }

    public TrustedDevicesRequest zzfO(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new TrustedDevicesRequest(i, str, bArr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public TrustedDevicesRequest[] zziC(int i) {
        return new TrustedDevicesRequest[i];
    }
}
