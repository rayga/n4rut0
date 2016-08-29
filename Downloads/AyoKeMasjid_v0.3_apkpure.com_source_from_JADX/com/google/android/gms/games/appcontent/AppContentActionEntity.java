package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzFz;
    private final ArrayList<AppContentConditionEntity> zzase;
    private final String zzasf;
    private final AppContentAnnotationEntity zzasg;
    private final String zzash;
    private final String zzwj;

    static {
        CREATOR = new AppContentActionEntityCreator();
    }

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String type, String id, AppContentAnnotationEntity annotation, String overflowText) {
        this.mVersionCode = versionCode;
        this.zzasg = annotation;
        this.zzase = conditions;
        this.zzasf = contentDescription;
        this.mExtras = extras;
        this.zzwj = id;
        this.zzash = overflowText;
        this.zzFz = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.mVersionCode = 5;
        this.zzasg = (AppContentAnnotationEntity) action.zzsZ().freeze();
        this.zzasf = action.zztb();
        this.mExtras = action.getExtras();
        this.zzwj = action.getId();
        this.zzash = action.zztc();
        this.zzFz = action.getType();
        List zzta = action.zzta();
        int size = zzta.size();
        this.zzase = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzase.add((AppContentConditionEntity) ((AppContentCondition) zzta.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzw.hashCode(appContentAction.zzsZ(), appContentAction.zzta(), appContentAction.zztb(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zztc(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.equal(appContentAction2.zzsZ(), appContentAction.zzsZ()) && zzw.equal(appContentAction2.zzta(), appContentAction.zzta()) && zzw.equal(appContentAction2.zztb(), appContentAction.zztb()) && zzw.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzw.equal(appContentAction2.getId(), appContentAction.getId()) && zzw.equal(appContentAction2.zztc(), appContentAction.zztc()) && zzw.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzw.zzu(appContentAction).zzg("Annotation", appContentAction.zzsZ()).zzg("Conditions", appContentAction.zzta()).zzg("ContentDescription", appContentAction.zztb()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zztc()).zzg("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztd();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getType() {
        return this.zzFz;
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
        AppContentActionEntityCreator.zza(this, out, flags);
    }

    public AppContentAnnotation zzsZ() {
        return this.zzasg;
    }

    public List<AppContentCondition> zzta() {
        return new ArrayList(this.zzase);
    }

    public String zztb() {
        return this.zzasf;
    }

    public String zztc() {
        return this.zzash;
    }

    public AppContentAction zztd() {
        return this;
    }
}
