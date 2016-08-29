package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzd;

public class AncsNotificationParcelable implements SafeParcelable, zzd {
    public static final Creator<AncsNotificationParcelable> CREATOR;
    private int mId;
    final int mVersionCode;
    private final String zzTZ;
    private final String zzaIs;
    private byte zzaZA;
    private final String zzaZw;
    private byte zzaZx;
    private byte zzaZy;
    private byte zzaZz;
    private final String zzagU;
    private String zzahh;
    private final String zzasq;

    static {
        CREATOR = new zzg();
    }

    AncsNotificationParcelable(int versionCode, int id, String appId, String dateTime, String notificationText, String title, String subtitle, String displayName, byte eventId, byte eventFlags, byte categoryId, byte categoryCount) {
        this.mId = id;
        this.mVersionCode = versionCode;
        this.zzaIs = appId;
        this.zzaZw = dateTime;
        this.zzTZ = notificationText;
        this.zzagU = title;
        this.zzasq = subtitle;
        this.zzahh = displayName;
        this.zzaZx = eventId;
        this.zzaZy = eventFlags;
        this.zzaZz = categoryId;
        this.zzaZA = categoryCount;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) o;
        if (this.zzaZA != ancsNotificationParcelable.zzaZA) {
            return false;
        }
        if (this.zzaZz != ancsNotificationParcelable.zzaZz) {
            return false;
        }
        if (this.zzaZy != ancsNotificationParcelable.zzaZy) {
            return false;
        }
        if (this.zzaZx != ancsNotificationParcelable.zzaZx) {
            return false;
        }
        if (this.mId != ancsNotificationParcelable.mId) {
            return false;
        }
        if (this.mVersionCode != ancsNotificationParcelable.mVersionCode) {
            return false;
        }
        if (!this.zzaIs.equals(ancsNotificationParcelable.zzaIs)) {
            return false;
        }
        if (this.zzaZw == null ? ancsNotificationParcelable.zzaZw != null : !this.zzaZw.equals(ancsNotificationParcelable.zzaZw)) {
            return false;
        }
        if (!this.zzahh.equals(ancsNotificationParcelable.zzahh)) {
            return false;
        }
        if (!this.zzTZ.equals(ancsNotificationParcelable.zzTZ)) {
            return false;
        }
        if (this.zzasq.equals(ancsNotificationParcelable.zzasq)) {
            return this.zzagU.equals(ancsNotificationParcelable.zzagU);
        } else {
            return false;
        }
    }

    public String getDisplayName() {
        return this.zzahh == null ? this.zzaIs : this.zzahh;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.zzagU;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzaZw != null ? this.zzaZw.hashCode() : 0) + (((((this.mVersionCode * 31) + this.mId) * 31) + this.zzaIs.hashCode()) * 31)) * 31) + this.zzTZ.hashCode()) * 31) + this.zzagU.hashCode()) * 31) + this.zzasq.hashCode()) * 31) + this.zzahh.hashCode()) * 31) + this.zzaZx) * 31) + this.zzaZy) * 31) + this.zzaZz) * 31) + this.zzaZA;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.zzaIs + '\'' + ", mDateTime='" + this.zzaZw + '\'' + ", mNotificationText='" + this.zzTZ + '\'' + ", mTitle='" + this.zzagU + '\'' + ", mSubtitle='" + this.zzasq + '\'' + ", mDisplayName='" + this.zzahh + '\'' + ", mEventId=" + this.zzaZx + ", mEventFlags=" + this.zzaZy + ", mCategoryId=" + this.zzaZz + ", mCategoryCount=" + this.zzaZA + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public byte zzCA() {
        return this.zzaZz;
    }

    public byte zzCB() {
        return this.zzaZA;
    }

    public String zzCw() {
        return this.zzaZw;
    }

    public String zzCx() {
        return this.zzTZ;
    }

    public byte zzCy() {
        return this.zzaZx;
    }

    public byte zzCz() {
        return this.zzaZy;
    }

    public String zztW() {
        return this.zzaIs;
    }

    public String zztn() {
        return this.zzasq;
    }
}
