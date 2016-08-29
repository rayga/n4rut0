package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR;
    String mName;
    private final int mVersionCode;
    String zzSX;
    List<String> zzSY;
    String zzSZ;
    Uri zzTa;
    List<WebImage> zzvL;

    static {
        CREATOR = new zza();
    }

    private ApplicationMetadata() {
        this.mVersionCode = 1;
        this.zzvL = new ArrayList();
        this.zzSY = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List<WebImage> images, List<String> namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.mVersionCode = versionCode;
        this.zzSX = applicationId;
        this.mName = name;
        this.zzvL = images;
        this.zzSY = namespaces;
        this.zzSZ = senderAppIdentifier;
        this.zzTa = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List<String> namespaces) {
        return this.zzSY != null && this.zzSY.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.zza(this.zzSX, applicationMetadata.zzSX) && zzf.zza(this.zzvL, applicationMetadata.zzvL) && zzf.zza(this.mName, applicationMetadata.mName) && zzf.zza(this.zzSY, applicationMetadata.zzSY) && zzf.zza(this.zzSZ, applicationMetadata.zzSZ) && zzf.zza(this.zzTa, applicationMetadata.zzTa);
    }

    public String getApplicationId() {
        return this.zzSX;
    }

    public List<WebImage> getImages() {
        return this.zzvL;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzSZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzSX, this.mName, this.zzvL, this.zzSY, this.zzSZ, this.zzTa);
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.zzSY != null && this.zzSY.contains(namespace);
    }

    public String toString() {
        int i = 0;
        StringBuilder append = new StringBuilder().append("applicationId: ").append(this.zzSX).append(", name: ").append(this.mName).append(", images.count: ").append(this.zzvL == null ? 0 : this.zzvL.size()).append(", namespaces.count: ");
        if (this.zzSY != null) {
            i = this.zzSY.size();
        }
        return append.append(i).append(", senderAppIdentifier: ").append(this.zzSZ).append(", senderAppLaunchUrl: ").append(this.zzTa).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zzlM() {
        return this.zzTa;
    }
}
