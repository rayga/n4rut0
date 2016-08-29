package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbc implements Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.mVersionCode);
        zzb.zza(parcel, 2, onListEntriesResponse.zzajT, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzaio);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzde(x0);
    }

    public OnListEntriesResponse zzbq(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            DataHolder dataHolder2;
            int zzg;
            boolean z2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzai);
                    z2 = z3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z2 = zza.zzc(parcel, zzai);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnListEntriesResponse[] zzde(int i) {
        return new OnListEntriesResponse[i];
    }
}
