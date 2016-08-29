package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzbp implements Creator<SetFileUploadPreferencesRequest> {
    static void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, setFileUploadPreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, setFileUploadPreferencesRequest.zzajJ, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdq(x0);
    }

    public SetFileUploadPreferencesRequest zzbC(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) zza.zza(parcel, zzai, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SetFileUploadPreferencesRequest[] zzdq(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }
}
