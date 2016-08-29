package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR;
    private static final HashMap<String, Field<?, ?>> zzaLS;
    final int mVersionCode;
    String zzFz;
    final Set<Integer> zzaLT;
    String zzaMG;
    ItemScopeEntity zzaMO;
    ItemScopeEntity zzaMP;
    String zzwj;

    static {
        CREATOR = new zzb();
        zzaLS = new HashMap();
        zzaLS.put("id", Field.zzm("id", 2));
        zzaLS.put("result", Field.zza("result", 4, ItemScopeEntity.class));
        zzaLS.put("startDate", Field.zzm("startDate", 5));
        zzaLS.put("target", Field.zza("target", 6, ItemScopeEntity.class));
        zzaLS.put("type", Field.zzm("type", 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzaLT = new HashSet();
    }

    MomentEntity(Set<Integer> indicatorSet, int versionCode, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzwj = id;
        this.zzaMO = result;
        this.zzaMG = startDate;
        this.zzaMP = target;
        this.zzFz = type;
    }

    public MomentEntity(Set<Integer> indicatorSet, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = 1;
        this.zzwj = id;
        this.zzaMO = result;
        this.zzaMG = startDate;
        this.zzaMP = target;
        this.zzFz = type;
    }

    public int describeContents() {
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (Field field : zzaLS.values()) {
            if (zza(field)) {
                if (!momentEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(momentEntity.zzb(field))) {
                    return false;
                }
            } else if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzyV();
    }

    public String getId() {
        return this.zzwj;
    }

    public ItemScope getResult() {
        return this.zzaMO;
    }

    public String getStartDate() {
        return this.zzaMG;
    }

    public ItemScope getTarget() {
        return this.zzaMP;
    }

    public String getType() {
        return this.zzFz;
    }

    public boolean hasId() {
        return this.zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
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
        zzb com_google_android_gms_plus_internal_model_moments_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    protected boolean zza(Field field) {
        return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    protected Object zzb(Field field) {
        switch (field.zzpi()) {
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return this.zzwj;
            case Barcode.PHONE /*4*/:
                return this.zzaMO;
            case Barcode.PRODUCT /*5*/:
                return this.zzaMG;
            case Barcode.SMS /*6*/:
                return this.zzaMP;
            case Barcode.TEXT /*7*/:
                return this.zzFz;
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

    public MomentEntity zzyV() {
        return this;
    }
}
