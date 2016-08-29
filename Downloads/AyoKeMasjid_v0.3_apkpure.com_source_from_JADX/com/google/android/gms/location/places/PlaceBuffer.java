package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzr;

public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Context mContext;
    private final Status zzQA;
    private final String zzaDy;

    public PlaceBuffer(DataHolder dataHolder, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzQA = PlacesStatusCodes.zzhg(dataHolder.getStatusCode());
        if (dataHolder == null || dataHolder.zznP() == null) {
            this.zzaDy = null;
        } else {
            this.zzaDy = dataHolder.zznP().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public Place get(int position) {
        return new zzr(this.zzYX, position, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzaDy;
    }

    public Status getStatus() {
        return this.zzQA;
    }
}
