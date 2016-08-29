package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {
        private String zzFz;
        private final Set<Integer> zzaLT;
        private String zzaMG;
        private ItemScopeEntity zzaMO;
        private ItemScopeEntity zzaMP;
        private String zzwj;

        public Builder() {
            this.zzaLT = new HashSet();
        }

        public Moment build() {
            return new MomentEntity(this.zzaLT, this.zzwj, this.zzaMO, this.zzaMG, this.zzaMP, this.zzFz);
        }

        public Builder setId(String id) {
            this.zzwj = id;
            this.zzaLT.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.zzaMO = (ItemScopeEntity) result;
            this.zzaLT.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzaMG = startDate;
            this.zzaLT.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.zzaMP = (ItemScopeEntity) target;
            this.zzaLT.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String type) {
            this.zzFz = type;
            this.zzaLT.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
