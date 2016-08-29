package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR;
    final int mVersionCode;
    int status;
    String zzaWi;
    String zzaXs;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest zzaXt;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzaXt = notifyTransactionStatusRequest;
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            zzx.zzb(!TextUtils.isEmpty(this.zzaXt.zzaWi), (Object) "googleTransactionId is required");
            if (this.zzaXt.status < 1 || this.zzaXt.status > 8) {
                z = false;
            }
            zzx.zzb(z, (Object) "status is an unrecognized value");
            return this.zzaXt;
        }

        public Builder setDetailedReason(String detailedReason) {
            this.zzaXt.zzaXs = detailedReason;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaXt.zzaWi = googleTransactionId;
            return this;
        }

        public Builder setStatus(int status) {
            this.zzaXt.status = status;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    static {
        CREATOR = new zzm();
    }

    NotifyTransactionStatusRequest() {
        this.mVersionCode = 1;
    }

    NotifyTransactionStatusRequest(int versionCode, String googleTransactionId, int status, String detailedReason) {
        this.mVersionCode = versionCode;
        this.zzaWi = googleTransactionId;
        this.status = status;
        this.zzaXs = detailedReason;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.zzaXs;
    }

    public String getGoogleTransactionId() {
        return this.zzaWi;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }
}
