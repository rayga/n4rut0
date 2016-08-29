package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

public class zzq extends zzt implements PlacePhotoMetadata {
    private final String zzaET;

    public zzq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzaET = getString("photo_fife_url");
    }

    public /* synthetic */ Object freeze() {
        return zzwu();
    }

    public CharSequence getAttributions() {
        return zzD("photo_attributions", null);
    }

    public int getMaxHeight() {
        return zzA("photo_max_height", 0);
    }

    public int getMaxWidth() {
        return zzA("photo_max_width", 0);
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        return zzwu().getScaledPhoto(client, width, height);
    }

    public PlacePhotoMetadata zzwu() {
        return new zzp(this.zzaET, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzabg);
    }
}
