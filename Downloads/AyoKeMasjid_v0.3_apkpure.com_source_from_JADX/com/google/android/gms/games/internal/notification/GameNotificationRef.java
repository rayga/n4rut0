package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends zzc implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String toString() {
        return zzw.zzu(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzuB()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzuC()).zzg("Text", getText()).zzg("CoalescedText", zzuD()).zzg("isAcknowledged", Boolean.valueOf(zzuE())).zzg("isSilent", Boolean.valueOf(zzuF())).toString();
    }

    public String zzuB() {
        return getString("notification_id");
    }

    public String zzuC() {
        return getString("ticker");
    }

    public String zzuD() {
        return getString("coalesced_text");
    }

    public boolean zzuE() {
        return getInteger("acknowledged") > 0;
    }

    public boolean zzuF() {
        return getInteger("alert_level") == 0;
    }
}
