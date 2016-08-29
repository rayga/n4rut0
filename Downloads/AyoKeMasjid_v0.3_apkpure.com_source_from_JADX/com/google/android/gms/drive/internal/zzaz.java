package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzaz implements Creator<OnDrivePreferencesResponse> {
    static void zza(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onDrivePreferencesResponse.mVersionCode);
        zzb.zza(parcel, 2, onDrivePreferencesResponse.zzajM, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdb(x0);
    }

    public OnDrivePreferencesResponse zzbn(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzai, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnDrivePreferencesResponse[] zzdb(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
