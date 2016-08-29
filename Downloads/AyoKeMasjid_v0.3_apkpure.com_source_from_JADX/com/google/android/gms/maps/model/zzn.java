package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzn implements Creator<Tile> {
    static void zza(Tile tile, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, tile.getVersionCode());
        zzb.zzc(parcel, 2, tile.width);
        zzb.zzc(parcel, 3, tile.height);
        zzb.zza(parcel, 4, tile.data, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhJ(x0);
    }

    public Tile zzfj(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Tile[] zzhJ(int i) {
        return new Tile[i];
    }
}
