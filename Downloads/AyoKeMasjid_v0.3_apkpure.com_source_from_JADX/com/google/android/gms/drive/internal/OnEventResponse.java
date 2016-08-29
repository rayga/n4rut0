package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.vision.barcode.Barcode;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR;
    final int mVersionCode;
    final int zzafk;
    final ChangeEvent zzajN;
    final CompletionEvent zzajO;
    final QueryResultEventParcelable zzajP;
    final ChangesAvailableEvent zzajQ;
    final ProgressEvent zzajR;

    static {
        CREATOR = new zzba();
    }

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEvent, ChangesAvailableEvent changesAvailableEvent, ProgressEvent progressEvent) {
        this.mVersionCode = versionCode;
        this.zzafk = eventType;
        this.zzajN = changeEvent;
        this.zzajO = completionEvent;
        this.zzajP = queryResultEvent;
        this.zzajQ = changesAvailableEvent;
        this.zzajR = progressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags);
    }

    public DriveEvent zzqS() {
        switch (this.zzafk) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return this.zzajN;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return this.zzajO;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return this.zzajP;
            case Barcode.PHONE /*4*/:
                return this.zzajQ;
            case Barcode.PRODUCT /*5*/:
            case Barcode.SMS /*6*/:
                return this.zzajR;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzafk);
        }
    }
}
