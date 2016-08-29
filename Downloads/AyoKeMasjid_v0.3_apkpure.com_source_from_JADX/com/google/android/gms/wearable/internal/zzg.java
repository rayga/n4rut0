package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzg implements Creator<AncsNotificationParcelable> {
    static void zza(AncsNotificationParcelable ancsNotificationParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, ancsNotificationParcelable.mVersionCode);
        zzb.zzc(parcel, 2, ancsNotificationParcelable.getId());
        zzb.zza(parcel, 3, ancsNotificationParcelable.zztW(), false);
        zzb.zza(parcel, 4, ancsNotificationParcelable.zzCw(), false);
        zzb.zza(parcel, 5, ancsNotificationParcelable.zzCx(), false);
        zzb.zza(parcel, 6, ancsNotificationParcelable.getTitle(), false);
        zzb.zza(parcel, 7, ancsNotificationParcelable.zztn(), false);
        zzb.zza(parcel, 8, ancsNotificationParcelable.getDisplayName(), false);
        zzb.zza(parcel, 9, ancsNotificationParcelable.zzCy());
        zzb.zza(parcel, 10, ancsNotificationParcelable.zzCz());
        zzb.zza(parcel, 11, ancsNotificationParcelable.zzCA());
        zzb.zza(parcel, 12, ancsNotificationParcelable.zzCB());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkz(x0);
    }

    public AncsNotificationParcelable zzhr(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    b = zza.zze(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    b2 = zza.zze(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    b3 = zza.zze(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    b4 = zza.zze(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AncsNotificationParcelable(i, i2, str, str2, str3, str4, str5, str6, b, b2, b3, b4);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AncsNotificationParcelable[] zzkz(int i) {
        return new AncsNotificationParcelable[i];
    }
}
