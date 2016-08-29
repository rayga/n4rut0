package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR;
    private final long zzaAb;
    private final long zzaAc;

    /* renamed from: com.google.android.gms.gcm.OneoffTask.1 */
    static class C03091 implements Creator<OneoffTask> {
        C03091() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzeh(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgt(x0);
        }

        public OneoffTask zzeh(Parcel parcel) {
            return new OneoffTask(null);
        }

        public OneoffTask[] zzgt(int i) {
            return new OneoffTask[i];
        }
    }

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzaAd;
        private long zzaAe;

        public Builder() {
            this.zzaAd = -1;
            this.zzaAe = -1;
            this.isPersisted = false;
        }

        public OneoffTask build() {
            checkConditions();
            return new OneoffTask();
        }

        protected void checkConditions() {
            super.checkConditions();
            if (this.zzaAd == -1 || this.zzaAe == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            } else if (this.zzaAd >= this.zzaAe) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public Builder setExecutionWindow(long windowStartDelaySeconds, long windowEndDelaySeconds) {
            this.zzaAd = windowStartDelaySeconds;
            this.zzaAe = windowEndDelaySeconds;
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.extras = extras;
            return this;
        }

        public Builder setPersisted(boolean isPersisted) {
            this.isPersisted = isPersisted;
            return this;
        }

        public Builder setRequiredNetwork(int requiredNetworkState) {
            this.requiredNetworkState = requiredNetworkState;
            return this;
        }

        public Builder setRequiresCharging(boolean requiresCharging) {
            this.requiresCharging = requiresCharging;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> gcmTaskService) {
            this.gcmTaskService = gcmTaskService.getName();
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setUpdateCurrent(boolean updateCurrent) {
            this.updateCurrent = updateCurrent;
            return this;
        }
    }

    static {
        CREATOR = new C03091();
    }

    @Deprecated
    private OneoffTask(Parcel in) {
        super(in);
        this.zzaAb = in.readLong();
        this.zzaAc = in.readLong();
    }

    private OneoffTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.zzaAb = builder.zzaAd;
        this.zzaAc = builder.zzaAe;
    }

    public long getWindowEnd() {
        return this.zzaAc;
    }

    public long getWindowStart() {
        return this.zzaAb;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzaAb);
        bundle.putLong("window_end", this.zzaAc);
    }

    public String toString() {
        return super.toString() + " " + "windowStart=" + getWindowStart() + " " + "windowEnd=" + getWindowEnd();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        super.writeToParcel(parcel, flags);
        parcel.writeLong(this.zzaAb);
        parcel.writeLong(this.zzaAc);
    }
}
