package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzf implements Creator<TextDeletedDetails> {
    static void zza(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, textDeletedDetails.mVersionCode);
        zzb.zzc(parcel, 2, textDeletedDetails.mIndex);
        zzb.zzc(parcel, 3, textDeletedDetails.zzamD);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzec(x0);
    }

    public TextDeletedDetails zzcn(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public TextDeletedDetails[] zzec(int i) {
        return new TextDeletedDetails[i];
    }
}
