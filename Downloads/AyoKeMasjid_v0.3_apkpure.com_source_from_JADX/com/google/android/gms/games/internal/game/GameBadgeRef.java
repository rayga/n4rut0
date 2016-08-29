package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class GameBadgeRef extends zzc implements GameBadge {
    public GameBadgeRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameBadgeEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuu();
    }

    public String getDescription() {
        return getString("badge_description");
    }

    public Uri getIconImageUri() {
        return zzce("badge_icon_image_uri");
    }

    public String getTitle() {
        return getString("badge_title");
    }

    public int getType() {
        return getInteger("badge_type");
    }

    public int hashCode() {
        return GameBadgeEntity.zza(this);
    }

    public String toString() {
        return GameBadgeEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameBadgeEntity) zzuu()).writeToParcel(dest, flags);
    }

    public GameBadge zzuu() {
        return new GameBadgeEntity(this);
    }
}
