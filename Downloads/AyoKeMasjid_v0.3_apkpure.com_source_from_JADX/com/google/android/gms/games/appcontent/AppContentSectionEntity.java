package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR;
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzFz;
    private final String zzagU;
    private final String zzasf;
    private final ArrayList<AppContentAnnotationEntity> zzaso;
    private final String zzasq;
    private final ArrayList<AppContentCardEntity> zzasx;
    private final String zzasy;
    private final String zzwj;

    static {
        CREATOR = new AppContentSectionEntityCreator();
    }

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaso = annotations;
        this.zzasx = cards;
        this.zzasy = cardType;
        this.zzasf = contentDescription;
        this.mExtras = extras;
        this.zzwj = id;
        this.zzasq = subtitle;
        this.zzagU = title;
        this.zzFz = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        int i;
        int i2 = 0;
        this.mVersionCode = 5;
        this.zzasy = section.zztw();
        this.zzasf = section.zztb();
        this.mExtras = section.getExtras();
        this.zzwj = section.getId();
        this.zzasq = section.zztn();
        this.zzagU = section.getTitle();
        this.zzFz = section.getType();
        List actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = section.zztv();
        size = actions.size();
        this.zzasx = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzasx.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zztl = section.zztl();
        int size2 = zztl.size();
        this.zzaso = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaso.add((AppContentAnnotationEntity) ((AppContentAnnotation) zztl.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zztl(), appContentSection.zztv(), appContentSection.zztw(), appContentSection.zztb(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zztn(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zztl(), appContentSection.zztl()) && zzw.equal(appContentSection2.zztv(), appContentSection.zztv()) && zzw.equal(appContentSection2.zztw(), appContentSection.zztw()) && zzw.equal(appContentSection2.zztb(), appContentSection.zztb()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zztn(), appContentSection.zztn()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzu(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zztl()).zzg("Cards", appContentSection.zztv()).zzg("CardType", appContentSection.zztw()).zzg("ContentDescription", appContentSection.zztb()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zztn()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztx();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getTitle() {
        return this.zzagU;
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
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    public String zztb() {
        return this.zzasf;
    }

    public List<AppContentAnnotation> zztl() {
        return new ArrayList(this.zzaso);
    }

    public String zztn() {
        return this.zzasq;
    }

    public List<AppContentCard> zztv() {
        return new ArrayList(this.zzasx);
    }

    public String zztw() {
        return this.zzasy;
    }

    public AppContentSection zztx() {
        return this;
    }
}
