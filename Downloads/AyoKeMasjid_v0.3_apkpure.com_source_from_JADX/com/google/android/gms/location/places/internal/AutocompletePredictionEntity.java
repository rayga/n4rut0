package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePrediction.Substring;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Creator<AutocompletePredictionEntity> CREATOR;
    final int mVersionCode;
    final String zzaDH;
    final List<Integer> zzaDi;
    final List<SubstringEntity> zzaEb;
    final int zzaEc;
    final String zzaoB;

    public static class SubstringEntity implements SafeParcelable, Substring {
        public static final Creator<SubstringEntity> CREATOR;
        final int mLength;
        final int mOffset;
        final int mVersionCode;

        static {
            CREATOR = new zzu();
        }

        public SubstringEntity(int versionCode, int offset, int length) {
            this.mVersionCode = versionCode;
            this.mOffset = offset;
            this.mLength = length;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) object;
            return zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(substringEntity.mOffset)) && zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(substringEntity.mLength));
        }

        public int getLength() {
            return this.mLength;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength));
        }

        public String toString() {
            return zzw.zzu(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zzu.zza(this, parcel, flags);
        }
    }

    static {
        CREATOR = new zza();
    }

    AutocompletePredictionEntity(int versionCode, String description, String placeId, List<Integer> placeTypes, List<SubstringEntity> substrings, int personalizationType) {
        this.mVersionCode = versionCode;
        this.zzaoB = description;
        this.zzaDH = placeId;
        this.zzaDi = placeTypes;
        this.zzaEb = substrings;
        this.zzaEc = personalizationType;
    }

    public static AutocompletePredictionEntity zza(String str, String str2, List<Integer> list, List<SubstringEntity> list2, int i) {
        return new AutocompletePredictionEntity(0, (String) zzx.zzv(str), str2, list, list2, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) object;
        return zzw.equal(this.zzaoB, autocompletePredictionEntity.zzaoB) && zzw.equal(this.zzaDH, autocompletePredictionEntity.zzaDH) && zzw.equal(this.zzaDi, autocompletePredictionEntity.zzaDi) && zzw.equal(this.zzaEb, autocompletePredictionEntity.zzaEb) && zzw.equal(Integer.valueOf(this.zzaEc), Integer.valueOf(autocompletePredictionEntity.zzaEc));
    }

    public /* synthetic */ Object freeze() {
        return zzwg();
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public List<? extends Substring> getMatchedSubstrings() {
        return this.zzaEb;
    }

    public String getPlaceId() {
        return this.zzaDH;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaDi;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoB, this.zzaDH, this.zzaDi, this.zzaEb, Integer.valueOf(this.zzaEc));
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzu(this).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzaoB).zzg("placeId", this.zzaDH).zzg("placeTypes", this.zzaDi).zzg("substrings", this.zzaEb).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public AutocompletePrediction zzwg() {
        return this;
    }
}
