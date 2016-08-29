package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR;
    final int mVersionCode;
    final String zzGY;
    final String zzGh;
    final String zzahh;
    final boolean zzalX;
    final boolean zzalY;
    final String zzalZ;
    final String zzama;

    static {
        CREATOR = new zzq();
    }

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.mVersionCode = versionCode;
        this.zzalX = isMe;
        this.zzalY = isAnonymous;
        this.zzGY = sessionId;
        this.zzGh = userId;
        this.zzahh = displayName;
        this.zzalZ = color;
        this.zzama = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzGY.equals(((ParcelableCollaborator) obj).zzGY);
    }

    public int hashCode() {
        return this.zzGY.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzalX + ", isAnonymous=" + this.zzalY + ", sessionId=" + this.zzGY + ", userId=" + this.zzGh + ", displayName=" + this.zzahh + ", color=" + this.zzalZ + ", photoUrl=" + this.zzama + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
