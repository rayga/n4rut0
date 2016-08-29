package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR;
    private final int mVersionCode;
    private boolean zzUb;
    private String zzUc;

    public static final class Builder {
        private LaunchOptions zzUd;

        public Builder() {
            this.zzUd = new LaunchOptions();
        }

        public LaunchOptions build() {
            return this.zzUd;
        }

        public Builder setLocale(Locale locale) {
            this.zzUd.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.zzUd.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    static {
        CREATOR = new zzc();
    }

    public LaunchOptions() {
        this(1, false, zzf.zzb(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.mVersionCode = versionCode;
        this.zzUb = relaunchIfRunning;
        this.zzUc = language;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzUb == launchOptions.zzUb && zzf.zza(this.zzUc, launchOptions.zzUc);
    }

    public String getLanguage() {
        return this.zzUc;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzUb;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzUb), this.zzUc);
    }

    public void setLanguage(String language) {
        this.zzUc = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.zzUb = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.zzUb), this.zzUc});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
