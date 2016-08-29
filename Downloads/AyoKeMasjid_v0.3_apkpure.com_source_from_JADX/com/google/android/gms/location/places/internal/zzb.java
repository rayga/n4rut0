package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.Collections;
import java.util.List;
import org.bpmikc.akm.BuildConfig;

public class zzb extends zzt implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return zzwg();
    }

    public String getDescription() {
        return zzD("ap_description", BuildConfig.FLAVOR);
    }

    public List<SubstringEntity> getMatchedSubstrings() {
        return zza("ap_matched_subscriptions", SubstringEntity.CREATOR, Collections.emptyList());
    }

    public String getPlaceId() {
        return zzD("ap_place_id", null);
    }

    public List<Integer> getPlaceTypes() {
        return zza("ap_place_types", Collections.emptyList());
    }

    public AutocompletePrediction zzwg() {
        return AutocompletePredictionEntity.zza(getDescription(), getPlaceId(), getPlaceTypes(), getMatchedSubstrings(), zzwh());
    }

    public int zzwh() {
        return zzA("ap_personalization_type", 6);
    }
}
