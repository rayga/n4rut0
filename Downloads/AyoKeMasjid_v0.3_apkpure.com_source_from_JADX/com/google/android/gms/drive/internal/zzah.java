package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzah implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.mVersionCode);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzajo, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzajp);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcQ(x0);
    }

    public GetDriveIdFromUniqueIdentifierRequest zzbc(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i = 0;
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
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] zzcQ(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
