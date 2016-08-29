package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzg implements Creator<ConnectionConfiguration> {
    static void zza(ConnectionConfiguration connectionConfiguration, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, connectionConfiguration.mVersionCode);
        zzb.zza(parcel, 2, connectionConfiguration.getName(), false);
        zzb.zza(parcel, 3, connectionConfiguration.getAddress(), false);
        zzb.zzc(parcel, 4, connectionConfiguration.getType());
        zzb.zzc(parcel, 5, connectionConfiguration.getRole());
        zzb.zza(parcel, 6, connectionConfiguration.isEnabled());
        zzb.zza(parcel, 7, connectionConfiguration.isConnected());
        zzb.zza(parcel, 8, connectionConfiguration.zzCp(), false);
        zzb.zza(parcel, 9, connectionConfiguration.zzCq());
        zzb.zza(parcel, 10, connectionConfiguration.getNodeId(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzku(x0);
    }

    public ConnectionConfiguration zzhm(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ConnectionConfiguration(i3, str4, str3, i2, i, z3, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ConnectionConfiguration[] zzku(int i) {
        return new ConnectionConfiguration[i];
    }
}
