package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzz implements Creator<ResolveAccountResponse> {
    static void zza(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, resolveAccountResponse.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountResponse.zzacC, false);
        zzb.zza(parcel, 3, resolveAccountResponse.zzoP(), i, false);
        zzb.zza(parcel, 4, resolveAccountResponse.zzoQ());
        zzb.zza(parcel, 5, resolveAccountResponse.zzoR());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbF(x0);
    }

    public ResolveAccountResponse zzag(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
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
                    connectionResult = (ConnectionResult) zza.zza(parcel, zzai, ConnectionResult.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ResolveAccountResponse[] zzbF(int i) {
        return new ResolveAccountResponse[i];
    }
}
