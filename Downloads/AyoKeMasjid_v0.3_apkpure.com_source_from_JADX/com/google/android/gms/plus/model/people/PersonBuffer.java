package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> zzaNz;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zznP() == null || !dataHolder.zznP().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzaNz = null;
        } else {
            this.zzaNz = new zzd(dataHolder, PersonEntity.CREATOR);
        }
    }

    public Person get(int position) {
        return this.zzaNz != null ? (Person) this.zzaNz.zzbn(position) : new zzk(this.zzYX, position);
    }
}
