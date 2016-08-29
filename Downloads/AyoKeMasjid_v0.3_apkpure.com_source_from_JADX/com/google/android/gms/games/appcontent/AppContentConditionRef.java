package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 4, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentConditionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztu();
    }

    public int hashCode() {
        return AppContentConditionEntity.zza(this);
    }

    public String toString() {
        return AppContentConditionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentConditionEntity) zztu()).writeToParcel(dest, flags);
    }

    public String zztq() {
        return getString("condition_default_value");
    }

    public String zztr() {
        return getString("condition_expected_value");
    }

    public String zzts() {
        return getString("condition_predicate");
    }

    public Bundle zztt() {
        return AppContentUtils.zzd(this.zzYX, this.zzasw, "condition_predicate_parameters", this.zzabg);
    }

    public AppContentCondition zztu() {
        return new AppContentConditionEntity(this);
    }
}
