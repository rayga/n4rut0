package net.sourceforge.jitl;

import net.sourceforge.jitl.astro.Utils;

public class Method {
    public static final Method EGYPT_SURVEY;
    public static final Method FIXED_ISHAA;
    public static final Method KARACHI_HANAF;
    public static final Method KARACHI_SHAF;
    public static final Method MUSLIM_LEAGUE;
    public static final Method NONE;
    public static final Method NORTH_AMERICA;
    public static final Method UMM_ALQURRA;
    private double assrOffset;
    private ExtremeLatitude extremeLatitude;
    private double fajrAng;
    private int fajrInv;
    private double fajrOffset;
    private double imsaakAng;
    private int imsaakInv;
    private double ishaaAng;
    private int ishaaInv;
    private double ishaaOffset;
    private double maghribOffset;
    private Mathhab mathhab;
    private double nearestLat;
    private boolean offset;
    private Rounding round;
    private double shurooqOffset;
    private double thuhrOffset;

    public Method(Method orig) {
        this.fajrAng = orig.getFajrAng();
        this.ishaaAng = orig.getIshaaAng();
        this.imsaakAng = orig.getImsaakAng();
        this.fajrInv = orig.getFajrInv();
        this.ishaaInv = orig.getIshaaInv();
        this.imsaakInv = orig.getImsaakInv();
        this.round = orig.getRound();
        this.mathhab = orig.getMathhab();
        this.nearestLat = orig.getNearestLat();
        this.extremeLatitude = orig.getExtremeLatitude();
        this.offset = orig.getOffset();
        this.fajrOffset = orig.getFajrOffset();
        this.shurooqOffset = orig.getShurooqOffset();
        this.thuhrOffset = orig.getThuhrOffset();
        this.assrOffset = orig.getAssrOffset();
        this.maghribOffset = orig.getMaghribOffset();
        this.ishaaOffset = orig.getIshaaOffset();
    }

    public Method(double fajrAng, double ishaaAng, double imsaakAng, int fajrInv, int ishaaInv, int imsaakInv, Rounding round, Mathhab mathhab, double nearestLat, ExtremeLatitude extreme, boolean offset, double fajrOffset, double shurooqOffset, double thuhrOffset, double assrOffset, double maghribOffset, double ishaaOffset) {
        this.fajrAng = fajrAng;
        this.ishaaAng = ishaaAng;
        this.imsaakAng = imsaakAng;
        this.fajrInv = fajrInv;
        this.ishaaInv = ishaaInv;
        this.imsaakInv = imsaakInv;
        this.round = round;
        this.mathhab = mathhab;
        this.nearestLat = nearestLat;
        this.extremeLatitude = extreme;
        this.offset = offset;
        this.fajrOffset = fajrOffset;
        this.shurooqOffset = shurooqOffset;
        this.thuhrOffset = thuhrOffset;
        this.assrOffset = assrOffset;
        this.maghribOffset = maghribOffset;
        this.ishaaOffset = ishaaOffset;
    }

    public Method copy() {
        return new Method(this.fajrAng, this.ishaaAng, this.imsaakAng, this.fajrInv, this.ishaaInv, this.imsaakInv, this.round, this.mathhab, this.nearestLat, this.extremeLatitude, this.offset, this.fajrOffset, this.shurooqOffset, this.thuhrOffset, this.assrOffset, this.maghribOffset, this.ishaaOffset);
    }

    public ExtremeLatitude getExtremeLatitude() {
        return this.extremeLatitude;
    }

    public void setExtremeLatitude(ExtremeLatitude extreme) {
        this.extremeLatitude = extreme;
    }

    public double getFajrAng() {
        return this.fajrAng;
    }

    public void setFajrAng(double fajrAng) {
        this.fajrAng = fajrAng;
    }

    public int getFajrInv() {
        return this.fajrInv;
    }

    public void setFajrInv(int fajrInv) {
        this.fajrInv = fajrInv;
    }

    public double getImsaakAng() {
        return this.imsaakAng;
    }

    public void setImsaakAng(double imsaakAng) {
        this.imsaakAng = imsaakAng;
    }

    public int getImsaakInv() {
        return this.imsaakInv;
    }

    public void setImsaakInv(int imsaakInv) {
        this.imsaakInv = imsaakInv;
    }

    public double getIshaaAng() {
        return this.ishaaAng;
    }

    public void setIshaaAng(double ishaaAng) {
        this.ishaaAng = ishaaAng;
    }

    public int getIshaaInv() {
        return this.ishaaInv;
    }

    public void setIshaaInv(int ishaaInv) {
        this.ishaaInv = ishaaInv;
    }

    public Mathhab getMathhab() {
        return this.mathhab;
    }

    public void setMathhab(Mathhab mathhab) {
        this.mathhab = mathhab;
    }

    public double getNearestLat() {
        return this.nearestLat;
    }

    public void setNearestLat(double nearestLat) {
        this.nearestLat = nearestLat;
    }

    public boolean getOffset() {
        return this.offset;
    }

    public void setOffset(boolean offset) {
        this.offset = offset;
    }

    public Rounding getRound() {
        return this.round;
    }

    public void setRound(Rounding round) {
        this.round = round;
    }

    static {
        NONE = new Method(0.0d, 0.0d, Utils.DEF_IMSAAK_ANGLE, 0, 0, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        EGYPT_SURVEY = new Method(20.0d, 18.0d, Utils.DEF_IMSAAK_ANGLE, 0, 0, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        KARACHI_SHAF = new Method(18.0d, 18.0d, Utils.DEF_IMSAAK_ANGLE, 0, 0, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        KARACHI_HANAF = new Method(18.0d, 18.0d, Utils.DEF_IMSAAK_ANGLE, 0, 0, 0, Rounding.SPECIAL, Mathhab.HANAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        NORTH_AMERICA = new Method(15.0d, 15.0d, Utils.DEF_IMSAAK_ANGLE, 0, 0, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        MUSLIM_LEAGUE = new Method(18.0d, 17.0d, Utils.DEF_IMSAAK_ANGLE, 0, 0, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        UMM_ALQURRA = new Method(19.0d, 0.0d, Utils.DEF_IMSAAK_ANGLE, 0, 90, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        FIXED_ISHAA = new Method(19.5d, 0.0d, Utils.DEF_IMSAAK_ANGLE, 0, 90, 0, Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, false, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public double getAssrOffset() {
        return this.assrOffset;
    }

    public void setAssrOffset(double assrOffset) {
        this.assrOffset = assrOffset;
    }

    public double getFajrOffset() {
        return this.fajrOffset;
    }

    public void setFajrOffset(double fajrOffset) {
        this.fajrOffset = fajrOffset;
    }

    public double getIshaaOffset() {
        return this.ishaaOffset;
    }

    public void setIshaaOffset(double ishaaOffset) {
        this.ishaaOffset = ishaaOffset;
    }

    public double getMaghribOffset() {
        return this.maghribOffset;
    }

    public void setMaghribOffset(double maghribOffset) {
        this.maghribOffset = maghribOffset;
    }

    public double getShurooqOffset() {
        return this.shurooqOffset;
    }

    public void setShurooqOffset(double shurooqOffset) {
        this.shurooqOffset = shurooqOffset;
    }

    public double getThuhrOffset() {
        return this.thuhrOffset;
    }

    public void setThuhrOffset(double thuhrOffset) {
        this.thuhrOffset = thuhrOffset;
    }

    public double getOffset(PrayerTime prayer) {
        if (prayer == PrayerTime.FAJR) {
            return getFajrOffset();
        }
        if (prayer == PrayerTime.SHUROOQ) {
            return getShurooqOffset();
        }
        if (prayer == PrayerTime.THUHR) {
            return getThuhrOffset();
        }
        if (prayer == PrayerTime.ASSR) {
            return getAssrOffset();
        }
        if (prayer == PrayerTime.MAGHRIB) {
            return getMaghribOffset();
        }
        if (prayer == PrayerTime.ISHAA) {
            return getIshaaOffset();
        }
        return 0.0d;
    }
}
