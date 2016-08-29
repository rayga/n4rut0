package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzo implements Creator<TileOverlayOptions> {
    static void zza(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, tileOverlayOptions.getVersionCode());
        zzb.zza(parcel, 2, tileOverlayOptions.zzxf(), false);
        zzb.zza(parcel, 3, tileOverlayOptions.isVisible());
        zzb.zza(parcel, 4, tileOverlayOptions.getZIndex());
        zzb.zza(parcel, 5, tileOverlayOptions.getFadeIn());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhK(x0);
    }

    public TileOverlayOptions zzfk(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    f = zza.zzl(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public TileOverlayOptions[] zzhK(int i) {
        return new TileOverlayOptions[i];
    }
}
