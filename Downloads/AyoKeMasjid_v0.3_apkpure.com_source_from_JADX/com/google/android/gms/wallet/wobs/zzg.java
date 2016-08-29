package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzg implements Creator<TimeInterval> {
    static void zza(TimeInterval timeInterval, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, timeInterval.getVersionCode());
        zzb.zza(parcel, 2, timeInterval.zzaYF);
        zzb.zza(parcel, 3, timeInterval.zzaYG);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkq(x0);
    }

    public TimeInterval zzhi(Parcel parcel) {
        long j = 0;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new TimeInterval(i, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public TimeInterval[] zzkq(int i) {
        return new TimeInterval[i];
    }
}
