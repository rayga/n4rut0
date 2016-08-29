package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode;

public class zzk implements Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, queryResultEventParcelable.zzYX, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzahH);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzahI);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcr(x0);
    }

    public QueryResultEventParcelable zzaJ(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DataHolder dataHolder = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            boolean z2;
            DataHolder dataHolder2;
            int zzg;
            int zzai = zza.zzai(parcel);
            int i3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzai);
                    zzai = i3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    boolean z3 = z;
                    dataHolder2 = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
                    zzai = i;
                    z2 = z3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    i3 = i;
                    z2 = zza.zzc(parcel, zzai);
                    zzai = i3;
                    break;
                case Barcode.PHONE /*4*/:
                    zzai = zza.zzg(parcel, zzai);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzai = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            dataHolder = dataHolder2;
            z = z2;
            i = zzai;
        }
        if (parcel.dataPosition() == zzaj) {
            return new QueryResultEventParcelable(i2, dataHolder, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public QueryResultEventParcelable[] zzcr(int i) {
        return new QueryResultEventParcelable[i];
    }
}
