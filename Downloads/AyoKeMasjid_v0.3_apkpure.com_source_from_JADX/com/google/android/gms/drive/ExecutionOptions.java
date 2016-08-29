package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzt;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzagM;
    private final boolean zzagN;
    private final int zzagO;

    public static final class Builder {
        private String zzagM;
        private boolean zzagN;
        private int zzagO;

        public Builder() {
            this.zzagO = ExecutionOptions.CONFLICT_STRATEGY_OVERWRITE_REMOTE;
        }

        public ExecutionOptions build() {
            if (this.zzagO != ExecutionOptions.CONFLICT_STRATEGY_KEEP_REMOTE || this.zzagN) {
                return new ExecutionOptions(this.zzagM, this.zzagN, this.zzagO);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int strategy) {
            if (ExecutionOptions.zzcg(strategy)) {
                this.zzagO = strategy;
                return this;
            }
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + strategy);
        }

        public Builder setNotifyOnCompletion(boolean notify) {
            this.zzagN = notify;
            return this;
        }

        public Builder setTrackingTag(String trackingTag) {
            if (ExecutionOptions.zzcD(trackingTag)) {
                this.zzagM = trackingTag;
                return this;
            }
            Object[] objArr = new Object[ExecutionOptions.CONFLICT_STRATEGY_KEEP_REMOTE];
            objArr[ExecutionOptions.CONFLICT_STRATEGY_OVERWRITE_REMOTE] = Integer.valueOf(ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", objArr));
        }
    }

    public ExecutionOptions(String trackingTag, boolean notifyOnCompletion, int conflictStrategy) {
        this.zzagM = trackingTag;
        this.zzagN = notifyOnCompletion;
        this.zzagO = conflictStrategy;
    }

    public static void zza(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        zzt com_google_android_gms_drive_internal_zzt = (zzt) googleApiClient.zza(Drive.zzQf);
        if (executionOptions.zzqm() && !com_google_android_gms_drive_internal_zzt.zzqI()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean zzcD(String str) {
        return (str == null || str.isEmpty() || str.length() > MAX_TRACKING_TAG_STRING_LENGTH) ? false : true;
    }

    public static boolean zzcf(int i) {
        switch (i) {
            case CONFLICT_STRATEGY_KEEP_REMOTE /*1*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcg(int i) {
        switch (i) {
            case CONFLICT_STRATEGY_OVERWRITE_REMOTE /*0*/:
            case CONFLICT_STRATEGY_KEEP_REMOTE /*1*/:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) o;
        return zzw.equal(this.zzagM, executionOptions.zzagM) && this.zzagO == executionOptions.zzagO && this.zzagN == executionOptions.zzagN;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzagM, Integer.valueOf(this.zzagO), Boolean.valueOf(this.zzagN));
    }

    public String zzql() {
        return this.zzagM;
    }

    public boolean zzqm() {
        return this.zzagN;
    }

    public int zzqn() {
        return this.zzagO;
    }
}
