package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Strategy implements SafeParcelable {
    public static final Strategy BLE_ONLY;
    public static final Creator<Strategy> CREATOR;
    public static final Strategy DEFAULT;
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    public static final Strategy zzaJK;
    final int versionCode;
    @Deprecated
    final int zzaJL;
    final int zzaJM;
    final int zzaJN;
    @Deprecated
    final boolean zzaJO;
    final int zzaJP;
    final int zzaJQ;

    public static class Builder {
        private int zzaJM;
        private int zzaJN;
        private int zzaJP;
        private int zzaJQ;

        public Builder() {
            this.zzaJQ = Strategy.DISCOVERY_MODE_DEFAULT;
            this.zzaJM = Strategy.TTL_SECONDS_DEFAULT;
            this.zzaJN = Strategy.DISTANCE_TYPE_DEFAULT;
            this.zzaJP = Strategy.DISTANCE_TYPE_EARSHOT;
        }

        public Strategy build() {
            if (this.zzaJP == Strategy.DISCOVERY_MODE_SCAN) {
                if (this.zzaJQ != Strategy.DISCOVERY_MODE_DEFAULT) {
                    throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
                } else if (this.zzaJN == Strategy.DISTANCE_TYPE_EARSHOT) {
                    throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
                }
            }
            return new Strategy(Strategy.DISCOVERY_MODE_SCAN, Strategy.DISTANCE_TYPE_DEFAULT, this.zzaJM, this.zzaJN, false, this.zzaJP, this.zzaJQ);
        }

        public Builder setDiscoveryMode(int discoveryMode) {
            this.zzaJQ = discoveryMode;
            return this;
        }

        public Builder setDistanceType(int distanceType) {
            this.zzaJN = distanceType;
            return this;
        }

        public Builder setTtlSeconds(int ttlSeconds) {
            boolean z = ttlSeconds == Strategy.TTL_SECONDS_INFINITE || (ttlSeconds > 0 && ttlSeconds <= Strategy.TTL_SECONDS_MAX);
            Object[] objArr = new Object[Strategy.DISCOVERY_MODE_SCAN];
            objArr[Strategy.DISTANCE_TYPE_DEFAULT] = Integer.valueOf(ttlSeconds);
            objArr[Strategy.DISTANCE_TYPE_EARSHOT] = Integer.valueOf(Strategy.TTL_SECONDS_MAX);
            zzx.zzb(z, "ttlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", objArr);
            this.zzaJM = ttlSeconds;
            return this;
        }

        public Builder zzim(int i) {
            this.zzaJP = i;
            return this;
        }
    }

    static {
        CREATOR = new zzd();
        DEFAULT = new Builder().build();
        BLE_ONLY = new Builder().zzim(DISCOVERY_MODE_SCAN).setTtlSeconds(TTL_SECONDS_INFINITE).build();
        zzaJK = BLE_ONLY;
    }

    Strategy(int versionCode, int broadcastScanStrategy, int ttlSeconds, int distanceType, boolean isBleBeaconStrategy, int discoveryMedium, int discoveryMode) {
        this.versionCode = versionCode;
        this.zzaJL = broadcastScanStrategy;
        if (broadcastScanStrategy != 0) {
            switch (broadcastScanStrategy) {
                case DISCOVERY_MODE_SCAN /*2*/:
                    this.zzaJQ = DISTANCE_TYPE_EARSHOT;
                    break;
                case DISCOVERY_MODE_DEFAULT /*3*/:
                    this.zzaJQ = DISCOVERY_MODE_SCAN;
                    break;
                default:
                    this.zzaJQ = DISCOVERY_MODE_DEFAULT;
                    break;
            }
        }
        this.zzaJQ = discoveryMode;
        this.zzaJN = distanceType;
        this.zzaJO = isBleBeaconStrategy;
        if (isBleBeaconStrategy) {
            this.zzaJP = DISCOVERY_MODE_SCAN;
            this.zzaJM = TTL_SECONDS_INFINITE;
        } else if (discoveryMedium == 0) {
            this.zzaJP = DISTANCE_TYPE_EARSHOT;
            this.zzaJM = ttlSeconds;
        } else {
            this.zzaJP = discoveryMedium;
            this.zzaJM = ttlSeconds;
        }
    }

    public int describeContents() {
        return DISTANCE_TYPE_DEFAULT;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) other;
        return this.versionCode == strategy.versionCode && this.zzaJQ == strategy.zzaJQ && this.zzaJM == strategy.zzaJM && this.zzaJN == strategy.zzaJN && this.zzaJP == strategy.zzaJP;
    }

    public int hashCode() {
        return (((((((this.versionCode * 31) + this.zzaJQ) * 31) + this.zzaJM) * 31) + this.zzaJN) * 31) + this.zzaJP;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
