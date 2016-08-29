package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zze implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, completionEvent.mVersionCode);
        zzb.zza(parcel, 2, completionEvent.zzags, i, false);
        zzb.zza(parcel, 3, completionEvent.zzQE, false);
        zzb.zza(parcel, 4, completionEvent.zzahs, i, false);
        zzb.zza(parcel, 5, completionEvent.zzaht, i, false);
        zzb.zza(parcel, 6, completionEvent.zzahu, i, false);
        zzb.zzb(parcel, 7, completionEvent.zzahv, false);
        zzb.zzc(parcel, 8, completionEvent.zzxJ);
        zzb.zza(parcel, 9, completionEvent.zzahw, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcp(x0);
    }

    public CompletionEvent zzaH(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
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
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    list = zza.zzC(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CompletionEvent[] zzcp(int i) {
        return new CompletionEvent[i];
    }
}
