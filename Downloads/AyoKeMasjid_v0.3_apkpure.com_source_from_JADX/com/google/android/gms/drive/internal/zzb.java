package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzb implements Creator<AddPermissionRequest> {
    static void zza(AddPermissionRequest addPermissionRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addPermissionRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addPermissionRequest.zzags, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addPermissionRequest.zzahJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPermissionRequest.zzahK);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPermissionRequest.zzahL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addPermissionRequest.zzahM);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addPermissionRequest.zzagM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcu(x0);
    }

    public AddPermissionRequest zzaL(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        boolean z2 = false;
        Permission permission = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    permission = (Permission) zza.zza(parcel, zzai, Permission.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AddPermissionRequest(i, driveId, permission, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AddPermissionRequest[] zzcu(int i) {
        return new AddPermissionRequest[i];
    }
}
