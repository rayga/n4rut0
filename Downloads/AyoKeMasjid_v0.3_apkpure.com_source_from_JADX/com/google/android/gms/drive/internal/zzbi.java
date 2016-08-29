package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzbi implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, openContentsRequest.zzahP, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzagr);
        zzb.zzc(parcel, 4, openContentsRequest.zzajV);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdk(x0);
    }

    public OpenContentsRequest zzbw(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            DriveId driveId2;
            int zzg;
            int zzai = zza.zzai(parcel);
            int i4;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzai);
                    zzai = i4;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzai = i;
                    i = i4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzai);
                    zzai = i4;
                    break;
                case Barcode.PHONE /*4*/:
                    zzai = zza.zzg(parcel, zzai);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzai = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzai;
        }
        if (parcel.dataPosition() == zzaj) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OpenContentsRequest[] zzdk(int i) {
        return new OpenContentsRequest[i];
    }
}
