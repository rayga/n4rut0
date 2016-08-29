package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.ArrayList;
import java.util.List;

public class zzbq implements Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, setResourceParentsRequest.zzajZ, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzaka, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdr(x0);
    }

    public SetResourceParentsRequest zzbD(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaj) {
            DriveId driveId2;
            int zzg;
            ArrayList zzc;
            int zzai = zza.zzai(parcel);
            List list2;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    List list3 = list;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzai);
                    list2 = list3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzc = zza.zzc(parcel, zzai, DriveId.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SetResourceParentsRequest[] zzdr(int i) {
        return new SetResourceParentsRequest[i];
    }
}
