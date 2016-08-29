package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzau implements Creator<OnChangesResponse> {
    static void zza(OnChangesResponse onChangesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onChangesResponse.mVersionCode);
        zzb.zza(parcel, 2, onChangesResponse.zzajE, i, false);
        zzb.zzc(parcel, 3, onChangesResponse.zzajF, false);
        zzb.zza(parcel, 4, onChangesResponse.zzajG, i, false);
        zzb.zza(parcel, 5, onChangesResponse.zzajH);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcW(x0);
    }

    public OnChangesResponse zzbi(Parcel parcel) {
        boolean z = false;
        ChangeSequenceNumber changeSequenceNumber = null;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzc(parcel, zzai, DriveId.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzai, ChangeSequenceNumber.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnChangesResponse(i, dataHolder, list, changeSequenceNumber, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnChangesResponse[] zzcW(int i) {
        return new OnChangesResponse[i];
    }
}
