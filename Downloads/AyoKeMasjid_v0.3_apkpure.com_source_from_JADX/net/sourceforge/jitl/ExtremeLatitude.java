package net.sourceforge.jitl;

public class ExtremeLatitude {
    public static final ExtremeLatitude GOOD_ALL;
    public static final ExtremeLatitude GOOD_DIF;
    public static final ExtremeLatitude GOOD_INVALID;
    public static final ExtremeLatitude HALF_ALWAYS;
    public static final ExtremeLatitude HALF_INVALID;
    public static final ExtremeLatitude LAT_ALL;
    public static final ExtremeLatitude LAT_ALWAYS;
    public static final ExtremeLatitude LAT_INVALID;
    public static final ExtremeLatitude MIN_ALWAYS;
    public static final ExtremeLatitude MIN_INVALID;
    public static final ExtremeLatitude NONE_EX;
    public static final ExtremeLatitude SEVEN_DAY_ALWAYS;
    public static final ExtremeLatitude SEVEN_DAY_INVALID;
    public static final ExtremeLatitude SEVEN_NIGHT_ALWAYS;
    public static final ExtremeLatitude SEVEN_NIGHT_INVALID;

    private ExtremeLatitude() {
    }

    static {
        NONE_EX = new ExtremeLatitude();
        LAT_ALL = new ExtremeLatitude();
        LAT_ALWAYS = new ExtremeLatitude();
        LAT_INVALID = new ExtremeLatitude();
        GOOD_ALL = new ExtremeLatitude();
        GOOD_INVALID = new ExtremeLatitude();
        SEVEN_NIGHT_ALWAYS = new ExtremeLatitude();
        SEVEN_NIGHT_INVALID = new ExtremeLatitude();
        SEVEN_DAY_ALWAYS = new ExtremeLatitude();
        SEVEN_DAY_INVALID = new ExtremeLatitude();
        HALF_ALWAYS = new ExtremeLatitude();
        HALF_INVALID = new ExtremeLatitude();
        MIN_ALWAYS = new ExtremeLatitude();
        MIN_INVALID = new ExtremeLatitude();
        GOOD_DIF = new ExtremeLatitude();
    }
}
