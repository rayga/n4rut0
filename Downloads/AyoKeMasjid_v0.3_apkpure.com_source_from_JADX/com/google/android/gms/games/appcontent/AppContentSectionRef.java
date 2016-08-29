package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzasz;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.zzasz = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztx();
    }

    public /* synthetic */ List getActions() {
        return zzty();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzYX, this.zzasw, "section_data", this.zzabg);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) zztx()).writeToParcel(dest, flags);
    }

    public ArrayList<AppContentCard> zztA() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzasz);
        for (int i = 0; i < this.zzasz; i++) {
            arrayList.add(new AppContentCardRef(this.zzasw, this.zzabg + i));
        }
        return arrayList;
    }

    public String zztb() {
        return getString("section_content_description");
    }

    public /* synthetic */ List zztl() {
        return zztz();
    }

    public String zztn() {
        return getString("section_subtitle");
    }

    public /* synthetic */ List zztv() {
        return zztA();
    }

    public String zztw() {
        return getString("section_card_type");
    }

    public AppContentSection zztx() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzty() {
        return AppContentUtils.zza(this.zzYX, this.zzasw, "section_actions", this.zzabg);
    }

    public ArrayList<AppContentAnnotation> zztz() {
        return AppContentUtils.zzb(this.zzYX, this.zzasw, "section_annotations", this.zzabg);
    }
}
