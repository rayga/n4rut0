package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.vision.barcode.Barcode;

public class zzba implements Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onEventResponse.mVersionCode);
        zzb.zzc(parcel, 2, onEventResponse.zzafk);
        zzb.zza(parcel, 3, onEventResponse.zzajN, i, false);
        zzb.zza(parcel, 5, onEventResponse.zzajO, i, false);
        zzb.zza(parcel, 6, onEventResponse.zzajP, i, false);
        zzb.zza(parcel, 7, onEventResponse.zzajQ, i, false);
        zzb.zza(parcel, 8, onEventResponse.zzajR, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdc(x0);
    }

    public OnEventResponse zzbo(Parcel parcel) {
        int i = 0;
        ProgressEvent progressEvent = null;
        int zzaj = zza.zzaj(parcel);
        ChangesAvailableEvent changesAvailableEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzai, ChangeEvent.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzai, CompletionEvent.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    queryResultEventParcelable = (QueryResultEventParcelable) zza.zza(parcel, zzai, QueryResultEventParcelable.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    changesAvailableEvent = (ChangesAvailableEvent) zza.zza(parcel, zzai, ChangesAvailableEvent.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    progressEvent = (ProgressEvent) zza.zza(parcel, zzai, ProgressEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, progressEvent);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OnEventResponse[] zzdc(int i) {
        return new OnEventResponse[i];
    }
}
