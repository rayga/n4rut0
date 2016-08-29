package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<ConnectionEvent> {
    static void zza(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, connectionEvent.mVersionCode);
        zzb.zza(parcel, 2, connectionEvent.getTimeMillis());
        zzb.zza(parcel, 4, connectionEvent.zzpv(), false);
        zzb.zza(parcel, 5, connectionEvent.zzpw(), false);
        zzb.zza(parcel, 6, connectionEvent.zzpx(), false);
        zzb.zza(parcel, 7, connectionEvent.zzpy(), false);
        zzb.zza(parcel, 8, connectionEvent.zzpz(), false);
        zzb.zza(parcel, 10, connectionEvent.zzpC());
        zzb.zza(parcel, 11, connectionEvent.zzpB());
        zzb.zzc(parcel, 12, connectionEvent.getEventType());
        zzb.zza(parcel, 13, connectionEvent.zzpA(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzau(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbT(x0);
    }

    public ConnectionEvent zzau(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ConnectionEvent[] zzbT(int i) {
        return new ConnectionEvent[i];
    }
}
