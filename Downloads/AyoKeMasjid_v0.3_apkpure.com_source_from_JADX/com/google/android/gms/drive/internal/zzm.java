package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.vision.barcode.Barcode;

public class zzm implements Creator<CreateFileRequest> {
    static void zza(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createFileRequest.mVersionCode);
        zzb.zza(parcel, 2, createFileRequest.zzaid, i, false);
        zzb.zza(parcel, 3, createFileRequest.zzaib, i, false);
        zzb.zza(parcel, 4, createFileRequest.zzahR, i, false);
        zzb.zza(parcel, 5, createFileRequest.zzaic, false);
        zzb.zza(parcel, 6, createFileRequest.zzahM);
        zzb.zza(parcel, 7, createFileRequest.zzagM, false);
        zzb.zzc(parcel, 8, createFileRequest.zzaie);
        zzb.zzc(parcel, 9, createFileRequest.zzaif);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcE(x0);
    }

    public CreateFileRequest zzaU(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
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
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    contents = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    num = zza.zzh(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CreateFileRequest[] zzcE(int i) {
        return new CreateFileRequest[i];
    }
}
