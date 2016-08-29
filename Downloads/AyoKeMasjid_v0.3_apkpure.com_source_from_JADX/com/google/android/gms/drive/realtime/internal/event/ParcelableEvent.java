package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR;
    final int mVersionCode;
    final String zzGY;
    final String zzGh;
    final String zzamb;
    final List<String> zzamh;
    final boolean zzami;
    final boolean zzamj;
    final boolean zzamk;
    final String zzaml;
    final TextInsertedDetails zzamm;
    final TextDeletedDetails zzamn;
    final ValuesAddedDetails zzamo;
    final ValuesRemovedDetails zzamp;
    final ValuesSetDetails zzamq;
    final ValueChangedDetails zzamr;
    final ReferenceShiftedDetails zzams;
    final ObjectChangedDetails zzamt;
    final FieldChangedDetails zzamu;

    static {
        CREATOR = new zzc();
    }

    ParcelableEvent(int versionCode, String sessionId, String userId, List<String> compoundOperationNames, boolean isLocal, boolean isUndo, boolean isRedo, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.mVersionCode = versionCode;
        this.zzGY = sessionId;
        this.zzGh = userId;
        this.zzamh = compoundOperationNames;
        this.zzami = isLocal;
        this.zzamj = isUndo;
        this.zzamk = isRedo;
        this.zzamb = objectId;
        this.zzaml = objectType;
        this.zzamm = textInsertedDetails;
        this.zzamn = textDeletedDetails;
        this.zzamo = valuesAddedDetails;
        this.zzamp = valuesRemovedDetails;
        this.zzamq = valuesSetDetails;
        this.zzamr = valueChangedDetails;
        this.zzams = referenceShiftedDetails;
        this.zzamt = objectChangedDetails;
        this.zzamu = fieldChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
