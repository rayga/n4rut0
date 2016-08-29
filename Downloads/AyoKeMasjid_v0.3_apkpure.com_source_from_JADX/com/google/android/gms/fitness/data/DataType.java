package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzli;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataType implements SafeParcelable {
    public static final DataType AGGREGATE_ACTIVITY_SUMMARY;
    public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
    public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
    @Deprecated
    public static final DataType AGGREGATE_CALORIES_CONSUMED;
    public static final DataType AGGREGATE_CALORIES_EXPENDED;
    public static final DataType AGGREGATE_DISTANCE_DELTA;
    public static final DataType AGGREGATE_HEART_RATE_SUMMARY;
    public static final Set<DataType> AGGREGATE_INPUT_TYPES;
    public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;
    public static final DataType AGGREGATE_NUTRITION_SUMMARY;
    public static final DataType AGGREGATE_POWER_SUMMARY;
    public static final DataType AGGREGATE_SPEED_SUMMARY;
    public static final DataType AGGREGATE_STEP_COUNT_DELTA;
    public static final DataType AGGREGATE_WEIGHT_SUMMARY;
    public static final Creator<DataType> CREATOR;
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.data_type/";
    public static final DataType TYPE_ACTIVITY_SAMPLE;
    public static final DataType TYPE_ACTIVITY_SEGMENT;
    public static final DataType TYPE_BASAL_METABOLIC_RATE;
    public static final DataType TYPE_BODY_FAT_PERCENTAGE;
    public static final DataType TYPE_CALORIES_CONSUMED;
    public static final DataType TYPE_CALORIES_EXPENDED;
    public static final DataType TYPE_CYCLING_PEDALING_CADENCE;
    public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;
    public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;
    public static final DataType TYPE_CYCLING_WHEEL_RPM;
    public static final DataType TYPE_DISTANCE_CUMULATIVE;
    public static final DataType TYPE_DISTANCE_DELTA;
    public static final DataType TYPE_HEART_RATE_BPM;
    public static final DataType TYPE_HEIGHT;
    public static final DataType TYPE_LOCATION_SAMPLE;
    public static final DataType TYPE_LOCATION_TRACK;
    public static final DataType TYPE_NUTRITION;
    public static final DataType TYPE_POWER_SAMPLE;
    public static final DataType TYPE_SPEED;
    public static final DataType TYPE_STEP_COUNT_CADENCE;
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE;
    public static final DataType TYPE_STEP_COUNT_DELTA;
    public static final DataType TYPE_WEIGHT;
    public static final DataType TYPE_WORKOUT_EXERCISE;
    public static final DataType zzanN;
    public static final DataType zzanO;
    public static final DataType zzanP;
    public static final DataType zzanQ;
    public static final DataType zzanR;
    public static final DataType zzanS;
    public static final DataType zzanT;
    public static final DataType zzanU;
    private static final Map<DataType, List<DataType>> zzanV;
    public static final DataType[] zzanW;
    private final String mName;
    private final int mVersionCode;
    private final List<Field> zzanX;

    /* renamed from: com.google.android.gms.fitness.data.DataType.1 */
    static class C02841 extends HashMap<DataType, List<DataType>> {
        C02841() {
            put(DataType.TYPE_ACTIVITY_SEGMENT, Collections.singletonList(DataType.AGGREGATE_ACTIVITY_SUMMARY));
            put(DataType.TYPE_BASAL_METABOLIC_RATE, Collections.singletonList(DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY));
            put(DataType.TYPE_BODY_FAT_PERCENTAGE, Collections.singletonList(DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY));
            put(DataType.zzanR, Collections.singletonList(DataType.zzanT));
            put(DataType.zzanQ, Collections.singletonList(DataType.zzanU));
            put(DataType.TYPE_CALORIES_CONSUMED, Collections.singletonList(DataType.AGGREGATE_CALORIES_CONSUMED));
            put(DataType.TYPE_CALORIES_EXPENDED, Collections.singletonList(DataType.AGGREGATE_CALORIES_EXPENDED));
            put(DataType.TYPE_DISTANCE_DELTA, Collections.singletonList(DataType.AGGREGATE_DISTANCE_DELTA));
            put(DataType.zzanN, Collections.singletonList(DataType.zzanS));
            put(DataType.TYPE_LOCATION_SAMPLE, Collections.singletonList(DataType.AGGREGATE_LOCATION_BOUNDING_BOX));
            put(DataType.TYPE_NUTRITION, Collections.singletonList(DataType.AGGREGATE_NUTRITION_SUMMARY));
            put(DataType.TYPE_POWER_SAMPLE, Collections.singletonList(DataType.AGGREGATE_POWER_SUMMARY));
            put(DataType.TYPE_HEART_RATE_BPM, Collections.singletonList(DataType.AGGREGATE_HEART_RATE_SUMMARY));
            put(DataType.TYPE_SPEED, Collections.singletonList(DataType.AGGREGATE_SPEED_SUMMARY));
            put(DataType.TYPE_STEP_COUNT_DELTA, Collections.singletonList(DataType.AGGREGATE_STEP_COUNT_DELTA));
            put(DataType.TYPE_WEIGHT, Collections.singletonList(DataType.AGGREGATE_WEIGHT_SUMMARY));
        }
    }

    static {
        TYPE_STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", Field.FIELD_STEPS);
        TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", Field.FIELD_STEPS);
        TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", Field.FIELD_RPM);
        TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", Field.FIELD_ACTIVITY);
        zzanN = new DataType("com.google.floor_change", Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE, Field.zzaog, Field.zzaoj);
        TYPE_CALORIES_CONSUMED = new DataType("com.google.calories.consumed", Field.FIELD_CALORIES);
        TYPE_CALORIES_EXPENDED = new DataType("com.google.calories.expended", Field.FIELD_CALORIES);
        TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", Field.FIELD_CALORIES);
        TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", Field.FIELD_WATTS);
        TYPE_ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE);
        zzanO = new DataType("com.google.activity.edge", Field.FIELD_ACTIVITY, Field.zzaom);
        zzanP = new DataType("com.google.accelerometer", Field.zzaon, Field.zzaoo, Field.zzaop);
        TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", Field.FIELD_BPM);
        TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE);
        TYPE_LOCATION_TRACK = new DataType("com.google.location.track", Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE);
        TYPE_DISTANCE_DELTA = new DataType("com.google.distance.delta", Field.FIELD_DISTANCE);
        TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", Field.FIELD_DISTANCE);
        TYPE_SPEED = new DataType("com.google.speed", Field.FIELD_SPEED);
        TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", Field.FIELD_REVOLUTIONS);
        TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", Field.FIELD_RPM);
        TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", Field.FIELD_REVOLUTIONS);
        TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", Field.FIELD_RPM);
        TYPE_HEIGHT = new DataType("com.google.height", Field.FIELD_HEIGHT);
        TYPE_WEIGHT = new DataType("com.google.weight", Field.FIELD_WEIGHT);
        TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", Field.FIELD_PERCENTAGE);
        zzanQ = new DataType("com.google.body.waist.circumference", Field.FIELD_CIRCUMFERENCE);
        zzanR = new DataType("com.google.body.hip.circumference", Field.FIELD_CIRCUMFERENCE);
        TYPE_NUTRITION = new DataType("com.google.nutrition", Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE, Field.FIELD_FOOD_ITEM);
        TYPE_WORKOUT_EXERCISE = new DataType("com.google.activity.exercise", Field.FIELD_EXERCISE, Field.FIELD_REPETITIONS, Field.FIELD_DURATION, Field.FIELD_RESISTANCE_TYPE, Field.FIELD_RESISTANCE);
        AGGREGATE_INPUT_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DataType[]{TYPE_STEP_COUNT_DELTA, TYPE_DISTANCE_DELTA, TYPE_ACTIVITY_SEGMENT, zzanN, TYPE_SPEED, TYPE_HEART_RATE_BPM, TYPE_WEIGHT, TYPE_LOCATION_SAMPLE, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_BODY_FAT_PERCENTAGE, zzanR, zzanQ, TYPE_NUTRITION})));
        AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", Field.FIELD_ACTIVITY, Field.FIELD_DURATION, Field.FIELD_NUM_SEGMENTS);
        zzanS = new DataType("com.google.floor_change.summary", Field.zzaoe, Field.zzaof, Field.zzaoh, Field.zzaoi, Field.zzaok, Field.zzaol);
        AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_STEP_COUNT_DELTA = TYPE_STEP_COUNT_DELTA;
        AGGREGATE_DISTANCE_DELTA = TYPE_DISTANCE_DELTA;
        AGGREGATE_CALORIES_CONSUMED = TYPE_CALORIES_CONSUMED;
        AGGREGATE_CALORIES_EXPENDED = TYPE_CALORIES_EXPENDED;
        AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE);
        AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        zzanT = new DataType("com.google.body.hip.circumference.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        zzanU = new DataType("com.google.body.waist.circumference.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN);
        AGGREGATE_NUTRITION_SUMMARY = new DataType("com.google.nutrition.summary", Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE);
        zzanV = new C02841();
        zzanW = new DataType[]{zzanP, zzanO, TYPE_WORKOUT_EXERCISE, TYPE_ACTIVITY_SAMPLE, TYPE_ACTIVITY_SEGMENT, AGGREGATE_ACTIVITY_SUMMARY, TYPE_BODY_FAT_PERCENTAGE, AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, zzanR, zzanT, zzanQ, zzanU, TYPE_BASAL_METABOLIC_RATE, AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_CYCLING_PEDALING_CADENCE, TYPE_CYCLING_PEDALING_CUMULATIVE, TYPE_CYCLING_WHEEL_REVOLUTION, TYPE_CYCLING_WHEEL_RPM, TYPE_DISTANCE_CUMULATIVE, TYPE_DISTANCE_DELTA, zzanN, zzanS, TYPE_HEART_RATE_BPM, AGGREGATE_HEART_RATE_SUMMARY, TYPE_HEIGHT, AGGREGATE_LOCATION_BOUNDING_BOX, TYPE_LOCATION_SAMPLE, TYPE_LOCATION_TRACK, TYPE_NUTRITION, AGGREGATE_NUTRITION_SUMMARY, TYPE_POWER_SAMPLE, AGGREGATE_POWER_SUMMARY, TYPE_SPEED, AGGREGATE_SPEED_SUMMARY, TYPE_STEP_COUNT_CADENCE, TYPE_STEP_COUNT_CUMULATIVE, TYPE_STEP_COUNT_DELTA, TYPE_WEIGHT, AGGREGATE_WEIGHT_SUMMARY};
        CREATOR = new zzg();
    }

    DataType(int versionCode, String name, List<Field> fields) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzanX = Collections.unmodifiableList(fields);
    }

    public DataType(String name, Field... fields) {
        this(1, name, zzli.zzb(fields));
    }

    public static List<DataType> getAggregatesForInput(DataType inputDataType) {
        List list = (List) zzanV.get(inputDataType);
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static String getMimeType(DataType dataType) {
        return MIME_TYPE_PREFIX + dataType.getName();
    }

    private boolean zza(DataType dataType) {
        return this.mName.equals(dataType.mName) && this.zzanX.equals(dataType.zzanX);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataType) && zza((DataType) that));
    }

    public List<Field> getFields() {
        return this.zzanX;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public int indexOf(Field field) {
        if (this.zzanX.contains(field)) {
            return this.zzanX.indexOf(field);
        }
        throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[]{field, this}));
    }

    public String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.mName, this.zzanX});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public String zzrH() {
        return this.mName.startsWith("com.google.") ? this.mName.substring(11) : this.mName;
    }
}
