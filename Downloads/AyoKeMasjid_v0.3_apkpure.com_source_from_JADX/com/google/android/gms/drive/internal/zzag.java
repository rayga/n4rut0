package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.List;

public class zzag implements Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.mVersionCode);
        zzb.zza(parcel, 2, getChangesRequest.zzajm, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzajn);
        zzb.zzc(parcel, 4, getChangesRequest.zzahq, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcP(x0);
    }

    public GetChangesRequest zzbb(Parcel parcel) {
        List list = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ChangeSequenceNumber changeSequenceNumber = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int i3;
            ChangeSequenceNumber changeSequenceNumber2;
            int zzg;
            ArrayList zzc;
            int zzai = zza.zzai(parcel);
            List list2;
            List list3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list2 = list;
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = zza.zzg(parcel, zzai);
                    list3 = list2;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i2;
                    int i4 = i;
                    changeSequenceNumber2 = (ChangeSequenceNumber) zza.zza(parcel, zzai, ChangeSequenceNumber.CREATOR);
                    list3 = list;
                    i3 = i4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    list2 = list;
                    i3 = zza.zzg(parcel, zzai);
                    list3 = list2;
                    break;
                case Barcode.PHONE /*4*/:
                    zzc = zza.zzc(parcel, zzai, DriveSpace.CREATOR);
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            changeSequenceNumber = changeSequenceNumber2;
            i = i3;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetChangesRequest(i2, changeSequenceNumber, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetChangesRequest[] zzcP(int i) {
        return new GetChangesRequest[i];
    }
}
