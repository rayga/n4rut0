package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR;
    private final int mVersionCode;
    private boolean zzaoG;
    private String zzaoH;
    private Map<String, MapValue> zzaoI;
    private int[] zzaoJ;
    private float[] zzaoK;
    private final int zzaoq;
    private float zzaou;

    static {
        CREATOR = new zzt();
    }

    public Value(int format) {
        this(3, format, false, 0.0f, null, null, null, null);
    }

    Value(int versionCode, int format, boolean isSet, float value, String stringValue, Bundle mapValue, int[] intArrayValue, float[] floatArrayValue) {
        this.mVersionCode = versionCode;
        this.zzaoq = format;
        this.zzaoG = isSet;
        this.zzaou = value;
        this.zzaoH = stringValue;
        this.zzaoI = zzs(mapValue);
        this.zzaoJ = intArrayValue;
        this.zzaoK = floatArrayValue;
    }

    private boolean zza(Value value) {
        if (this.zzaoq != value.zzaoq || this.zzaoG != value.zzaoG) {
            return false;
        }
        switch (this.zzaoq) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return asInt() == value.asInt();
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return asFloat() == value.asFloat();
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return asString().equals(value.asString());
            case Barcode.PHONE /*4*/:
                return zzqX().equals(value.zzqX());
            case Barcode.PRODUCT /*5*/:
                return zzrS().equals(value.zzrS());
            case Barcode.SMS /*6*/:
                return zzrT().equals(value.zzrT());
            default:
                return this.zzaou == value.zzaou;
        }
    }

    private static Map<String, MapValue> zzs(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        Map<String, MapValue> arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzx.zza(this.zzaoq == 2, (Object) "Value is not in float format");
        return this.zzaou;
    }

    public int asInt() {
        boolean z = true;
        if (this.zzaoq != 1) {
            z = false;
        }
        zzx.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.zzaou);
    }

    public String asString() {
        zzx.zza(this.zzaoq == 3, (Object) "Value is not in string format");
        return this.zzaoH;
    }

    public void clearKey(String key) {
        zzx.zza(this.zzaoq == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzaoI != null) {
            this.zzaoI.remove(key);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof Value) && zza((Value) o));
    }

    public int getFormat() {
        return this.zzaoq;
    }

    public Float getKeyValue(String key) {
        zzx.zza(this.zzaoq == 4, (Object) "Value is not in float map format");
        return (this.zzaoI == null || !this.zzaoI.containsKey(key)) ? null : Float.valueOf(((MapValue) this.zzaoI.get(key)).asFloat());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaou), this.zzaoH, this.zzaoI, this.zzaoJ, this.zzaoK);
    }

    public boolean isSet() {
        return this.zzaoG;
    }

    public void setActivity(String activity) {
        setInt(FitnessActivities.zzcP(activity));
    }

    public void setFloat(float value) {
        zzx.zza(this.zzaoq == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzaoG = true;
        this.zzaou = value;
    }

    public void setInt(int value) {
        zzx.zza(this.zzaoq == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzaoG = true;
        this.zzaou = Float.intBitsToFloat(value);
    }

    public void setKeyValue(String key, float value) {
        zzx.zza(this.zzaoq == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzaoG = true;
        if (this.zzaoI == null) {
            this.zzaoI = new HashMap();
        }
        this.zzaoI.put(key, MapValue.zzc(value));
    }

    public void setString(String value) {
        zzx.zza(this.zzaoq == 3, (Object) "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzaoG = true;
        this.zzaoH = value;
    }

    public String toString() {
        if (!this.zzaoG) {
            return "unset";
        }
        switch (this.zzaoq) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return Integer.toString(asInt());
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return Float.toString(asFloat());
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return this.zzaoH;
            case Barcode.PHONE /*4*/:
                return new TreeMap(this.zzaoI).toString();
            case Barcode.PRODUCT /*5*/:
                return zzrS().toString();
            case Barcode.SMS /*6*/:
                return zzrT().toString();
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzt.zza(this, dest, flags);
    }

    public Map<String, MapValue> zzqX() {
        zzx.zza(this.zzaoq == 4, (Object) "Value is not in float map format");
        return this.zzaoI == null ? Collections.emptyMap() : this.zzaoI;
    }

    float zzrM() {
        return this.zzaou;
    }

    public int[] zzrS() {
        zzx.zza(this.zzaoq == 5, (Object) "Value is not in int list format");
        return this.zzaoJ;
    }

    public float[] zzrT() {
        zzx.zza(this.zzaoq == 6, (Object) "Value is not in float list format");
        return this.zzaoK;
    }

    String zzrU() {
        return this.zzaoH;
    }

    Bundle zzrV() {
        if (this.zzaoI == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzaoI.size());
        for (Entry entry : this.zzaoI.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }

    int[] zzrW() {
        return this.zzaoJ;
    }

    float[] zzrX() {
        return this.zzaoK;
    }
}
