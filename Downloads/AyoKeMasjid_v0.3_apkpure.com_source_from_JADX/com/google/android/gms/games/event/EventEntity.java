package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzln;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzaoB;
    private final Uri zzaqW;
    private final PlayerEntity zzarZ;
    private final String zzarh;
    private final String zzasD;
    private final long zzasE;
    private final String zzasF;
    private final boolean zzasG;

    static {
        CREATOR = new EventEntityCreator();
    }

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.mVersionCode = versionCode;
        this.zzasD = eventId;
        this.mName = name;
        this.zzaoB = description;
        this.zzaqW = iconImageUri;
        this.zzarh = iconImageUrl;
        this.zzarZ = new PlayerEntity(player);
        this.zzasE = value;
        this.zzasF = formattedValue;
        this.zzasG = isVisible;
    }

    public EventEntity(Event event) {
        this.mVersionCode = 1;
        this.zzasD = event.getEventId();
        this.mName = event.getName();
        this.zzaoB = event.getDescription();
        this.zzaqW = event.getIconImageUri();
        this.zzarh = event.getIconImageUrl();
        this.zzarZ = (PlayerEntity) event.getPlayer().freeze();
        this.zzasE = event.getValue();
        this.zzasF = event.getFormattedValue();
        this.zzasG = event.isVisible();
    }

    static int zza(Event event) {
        return zzw.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzw.equal(event2.getEventId(), event.getEventId()) && zzw.equal(event2.getName(), event.getName()) && zzw.equal(event2.getDescription(), event.getDescription()) && zzw.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzw.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzw.equal(event2.getPlayer(), event.getPlayer()) && zzw.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzw.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzw.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzw.zzu(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaoB, dataOut);
    }

    public String getEventId() {
        return this.zzasD;
    }

    public String getFormattedValue() {
        return this.zzasF;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzasF, dataOut);
    }

    public Uri getIconImageUri() {
        return this.zzaqW;
    }

    public String getIconImageUrl() {
        return this.zzarh;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzln.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzarZ;
    }

    public long getValue() {
        return this.zzasE;
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

    public boolean isVisible() {
        return this.zzasG;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.zza(this, out, flags);
    }
}
