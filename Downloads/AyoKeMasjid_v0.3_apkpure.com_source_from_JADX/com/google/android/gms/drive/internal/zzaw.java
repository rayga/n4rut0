package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzaw implements Creator<OnDeviceUsagePreferenceResponse> {
    static void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onDeviceUsagePreferenceResponse.mVersionCode);
        zzb.zza(parcel, 2, onDeviceUsagePreferenceResponse.zzajJ, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcY(x0);
    }

    public OnDeviceUsagePreferenceResponse zzbk(Parcel parcel) {
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
            return new OnDeviceUsagePreferenceResponse(i, fileUploadPreferencesImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnDeviceUsagePreferenceResponse[] zzcY(int i) {
        return new OnDeviceUsagePreferenceResponse[i];
    }
}
