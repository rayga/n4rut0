package net.sourceforge.jitl.astro;

public class AstroLib {
    static final double[][] B0;
    static final double[][] B1;
    static final double[][] L0;
    static final double[][] L1;
    static final double[][] L2;
    static final double[][] L3;
    static final double[][] L4;
    static final double[][] L5;
    static final double[][] PE;
    static final double[][] R0;
    static final double[][] R1;
    static final double[][] R2;
    static final double[][] R3;
    static final double[] R4;
    static final int[][] SINCOEFF;

    static {
        L0 = new double[][]{new double[]{1.75347046E8d, 0.0d, 0.0d}, new double[]{3341656.0d, 4.6692568d, 6283.07585d}, new double[]{34894.0d, 4.6261d, 12566.1517d}, new double[]{3497.0d, 2.7441d, 5753.3849d}, new double[]{3418.0d, 2.8289d, 3.5231d}, new double[]{3136.0d, 3.6277d, 77713.7715d}, new double[]{2676.0d, 4.4181d, 7860.4194d}, new double[]{2343.0d, 6.1352d, 3930.2097d}, new double[]{1324.0d, 0.7425d, 11506.7698d}, new double[]{1273.0d, 2.0371d, 529.691d}, new double[]{1199.0d, 1.1096d, 1577.3435d}, new double[]{990.0d, 5.233d, 5884.927d}, new double[]{902.0d, 2.045d, 26.298d}, new double[]{857.0d, 3.508d, 398.149d}, new double[]{780.0d, 1.179d, 5223.694d}, new double[]{753.0d, 2.533d, 5507.553d}, new double[]{505.0d, 4.583d, 18849.228d}, new double[]{492.0d, 4.205d, 775.523d}, new double[]{357.0d, 2.92d, 0.067d}, new double[]{317.0d, 5.849d, 11790.629d}, new double[]{284.0d, 1.899d, 796.298d}, new double[]{271.0d, 0.315d, 10977.079d}, new double[]{243.0d, 0.345d, 5486.778d}, new double[]{206.0d, 4.806d, 2544.314d}, new double[]{205.0d, 1.869d, 5573.143d}, new double[]{202.0d, 2.4458d, 6069.777d}, new double[]{156.0d, 0.833d, 213.299d}, new double[]{132.0d, 3.411d, 2942.463d}, new double[]{126.0d, 1.083d, 20.775d}, new double[]{115.0d, 0.645d, 0.98d}, new double[]{103.0d, 0.636d, 4694.003d}, new double[]{102.0d, 0.976d, 15720.839d}, new double[]{102.0d, 4.267d, 7.114d}, new double[]{99.0d, 6.21d, 2146.17d}, new double[]{98.0d, 0.68d, 155.42d}, new double[]{86.0d, 5.98d, 161000.69d}, new double[]{85.0d, 1.3d, 6275.96d}, new double[]{85.0d, 3.67d, 71430.7d}, new double[]{80.0d, 1.81d, 17260.15d}, new double[]{79.0d, 3.04d, 12036.46d}, new double[]{71.0d, 1.76d, 5088.63d}, new double[]{74.0d, 3.5d, 3154.69d}, new double[]{74.0d, 4.68d, 801.82d}, new double[]{70.0d, 0.83d, 9437.76d}, new double[]{62.0d, 3.98d, 8827.39d}, new double[]{61.0d, 1.82d, 7084.9d}, new double[]{57.0d, 2.78d, 6286.6d}, new double[]{56.0d, 4.39d, 14143.5d}, new double[]{56.0d, 3.47d, 6279.55d}, new double[]{52.0d, 0.19d, 12139.55d}, new double[]{52.0d, 1.33d, 1748.02d}, new double[]{51.0d, 0.28d, 5856.48d}, new double[]{49.0d, 0.49d, 1194.45d}, new double[]{41.0d, 5.37d, 8429.24d}, new double[]{41.0d, 2.4d, 19651.05d}, new double[]{39.0d, 6.17d, 10447.39d}, new double[]{37.0d, 6.04d, 10213.29d}, new double[]{37.0d, 2.57d, 1059.38d}, new double[]{36.0d, 1.71d, 2352.87d}, new double[]{36.0d, 1.78d, 6812.77d}, new double[]{33.0d, 0.59d, 17789.85d}, new double[]{Utils.DEFAULT_ROUND_SEC, 0.44d, 83996.85d}, new double[]{Utils.DEFAULT_ROUND_SEC, 2.74d, 1349.87d}, new double[]{25.0d, 3.16d, 4690.48d}};
        L1 = new double[][]{new double[]{6.28331966747E11d, 0.0d, 0.0d}, new double[]{206059.0d, 2.678235d, 6283.07585d}, new double[]{4303.0d, 2.6351d, 12566.1517d}, new double[]{425.0d, 1.59d, 3.523d}, new double[]{119.0d, 5.796d, 26.298d}, new double[]{109.0d, 2.966d, 1577.344d}, new double[]{93.0d, 2.59d, 18849.23d}, new double[]{72.0d, 1.14d, 529.69d}, new double[]{68.0d, 1.87d, 398.15d}, new double[]{67.0d, 4.41d, 5507.55d}, new double[]{59.0d, 2.89d, 5223.69d}, new double[]{56.0d, 2.17d, 155.42d}, new double[]{45.0d, 0.4d, 796.3d}, new double[]{36.0d, 0.47d, 775.52d}, new double[]{29.0d, 2.65d, 7.11d}, new double[]{21.0d, 5.34d, 0.98d}, new double[]{19.0d, 1.85d, 5486.78d}, new double[]{19.0d, 4.97d, 213.3d}, new double[]{17.0d, 2.99d, 6275.96d}, new double[]{16.0d, 0.03d, 2544.31d}, new double[]{16.0d, 1.43d, 2146.17d}, new double[]{15.0d, 1.21d, 10977.08d}, new double[]{12.0d, 2.83d, 1748.02d}, new double[]{12.0d, 3.26d, 5088.63d}, new double[]{12.0d, 5.27d, 1194.45d}, new double[]{12.0d, 2.08d, 4694.0d}, new double[]{11.0d, 0.77d, 553.57d}, new double[]{Utils.DEF_IMSAAK_INTERVAL, 1.3d, 3286.6d}, new double[]{Utils.DEF_IMSAAK_INTERVAL, 4.24d, 1349.87d}, new double[]{9.0d, 2.7d, 242.73d}, new double[]{9.0d, 5.64d, 951.72d}, new double[]{8.0d, 5.3d, 2352.87d}, new double[]{6.0d, 2.65d, 9437.76d}, new double[]{6.0d, 4.67d, 4690.48d}};
        L2 = new double[][]{new double[]{52919.0d, 0.0d, 0.0d}, new double[]{8720.0d, 1.0721d, 6283.0758d}, new double[]{309.0d, 0.867d, 12566.152d}, new double[]{27.0d, 0.05d, 3.52d}, new double[]{16.0d, 5.19d, 26.3d}, new double[]{16.0d, 3.68d, 155.42d}, new double[]{Utils.DEF_IMSAAK_INTERVAL, 0.76d, 18849.23d}, new double[]{9.0d, 2.06d, 77713.77d}, new double[]{7.0d, 0.83d, 775.52d}, new double[]{5.0d, 4.66d, 1577.34d}, new double[]{4.0d, 1.03d, 7.11d}, new double[]{4.0d, 3.44d, 5573.14d}, new double[]{3.0d, 5.14d, 796.3d}, new double[]{3.0d, 6.05d, 5507.55d}, new double[]{3.0d, 1.19d, 242.73d}, new double[]{3.0d, 6.12d, 529.69d}, new double[]{3.0d, 0.31d, 398.15d}, new double[]{3.0d, 2.28d, 553.57d}, new double[]{2.0d, 4.38d, 5223.69d}, new double[]{2.0d, 3.75d, 0.98d}};
        L3 = new double[][]{new double[]{289.0d, 5.844d, 6283.076d}, new double[]{35.0d, 0.0d, 0.0d}, new double[]{17.0d, 5.49d, 12566.15d}, new double[]{3.0d, 5.2d, 155.42d}, new double[]{Utils.AGGRESSIVE_ROUND_SEC, 4.72d, 3.52d}, new double[]{Utils.AGGRESSIVE_ROUND_SEC, 5.3d, 18849.23d}, new double[]{Utils.AGGRESSIVE_ROUND_SEC, 5.97d, 242.73d}};
        L4 = new double[][]{new double[]{114.0d, 3.142d, 0.0d}, new double[]{8.0d, 4.13d, 6283.08d}, new double[]{Utils.AGGRESSIVE_ROUND_SEC, 3.84d, 12566.15d}};
        L5 = new double[][]{new double[]{Utils.AGGRESSIVE_ROUND_SEC, 3.14d, 0.0d}};
        B0 = new double[][]{new double[]{280.0d, 3.199d, 84334.662d}, new double[]{102.0d, 5.422d, 5507.553d}, new double[]{80.0d, 3.88d, 5223.69d}, new double[]{44.0d, 3.7d, 2352.87d}, new double[]{32.0d, 4.0d, 1577.34d}};
        B1 = new double[][]{new double[]{9.0d, 3.9d, 5507.55d}, new double[]{6.0d, 1.73d, 5223.69d}};
        R0 = new double[][]{new double[]{1.00013989E8d, 0.0d, 0.0d}, new double[]{1670700.0d, 3.0984635d, 6283.07585d}, new double[]{13956.0d, 3.05525d, 12566.1517d}, new double[]{3084.0d, 5.1985d, 77713.7715d}, new double[]{1628.0d, 1.1739d, 5753.3849d}, new double[]{1576.0d, 2.8469d, 7860.4194d}, new double[]{925.0d, 5.453d, 11506.77d}, new double[]{542.0d, 4.564d, 3930.21d}, new double[]{472.0d, 3.661d, 5884.927d}, new double[]{346.0d, 0.964d, 5507.553d}, new double[]{329.0d, 5.9d, 5223.694d}, new double[]{307.0d, 0.299d, 5573.143d}, new double[]{243.0d, 4.273d, 11790.629d}, new double[]{212.0d, 5.847d, 1577.344d}, new double[]{186.0d, 5.022d, 10977.079d}, new double[]{175.0d, 3.012d, 18849.228d}, new double[]{110.0d, 5.055d, 5486.778d}, new double[]{98.0d, 0.89d, 6069.78d}, new double[]{86.0d, 5.69d, 15720.84d}, new double[]{86.0d, 1.27d, 161000.69d}, new double[]{85.0d, 0.27d, 17260.15d}, new double[]{63.0d, 0.92d, 529.69d}, new double[]{57.0d, 2.01d, 83996.85d}, new double[]{56.0d, 5.24d, 71430.7d}, new double[]{49.0d, 3.25d, 2544.31d}, new double[]{47.0d, 2.58d, 775.52d}, new double[]{45.0d, 5.54d, 9437.76d}, new double[]{43.0d, 6.01d, 6275.96d}, new double[]{39.0d, 5.36d, 4694.0d}, new double[]{38.0d, 2.39d, 8827.39d}, new double[]{37.0d, 0.83d, 19651.05d}, new double[]{37.0d, 4.9d, 12139.55d}, new double[]{36.0d, 1.67d, 12036.46d}, new double[]{35.0d, 1.84d, 2942.46d}, new double[]{33.0d, 0.24d, 7084.9d}, new double[]{32.0d, 0.18d, 5088.63d}, new double[]{32.0d, 1.78d, 398.15d}, new double[]{28.0d, 1.21d, 6286.6d}, new double[]{28.0d, 1.9d, 6279.55d}, new double[]{26.0d, 4.59d, 10447.39d}};
        R1 = new double[][]{new double[]{103019.0d, 1.10749d, 6283.07585d}, new double[]{1721.0d, 1.0644d, 12566.1517d}, new double[]{702.0d, 3.142d, 0.0d}, new double[]{32.0d, 1.02d, 18849.23d}, new double[]{31.0d, 2.84d, 5507.55d}, new double[]{25.0d, 1.32d, 5223.69d}, new double[]{18.0d, 1.42d, 1577.34d}, new double[]{Utils.DEF_IMSAAK_INTERVAL, 5.91d, 10977.08d}, new double[]{9.0d, 1.42d, 6275.96d}, new double[]{9.0d, 0.27d, 5486.78d}};
        R2 = new double[][]{new double[]{4359.0d, 5.7846d, 6283.0758d}, new double[]{124.0d, 5.579d, 12566.152d}, new double[]{12.0d, 3.14d, 0.0d}, new double[]{9.0d, 3.63d, 77713.77d}, new double[]{6.0d, 1.87d, 5573.14d}, new double[]{3.0d, 5.47d, 18849.0d}};
        R3 = new double[][]{new double[]{145.0d, 4.273d, 6283.076d}, new double[]{7.0d, 3.92d, 12566.15d}};
        R4 = new double[]{4.0d, 2.56d, 6283.08d};
        PE = new double[][]{new double[]{-171996.0d, -174.2d, 92025.0d, 8.9d}, new double[]{-13187.0d, -1.6d, 5736.0d, -3.1d}, new double[]{-2274.0d, -0.2d, 977.0d, -0.5d}, new double[]{2062.0d, 0.2d, -895.0d, 0.5d}, new double[]{1426.0d, -3.4d, 54.0d, -0.1d}, new double[]{712.0d, 0.1d, -7.0d, 0.0d}, new double[]{-517.0d, 1.2d, 224.0d, -0.6d}, new double[]{-386.0d, -0.4d, 200.0d, 0.0d}, new double[]{-301.0d, 0.0d, 129.0d, -0.1d}, new double[]{217.0d, -0.5d, -95.0d, 0.3d}, new double[]{-158.0d, 0.0d, 0.0d, 0.0d}, new double[]{129.0d, 0.1d, -70.0d, 0.0d}, new double[]{123.0d, 0.0d, -53.0d, 0.0d}, new double[]{63.0d, 0.0d, 0.0d, 0.0d}, new double[]{63.0d, 0.1d, -33.0d, 0.0d}, new double[]{-59.0d, 0.0d, 26.0d, 0.0d}, new double[]{-58.0d, -0.1d, 32.0d, 0.0d}, new double[]{-51.0d, 0.0d, 27.0d, 0.0d}, new double[]{48.0d, 0.0d, 0.0d, 0.0d}, new double[]{46.0d, 0.0d, -24.0d, 0.0d}, new double[]{-38.0d, 0.0d, 16.0d, 0.0d}, new double[]{-31.0d, 0.0d, 13.0d, 0.0d}, new double[]{29.0d, 0.0d, 0.0d, 0.0d}, new double[]{29.0d, 0.0d, -12.0d, 0.0d}, new double[]{26.0d, 0.0d, 0.0d, 0.0d}, new double[]{-22.0d, 0.0d, 0.0d, 0.0d}, new double[]{21.0d, 0.0d, -10.0d, 0.0d}, new double[]{17.0d, -0.1d, 0.0d, 0.0d}, new double[]{16.0d, 0.0d, -8.0d, 0.0d}, new double[]{-16.0d, 0.1d, 7.0d, 0.0d}, new double[]{-15.0d, 0.0d, 9.0d, 0.0d}, new double[]{-13.0d, 0.0d, 7.0d, 0.0d}, new double[]{-12.0d, 0.0d, 6.0d, 0.0d}, new double[]{11.0d, 0.0d, 0.0d, 0.0d}, new double[]{-10.0d, 0.0d, 5.0d, 0.0d}, new double[]{-8.0d, 0.0d, 3.0d, 0.0d}, new double[]{7.0d, 0.0d, -3.0d, 0.0d}, new double[]{-7.0d, 0.0d, 0.0d, 0.0d}, new double[]{-7.0d, 0.0d, 3.0d, 0.0d}, new double[]{-7.0d, 0.0d, 3.0d, 0.0d}, new double[]{6.0d, 0.0d, 0.0d, 0.0d}, new double[]{6.0d, 0.0d, -3.0d, 0.0d}, new double[]{6.0d, 0.0d, -3.0d, 0.0d}, new double[]{-6.0d, 0.0d, 3.0d, 0.0d}, new double[]{-6.0d, 0.0d, 3.0d, 0.0d}, new double[]{5.0d, 0.0d, 0.0d, 0.0d}, new double[]{-5.0d, 0.0d, 3.0d, 0.0d}, new double[]{-5.0d, 0.0d, 3.0d, 0.0d}, new double[]{-5.0d, 0.0d, 3.0d, 0.0d}, new double[]{4.0d, 0.0d, 0.0d, 0.0d}, new double[]{4.0d, 0.0d, 0.0d, 0.0d}, new double[]{4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-4.0d, 0.0d, 0.0d, 0.0d}, new double[]{3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 0.0d, 0.0d}};
        SINCOEFF = new int[][]{new int[]{0, 0, 0, 0, 1}, new int[]{-2, 0, 0, 2, 2}, new int[]{0, 0, 0, 2, 2}, new int[]{0, 0, 0, 0, 2}, new int[]{0, 1, 0, 0, 0}, new int[]{0, 0, 1, 0, 0}, new int[]{-2, 1, 0, 2, 2}, new int[]{0, 0, 0, 2, 1}, new int[]{0, 0, 1, 2, 2}, new int[]{-2, -1, 0, 2, 2}, new int[]{-2, 0, 1, 0, 0}, new int[]{-2, 0, 0, 2, 1}, new int[]{0, 0, -1, 2, 2}, new int[]{2, 0, 0, 0, 0}, new int[]{0, 0, 1, 0, 1}, new int[]{2, 0, -1, 2, 2}, new int[]{0, 0, -1, 0, 1}, new int[]{0, 0, 1, 2, 1}, new int[]{-2, 0, 2, 0, 0}, new int[]{0, 0, -2, 2, 1}, new int[]{2, 0, 0, 2, 2}, new int[]{0, 0, 2, 2, 2}, new int[]{0, 0, 2, 0, 0}, new int[]{-2, 0, 1, 2, 2}, new int[]{0, 0, 0, 2, 0}, new int[]{-2, 0, 0, 2, 0}, new int[]{0, 0, -1, 2, 1}, new int[]{0, 2, 0, 0, 0}, new int[]{2, 0, -1, 0, 1}, new int[]{-2, 2, 0, 2, 2}, new int[]{0, 1, 0, 0, 1}, new int[]{-2, 0, 1, 0, 1}, new int[]{0, -1, 0, 0, 1}, new int[]{0, 0, 2, -2, 0}, new int[]{2, 0, -1, 2, 1}, new int[]{2, 0, 1, 2, 2}, new int[]{0, 1, 0, 2, 2}, new int[]{-2, 1, 1, 0, 0}, new int[]{0, -1, 0, 2, 2}, new int[]{2, 0, 0, 2, 1}, new int[]{2, 0, 1, 0, 0}, new int[]{-2, 0, 2, 2, 2}, new int[]{-2, 0, 1, 2, 1}, new int[]{2, 0, -2, 0, 1}, new int[]{2, 0, 0, 0, 1}, new int[]{0, -1, 1, 0, 0}, new int[]{-2, -1, 0, 2, 1}, new int[]{-2, 0, 0, 0, 1}, new int[]{0, 0, 2, 2, 1}, new int[]{-2, 0, 2, 0, 1}, new int[]{-2, 1, 0, 2, 1}, new int[]{0, 0, 1, -2, 0}, new int[]{-1, 0, 1, 0, 0}, new int[]{-2, 1, 0, 0, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{0, 0, 1, 2, 0}, new int[]{0, 0, -2, 2, 2}, new int[]{-1, -1, 1, 0, 0}, new int[]{0, 1, 1, 0, 0}, new int[]{0, -1, 1, 2, 2}, new int[]{2, -1, -1, 2, 2}, new int[]{0, 0, 3, 2, 2}, new int[]{2, -1, 0, 2, 2}};
    }

    public static double getRefraction(Location loc, double sunAlt) {
        return (((loc.getPressure() / Location.DEFAULT_PRESSURE) * (283.0d / (273.0d + loc.getTemperature()))) * (1.02d / (Utils.RAD_TO_DEG(Math.tan(Utils.DEG_TO_RAD((10.3d / (5.11d + sunAlt)) + sunAlt))) + 0.0019279d))) / 60.0d;
    }

    public static double getJulianDay(SimpleDate date, double gmt) {
        double jdB = 0.0d;
        double jdY = (double) date.getYear();
        double jdM = (double) date.getMonth();
        if (date.getMonth() <= 2) {
            jdY -= Utils.AGGRESSIVE_ROUND_SEC;
            jdM += 12.0d;
        }
        if (date.getYear() < 1) {
            jdY += Utils.AGGRESSIVE_ROUND_SEC;
        }
        if (date.getYear() > 1582 || (date.getYear() == 1582 && (date.getMonth() > 10 || (date.getMonth() == 10 && date.getDay() >= 4)))) {
            jdB = (2.0d - Math.floor(jdY / 100.0d)) + Math.floor((jdY / 100.0d) / 4.0d);
        }
        return (((Math.floor(365.25d * (4716.0d + jdY)) + Math.floor(30.6001d * (Utils.AGGRESSIVE_ROUND_SEC + jdM))) + (((double) date.day) + ((-gmt) / 24.0d))) + jdB) - 1524.5d;
    }

    public static void getAstroValuesByDay(double julianDay, Location loc, Astro astro, Astro topAstro) {
        AstroDay ad = new AstroDay();
        if (astro.getJd() == julianDay - Utils.AGGRESSIVE_ROUND_SEC) {
            astro.getRa()[0] = astro.getRa()[1];
            astro.getRa()[1] = astro.getRa()[2];
            astro.getDec()[0] = astro.getDec()[1];
            astro.getDec()[1] = astro.getDec()[2];
            astro.getSid()[0] = astro.getSid()[1];
            astro.getSid()[1] = astro.getSid()[2];
            astro.getDra()[0] = astro.getDra()[1];
            astro.getDra()[1] = astro.getDra()[2];
            astro.getRsum()[0] = astro.getRsum()[1];
            astro.getRsum()[1] = astro.getRsum()[2];
            computeAstroDay(Utils.AGGRESSIVE_ROUND_SEC + julianDay, ad);
            astro.getRa()[2] = ad.getRa();
            astro.getDec()[2] = ad.getDec();
            astro.getSid()[2] = ad.getSidtime();
            astro.getDra()[2] = ad.getDra();
            astro.getRsum()[2] = ad.getRsum();
        } else if (astro.getJd() == Utils.AGGRESSIVE_ROUND_SEC + julianDay) {
            astro.getRa()[2] = astro.getRa()[1];
            astro.getRa()[1] = astro.getRa()[0];
            astro.getDec()[2] = astro.getDec()[1];
            astro.getDec()[1] = astro.getDec()[0];
            astro.getSid()[2] = astro.getSid()[1];
            astro.getSid()[1] = astro.getSid()[0];
            astro.getDra()[2] = astro.getDra()[1];
            astro.getDra()[1] = astro.getDra()[0];
            astro.getRsum()[2] = astro.getRsum()[1];
            astro.getRsum()[1] = astro.getRsum()[0];
            computeAstroDay(julianDay - Utils.AGGRESSIVE_ROUND_SEC, ad);
            astro.getRa()[0] = ad.getRa();
            astro.getDec()[0] = ad.getDec();
            astro.getSid()[0] = ad.getSidtime();
            astro.getDra()[0] = ad.getDra();
            astro.getRsum()[0] = ad.getRsum();
        } else if (astro.getJd() != julianDay) {
            computeAstroDay(julianDay - Utils.AGGRESSIVE_ROUND_SEC, ad);
            astro.getRa()[0] = ad.getRa();
            astro.getDec()[0] = ad.getDec();
            astro.getSid()[0] = ad.getSidtime();
            astro.getDra()[0] = ad.getDra();
            astro.getRsum()[0] = ad.getRsum();
            computeAstroDay(julianDay, ad);
            astro.getRa()[1] = ad.getRa();
            astro.getDec()[1] = ad.getDec();
            astro.getSid()[1] = ad.getSidtime();
            astro.getDra()[1] = ad.getDra();
            astro.getRsum()[1] = ad.getRsum();
            computeAstroDay(Utils.AGGRESSIVE_ROUND_SEC + julianDay, ad);
            astro.getRa()[2] = ad.getRa();
            astro.getDec()[2] = ad.getDec();
            astro.getSid()[2] = ad.getSidtime();
            astro.getDra()[2] = ad.getDra();
            astro.getRsum()[2] = ad.getRsum();
        }
        astro.setJd(julianDay);
        computeTopAstro(loc, astro, topAstro);
    }

    public static void computeAstroDay(double JD, AstroDay astroday) {
        int i;
        double B0sum = 0.0d;
        double B1sum = 0.0d;
        double R0sum = 0.0d;
        double R1sum = 0.0d;
        double R2sum = 0.0d;
        double R3sum = 0.0d;
        double L0sum = 0.0d;
        double L1sum = 0.0d;
        double L2sum = 0.0d;
        double L3sum = 0.0d;
        double L4sum = 0.0d;
        double xsum = 0.0d;
        double psi = 0.0d;
        double epsilon = 0.0d;
        double JC = (JD - 2451545.0d) / 36525.0d;
        double JM = JC / Utils.DEF_IMSAAK_INTERVAL;
        double JM2 = Math.pow(JM, 2.0d);
        double JM3 = Math.pow(JM, 3.0d);
        double JM4 = Math.pow(JM, 4.0d);
        double JM5 = Math.pow(JM, 5.0d);
        for (i = 0; i < 64; i++) {
            L0sum += L0[i][0] * Math.cos(L0[i][1] + (L0[i][2] * JM));
        }
        for (i = 0; i < 34; i++) {
            L1sum += L1[i][0] * Math.cos(L1[i][1] + (L1[i][2] * JM));
        }
        for (i = 0; i < 20; i++) {
            L2sum += L2[i][0] * Math.cos(L2[i][1] + (L2[i][2] * JM));
        }
        for (i = 0; i < 7; i++) {
            L3sum += L3[i][0] * Math.cos(L3[i][1] + (L3[i][2] * JM));
        }
        for (i = 0; i < 3; i++) {
            L4sum += L4[i][0] * Math.cos(L4[i][1] + (L4[i][2] * JM));
        }
        double L = limitAngle(Utils.RAD_TO_DEG(((((((L1sum * JM) + L0sum) + (L2sum * JM2)) + (L3sum * JM3)) + (L4sum * JM4)) + ((L5[0][0] * Math.cos(L5[0][1] + (L5[0][2] * JM))) * JM5)) / Math.pow(Utils.DEF_IMSAAK_INTERVAL, 8.0d)));
        for (i = 0; i < 5; i++) {
            B0sum += B0[i][0] * Math.cos(B0[i][1] + (B0[i][2] * JM));
        }
        for (i = 0; i < 2; i++) {
            B1sum += B1[i][0] * Math.cos(B1[i][1] + (B1[i][2] * JM));
        }
        double B = Utils.RAD_TO_DEG(((B1sum * JM) + B0sum) / Math.pow(Utils.DEF_IMSAAK_INTERVAL, 8.0d));
        for (i = 0; i < 40; i++) {
            R0sum += R0[i][0] * Math.cos(R0[i][1] + (R0[i][2] * JM));
        }
        for (i = 0; i < 10; i++) {
            R1sum += R1[i][0] * Math.cos(R1[i][1] + (R1[i][2] * JM));
        }
        for (i = 0; i < 6; i++) {
            R2sum += R2[i][0] * Math.cos(R2[i][1] + (R2[i][2] * JM));
        }
        for (i = 0; i < 2; i++) {
            R3sum += R3[i][0] * Math.cos(R3[i][1] + (R3[i][2] * JM));
        }
        double R = (((((R1sum * JM) + R0sum) + (R2sum * JM2)) + (R3sum * JM3)) + ((R4[0] * Math.cos(R4[1] + (R4[2] * JM))) * JM4)) / Math.pow(Utils.DEF_IMSAAK_INTERVAL, 8.0d);
        double G = limitAngle(180.0d + L);
        double Gg = -B;
        double X0 = ((297.85036d + (445267.11148d * JC)) - (0.0019142d * Math.pow(JC, 2.0d))) + (Math.pow(JC, 3.0d) / 189474.0d);
        double X1 = ((357.52772d + (35999.05034d * JC)) - (1.603E-4d * Math.pow(JC, 2.0d))) - (Math.pow(JC, 3.0d) / 300000.0d);
        double X2 = ((134.96298d + (477198.867398d * JC)) + (0.0086972d * Math.pow(JC, 2.0d))) + (Math.pow(JC, 3.0d) / 56250.0d);
        double X3 = ((93.27191d + (483202.017538d * JC)) - (0.0036825d * Math.pow(JC, 2.0d))) + (Math.pow(JC, 3.0d) / 327270.0d);
        double X4 = ((125.04452d - (1934.136261d * JC)) + (0.0020708d * Math.pow(JC, 2.0d))) + (Math.pow(JC, 3.0d) / 450000.0d);
        for (i = 0; i < 63; i++) {
            xsum = ((((xsum + (((double) SINCOEFF[i][0]) * X0)) + (((double) SINCOEFF[i][1]) * X1)) + (((double) SINCOEFF[i][2]) * X2)) + (((double) SINCOEFF[i][3]) * X3)) + (((double) SINCOEFF[i][4]) * X4);
            psi += (PE[i][0] + (PE[i][1] * JC)) * Math.sin(Utils.DEG_TO_RAD(xsum));
            epsilon += (PE[i][2] + (PE[i][3] * JC)) * Math.cos(Utils.DEG_TO_RAD(xsum));
            xsum = 0.0d;
        }
        double deltaPsi = psi / 3.6E7d;
        double U = JM / Utils.DEF_IMSAAK_INTERVAL;
        double E = (((((((((((84381.448d - (4680.93d * U)) - (1.55d * Math.pow(U, 2.0d))) + (1999.25d * Math.pow(U, 3.0d))) - (51.38d * Math.pow(U, 4.0d))) - (249.67d * Math.pow(U, 5.0d))) - (39.05d * Math.pow(U, 6.0d))) + (7.12d * Math.pow(U, 7.0d))) + (27.87d * Math.pow(U, 8.0d))) + (5.79d * Math.pow(U, 9.0d))) + (2.45d * Math.pow(U, Utils.DEF_IMSAAK_INTERVAL))) / 3600.0d) + (epsilon / 3.6E7d);
        double lamda = (G + deltaPsi) + (-20.4898d / (3600.0d * R));
        double V = limitAngle(((280.46061837d + (360.98564736629d * (JD - 2451545.0d))) + (3.87933E-4d * Math.pow(JC, 2.0d))) - (Math.pow(JC, 3.0d) / 3.871E7d)) + (Math.cos(Utils.DEG_TO_RAD(E)) * deltaPsi);
        double RA = limitAngle(Utils.RAD_TO_DEG(Math.atan2((Math.sin(Utils.DEG_TO_RAD(lamda)) * Math.cos(Utils.DEG_TO_RAD(E))) - (Math.tan(Utils.DEG_TO_RAD(Gg)) * Math.sin(Utils.DEG_TO_RAD(E))), Math.cos(Utils.DEG_TO_RAD(lamda)))));
        double DEC = Math.asin((Math.sin(Utils.DEG_TO_RAD(Gg)) * Math.cos(Utils.DEG_TO_RAD(E))) + ((Math.cos(Utils.DEG_TO_RAD(Gg)) * Math.sin(Utils.DEG_TO_RAD(E))) * Math.sin(Utils.DEG_TO_RAD(lamda))));
        astroday.setRa(RA);
        astroday.setDec(DEC);
        astroday.setSidtime(V);
        astroday.setDra(0.0d);
        astroday.setRsum(R);
    }

    public static void computeTopAstro(Location loc, Astro astro, Astro topAstro) {
        for (int i = 0; i < 3; i++) {
            double lHour = limitAngle((astro.getSid()[i] + loc.getDegreeLong()) - astro.getRa()[i]);
            double SP = 8.794d / (3600.0d * astro.getRsum()[i]);
            double tU = Math.atan(0.99664719d * Math.tan(Utils.DEG_TO_RAD(loc.getDegreeLat())));
            double tCos = Math.cos(tU) + ((loc.getSeaLevel() / 6378140.0d) * Math.cos(Utils.DEG_TO_RAD(loc.getDegreeLat())));
            double tRA0 = (((-tCos) * Math.sin(Utils.DEG_TO_RAD(SP))) * Math.sin(Utils.DEG_TO_RAD(lHour))) / (Math.cos(astro.getDec()[i]) - ((Math.sin(Utils.DEG_TO_RAD(SP)) * tCos) * Math.cos(Utils.DEG_TO_RAD(lHour))));
            double tRA = astro.getRa()[i] + Utils.RAD_TO_DEG(tRA0);
            double tDEC = Utils.RAD_TO_DEG(Math.atan2((Math.sin(astro.getDec()[i]) - (Math.sin(Utils.DEG_TO_RAD(SP)) * ((0.99664719d * Math.sin(tU)) + ((loc.getSeaLevel() / 6378140.0d) * Math.sin(Utils.DEG_TO_RAD(loc.getDegreeLat())))))) * Math.cos(tRA0), Math.cos(astro.getDec()[i]) - ((Math.sin(Utils.DEG_TO_RAD(SP)) * tCos) * Math.cos(Utils.DEG_TO_RAD(lHour)))));
            topAstro.getRa()[i] = tRA;
            topAstro.getDec()[i] = tDEC;
            topAstro.getSid()[i] = astro.getSid()[i];
            topAstro.getDra()[i] = tRA0;
            topAstro.getRsum()[i] = astro.getRsum()[i];
        }
    }

    public static double limitAngle(double L) {
        L /= 360.0d;
        double F = L - Math.floor(L);
        if (F > 0.0d) {
            return 360.0d * F;
        }
        if (F < 0.0d) {
            return 360.0d - (360.0d * F);
        }
        return L;
    }

    public static double limitAngle180(double L) {
        L /= 180.0d;
        double F = L - Math.floor(L);
        if (F > 0.0d) {
            return 180.0d * F;
        }
        if (F < 0.0d) {
            return 180.0d - (180.0d * F);
        }
        return L;
    }

    public static double limitAngle111(double L) {
        double F = L - Math.floor(L);
        if (F < 0.0d) {
            return F + Utils.AGGRESSIVE_ROUND_SEC;
        }
        return F;
    }

    public static double limitAngle180between(double L) {
        L /= 360.0d;
        double F = (L - Math.floor(L)) * 360.0d;
        if (F < -180.0d) {
            return F + 360.0d;
        }
        if (F > 180.0d) {
            return F - 360.0d;
        }
        return F;
    }
}
