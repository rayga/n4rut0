package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzg implements Creator<DeviceStatus> {
    static void zza(DeviceStatus deviceStatus, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, deviceStatus.getVersionCode());
        zzb.zza(parcel, 2, deviceStatus.zzmy());
        zzb.zza(parcel, 3, deviceStatus.zzmH());
        zzb.zzc(parcel, 4, deviceStatus.zzmz());
        zzb.zza(parcel, 5, deviceStatus.getApplicationMetadata(), i, false);
        zzb.zzc(parcel, 6, deviceStatus.zzmA());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaY(x0);
    }

    public DeviceStatus zzV(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    d = zza.zzm(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    applicationMetadata = (ApplicationMetadata) zza.zza(parcel, zzai, ApplicationMetadata.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DeviceStatus(i3, d, z, i2, applicationMetadata, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DeviceStatus[] zzaY(int i) {
        return new DeviceStatus[i];
    }
}
