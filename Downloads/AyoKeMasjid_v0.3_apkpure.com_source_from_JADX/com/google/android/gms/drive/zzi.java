package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.List;

public class zzi implements Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.mVersionCode);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzahe, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzahf, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzck(x0);
    }

    public RealtimeDocumentSyncRequest zzaC(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list2 = zza.zzC(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzC(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public RealtimeDocumentSyncRequest[] zzck(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
