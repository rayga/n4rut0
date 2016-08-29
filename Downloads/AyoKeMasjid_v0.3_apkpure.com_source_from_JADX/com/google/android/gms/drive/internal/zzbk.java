package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.vision.barcode.Barcode;

public class zzbk implements Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzagU, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzagV, false);
        zzb.zza(parcel, 4, openFileIntentSenderRequest.zzagX, i, false);
        zzb.zza(parcel, 5, openFileIntentSenderRequest.zzajX, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdl(x0);
    }

    public OpenFileIntentSenderRequest zzbx(Parcel parcel) {
        FilterHolder filterHolder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzai, FilterHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OpenFileIntentSenderRequest[] zzdl(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
