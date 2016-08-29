package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR;
    private final int mVersionCode;
    private final String zzagU;
    private final String zzaoB;
    private final Uri zzasi;
    private final String zzasj;
    private final String zzask;
    private final int zzasl;
    private final int zzasm;
    private final Bundle zzasn;
    private final String zzwj;

    static {
        CREATOR = new AppContentAnnotationEntityCreator();
    }

    AppContentAnnotationEntity(int versionCode, String description, Uri imageUri, String title, String id, String layoutSlot, String imageDefaultId, int imageHeight, int imageWidth, Bundle modifiers) {
        this.mVersionCode = versionCode;
        this.zzaoB = description;
        this.zzwj = id;
        this.zzask = imageDefaultId;
        this.zzasl = imageHeight;
        this.zzasi = imageUri;
        this.zzasm = imageWidth;
        this.zzasj = layoutSlot;
        this.zzasn = modifiers;
        this.zzagU = title;
    }

    public AppContentAnnotationEntity(AppContentAnnotation annotation) {
        this.mVersionCode = 4;
        this.zzaoB = annotation.getDescription();
        this.zzwj = annotation.getId();
        this.zzask = annotation.zzte();
        this.zzasl = annotation.zztf();
        this.zzasi = annotation.zztg();
        this.zzasm = annotation.zzti();
        this.zzasj = annotation.zztj();
        this.zzasn = annotation.zzth();
        this.zzagU = annotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzw.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzte(), Integer.valueOf(appContentAnnotation.zztf()), appContentAnnotation.zztg(), Integer.valueOf(appContentAnnotation.zzti()), appContentAnnotation.zztj(), appContentAnnotation.zzth(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzw.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzw.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzw.equal(appContentAnnotation2.zzte(), appContentAnnotation.zzte()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zztf()), Integer.valueOf(appContentAnnotation.zztf())) && zzw.equal(appContentAnnotation2.zztg(), appContentAnnotation.zztg()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzti()), Integer.valueOf(appContentAnnotation.zzti())) && zzw.equal(appContentAnnotation2.zztj(), appContentAnnotation.zztj()) && zzw.equal(appContentAnnotation2.zzth(), appContentAnnotation.zzth()) && zzw.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzw.zzu(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zzte()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zztf())).zzg("ImageUri", appContentAnnotation.zztg()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zzti())).zzg("LayoutSlot", appContentAnnotation.zztj()).zzg("Modifiers", appContentAnnotation.zzth()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztk();
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getTitle() {
        return this.zzagU;
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
        AppContentAnnotationEntityCreator.zza(this, out, flags);
    }

    public String zzte() {
        return this.zzask;
    }

    public int zztf() {
        return this.zzasl;
    }

    public Uri zztg() {
        return this.zzasi;
    }

    public Bundle zzth() {
        return this.zzasn;
    }

    public int zzti() {
        return this.zzasm;
    }

    public String zztj() {
        return this.zzasj;
    }

    public AppContentAnnotation zztk() {
        return this;
    }
}
