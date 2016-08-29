package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Creator<ProgressEvent> {
    static void zza(ProgressEvent progressEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, progressEvent.mVersionCode);
        zzb.zza(parcel, 2, progressEvent.zzags, i, false);
        zzb.zzc(parcel, 3, progressEvent.zzxJ);
        zzb.zza(parcel, 4, progressEvent.zzahF);
        zzb.zza(parcel, 5, progressEvent.zzahG);
        zzb.zzc(parcel, 6, progressEvent.zzUS);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcq(x0);
    }

    public ProgressEvent zzaI(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ProgressEvent(i3, driveId, i2, j2, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ProgressEvent[] zzcq(int i) {
        return new ProgressEvent[i];
    }
}
