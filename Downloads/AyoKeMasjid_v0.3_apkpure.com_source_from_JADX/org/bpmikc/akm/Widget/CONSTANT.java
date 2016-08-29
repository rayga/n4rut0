package org.bpmikc.akm.Widget;

import net.sourceforge.jitl.Method;
import net.sourceforge.jitl.Rounding;
import org.bpmikc.akm.C0615R;

public class CONSTANT {
    public static final int ASR = 3;
    public static final Method[] CALCULATION_METHODS;
    public static final String[][] CALCULATION_METHOD_COUNTRY_CODES;
    public static final short DEFAULT_CALCULATION_METHOD = (short) 5;
    public static final short DEFAULT_ROUNDING_INDEX = (short) 2;
    public static final int DHUHR = 2;
    public static final String EXTRA_ACTUAL_TIME = "uz.efir.muazzin.EXTRA_ACTUAL_TIME";
    public static final String EXTRA_TIME_INDEX = "uz.efir.muazzin.EXTRA_TIME_INDEX";
    public static final int FAJR = 0;
    public static final int ISHAA = 5;
    public static final int MAGHRIB = 4;
    public static final int NEXT_FAJR = 6;
    public static final short NOTIFICATION_CUSTOM = (short) 3;
    public static final short NOTIFICATION_DEFAULT = (short) 1;
    public static final short NOTIFICATION_NONE = (short) 0;
    public static final short NOTIFICATION_PLAY = (short) 2;
    public static final Rounding[] ROUNDING_METHODS;
    public static final int SUNRISE = 1;
    public static int[] TIME_NAMES;

    static {
        r0 = new String[7][];
        r0[FAJR] = new String[]{"AGO", "BDI", "BEN", "BFA", "BWA", "CAF", "CIV", "CMR", "COG", "COM", "CPV", "DJI", "DZA", "EGY", "ERI", "ESH", "ETH", "GAB", "GHA", "GIN", "GMB", "GNB", "GNQ", "KEN", "LBR", "LBY", "LSO", "MAR", "MDG", "MLI", "MOZ", "MRT", "MUS", "MWI", "MYT", "NAM", "NER", "NGA", "REU", "RWA", "SDN", "SEN", "SLE", "SOM", "STP", "SWZ", "SYC", "TCD", "TGO", "TUN", "TZA", "UGA", "ZAF", "ZAR", "ZWB", "ZWE", "IRQ", "LBN", "MYS", "SYR"};
        r0[SUNRISE] = new String[FAJR];
        String[] strArr = new String[MAGHRIB];
        strArr[FAJR] = "AFG";
        strArr[SUNRISE] = "BGD";
        strArr[DHUHR] = "IND";
        strArr[ASR] = "PAK";
        r0[DHUHR] = strArr;
        strArr = new String[DHUHR];
        strArr[FAJR] = "USA";
        strArr[SUNRISE] = "CAN";
        r0[ASR] = strArr;
        r0[MAGHRIB] = new String[]{"AND", "AUT", "BEL", "DNK", "FIN", "FRA", "DEU", "GIB", "IRL", "ITA", "LIE", "LUX", "MCO", "NLD", "NOR", "PRT", "SMR", "ESP", "SWE", "CHE", "GBR", "VAT", "CHN", "JPN", "KOR", "PRK", "TWN"};
        String[] strArr2 = new String[NEXT_FAJR];
        strArr2[FAJR] = "BHR";
        strArr2[SUNRISE] = "KWT";
        strArr2[DHUHR] = "OMN";
        strArr2[ASR] = "QAT";
        strArr2[MAGHRIB] = "SAU";
        strArr2[ISHAA] = "YEM";
        r0[ISHAA] = strArr2;
        r0[NEXT_FAJR] = new String[FAJR];
        CALCULATION_METHOD_COUNTRY_CODES = r0;
        CALCULATION_METHODS = new Method[]{Method.EGYPT_SURVEY, Method.KARACHI_SHAF, Method.KARACHI_HANAF, Method.NORTH_AMERICA, Method.MUSLIM_LEAGUE, Method.UMM_ALQURRA, Method.FIXED_ISHAA};
        TIME_NAMES = new int[]{C0615R.string.fajr, C0615R.string.sunrise, C0615R.string.dhuhr, C0615R.string.asr, C0615R.string.maghrib, C0615R.string.ishaa, C0615R.string.next_fajr};
        Rounding[] roundingArr = new Rounding[MAGHRIB];
        roundingArr[FAJR] = Rounding.NONE;
        roundingArr[SUNRISE] = Rounding.NORMAL;
        roundingArr[DHUHR] = Rounding.SPECIAL;
        roundingArr[ASR] = Rounding.AGRESSIVE;
        ROUNDING_METHODS = roundingArr;
    }

    private CONSTANT() {
    }
}
