package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztd();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzYX, this.zzasw, "action_data", this.zzabg);
    }

    public String getId() {
        return getString("action_id");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) zztd()).writeToParcel(dest, flags);
    }

    public AppContentAnnotation zzsZ() {
        List zzb = AppContentUtils.zzb(this.zzYX, this.zzasw, "action_annotation", this.zzabg);
        return zzb.size() == 1 ? (AppContentAnnotation) zzb.get(0) : null;
    }

    public List<AppContentCondition> zzta() {
        return AppContentUtils.zzc(this.zzYX, this.zzasw, "action_conditions", this.zzabg);
    }

    public String zztb() {
        return getString("action_content_description");
    }

    public String zztc() {
        return getString("overflow_text");
    }

    public AppContentAction zztd() {
        return new AppContentActionEntity(this);
    }
}
