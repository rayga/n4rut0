package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzj implements Creator<CreateContentsRequest> {
    static void zza(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createContentsRequest.mVersionCode);
        zzb.zzc(parcel, 2, createContentsRequest.zzagr);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcB(x0);
    }

    public CreateContentsRequest zzaS(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateContentsRequest(i, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CreateContentsRequest[] zzcB(int i) {
        return new CreateContentsRequest[i];
    }
}
