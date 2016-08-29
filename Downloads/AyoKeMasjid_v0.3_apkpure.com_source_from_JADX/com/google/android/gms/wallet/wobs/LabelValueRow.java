package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzli;
import java.util.ArrayList;

public final class LabelValueRow implements SafeParcelable {
    public static final Creator<LabelValueRow> CREATOR;
    private final int mVersionCode;
    String zzaYv;
    String zzaYw;
    ArrayList<LabelValue> zzaYx;

    static {
        CREATOR = new zzc();
    }

    LabelValueRow() {
        this.mVersionCode = 1;
        this.zzaYx = zzli.zzpM();
    }

    LabelValueRow(int versionCode, String hexFontColor, String hexBackgroundColor, ArrayList<LabelValue> columns) {
        this.mVersionCode = versionCode;
        this.zzaYv = hexFontColor;
        this.zzaYw = hexBackgroundColor;
        this.zzaYx = columns;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
