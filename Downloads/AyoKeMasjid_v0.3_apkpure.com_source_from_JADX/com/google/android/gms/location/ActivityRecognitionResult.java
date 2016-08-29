package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR;
    private final int mVersionCode;
    List<DetectedActivity> zzaBt;
    long zzaBu;
    long zzaBv;
    int zzaBw;

    static {
        CREATOR = new ActivityRecognitionResultCreator();
    }

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis, int detectorInfoId) {
        this.mVersionCode = versionCode;
        this.zzaBt = probableActivities;
        this.zzaBu = timeMillis;
        this.zzaBv = elapsedRealtimeMillis;
        this.zzaBw = detectorInfoId;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(mostProbableActivity, time, elapsedRealtimeMillis, 0);
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis, int detectorInfoId) {
        this(Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis, detectorInfoId);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        this((List) probableActivities, time, elapsedRealtimeMillis, 0);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis, int detectorInfoId) {
        boolean z = true;
        boolean z2 = probableActivities != null && probableActivities.size() > 0;
        zzx.zzb(z2, (Object) "Must have at least 1 detected activity");
        if (time <= 0 || elapsedRealtimeMillis <= 0) {
            z = false;
        }
        zzx.zzb(z, (Object) "Must set times");
        this.mVersionCode = 2;
        this.zzaBt = probableActivities;
        this.zzaBu = time;
        this.zzaBv = elapsedRealtimeMillis;
        this.zzaBw = detectorInfoId;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        if (!(obj instanceof byte[])) {
            return obj instanceof ActivityRecognitionResult ? (ActivityRecognitionResult) obj : null;
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        }
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) o;
        return this.zzaBu == activityRecognitionResult.zzaBu && this.zzaBv == activityRecognitionResult.zzaBv && this.zzaBw == activityRecognitionResult.zzaBw && zzw.equal(this.zzaBt, activityRecognitionResult.zzaBt);
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity detectedActivity : this.zzaBt) {
            if (detectedActivity.getType() == activityType) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaBv;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zzaBt.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaBt;
    }

    public long getTime() {
        return this.zzaBu;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaBu), Long.valueOf(this.zzaBv), Integer.valueOf(this.zzaBw), this.zzaBt);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaBt + ", timeMillis=" + this.zzaBu + ", elapsedRealtimeMillis=" + this.zzaBv + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.zza(this, out, flags);
    }
}
