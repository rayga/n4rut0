package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.vision.barcode.Barcode;

public class zzl implements Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, createFileIntentSenderRequest.zzaib, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzagq);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzagU, false);
        zzb.zza(parcel, 5, createFileIntentSenderRequest.zzagX, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzaic, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcD(x0);
    }

    public CreateFileIntentSenderRequest zzaT(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    num = zza.zzh(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CreateFileIntentSenderRequest[] zzcD(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
