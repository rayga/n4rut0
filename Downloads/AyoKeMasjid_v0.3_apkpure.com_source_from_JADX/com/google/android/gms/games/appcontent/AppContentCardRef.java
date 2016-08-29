package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztp();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzYX, this.zzasw, "card_actions", this.zzabg);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzYX, this.zzasw, "card_data", this.zzabg);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) zztp()).writeToParcel(dest, flags);
    }

    public List<AppContentCondition> zzta() {
        return AppContentUtils.zzc(this.zzYX, this.zzasw, "card_conditions", this.zzabg);
    }

    public String zztb() {
        return getString("card_content_description");
    }

    public List<AppContentAnnotation> zztl() {
        return AppContentUtils.zzb(this.zzYX, this.zzasw, "card_annotations", this.zzabg);
    }

    public int zztm() {
        return getInteger("card_current_steps");
    }

    public String zztn() {
        return getString("card_subtitle");
    }

    public int zzto() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zztp() {
        return new AppContentCardEntity(this);
    }
}
