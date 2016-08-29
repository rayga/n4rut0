package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bpmikc.akm.Fragment.Frg_Qiblat_Map;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final zza CREATOR;
    private static final HashMap<String, Field<?, ?>> zzaLS;
    final int mVersionCode;
    String zzF;
    String zzUc;
    final Set<Integer> zzaLT;
    String zzaMR;
    AgeRangeEntity zzaMS;
    String zzaMT;
    String zzaMU;
    int zzaMV;
    CoverEntity zzaMW;
    String zzaMX;
    ImageEntity zzaMY;
    boolean zzaMZ;
    NameEntity zzaNa;
    String zzaNb;
    int zzaNc;
    List<OrganizationsEntity> zzaNd;
    List<PlacesLivedEntity> zzaNe;
    int zzaNf;
    int zzaNg;
    String zzaNh;
    List<UrlsEntity> zzaNi;
    boolean zzaNj;
    String zzahh;
    int zzsW;
    String zzwj;

    public static class zza {
        public static int zzek(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements AgeRange {
        public static final zzb CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        final int mVersionCode;
        final Set<Integer> zzaLT;
        int zzaNk;
        int zzaNl;

        static {
            CREATOR = new zzb();
            zzaLS = new HashMap();
            zzaLS.put("max", Field.zzj("max", 2));
            zzaLS.put("min", Field.zzj("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        AgeRangeEntity(Set<Integer> indicatorSet, int versionCode, int max, int min) {
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaNk = max;
            this.zzaNl = min;
        }

        public int describeContents() {
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!ageRangeEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(ageRangeEntity.zzb(field))) {
                        return false;
                    }
                } else if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzyY();
        }

        public int getMax() {
            return this.zzaNk;
        }

        public int getMin() {
            return this.zzaNl;
        }

        public boolean hasMax() {
            return this.zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.zzaLT.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            zzb.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return Integer.valueOf(this.zzaNk);
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    return Integer.valueOf(this.zzaNl);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        public AgeRangeEntity zzyY() {
            return this;
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Cover {
        public static final zzc CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        final int mVersionCode;
        final Set<Integer> zzaLT;
        CoverInfoEntity zzaNm;
        CoverPhotoEntity zzaNn;
        int zzaNo;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements CoverInfo {
            public static final zzd CREATOR;
            private static final HashMap<String, Field<?, ?>> zzaLS;
            final int mVersionCode;
            final Set<Integer> zzaLT;
            int zzaNp;
            int zzaNq;

            static {
                CREATOR = new zzd();
                zzaLS = new HashMap();
                zzaLS.put("leftImageOffset", Field.zzj("leftImageOffset", 2));
                zzaLS.put("topImageOffset", Field.zzj("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzaLT = new HashSet();
            }

            CoverInfoEntity(Set<Integer> indicatorSet, int versionCode, int leftImageOffset, int topImageOffset) {
                this.zzaLT = indicatorSet;
                this.mVersionCode = versionCode;
                this.zzaNp = leftImageOffset;
                this.zzaNq = topImageOffset;
            }

            public int describeContents() {
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (Field field : zzaLS.values()) {
                    if (zza(field)) {
                        if (!coverInfoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverInfoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzza();
            }

            public int getLeftImageOffset() {
                return this.zzaNp;
            }

            public int getTopImageOffset() {
                return this.zzaNq;
            }

            public boolean hasLeftImageOffset() {
                return this.zzaLT.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.zzaLT.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzaLS.values()) {
                    int hashCode;
                    if (zza(field)) {
                        hashCode = zzb(field).hashCode() + (i + field.zzpi());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                zzd.zza(this, out, flags);
            }

            protected boolean zza(Field field) {
                return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
            }

            protected Object zzb(Field field) {
                switch (field.zzpi()) {
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        return Integer.valueOf(this.zzaNp);
                    case CompletionEvent.STATUS_CANCELED /*3*/:
                        return Integer.valueOf(this.zzaNq);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
                }
            }

            public /* synthetic */ Map zzpb() {
                return zzyT();
            }

            public HashMap<String, Field<?, ?>> zzyT() {
                return zzaLS;
            }

            public CoverInfoEntity zzza() {
                return this;
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements CoverPhoto {
            public static final zze CREATOR;
            private static final HashMap<String, Field<?, ?>> zzaLS;
            final int mVersionCode;
            String zzF;
            final Set<Integer> zzaLT;
            int zznP;
            int zznQ;

            static {
                CREATOR = new zze();
                zzaLS = new HashMap();
                zzaLS.put("height", Field.zzj("height", 2));
                zzaLS.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzaLS.put("width", Field.zzj("width", 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzaLT = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> indicatorSet, int versionCode, int height, String url, int width) {
                this.zzaLT = indicatorSet;
                this.mVersionCode = versionCode;
                this.zznQ = height;
                this.zzF = url;
                this.zznP = width;
            }

            public int describeContents() {
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (Field field : zzaLS.values()) {
                    if (zza(field)) {
                        if (!coverPhotoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverPhotoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzzb();
            }

            public int getHeight() {
                return this.zznQ;
            }

            public String getUrl() {
                return this.zzF;
            }

            public int getWidth() {
                return this.zznP;
            }

            public boolean hasHeight() {
                return this.zzaLT.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.zzaLT.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.zzaLT.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (Field field : zzaLS.values()) {
                    int hashCode;
                    if (zza(field)) {
                        hashCode = zzb(field).hashCode() + (i + field.zzpi());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                zze.zza(this, out, flags);
            }

            protected boolean zza(Field field) {
                return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
            }

            protected Object zzb(Field field) {
                switch (field.zzpi()) {
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        return Integer.valueOf(this.zznQ);
                    case CompletionEvent.STATUS_CANCELED /*3*/:
                        return this.zzF;
                    case Barcode.PHONE /*4*/:
                        return Integer.valueOf(this.zznP);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
                }
            }

            public /* synthetic */ Map zzpb() {
                return zzyT();
            }

            public HashMap<String, Field<?, ?>> zzyT() {
                return zzaLS;
            }

            public CoverPhotoEntity zzzb() {
                return this;
            }
        }

        static {
            CREATOR = new zzc();
            zzaLS = new HashMap();
            zzaLS.put("coverInfo", Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzaLS.put("coverPhoto", Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzaLS.put("layout", Field.zza("layout", 4, new StringToIntConverter().zzi("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        CoverEntity(Set<Integer> indicatorSet, int versionCode, CoverInfoEntity coverInfo, CoverPhotoEntity coverPhoto, int layout) {
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaNm = coverInfo;
            this.zzaNn = coverPhoto;
            this.zzaNo = layout;
        }

        public int describeContents() {
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!coverEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(coverEntity.zzb(field))) {
                        return false;
                    }
                } else if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzyZ();
        }

        public CoverInfo getCoverInfo() {
            return this.zzaNm;
        }

        public CoverPhoto getCoverPhoto() {
            return this.zzaNn;
        }

        public int getLayout() {
            return this.zzaNo;
        }

        public boolean hasCoverInfo() {
            return this.zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.zzaLT.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.zzaLT.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            zzc.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return this.zzaNm;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    return this.zzaNn;
                case Barcode.PHONE /*4*/:
                    return Integer.valueOf(this.zzaNo);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        public CoverEntity zzyZ() {
            return this;
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Image {
        public static final zzf CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        final int mVersionCode;
        String zzF;
        final Set<Integer> zzaLT;

        static {
            CREATOR = new zzf();
            zzaLS = new HashMap();
            zzaLS.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        public ImageEntity(String url) {
            this.zzaLT = new HashSet();
            this.mVersionCode = 1;
            this.zzF = url;
            this.zzaLT.add(Integer.valueOf(2));
        }

        ImageEntity(Set<Integer> indicatorSet, int versionCode, String url) {
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzF = url;
        }

        public int describeContents() {
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!imageEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(imageEntity.zzb(field))) {
                        return false;
                    }
                } else if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzzc();
        }

        public String getUrl() {
            return this.zzF;
        }

        public boolean hasUrl() {
            return this.zzaLT.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            zzf.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        public ImageEntity zzzc() {
            return this;
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Name {
        public static final zzg CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        final int mVersionCode;
        final Set<Integer> zzaLT;
        String zzaMr;
        String zzaMu;
        String zzaNr;
        String zzaNs;
        String zzaNt;
        String zzaNu;

        static {
            CREATOR = new zzg();
            zzaLS = new HashMap();
            zzaLS.put("familyName", Field.zzm("familyName", 2));
            zzaLS.put("formatted", Field.zzm("formatted", 3));
            zzaLS.put("givenName", Field.zzm("givenName", 4));
            zzaLS.put("honorificPrefix", Field.zzm("honorificPrefix", 5));
            zzaLS.put("honorificSuffix", Field.zzm("honorificSuffix", 6));
            zzaLS.put("middleName", Field.zzm("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        NameEntity(Set<Integer> indicatorSet, int versionCode, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, String middleName) {
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaMr = familyName;
            this.zzaNr = formatted;
            this.zzaMu = givenName;
            this.zzaNs = honorificPrefix;
            this.zzaNt = honorificSuffix;
            this.zzaNu = middleName;
        }

        public int describeContents() {
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!nameEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(nameEntity.zzb(field))) {
                        return false;
                    }
                } else if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzzd();
        }

        public String getFamilyName() {
            return this.zzaMr;
        }

        public String getFormatted() {
            return this.zzaNr;
        }

        public String getGivenName() {
            return this.zzaMu;
        }

        public String getHonorificPrefix() {
            return this.zzaNs;
        }

        public String getHonorificSuffix() {
            return this.zzaNt;
        }

        public String getMiddleName() {
            return this.zzaNu;
        }

        public boolean hasFamilyName() {
            return this.zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.zzaLT.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.zzaLT.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.zzaLT.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.zzaLT.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.zzaLT.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            zzg.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return this.zzaMr;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    return this.zzaNr;
                case Barcode.PHONE /*4*/:
                    return this.zzaMu;
                case Barcode.PRODUCT /*5*/:
                    return this.zzaNs;
                case Barcode.SMS /*6*/:
                    return this.zzaNt;
                case Barcode.TEXT /*7*/:
                    return this.zzaNu;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        public NameEntity zzzd() {
            return this;
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Organizations {
        public static final zzh CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        String mName;
        final int mVersionCode;
        int zzUS;
        final Set<Integer> zzaLT;
        String zzaMG;
        String zzaMq;
        String zzaNv;
        String zzaNw;
        boolean zzaNx;
        String zzagU;
        String zzaoB;

        static {
            CREATOR = new zzh();
            zzaLS = new HashMap();
            zzaLS.put("department", Field.zzm("department", 2));
            zzaLS.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzaLS.put("endDate", Field.zzm("endDate", 4));
            zzaLS.put("location", Field.zzm("location", 5));
            zzaLS.put("name", Field.zzm("name", 6));
            zzaLS.put("primary", Field.zzl("primary", 7));
            zzaLS.put("startDate", Field.zzm("startDate", 8));
            zzaLS.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, Field.zzm(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzaLS.put("type", Field.zza("type", 10, new StringToIntConverter().zzi("work", 0).zzi("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        OrganizationsEntity(Set<Integer> indicatorSet, int versionCode, String department, String description, String endDate, String location, String name, boolean primary, String startDate, String title, int type) {
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaNv = department;
            this.zzaoB = description;
            this.zzaMq = endDate;
            this.zzaNw = location;
            this.mName = name;
            this.zzaNx = primary;
            this.zzaMG = startDate;
            this.zzagU = title;
            this.zzUS = type;
        }

        public int describeContents() {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!organizationsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(organizationsEntity.zzb(field))) {
                        return false;
                    }
                } else if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzze();
        }

        public String getDepartment() {
            return this.zzaNv;
        }

        public String getDescription() {
            return this.zzaoB;
        }

        public String getEndDate() {
            return this.zzaMq;
        }

        public String getLocation() {
            return this.zzaNw;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzaMG;
        }

        public String getTitle() {
            return this.zzagU;
        }

        public int getType() {
            return this.zzUS;
        }

        public boolean hasDepartment() {
            return this.zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.zzaLT.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.zzaLT.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.zzaLT.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.zzaLT.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.zzaLT.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.zzaLT.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.zzaLT.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.zzaLT.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzaNx;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            zzh.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return this.zzaNv;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    return this.zzaoB;
                case Barcode.PHONE /*4*/:
                    return this.zzaMq;
                case Barcode.PRODUCT /*5*/:
                    return this.zzaNw;
                case Barcode.SMS /*6*/:
                    return this.mName;
                case Barcode.TEXT /*7*/:
                    return Boolean.valueOf(this.zzaNx);
                case Barcode.URL /*8*/:
                    return this.zzaMG;
                case Barcode.WIFI /*9*/:
                    return this.zzagU;
                case Barcode.GEO /*10*/:
                    return Integer.valueOf(this.zzUS);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        public OrganizationsEntity zzze() {
            return this;
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements PlacesLived {
        public static final zzi CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzaLT;
        boolean zzaNx;

        static {
            CREATOR = new zzi();
            zzaLS = new HashMap();
            zzaLS.put("primary", Field.zzl("primary", 2));
            zzaLS.put("value", Field.zzm("value", 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> indicatorSet, int versionCode, boolean primary, String value) {
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaNx = primary;
            this.mValue = value;
        }

        public int describeContents() {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!placesLivedEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(placesLivedEntity.zzb(field))) {
                        return false;
                    }
                } else if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzzf();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzaLT.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzaLT.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.zzaNx;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            zzi.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    return Boolean.valueOf(this.zzaNx);
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        public PlacesLivedEntity zzzf() {
            return this;
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Urls {
        public static final zzj CREATOR;
        private static final HashMap<String, Field<?, ?>> zzaLS;
        String mValue;
        final int mVersionCode;
        int zzUS;
        String zzaID;
        final Set<Integer> zzaLT;
        private final int zzaNy;

        static {
            CREATOR = new zzj();
            zzaLS = new HashMap();
            zzaLS.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, Field.zzm(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzaLS.put("type", Field.zza("type", 6, new StringToIntConverter().zzi("home", 0).zzi("work", 1).zzi("blog", 2).zzi(Scopes.PROFILE, 3).zzi(FitnessActivities.OTHER, 4).zzi("otherProfile", 5).zzi("contributor", 6).zzi("website", 7), false));
            zzaLS.put("value", Field.zzm("value", 4));
        }

        public UrlsEntity() {
            this.zzaNy = 4;
            this.mVersionCode = 1;
            this.zzaLT = new HashSet();
        }

        UrlsEntity(Set<Integer> indicatorSet, int versionCode, String label, int type, String value, int type_DEPRECATED_FENACHO) {
            this.zzaNy = 4;
            this.zzaLT = indicatorSet;
            this.mVersionCode = versionCode;
            this.zzaID = label;
            this.zzUS = type;
            this.mValue = value;
        }

        public int describeContents() {
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (Field field : zzaLS.values()) {
                if (zza(field)) {
                    if (!urlsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(urlsEntity.zzb(field))) {
                        return false;
                    }
                } else if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzzh();
        }

        public String getLabel() {
            return this.zzaID;
        }

        public int getType() {
            return this.zzUS;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzaLT.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.zzaLT.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzaLT.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (Field field : zzaLS.values()) {
                int hashCode;
                if (zza(field)) {
                    hashCode = zzb(field).hashCode() + (i + field.zzpi());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            zzj.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
        }

        protected Object zzb(Field field) {
            switch (field.zzpi()) {
                case Barcode.PHONE /*4*/:
                    return this.mValue;
                case Barcode.PRODUCT /*5*/:
                    return this.zzaID;
                case Barcode.SMS /*6*/:
                    return Integer.valueOf(this.zzUS);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
            }
        }

        public /* synthetic */ Map zzpb() {
            return zzyT();
        }

        public HashMap<String, Field<?, ?>> zzyT() {
            return zzaLS;
        }

        @Deprecated
        public int zzzg() {
            return 4;
        }

        public UrlsEntity zzzh() {
            return this;
        }
    }

    static {
        CREATOR = new zza();
        zzaLS = new HashMap();
        zzaLS.put("aboutMe", Field.zzm("aboutMe", 2));
        zzaLS.put("ageRange", Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzaLS.put("birthday", Field.zzm("birthday", 4));
        zzaLS.put("braggingRights", Field.zzm("braggingRights", 5));
        zzaLS.put("circledByCount", Field.zzj("circledByCount", 6));
        zzaLS.put("cover", Field.zza("cover", 7, CoverEntity.class));
        zzaLS.put("currentLocation", Field.zzm("currentLocation", 8));
        zzaLS.put("displayName", Field.zzm("displayName", 9));
        zzaLS.put("gender", Field.zza("gender", 12, new StringToIntConverter().zzi("male", 0).zzi("female", 1).zzi(FitnessActivities.OTHER, 2), false));
        zzaLS.put("id", Field.zzm("id", 14));
        zzaLS.put(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, Field.zza(Frg_Qiblat_Map.sARGUMENT_IMAGE_CODE, 15, ImageEntity.class));
        zzaLS.put("isPlusUser", Field.zzl("isPlusUser", 16));
        zzaLS.put("language", Field.zzm("language", 18));
        zzaLS.put("name", Field.zza("name", 19, NameEntity.class));
        zzaLS.put("nickname", Field.zzm("nickname", 20));
        zzaLS.put("objectType", Field.zza("objectType", 21, new StringToIntConverter().zzi("person", 0).zzi("page", 1), false));
        zzaLS.put("organizations", Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzaLS.put("placesLived", Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzaLS.put("plusOneCount", Field.zzj("plusOneCount", 24));
        zzaLS.put("relationshipStatus", Field.zza("relationshipStatus", 25, new StringToIntConverter().zzi("single", 0).zzi("in_a_relationship", 1).zzi("engaged", 2).zzi("married", 3).zzi("its_complicated", 4).zzi("open_relationship", 5).zzi("widowed", 6).zzi("in_domestic_partnership", 7).zzi("in_civil_union", 8), false));
        zzaLS.put("tagline", Field.zzm("tagline", 26));
        zzaLS.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzm(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzaLS.put("urls", Field.zzb("urls", 28, UrlsEntity.class));
        zzaLS.put("verified", Field.zzl("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzaLT = new HashSet();
    }

    public PersonEntity(String displayName, String id, ImageEntity image, int objectType, String url) {
        this.mVersionCode = 1;
        this.zzaLT = new HashSet();
        this.zzahh = displayName;
        this.zzaLT.add(Integer.valueOf(9));
        this.zzwj = id;
        this.zzaLT.add(Integer.valueOf(14));
        this.zzaMY = image;
        this.zzaLT.add(Integer.valueOf(15));
        this.zzaNc = objectType;
        this.zzaLT.add(Integer.valueOf(21));
        this.zzF = url;
        this.zzaLT.add(Integer.valueOf(27));
    }

    PersonEntity(Set<Integer> indicatorSet, int versionCode, String aboutMe, AgeRangeEntity ageRange, String birthday, String braggingRights, int circledByCount, CoverEntity cover, String currentLocation, String displayName, int gender, String id, ImageEntity image, boolean isPlusUser, String language, NameEntity name, String nickname, int objectType, List<OrganizationsEntity> organizations, List<PlacesLivedEntity> placesLived, int plusOneCount, int relationshipStatus, String tagline, String url, List<UrlsEntity> urls, boolean verified) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzaMR = aboutMe;
        this.zzaMS = ageRange;
        this.zzaMT = birthday;
        this.zzaMU = braggingRights;
        this.zzaMV = circledByCount;
        this.zzaMW = cover;
        this.zzaMX = currentLocation;
        this.zzahh = displayName;
        this.zzsW = gender;
        this.zzwj = id;
        this.zzaMY = image;
        this.zzaMZ = isPlusUser;
        this.zzUc = language;
        this.zzaNa = name;
        this.zzaNb = nickname;
        this.zzaNc = objectType;
        this.zzaNd = organizations;
        this.zzaNe = placesLived;
        this.zzaNf = plusOneCount;
        this.zzaNg = relationshipStatus;
        this.zzaNh = tagline;
        this.zzF = url;
        this.zzaNi = urls;
        this.zzaNj = verified;
    }

    public static PersonEntity zzp(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity zzfV = CREATOR.zzfV(obtain);
        obtain.recycle();
        return zzfV;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (Field field : zzaLS.values()) {
            if (zza(field)) {
                if (!personEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(personEntity.zzb(field))) {
                    return false;
                }
            } else if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzyX();
    }

    public String getAboutMe() {
        return this.zzaMR;
    }

    public AgeRange getAgeRange() {
        return this.zzaMS;
    }

    public String getBirthday() {
        return this.zzaMT;
    }

    public String getBraggingRights() {
        return this.zzaMU;
    }

    public int getCircledByCount() {
        return this.zzaMV;
    }

    public Cover getCover() {
        return this.zzaMW;
    }

    public String getCurrentLocation() {
        return this.zzaMX;
    }

    public String getDisplayName() {
        return this.zzahh;
    }

    public int getGender() {
        return this.zzsW;
    }

    public String getId() {
        return this.zzwj;
    }

    public Image getImage() {
        return this.zzaMY;
    }

    public String getLanguage() {
        return this.zzUc;
    }

    public Name getName() {
        return this.zzaNa;
    }

    public String getNickname() {
        return this.zzaNb;
    }

    public int getObjectType() {
        return this.zzaNc;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.zzaNd;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzaNe;
    }

    public int getPlusOneCount() {
        return this.zzaNf;
    }

    public int getRelationshipStatus() {
        return this.zzaNg;
    }

    public String getTagline() {
        return this.zzaNh;
    }

    public String getUrl() {
        return this.zzF;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.zzaNi;
    }

    public boolean hasAboutMe() {
        return this.zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.zzaLT.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.zzaLT.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.zzaLT.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.zzaLT.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.zzaLT.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.zzaLT.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.zzaLT.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.zzaLT.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.zzaLT.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.zzaLT.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.zzaLT.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.zzaLT.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.zzaLT.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.zzaLT.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.zzaLT.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.zzaLT.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.zzaLT.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.zzaLT.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzaLT.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.zzaLT.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzaLS.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzpi());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.zzaMZ;
    }

    public boolean isVerified() {
        return this.zzaNj;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    protected boolean zza(Field field) {
        return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    protected Object zzb(Field field) {
        switch (field.zzpi()) {
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return this.zzaMR;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return this.zzaMS;
            case Barcode.PHONE /*4*/:
                return this.zzaMT;
            case Barcode.PRODUCT /*5*/:
                return this.zzaMU;
            case Barcode.SMS /*6*/:
                return Integer.valueOf(this.zzaMV);
            case Barcode.TEXT /*7*/:
                return this.zzaMW;
            case Barcode.URL /*8*/:
                return this.zzaMX;
            case Barcode.WIFI /*9*/:
                return this.zzahh;
            case Barcode.DRIVER_LICENSE /*12*/:
                return Integer.valueOf(this.zzsW);
            case Place.TYPE_BUS_STATION /*14*/:
                return this.zzwj;
            case Place.TYPE_CAFE /*15*/:
                return this.zzaMY;
            case Barcode.DATA_MATRIX /*16*/:
                return Boolean.valueOf(this.zzaMZ);
            case Place.TYPE_CAR_RENTAL /*18*/:
                return this.zzUc;
            case Place.TYPE_CAR_REPAIR /*19*/:
                return this.zzaNa;
            case Place.TYPE_CAR_WASH /*20*/:
                return this.zzaNb;
            case Place.TYPE_CASINO /*21*/:
                return Integer.valueOf(this.zzaNc);
            case Place.TYPE_CEMETERY /*22*/:
                return this.zzaNd;
            case Place.TYPE_CHURCH /*23*/:
                return this.zzaNe;
            case Place.TYPE_CITY_HALL /*24*/:
                return Integer.valueOf(this.zzaNf);
            case Place.TYPE_CLOTHING_STORE /*25*/:
                return Integer.valueOf(this.zzaNg);
            case Place.TYPE_CONVENIENCE_STORE /*26*/:
                return this.zzaNh;
            case Place.TYPE_COURTHOUSE /*27*/:
                return this.zzF;
            case Place.TYPE_DENTIST /*28*/:
                return this.zzaNi;
            case Place.TYPE_DEPARTMENT_STORE /*29*/:
                return Boolean.valueOf(this.zzaNj);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
        }
    }

    public /* synthetic */ Map zzpb() {
        return zzyT();
    }

    public HashMap<String, Field<?, ?>> zzyT() {
        return zzaLS;
    }

    public PersonEntity zzyX() {
        return this;
    }
}
