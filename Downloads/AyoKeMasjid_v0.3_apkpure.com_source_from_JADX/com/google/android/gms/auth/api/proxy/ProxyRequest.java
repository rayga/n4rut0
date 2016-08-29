package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR;
    public static final int HTTP_METHOD_DELETE;
    public static final int HTTP_METHOD_GET;
    public static final int HTTP_METHOD_HEAD;
    public static final int HTTP_METHOD_OPTIONS;
    public static final int HTTP_METHOD_PATCH;
    public static final int HTTP_METHOD_POST;
    public static final int HTTP_METHOD_PUT;
    public static final int HTTP_METHOD_TRACE;
    public static final int LAST_CODE;
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;
    Bundle zzRE;

    public static class Builder {
        private String zzRF;
        private int zzRG;
        private long zzRH;
        private byte[] zzRI;
        private Bundle zzRJ;

        public Builder(String url) {
            this.zzRG = ProxyRequest.HTTP_METHOD_GET;
            this.zzRH = 3000;
            this.zzRI = null;
            this.zzRJ = new Bundle();
            zzx.zzcs(url);
            if (Patterns.WEB_URL.matcher(url).matches()) {
                this.zzRF = url;
                return;
            }
            throw new IllegalArgumentException("The supplied url [ " + url + "] is not match Patterns.WEB_URL!");
        }

        public ProxyRequest build() {
            if (this.zzRI == null) {
                this.zzRI = new byte[ProxyRequest.LAST_CODE];
            }
            return new ProxyRequest(ProxyRequest.VERSION_CODE, this.zzRF, this.zzRG, this.zzRH, this.zzRI, this.zzRJ);
        }

        public Builder putHeader(String name, String value) {
            zzx.zzh(name, "Header name cannot be null or empty!");
            Bundle bundle = this.zzRJ;
            if (value == null) {
                value = BuildConfig.FLAVOR;
            }
            bundle.putString(name, value);
            return this;
        }

        public Builder setBody(byte[] body) {
            this.zzRI = body;
            return this;
        }

        public Builder setHttpMethod(int method) {
            boolean z = method >= 0 && method <= ProxyRequest.LAST_CODE;
            zzx.zzb(z, (Object) "Unrecognized http method code.");
            this.zzRG = method;
            return this;
        }

        public Builder setTimeoutMillis(long timeoutMillis) {
            zzx.zzb(timeoutMillis >= 0, (Object) "The specified timeout must be non-negative.");
            this.zzRH = timeoutMillis;
            return this;
        }
    }

    static {
        CREATOR = new zzb();
        HTTP_METHOD_GET = LAST_CODE;
        HTTP_METHOD_POST = 1;
        HTTP_METHOD_PUT = VERSION_CODE;
        HTTP_METHOD_DELETE = 3;
        HTTP_METHOD_HEAD = 4;
        HTTP_METHOD_OPTIONS = 5;
        HTTP_METHOD_TRACE = 6;
        HTTP_METHOD_PATCH = 7;
        LAST_CODE = 7;
    }

    ProxyRequest(int version, String googleUrl, int httpMethod, long timeoutMillis, byte[] body, Bundle headers) {
        this.versionCode = version;
        this.url = googleUrl;
        this.httpMethod = httpMethod;
        this.timeoutMillis = timeoutMillis;
        this.body = body;
        this.zzRE = headers;
    }

    public int describeContents() {
        return LAST_CODE;
    }

    public Map<String, String> getHeaderMap() {
        Map linkedHashMap = new LinkedHashMap(this.zzRE.size());
        for (String str : this.zzRE.keySet()) {
            linkedHashMap.put(str, this.zzRE.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.httpMethod + " ]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
