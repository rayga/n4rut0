package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR;
    private final int mVersionCode;
    private final String zzass;
    private final String zzast;
    private final String zzasu;
    private final Bundle zzasv;

    static {
        CREATOR = new AppContentConditionEntityCreator();
    }

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.mVersionCode = versionCode;
        this.zzass = defaultValue;
        this.zzast = expectedValue;
        this.zzasu = predicate;
        this.zzasv = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.mVersionCode = 1;
        this.zzass = condition.zztq();
        this.zzast = condition.zztr();
        this.zzasu = condition.zzts();
        this.zzasv = condition.zztt();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zztq(), appContentCondition.zztr(), appContentCondition.zzts(), appContentCondition.zztt());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.equal(appContentCondition2.zztq(), appContentCondition.zztq()) && zzw.equal(appContentCondition2.zztr(), appContentCondition.zztr()) && zzw.equal(appContentCondition2.zzts(), appContentCondition.zzts()) && zzw.equal(appContentCondition2.zztt(), appContentCondition.zztt());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzu(appContentCondition).zzg("DefaultValue", appContentCondition.zztq()).zzg("ExpectedValue", appContentCondition.zztr()).zzg("Predicate", appContentCondition.zzts()).zzg("PredicateParameters", appContentCondition.zztt()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztu();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentConditionEntityCreator.zza(this, out, flags);
    }

    public String zztq() {
        return this.zzass;
    }

    public String zztr() {
        return this.zzast;
    }

    public String zzts() {
        return this.zzasu;
    }

    public Bundle zztt() {
        return this.zzasv;
    }

    public AppContentCondition zztu() {
        return this;
    }
}
