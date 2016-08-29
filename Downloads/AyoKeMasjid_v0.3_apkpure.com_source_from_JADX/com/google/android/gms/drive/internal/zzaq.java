package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzaq implements Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.mVersionCode);
        zzb.zza(parcel, 2, loadRealtimeRequest.zzags, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzajt);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzaju, false);
        zzb.zza(parcel, 5, loadRealtimeRequest.zzajv);
        zzb.zza(parcel, 6, loadRealtimeRequest.zzajw, i, false);
        zzb.zza(parcel, 7, loadRealtimeRequest.zzajx, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcV(x0);
    }

    public LoadRealtimeRequest zzbh(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        DataHolder dataHolder = null;
        List list = null;
        boolean z2 = false;
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
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzC(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
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
            return new LoadRealtimeRequest(i, driveId, z2, list, z, dataHolder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LoadRealtimeRequest[] zzcV(int i) {
        return new LoadRealtimeRequest[i];
    }
}
