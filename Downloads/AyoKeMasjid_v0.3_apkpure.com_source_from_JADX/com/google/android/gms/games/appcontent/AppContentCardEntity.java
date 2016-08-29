package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR;
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzFz;
    private final String zzagU;
    private final String zzaoB;
    private final ArrayList<AppContentConditionEntity> zzase;
    private final String zzasf;
    private final ArrayList<AppContentAnnotationEntity> zzaso;
    private final int zzasp;
    private final String zzasq;
    private final int zzasr;
    private final String zzwj;

    static {
        CREATOR = new AppContentCardEntityCreator();
    }

    AppContentCardEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentAnnotationEntity> annotations, ArrayList<AppContentConditionEntity> conditions, String contentDescription, int currentProgress, String description, Bundle extras, String subtitle, String title, int totalProgress, String type, String id) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaso = annotations;
        this.zzase = conditions;
        this.zzasf = contentDescription;
        this.zzasp = currentProgress;
        this.zzaoB = description;
        this.mExtras = extras;
        this.zzwj = id;
        this.zzasq = subtitle;
        this.zzagU = title;
        this.zzasr = totalProgress;
        this.zzFz = type;
    }

    public AppContentCardEntity(AppContentCard card) {
        int i;
        int i2 = 0;
        this.mVersionCode = 4;
        this.zzasf = card.zztb();
        this.zzasp = card.zztm();
        this.zzaoB = card.getDescription();
        this.mExtras = card.getExtras();
        this.zzwj = card.getId();
        this.zzagU = card.getTitle();
        this.zzasq = card.zztn();
        this.zzasr = card.zzto();
        this.zzFz = card.getType();
        List actions = card.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = card.zztl();
        size = actions.size();
        this.zzaso = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaso.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zzta = card.zzta();
        int size2 = zzta.size();
        this.zzase = new ArrayList(size2);
        while (i2 < size2) {
            this.zzase.add((AppContentConditionEntity) ((AppContentCondition) zzta.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zztl(), appContentCard.zzta(), appContentCard.zztb(), Integer.valueOf(appContentCard.zztm()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zztn(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzto()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zztl(), appContentCard.zztl()) && zzw.equal(appContentCard2.zzta(), appContentCard.zzta()) && zzw.equal(appContentCard2.zztb(), appContentCard.zztb()) && zzw.equal(Integer.valueOf(appContentCard2.zztm()), Integer.valueOf(appContentCard.zztm())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zztn(), appContentCard.zztn()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzto()), Integer.valueOf(appContentCard.zzto())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzu(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zztl()).zzg("Conditions", appContentCard.zzta()).zzg("ContentDescription", appContentCard.zztb()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zztm())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zztn()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzto())).zzg("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztp();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzaoB;
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
        AppContentCardEntityCreator.zza(this, out, flags);
    }

    public List<AppContentCondition> zzta() {
        return new ArrayList(this.zzase);
    }

    public String zztb() {
        return this.zzasf;
    }

    public List<AppContentAnnotation> zztl() {
        return new ArrayList(this.zzaso);
    }

    public int zztm() {
        return this.zzasp;
    }

    public String zztn() {
        return this.zzasq;
    }

    public int zzto() {
        return this.zzasr;
    }

    public AppContentCard zztp() {
        return this;
    }
}
