package net.sourceforge.jitl.astro;

public class Utils {
    public static final double AGGRESSIVE_ROUND_SEC = 1.0d;
    public static final double ALTITUDE_REFRACTION = 0.0347d;
    public static final double CENTER_OF_SUN_ANGLE = -0.83337d;
    public static final double DEFAULT_ROUND_SEC = 30.0d;
    public static final double DEF_IMSAAK_ANGLE = 1.5d;
    public static final double DEF_IMSAAK_INTERVAL = 10.0d;
    public static final double DEF_NEAREST_LATITUDE = 48.5d;
    public static final double DEG_TO_10_BASE = 0.06666666666666667d;
    public static final double INVALID_TRIGGER = -0.999d;
    public static final double KAABA_LAT = 21.423333d;
    public static final double KAABA_LONG = 39.823333d;
    public static final double PI = 3.1415926535898d;
    public static final double REF_LIMIT = 9999999.0d;

    public static double DEG_TO_RAD(double A) {
        return 0.017453292519943334d * A;
    }

    public static double RAD_TO_DEG(double A) {
        return A / 0.017453292519943334d;
    }
}
