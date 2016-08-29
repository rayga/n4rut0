package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<BeginCompoundOperationRequest> {
    static void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, beginCompoundOperationRequest.mVersionCode);
        zzb.zza(parcel, 2, beginCompoundOperationRequest.zzalV);
        zzb.zza(parcel, 3, beginCompoundOperationRequest.mName, false);
        zzb.zza(parcel, 4, beginCompoundOperationRequest.zzalW);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdR(x0);
    }

    public BeginCompoundOperationRequest zzcd(Parcel parcel) {
        boolean z = false;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public BeginCompoundOperationRequest[] zzdR(int i) {
        return new BeginCompoundOperationRequest[i];
    }
}
