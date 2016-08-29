package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR;
    public static final Field FIELD_ACCURACY;
    public static final Field FIELD_ACTIVITY;
    public static final Field FIELD_ALTITUDE;
    public static final Field FIELD_AVERAGE;
    public static final Field FIELD_BPM;
    public static final Field FIELD_CALORIES;
    public static final Field FIELD_CIRCUMFERENCE;
    public static final Field FIELD_CONFIDENCE;
    public static final Field FIELD_DISTANCE;
    public static final Field FIELD_DURATION;
    public static final Field FIELD_EXERCISE;
    public static final Field FIELD_FOOD_ITEM;
    public static final Field FIELD_HEIGHT;
    public static final Field FIELD_HIGH_LATITUDE;
    public static final Field FIELD_HIGH_LONGITUDE;
    public static final Field FIELD_LATITUDE;
    public static final Field FIELD_LONGITUDE;
    public static final Field FIELD_LOW_LATITUDE;
    public static final Field FIELD_LOW_LONGITUDE;
    public static final Field FIELD_MAX;
    public static final Field FIELD_MEAL_TYPE;
    public static final Field FIELD_MIN;
    public static final Field FIELD_NUM_SEGMENTS;
    public static final Field FIELD_NUTRIENTS;
    public static final Field FIELD_PERCENTAGE;
    public static final Field FIELD_REPETITIONS;
    public static final Field FIELD_RESISTANCE;
    public static final Field FIELD_RESISTANCE_TYPE;
    public static final Field FIELD_REVOLUTIONS;
    public static final Field FIELD_RPM;
    public static final Field FIELD_SPEED;
    public static final Field FIELD_STEPS;
    public static final Field FIELD_WATTS;
    public static final Field FIELD_WEIGHT;
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    public static final Field zzaoc;
    public static final Field zzaod;
    public static final Field zzaoe;
    public static final Field zzaof;
    public static final Field zzaog;
    public static final Field zzaoh;
    public static final Field zzaoi;
    public static final Field zzaoj;
    public static final Field zzaok;
    public static final Field zzaol;
    public static final Field zzaom;
    public static final Field zzaon;
    public static final Field zzaoo;
    public static final Field zzaop;
    private final String mName;
    private final int mVersionCode;
    private final int zzaoq;

    static {
        FIELD_ACTIVITY = zzcR("activity");
        FIELD_CONFIDENCE = zzcS("confidence");
        zzaoc = zzcU("activity_confidence");
        FIELD_STEPS = zzcR("steps");
        FIELD_DURATION = zzcR("duration");
        zzaod = zzcU("activity_duration");
        zzaoe = zzcU("activity_duration.ascending");
        zzaof = zzcU("activity_duration.descending");
        FIELD_BPM = zzcS("bpm");
        FIELD_LATITUDE = zzcS("latitude");
        FIELD_LONGITUDE = zzcS("longitude");
        FIELD_ACCURACY = zzcS("accuracy");
        FIELD_ALTITUDE = zzcS("altitude");
        FIELD_DISTANCE = zzcS("distance");
        FIELD_HEIGHT = zzcS("height");
        FIELD_WEIGHT = zzcS("weight");
        FIELD_CIRCUMFERENCE = zzcS("circumference");
        FIELD_PERCENTAGE = zzcS("percentage");
        FIELD_SPEED = zzcS("speed");
        FIELD_RPM = zzcS("rpm");
        FIELD_REVOLUTIONS = zzcR("revolutions");
        FIELD_CALORIES = zzcS(NUTRIENT_CALORIES);
        FIELD_WATTS = zzcS("watts");
        FIELD_MEAL_TYPE = zzcR("meal_type");
        FIELD_FOOD_ITEM = zzcT("food_item");
        FIELD_NUTRIENTS = zzcU("nutrients");
        zzaog = zzcS("elevation.change");
        zzaoh = zzcU("elevation.gain");
        zzaoi = zzcU("elevation.loss");
        zzaoj = zzcS("floors");
        zzaok = zzcU("floor.gain");
        zzaol = zzcU("floor.loss");
        FIELD_EXERCISE = zzcT("exercise");
        FIELD_REPETITIONS = zzcR("repetitions");
        FIELD_RESISTANCE = zzcS("resistance");
        FIELD_RESISTANCE_TYPE = zzcR("resistance_type");
        FIELD_NUM_SEGMENTS = zzcR("num_segments");
        FIELD_AVERAGE = zzcS("average");
        FIELD_MAX = zzcS("max");
        FIELD_MIN = zzcS("min");
        FIELD_LOW_LATITUDE = zzcS("low_latitude");
        FIELD_LOW_LONGITUDE = zzcS("low_longitude");
        FIELD_HIGH_LATITUDE = zzcS("high_latitude");
        FIELD_HIGH_LONGITUDE = zzcS("high_longitude");
        zzaom = zzcR("edge_type");
        zzaon = zzcS("x");
        zzaoo = zzcS("y");
        zzaop = zzcS("z");
        CREATOR = new zzi();
    }

    Field(int versionCode, String name, int format) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzv(name);
        this.zzaoq = format;
    }

    private Field(String name, int format) {
        this(RESISTANCE_TYPE_BARBELL, name, format);
    }

    private boolean zza(Field field) {
        return this.mName.equals(field.mName) && this.zzaoq == field.zzaoq;
    }

    private static Field zzcR(String str) {
        return new Field(str, RESISTANCE_TYPE_BARBELL);
    }

    private static Field zzcS(String str) {
        return new Field(str, RESISTANCE_TYPE_CABLE);
    }

    private static Field zzcT(String str) {
        return new Field(str, RESISTANCE_TYPE_DUMBBELL);
    }

    private static Field zzcU(String str) {
        return new Field(str, RESISTANCE_TYPE_KETTLEBELL);
    }

    public static Field zzo(String str, int i) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2131707655:
                if (str.equals("accuracy")) {
                    obj = null;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    obj = 12;
                    break;
                }
                break;
            case -1655966961:
                if (str.equals("activity")) {
                    obj = RESISTANCE_TYPE_BARBELL;
                    break;
                }
                break;
            case -1579612127:
                if (str.equals("floor.gain")) {
                    obj = 18;
                    break;
                }
                break;
            case -1579449403:
                if (str.equals("floor.loss")) {
                    obj = 19;
                    break;
                }
                break;
            case -1569430471:
                if (str.equals("num_segments")) {
                    obj = 32;
                    break;
                }
                break;
            case -1531570079:
                if (str.equals("elevation.change")) {
                    obj = 14;
                    break;
                }
                break;
            case -1439978388:
                if (str.equals("latitude")) {
                    obj = 25;
                    break;
                }
                break;
            case -1271636505:
                if (str.equals("floors")) {
                    obj = 20;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    obj = 22;
                    break;
                }
                break;
            case -1133736764:
                if (str.equals("activity_duration")) {
                    obj = RESISTANCE_TYPE_CABLE;
                    break;
                }
                break;
            case -1110756780:
                if (str.equals("food_item")) {
                    obj = 21;
                    break;
                }
                break;
            case -921832806:
                if (str.equals("percentage")) {
                    obj = 34;
                    break;
                }
                break;
            case -791592328:
                if (str.equals("weight")) {
                    obj = 43;
                    break;
                }
                break;
            case -631448035:
                if (str.equals("average")) {
                    obj = RESISTANCE_TYPE_BODY;
                    break;
                }
                break;
            case -626344110:
                if (str.equals("high_longitude")) {
                    obj = 24;
                    break;
                }
                break;
            case -619868540:
                if (str.equals("low_longitude")) {
                    obj = 28;
                    break;
                }
                break;
            case -494782871:
                if (str.equals("high_latitude")) {
                    obj = 23;
                    break;
                }
                break;
            case -437053898:
                if (str.equals("meal_type")) {
                    obj = 30;
                    break;
                }
                break;
            case -277306353:
                if (str.equals("circumference")) {
                    obj = 9;
                    break;
                }
                break;
            case -266093204:
                if (str.equals("nutrients")) {
                    obj = 33;
                    break;
                }
                break;
            case -168965370:
                if (str.equals(NUTRIENT_CALORIES)) {
                    obj = 8;
                    break;
                }
                break;
            case -126538880:
                if (str.equals("resistance_type")) {
                    obj = 37;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    obj = 44;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    obj = 45;
                    break;
                }
                break;
            case 122:
                if (str.equals("z")) {
                    obj = 46;
                    break;
                }
                break;
            case 97759:
                if (str.equals("bpm")) {
                    obj = 7;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    obj = 29;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    obj = 31;
                    break;
                }
                break;
            case 113135:
                if (str.equals("rpm")) {
                    obj = 39;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    obj = 40;
                    break;
                }
                break;
            case 109761319:
                if (str.equals("steps")) {
                    obj = 41;
                    break;
                }
                break;
            case 112903913:
                if (str.equals("watts")) {
                    obj = 42;
                    break;
                }
                break;
            case 137365935:
                if (str.equals("longitude")) {
                    obj = 26;
                    break;
                }
                break;
            case 198162679:
                if (str.equals("low_latitude")) {
                    obj = 27;
                    break;
                }
                break;
            case 224520316:
                if (str.equals("edge_type")) {
                    obj = 13;
                    break;
                }
                break;
            case 286612066:
                if (str.equals("activity_duration.descending")) {
                    obj = RESISTANCE_TYPE_KETTLEBELL;
                    break;
                }
                break;
            case 288459765:
                if (str.equals("distance")) {
                    obj = 11;
                    break;
                }
                break;
            case 455965230:
                if (str.equals("activity_duration.ascending")) {
                    obj = RESISTANCE_TYPE_DUMBBELL;
                    break;
                }
                break;
            case 811264586:
                if (str.equals("revolutions")) {
                    obj = 38;
                    break;
                }
                break;
            case 829251210:
                if (str.equals("confidence")) {
                    obj = 10;
                    break;
                }
                break;
            case 984367650:
                if (str.equals("repetitions")) {
                    obj = 35;
                    break;
                }
                break;
            case 1857734768:
                if (str.equals("elevation.gain")) {
                    obj = 15;
                    break;
                }
                break;
            case 1857897492:
                if (str.equals("elevation.loss")) {
                    obj = 16;
                    break;
                }
                break;
            case 1863800889:
                if (str.equals("resistance")) {
                    obj = 36;
                    break;
                }
                break;
            case 2036550306:
                if (str.equals("altitude")) {
                    obj = RESISTANCE_TYPE_MACHINE;
                    break;
                }
                break;
            case 2056323544:
                if (str.equals("exercise")) {
                    obj = 17;
                    break;
                }
                break;
        }
        switch (obj) {
            case MEAL_TYPE_UNKNOWN /*0*/:
                return FIELD_ACCURACY;
            case RESISTANCE_TYPE_BARBELL /*1*/:
                return FIELD_ACTIVITY;
            case RESISTANCE_TYPE_CABLE /*2*/:
                return zzaod;
            case RESISTANCE_TYPE_DUMBBELL /*3*/:
                return zzaoe;
            case RESISTANCE_TYPE_KETTLEBELL /*4*/:
                return zzaof;
            case RESISTANCE_TYPE_MACHINE /*5*/:
                return FIELD_ALTITUDE;
            case RESISTANCE_TYPE_BODY /*6*/:
                return FIELD_AVERAGE;
            case Barcode.TEXT /*7*/:
                return FIELD_BPM;
            case Barcode.URL /*8*/:
                return FIELD_CALORIES;
            case Barcode.WIFI /*9*/:
                return FIELD_CIRCUMFERENCE;
            case Barcode.GEO /*10*/:
                return FIELD_CONFIDENCE;
            case Barcode.CALENDAR_EVENT /*11*/:
                return FIELD_DISTANCE;
            case Barcode.DRIVER_LICENSE /*12*/:
                return FIELD_DURATION;
            case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                return zzaom;
            case Place.TYPE_BUS_STATION /*14*/:
                return zzaog;
            case Place.TYPE_CAFE /*15*/:
                return zzaoh;
            case Barcode.DATA_MATRIX /*16*/:
                return zzaoi;
            case Place.TYPE_CAR_DEALER /*17*/:
                return FIELD_EXERCISE;
            case Place.TYPE_CAR_RENTAL /*18*/:
                return zzaok;
            case Place.TYPE_CAR_REPAIR /*19*/:
                return zzaol;
            case Place.TYPE_CAR_WASH /*20*/:
                return zzaoj;
            case Place.TYPE_CASINO /*21*/:
                return FIELD_FOOD_ITEM;
            case Place.TYPE_CEMETERY /*22*/:
                return FIELD_HEIGHT;
            case Place.TYPE_CHURCH /*23*/:
                return FIELD_HIGH_LATITUDE;
            case Place.TYPE_CITY_HALL /*24*/:
                return FIELD_HIGH_LONGITUDE;
            case Place.TYPE_CLOTHING_STORE /*25*/:
                return FIELD_LATITUDE;
            case Place.TYPE_CONVENIENCE_STORE /*26*/:
                return FIELD_LONGITUDE;
            case Place.TYPE_COURTHOUSE /*27*/:
                return FIELD_LOW_LATITUDE;
            case Place.TYPE_DENTIST /*28*/:
                return FIELD_LOW_LONGITUDE;
            case Place.TYPE_DEPARTMENT_STORE /*29*/:
                return FIELD_MAX;
            case Place.TYPE_DOCTOR /*30*/:
                return FIELD_MEAL_TYPE;
            case Place.TYPE_ELECTRICIAN /*31*/:
                return FIELD_MIN;
            case Barcode.EAN_13 /*32*/:
                return FIELD_NUM_SEGMENTS;
            case Place.TYPE_EMBASSY /*33*/:
                return FIELD_NUTRIENTS;
            case Place.TYPE_ESTABLISHMENT /*34*/:
                return FIELD_PERCENTAGE;
            case Place.TYPE_FINANCE /*35*/:
                return FIELD_REPETITIONS;
            case Place.TYPE_FIRE_STATION /*36*/:
                return FIELD_RESISTANCE;
            case Place.TYPE_FLORIST /*37*/:
                return FIELD_RESISTANCE_TYPE;
            case Place.TYPE_FOOD /*38*/:
                return FIELD_REVOLUTIONS;
            case Place.TYPE_FUNERAL_HOME /*39*/:
                return FIELD_RPM;
            case Place.TYPE_FURNITURE_STORE /*40*/:
                return FIELD_SPEED;
            case Place.TYPE_GAS_STATION /*41*/:
                return FIELD_STEPS;
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return FIELD_WATTS;
            case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                return FIELD_WEIGHT;
            case Place.TYPE_GYM /*44*/:
                return zzaon;
            case Place.TYPE_HAIR_CARE /*45*/:
                return zzaoo;
            case Place.TYPE_HARDWARE_STORE /*46*/:
                return zzaop;
            default:
                return new Field(str, i);
        }
    }

    public int describeContents() {
        return MEAL_TYPE_UNKNOWN;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Field) && zza((Field) that));
    }

    public int getFormat() {
        return this.zzaoq;
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

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[RESISTANCE_TYPE_CABLE];
        objArr[MEAL_TYPE_UNKNOWN] = this.mName;
        objArr[RESISTANCE_TYPE_BARBELL] = this.zzaoq == RESISTANCE_TYPE_BARBELL ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
