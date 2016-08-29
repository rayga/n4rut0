package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, addEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, addEventListenerRequest.zzags, i, false);
        zzb.zzc(parcel, 3, addEventListenerRequest.zzafk);
        zzb.zza(parcel, 4, addEventListenerRequest.zzahn, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzct(x0);
    }

    public AddEventListenerRequest zzaK(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int i = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int i3;
            DriveId driveId2;
            int zzg;
            ChangesAvailableOptions changesAvailableOptions2;
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            ChangesAvailableOptions changesAvailableOptions3;
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    changesAvailableOptions3 = changesAvailableOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    changesAvailableOptions2 = changesAvailableOptions3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    int i4 = i;
                    driveId2 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, DriveId.CREATOR);
                    changesAvailableOptions2 = changesAvailableOptions;
                    i3 = i4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    driveId2 = driveId;
                    zzg = i2;
                    changesAvailableOptions3 = changesAvailableOptions;
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    changesAvailableOptions2 = changesAvailableOptions3;
                    break;
                case Barcode.PHONE /*4*/:
                    changesAvailableOptions2 = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ChangesAvailableOptions.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    changesAvailableOptions2 = changesAvailableOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = i3;
            changesAvailableOptions = changesAvailableOptions2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new AddEventListenerRequest(i2, driveId, i, changesAvailableOptions);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AddEventListenerRequest[] zzct(int i) {
        return new AddEventListenerRequest[i];
    }
}
