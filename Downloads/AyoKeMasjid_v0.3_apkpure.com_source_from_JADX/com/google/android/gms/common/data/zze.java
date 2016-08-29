package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataHolder.zznU(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataHolder.getVersionCode());
        zzb.zza(parcel, 2, dataHolder.zznV(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zznP(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbq(x0);
    }

    public DataHolder zzaa(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzaj = zza.zzaj(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzai, CursorWindow.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() != zzaj) {
            throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zznT();
        return dataHolder;
    }

    public DataHolder[] zzbq(int i) {
        return new DataHolder[i];
    }
}
