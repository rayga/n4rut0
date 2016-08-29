package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity zzaMQ;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity zzyW() {
        synchronized (this) {
            if (this.zzaMQ == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.zzaMQ = MomentEntity.CREATOR.zzfU(obtain);
                obtain.recycle();
            }
        }
        return this.zzaMQ;
    }

    public /* synthetic */ Object freeze() {
        return zzyV();
    }

    public String getId() {
        return zzyW().getId();
    }

    public ItemScope getResult() {
        return zzyW().getResult();
    }

    public String getStartDate() {
        return zzyW().getStartDate();
    }

    public ItemScope getTarget() {
        return zzyW().getTarget();
    }

    public String getType() {
        return zzyW().getType();
    }

    public boolean hasId() {
        return zzyW().hasId();
    }

    public boolean hasResult() {
        return zzyW().hasResult();
    }

    public boolean hasStartDate() {
        return zzyW().hasStartDate();
    }

    public boolean hasTarget() {
        return zzyW().hasTarget();
    }

    public boolean hasType() {
        return zzyW().hasType();
    }

    public MomentEntity zzyV() {
        return zzyW();
    }
}
