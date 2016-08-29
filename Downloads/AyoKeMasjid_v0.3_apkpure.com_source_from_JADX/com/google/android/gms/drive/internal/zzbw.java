package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzbw implements Creator<UpdatePermissionRequest> {
    static void zza(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, updatePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, updatePermissionRequest.zzags, i, false);
        zzb.zza(parcel, 3, updatePermissionRequest.zzagY, false);
        zzb.zzc(parcel, 4, updatePermissionRequest.zzakb);
        zzb.zza(parcel, 5, updatePermissionRequest.zzahM);
        zzb.zza(parcel, 6, updatePermissionRequest.zzagM, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdw(x0);
    }

    public UpdatePermissionRequest zzbI(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UpdatePermissionRequest(i2, driveId, str2, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UpdatePermissionRequest[] zzdw(int i) {
        return new UpdatePermissionRequest[i];
    }
}
