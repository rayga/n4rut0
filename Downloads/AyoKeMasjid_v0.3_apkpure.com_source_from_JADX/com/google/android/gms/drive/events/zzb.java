package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ChangesAvailableEvent> {
    static void zza(ChangesAvailableEvent changesAvailableEvent, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, changesAvailableEvent.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, changesAvailableEvent.zzQE, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, changesAvailableEvent.zzahn, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcn(x0);
    }

    public ChangesAvailableEvent zzaF(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
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
                    changesAvailableOptions = (ChangesAvailableOptions) zza.zza(parcel, zzai, ChangesAvailableOptions.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChangesAvailableEvent(i, str, changesAvailableOptions);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ChangesAvailableEvent[] zzcn(int i) {
        return new ChangesAvailableEvent[i];
    }
}
