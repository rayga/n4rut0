package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class SharedContent implements SafeParcelable {
    public static final Creator<SharedContent> CREATOR;
    private final int versionCode;
    @Deprecated
    private String zzaKm;
    private ViewableItem[] zzaKn;
    private LocalContent[] zzaKo;

    static {
        CREATOR = new zzc();
    }

    private SharedContent() {
        this.versionCode = 2;
    }

    SharedContent(int versionCode, String uri, ViewableItem[] viewableItems, LocalContent[] localContents) {
        this.versionCode = versionCode;
        this.zzaKm = uri;
        this.zzaKn = viewableItems;
        this.zzaKo = localContents;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) o;
        return zzw.equal(this.zzaKn, sharedContent.zzaKn) && zzw.equal(this.zzaKo, sharedContent.zzaKo) && zzw.equal(this.zzaKm, sharedContent.zzaKm);
    }

    public String getUri() {
        return this.zzaKm;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKn, this.zzaKo, this.zzaKm);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.zzaKn) + ", localContents=" + Arrays.toString(this.zzaKo) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public ViewableItem[] zzyt() {
        return this.zzaKn;
    }

    public LocalContent[] zzyu() {
        return this.zzaKo;
    }
}
