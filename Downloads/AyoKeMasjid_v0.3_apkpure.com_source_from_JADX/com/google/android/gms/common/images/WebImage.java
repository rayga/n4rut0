package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR;
    private final int mVersionCode;
    private final Uri zzacb;
    private final int zznP;
    private final int zznQ;

    static {
        CREATOR = new zzb();
    }

    WebImage(int versionCode, Uri url, int width, int height) {
        this.mVersionCode = versionCode;
        this.zzacb = url;
        this.zznP = width;
        this.zznQ = height;
    }

    public WebImage(Uri url) throws IllegalArgumentException {
        this(url, 0, 0);
    }

    public WebImage(Uri url, int width, int height) throws IllegalArgumentException {
        this(1, url, width, height);
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject json) throws IllegalArgumentException {
        this(zzi(json), json.optInt("width", 0), json.optInt("height", 0));
    }

    private static Uri zzi(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) other;
        return zzw.equal(this.zzacb, webImage.zzacb) && this.zznP == webImage.zznP && this.zznQ == webImage.zznQ;
    }

    public int getHeight() {
        return this.zznQ;
    }

    public Uri getUrl() {
        return this.zzacb;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zznP;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzacb, Integer.valueOf(this.zznP), Integer.valueOf(this.zznQ));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PlusShare.KEY_CALL_TO_ACTION_URL, this.zzacb.toString());
            jSONObject.put("width", this.zznP);
            jSONObject.put("height", this.zznQ);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.zznP), Integer.valueOf(this.zznQ), this.zzacb.toString()});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
