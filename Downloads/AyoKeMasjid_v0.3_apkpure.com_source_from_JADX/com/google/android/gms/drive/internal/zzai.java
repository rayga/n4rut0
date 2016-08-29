package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzai implements Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, getMetadataRequest.zzahP, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzajq);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcR(x0);
    }

    public GetMetadataRequest zzbd(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            DriveId driveId2;
            int zzg;
            boolean z2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    boolean z3 = z;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzai);
                    z2 = z3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z2 = zza.zzc(parcel, zzai);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetMetadataRequest(i, driveId, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetMetadataRequest[] zzcR(int i) {
        return new GetMetadataRequest[i];
    }
}
