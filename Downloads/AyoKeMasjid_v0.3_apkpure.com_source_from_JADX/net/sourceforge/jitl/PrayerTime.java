package net.sourceforge.jitl;

public class PrayerTime {
    public static final PrayerTime ASSR;
    public static final PrayerTime FAJR;
    public static final PrayerTime IMSAAK;
    public static final PrayerTime ISHAA;
    public static final PrayerTime MAGHRIB;
    public static final PrayerTime NEXTFAJR;
    public static final PrayerTime SHUROOQ;
    public static final PrayerTime THUHR;

    private PrayerTime() {
    }

    static {
        FAJR = new PrayerTime();
        SHUROOQ = new PrayerTime();
        THUHR = new PrayerTime();
        ASSR = new PrayerTime();
        MAGHRIB = new PrayerTime();
        ISHAA = new PrayerTime();
        IMSAAK = new PrayerTime();
        NEXTFAJR = new PrayerTime();
    }
}
