package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR;
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    /* renamed from: com.google.android.gms.gcm.PeriodicTask.1 */
    static class C03111 implements Creator<PeriodicTask> {
        C03111() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzej(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgv(x0);
        }

        public PeriodicTask zzej(Parcel parcel) {
            return new PeriodicTask(null);
        }

        public PeriodicTask[] zzgv(int i) {
            return new PeriodicTask[i];
        }
    }

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzaAf;
        private long zzaAg;

        public Builder() {
            this.zzaAf = -1;
            this.zzaAg = -1;
            this.isPersisted = true;
        }

        public PeriodicTask build() {
            checkConditions();
            return new PeriodicTask();
        }

        protected void checkConditions() {
            super.checkConditions();
            if (this.zzaAf == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (this.zzaAg == -1) {
                this.zzaAg = (long) (((float) this.zzaAf) * 0.1f);
            }
        }

        public Builder setExtras(Bundle extras) {
            this.extras = extras;
            return this;
        }

        public Builder setFlex(long flexInSeconds) {
            this.zzaAg = flexInSeconds;
            return this;
        }

        public Builder setPeriod(long intervalInSeconds) {
            this.zzaAf = intervalInSeconds;
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
        CREATOR = new C03111();
    }

    @Deprecated
    private PeriodicTask(Parcel in) {
        super(in);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = in.readLong();
        this.mFlexInSeconds = in.readLong();
    }

    private PeriodicTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = builder.zzaAf;
        this.mFlexInSeconds = builder.zzaAg;
    }

    public long getFlex() {
        return this.mFlexInSeconds;
    }

    public long getPeriod() {
        return this.mIntervalInSeconds;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("period", this.mIntervalInSeconds);
        bundle.putLong("period_flex", this.mFlexInSeconds);
    }

    public String toString() {
        return super.toString() + " " + "period=" + getPeriod() + " " + "flex=" + getFlex();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        super.writeToParcel(parcel, flags);
        parcel.writeLong(this.mIntervalInSeconds);
        parcel.writeLong(this.mFlexInSeconds);
    }
}
