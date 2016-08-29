package net.sourceforge.jitl;

import java.util.GregorianCalendar;
import net.sourceforge.jitl.astro.Astro;
import net.sourceforge.jitl.astro.AstroLib;
import net.sourceforge.jitl.astro.Dms;
import net.sourceforge.jitl.astro.Location;
import net.sourceforge.jitl.astro.SimpleDate;
import net.sourceforge.jitl.astro.Utils;

public class Jitl {
    static final int VERSION_MAJOR = 1;
    static final int VERSION_MINOR = 0;
    private Astro astroCache;
    private Location loc;
    private Method method;

    public Jitl(Location loc, Method method) {
        this.astroCache = new Astro();
        this.loc = loc;
        this.method = method;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public DayPrayers getPrayerTimes(GregorianCalendar date) {
        return getPrayerTimes(new SimpleDate(date));
    }

    public void getPrayerTimes(GregorianCalendar date, DayPrayers pt) {
        getPrayerTimes(new SimpleDate(date), pt);
    }

    public DayPrayers getPrayerTimes(SimpleDate date) {
        DayPrayers dp = new DayPrayers();
        getPrayerTimes(date, dp);
        return dp;
    }

    public void getPrayerTimes(SimpleDate date, DayPrayers pt) {
        getPrayerTimesByDay(getDayInfo(date, this.loc.getGmtDiff()), pt, PrayerTime.FAJR);
    }

    void getPrayerTimesByDay(DayCouple dc, DayPrayers pt, PrayerTime type) {
        getPrayerTimesByDay(this.method, dc, pt, type);
    }

    void getPrayerTimesByDay(Method method, DayCouple dc, DayPrayers pt, PrayerTime type) {
        int i;
        double[] tempPrayer = new double[6];
        Astro tAstro = new Astro();
        double lat = this.loc.getDegreeLat();
        double lon = this.loc.getDegreeLong();
        int invalid = 0;
        AstroLib.getAstroValuesByDay(dc.getJulianDay(), this.loc, this.astroCache, tAstro);
        double dec = Utils.DEG_TO_RAD(tAstro.getDec()[VERSION_MAJOR]);
        double fj = getFajIsh(lat, dec, method.getFajrAng());
        double sh = getShoMag(this.loc, tAstro, PrayerTime.SHUROOQ);
        double th = getThuhr(lon, tAstro);
        double ar = getAssr(lat, dec, method.getMathhab());
        double mg = getShoMag(this.loc, tAstro, PrayerTime.MAGHRIB);
        double is = getFajIsh(lat, dec, method.getIshaaAng());
        if (fj == 99.0d) {
            tempPrayer[0] = 99.0d;
            invalid = VERSION_MAJOR;
        } else {
            tempPrayer[0] = th - fj;
        }
        if (sh == 99.0d) {
            invalid = VERSION_MAJOR;
        }
        tempPrayer[VERSION_MAJOR] = sh;
        tempPrayer[2] = th;
        tempPrayer[3] = th + ar;
        tempPrayer[4] = mg;
        if (mg == 99.0d) {
            invalid = VERSION_MAJOR;
        }
        if (is == 99.0d) {
            tempPrayer[5] = 99.0d;
            invalid = VERSION_MAJOR;
        } else {
            tempPrayer[5] = th + is;
        }
        pt.setAllExtreme(false);
        if (!(method.getExtremeLatitude() == ExtremeLatitude.NONE_EX || ((method.getExtremeLatitude() == ExtremeLatitude.GOOD_INVALID || method.getExtremeLatitude() == ExtremeLatitude.LAT_INVALID || method.getExtremeLatitude() == ExtremeLatitude.SEVEN_NIGHT_INVALID || method.getExtremeLatitude() == ExtremeLatitude.SEVEN_DAY_INVALID || method.getExtremeLatitude() == ExtremeLatitude.HALF_INVALID) && invalid == 0))) {
            double exTh = 99.0d;
            double exFj = 99.0d;
            double exIs = 99.0d;
            double exAr = 99.0d;
            double exSh = 99.0d;
            double exMg = 99.0d;
            double portion = 0.0d;
            Location exLoc = this.loc.copy();
            ExtremeLatitude ext = method.getExtremeLatitude();
            if (ext == ExtremeLatitude.LAT_ALL || ext == ExtremeLatitude.LAT_ALWAYS || ext == ExtremeLatitude.LAT_INVALID) {
                exLoc.setDegreeLat(method.getNearestLat());
                exFj = getFajIsh(method.getNearestLat(), dec, method.getFajrAng());
                exIs = getFajIsh(method.getNearestLat(), dec, method.getIshaaAng());
                exAr = getAssr(method.getNearestLat(), dec, method.getMathhab());
                exSh = getShoMag(exLoc, tAstro, PrayerTime.SHUROOQ);
                exMg = getShoMag(exLoc, tAstro, PrayerTime.MAGHRIB);
                if (ext == ExtremeLatitude.LAT_ALL) {
                    tempPrayer[0] = th - exFj;
                    tempPrayer[VERSION_MAJOR] = exSh;
                    tempPrayer[3] = th + exAr;
                    tempPrayer[4] = exMg;
                    tempPrayer[5] = th + exIs;
                    pt.setAllExtreme(true);
                } else if (ext == ExtremeLatitude.LAT_ALWAYS) {
                    tempPrayer[0] = th - exFj;
                    tempPrayer[5] = th + exIs;
                    pt.fajr().setExtreme(true);
                    pt.ishaa().setExtreme(true);
                } else if (ext == ExtremeLatitude.LAT_INVALID) {
                    if (tempPrayer[0] == 99.0d) {
                        tempPrayer[0] = th - exFj;
                        pt.fajr().setExtreme(true);
                    }
                    if (tempPrayer[5] == 99.0d) {
                        tempPrayer[5] = th + exIs;
                        pt.ishaa().setExtreme(true);
                    }
                }
            } else if (ext == ExtremeLatitude.GOOD_ALL || ext == ExtremeLatitude.GOOD_INVALID || ext == ExtremeLatitude.GOOD_DIF) {
                Astro exAstroPrev = this.astroCache;
                Astro exAstroNext = this.astroCache;
                for (i = 0; i <= dc.getLastDay(); i += VERSION_MAJOR) {
                    AstroLib.getAstroValuesByDay(dc.getJulianDay() - ((double) i), this.loc, exAstroPrev, tAstro);
                    double exdecPrev = Utils.DEG_TO_RAD(tAstro.getDec()[VERSION_MAJOR]);
                    exFj = getFajIsh(lat, exdecPrev, method.getFajrAng());
                    if (exFj != 99.0d) {
                        exIs = getFajIsh(lat, exdecPrev, method.getIshaaAng());
                        if (exIs != 99.0d) {
                            exTh = getThuhr(lon, tAstro);
                            exSh = getShoMag(this.loc, tAstro, PrayerTime.SHUROOQ);
                            exMg = getShoMag(this.loc, tAstro, PrayerTime.MAGHRIB);
                            exAr = getAssr(lat, exdecPrev, method.getMathhab());
                            break;
                        }
                    }
                    AstroLib.getAstroValuesByDay(dc.getJulianDay() + ((double) i), this.loc, exAstroNext, tAstro);
                    double exdecNext = Utils.DEG_TO_RAD(tAstro.getDec()[VERSION_MAJOR]);
                    exFj = getFajIsh(lat, exdecNext, method.getFajrAng());
                    if (exFj != 99.0d) {
                        exIs = getFajIsh(lat, exdecNext, method.getIshaaAng());
                        if (exIs != 99.0d) {
                            exTh = getThuhr(lon, tAstro);
                            exSh = getShoMag(this.loc, tAstro, PrayerTime.SHUROOQ);
                            exMg = getShoMag(this.loc, tAstro, PrayerTime.MAGHRIB);
                            exAr = getAssr(lat, exdecNext, method.getMathhab());
                            break;
                        }
                    }
                }
                if (ext == ExtremeLatitude.GOOD_ALL) {
                    tempPrayer[0] = exTh - exFj;
                    tempPrayer[VERSION_MAJOR] = exSh;
                    tempPrayer[2] = exTh;
                    tempPrayer[3] = exTh + exAr;
                    tempPrayer[4] = exMg;
                    tempPrayer[5] = exTh + exIs;
                    pt.setAllExtreme(true);
                } else if (ext == ExtremeLatitude.GOOD_INVALID) {
                    if (tempPrayer[0] == 99.0d) {
                        tempPrayer[0] = exTh - exFj;
                        pt.fajr().setExtreme(true);
                    }
                    if (tempPrayer[5] == 99.0d) {
                        tempPrayer[5] = exTh + exIs;
                        pt.ishaa().setExtreme(true);
                    }
                } else if (ext == ExtremeLatitude.GOOD_DIF) {
                }
            } else if (ext == ExtremeLatitude.SEVEN_NIGHT_ALWAYS || ext == ExtremeLatitude.SEVEN_NIGHT_INVALID || ext == ExtremeLatitude.SEVEN_DAY_ALWAYS || ext == ExtremeLatitude.SEVEN_DAY_INVALID || ext == ExtremeLatitude.HALF_ALWAYS || ext == ExtremeLatitude.HALF_INVALID) {
                if (ext == ExtremeLatitude.SEVEN_NIGHT_ALWAYS || ext == ExtremeLatitude.SEVEN_NIGHT_INVALID) {
                    portion = (24.0d - (tempPrayer[4] - tempPrayer[VERSION_MAJOR])) * 0.14285714285714285d;
                } else if (ext == ExtremeLatitude.SEVEN_DAY_ALWAYS || ext == ExtremeLatitude.SEVEN_DAY_INVALID) {
                    portion = (tempPrayer[4] - tempPrayer[VERSION_MAJOR]) * 0.14285714285714285d;
                } else if (ext == ExtremeLatitude.HALF_ALWAYS || ext == ExtremeLatitude.HALF_INVALID) {
                    portion = ((24.0d - tempPrayer[4]) - tempPrayer[VERSION_MAJOR]) * 0.5d;
                }
                if (method.getExtremeLatitude() == ExtremeLatitude.SEVEN_NIGHT_INVALID || method.getExtremeLatitude() == ExtremeLatitude.SEVEN_DAY_INVALID || method.getExtremeLatitude() == ExtremeLatitude.HALF_INVALID) {
                    if (tempPrayer[0] == 99.0d) {
                        if (method.getExtremeLatitude() == ExtremeLatitude.HALF_INVALID) {
                            tempPrayer[0] = portion - (((double) method.getFajrInv()) / 60.0d);
                        } else {
                            tempPrayer[0] = tempPrayer[VERSION_MAJOR] - portion;
                        }
                        pt.fajr().setExtreme(true);
                    }
                    if (tempPrayer[5] == 99.0d) {
                        if (method.getExtremeLatitude() == ExtremeLatitude.HALF_INVALID) {
                            tempPrayer[5] = (((double) method.getIshaaInv()) / 60.0d) + portion;
                        } else {
                            tempPrayer[5] = tempPrayer[4] + portion;
                        }
                        pt.ishaa().setExtreme(true);
                    }
                } else {
                    if (method.getExtremeLatitude() == ExtremeLatitude.HALF_ALWAYS) {
                        tempPrayer[0] = portion - (((double) method.getFajrInv()) / 60.0d);
                        tempPrayer[5] = (((double) method.getIshaaInv()) / 60.0d) + portion;
                    } else {
                        tempPrayer[0] = tempPrayer[VERSION_MAJOR] - portion;
                        tempPrayer[5] = tempPrayer[4] + portion;
                    }
                    pt.fajr().setExtreme(true);
                    pt.ishaa().setExtreme(true);
                }
            } else if (ext == ExtremeLatitude.MIN_ALWAYS) {
                tempPrayer[0] = tempPrayer[VERSION_MAJOR];
                tempPrayer[5] = tempPrayer[4];
                pt.fajr().setExtreme(true);
                pt.ishaa().setExtreme(true);
            } else if (ext == ExtremeLatitude.MIN_INVALID) {
                if (tempPrayer[0] == 99.0d) {
                    tempPrayer[0] = tempPrayer[VERSION_MAJOR] - ((double) ((int) (((double) method.getFajrInv()) / 60.0d)));
                    pt.fajr().setExtreme(true);
                }
                if (tempPrayer[5] == 99.0d) {
                    tempPrayer[5] = tempPrayer[4] + ((double) ((int) (((double) method.getIshaaInv()) / 60.0d)));
                    pt.ishaa().setExtreme(true);
                }
            }
        }
        if (!(method.getExtremeLatitude() == ExtremeLatitude.MIN_INVALID || method.getExtremeLatitude() == ExtremeLatitude.HALF_INVALID || method.getExtremeLatitude() == ExtremeLatitude.HALF_ALWAYS)) {
            if (method.getFajrInv() != 0) {
                tempPrayer[0] = tempPrayer[VERSION_MAJOR] - (((double) method.getFajrInv()) / 60.0d);
            }
            if (method.getIshaaInv() != 0) {
                tempPrayer[5] = tempPrayer[4] + (((double) method.getIshaaInv()) / 60.0d);
            }
        }
        if (type == PrayerTime.IMSAAK || type == PrayerTime.NEXTFAJR) {
            base6hm(tempPrayer[0], method, pt.fajr(), type);
            return;
        }
        Prayer[] pArray = pt.getPrayers();
        PrayerTime[] timeArray = new PrayerTime[]{PrayerTime.FAJR, PrayerTime.SHUROOQ, PrayerTime.THUHR, PrayerTime.ASSR, PrayerTime.MAGHRIB, PrayerTime.ISHAA};
        for (i = 0; i < 6; i += VERSION_MAJOR) {
            base6hm(tempPrayer[i], method, pArray[i], timeArray[i]);
        }
    }

    void base6hm(double bs, Method method, Prayer pt, PrayerTime type) {
        if (bs == 99.0d) {
            pt.setHour(99);
            pt.setMinute(99);
            pt.setSecond(0);
            return;
        }
        if (method.getOffset()) {
            if (type == PrayerTime.IMSAAK || type == PrayerTime.NEXTFAJR) {
                bs += method.getFajrOffset() / 60.0d;
            } else {
                bs += method.getOffset(type) / 60.0d;
            }
        }
        if (bs < 0.0d) {
            while (bs < 0.0d) {
                bs += 24.0d;
            }
        }
        double min = (bs - Math.floor(bs)) * 60.0d;
        double sec = (min - Math.floor(min)) * 60.0d;
        if (method.getRound() == Rounding.NORMAL) {
            if (sec >= Utils.DEFAULT_ROUND_SEC) {
                bs += 0.016666666666666666d;
            }
            min = (bs - Math.floor(bs)) * 60.0d;
            sec = 0.0d;
        } else if (method.getRound() == Rounding.SPECIAL || method.getRound() == Rounding.AGRESSIVE) {
            if (type == PrayerTime.FAJR || type == PrayerTime.THUHR || type == PrayerTime.ASSR || type == PrayerTime.MAGHRIB || type == PrayerTime.ISHAA || type == PrayerTime.NEXTFAJR) {
                if (method.getRound() == Rounding.SPECIAL) {
                    if (sec >= Utils.DEFAULT_ROUND_SEC) {
                        bs += 0.016666666666666666d;
                        min = (bs - Math.floor(bs)) * 60.0d;
                    }
                } else if (method.getRound() == Rounding.AGRESSIVE && sec >= Utils.AGGRESSIVE_ROUND_SEC) {
                    bs += 0.016666666666666666d;
                    min = (bs - Math.floor(bs)) * 60.0d;
                }
                sec = 0.0d;
            } else {
                sec = 0.0d;
            }
        }
        bs += (double) this.loc.getDst();
        if (bs >= 24.0d) {
            bs = Math.IEEEremainder(bs, 24.0d);
        }
        pt.setHour((int) bs);
        pt.setMinute((int) min);
        pt.setSecond((int) sec);
    }

    public Prayer getImsaak(GregorianCalendar date) {
        return getImsaak(new SimpleDate(date));
    }

    public Prayer getImsaak(SimpleDate date) {
        DayPrayers temp = new DayPrayers();
        Method tmpConf = this.method.copy();
        if (this.method.getFajrInv() != 0) {
            if (this.method.getImsaakInv() == 0) {
                tmpConf.setFajrInv((int) (((double) tmpConf.getFajrInv()) + Utils.DEF_IMSAAK_INTERVAL));
            } else {
                tmpConf.setFajrInv(tmpConf.getFajrInv() + this.method.getImsaakInv());
            }
        } else if (this.method.getImsaakInv() != 0) {
            tmpConf.setFajrOffset(tmpConf.getFajrOffset() + ((double) (this.method.getImsaakInv() * -1)));
            tmpConf.setOffset(true);
        } else {
            tmpConf.setFajrAng(tmpConf.getFajrAng() + this.method.getImsaakAng());
        }
        DayCouple dc = getDayInfo(date, this.loc.getGmtDiff());
        getPrayerTimesByDay(tmpConf, dc, temp, PrayerTime.IMSAAK);
        if (temp.fajr().isExtreme()) {
            tmpConf = this.method.copy();
            if (this.method.getImsaakInv() == 0) {
                tmpConf.setFajrOffset(tmpConf.getFajrOffset() - Utils.DEF_IMSAAK_INTERVAL);
                tmpConf.setOffset(true);
            } else {
                tmpConf.setFajrOffset(tmpConf.getFajrOffset() - ((double) this.method.getImsaakInv()));
                tmpConf.setOffset(true);
            }
            getPrayerTimesByDay(tmpConf, dc, temp, PrayerTime.IMSAAK);
        }
        return temp.fajr();
    }

    public Prayer getNextDayImsaak(GregorianCalendar date) {
        return getNextDayImsaak(new SimpleDate(date));
    }

    public Prayer getNextDayImsaak(SimpleDate date) {
        SimpleDate tempd = date.copy();
        tempd.setDay(tempd.getDay() + VERSION_MAJOR);
        return getImsaak(tempd);
    }

    public Prayer getNextDayFajr(GregorianCalendar date) {
        return getNextDayFajr(new SimpleDate(date));
    }

    public Prayer getNextDayFajr(SimpleDate date) {
        DayPrayers temp = new DayPrayers();
        DayCouple dc = getDayInfo(date, this.loc.getGmtDiff());
        dc.setJulianDay(dc.getJulianDay() + Utils.AGGRESSIVE_ROUND_SEC);
        getPrayerTimesByDay(dc, temp, PrayerTime.NEXTFAJR);
        return temp.fajr().copy();
    }

    static double getFajIsh(double Lat, double dec, double Ang) {
        double part3 = ((-Math.sin(Utils.DEG_TO_RAD(Ang))) - (Math.sin(Utils.DEG_TO_RAD(Lat)) * Math.sin(dec))) / (Math.cos(Utils.DEG_TO_RAD(Lat)) * Math.cos(dec));
        if (part3 <= Utils.INVALID_TRIGGER) {
            return 99.0d;
        }
        return Utils.DEG_TO_10_BASE * Utils.RAD_TO_DEG(Math.acos(part3));
    }

    static double getShoMag(Location loc, Astro astro, PrayerTime type) {
        double ra0 = astro.getRa()[0];
        double ra2 = astro.getRa()[2];
        double part4 = (Math.sin(Utils.DEG_TO_RAD(Utils.CENTER_OF_SUN_ANGLE)) - (Math.sin(Utils.DEG_TO_RAD(loc.getDegreeLat())) * Math.sin(Utils.DEG_TO_RAD(astro.getDec()[VERSION_MAJOR])))) / (Math.cos(Utils.DEG_TO_RAD(loc.getDegreeLat())) * Math.cos(Utils.DEG_TO_RAD(astro.getDec()[VERSION_MAJOR])));
        if (part4 <= -1.0d || part4 >= Utils.AGGRESSIVE_ROUND_SEC) {
            return 99.0d;
        }
        double lhour = AstroLib.limitAngle180(Utils.RAD_TO_DEG(Math.acos(part4)));
        double M = ((astro.getRa()[VERSION_MAJOR] - loc.getDegreeLong()) - astro.getSid()[VERSION_MAJOR]) / 360.0d;
        if (type == PrayerTime.SHUROOQ) {
            M -= lhour / 360.0d;
        }
        if (type == PrayerTime.MAGHRIB) {
            M += lhour / 360.0d;
        }
        M = AstroLib.limitAngle111(M);
        double sidG = AstroLib.limitAngle(astro.getSid()[VERSION_MAJOR] + (360.985647d * M));
        ra0 = astro.getRa()[0];
        ra2 = astro.getRa()[2];
        if (astro.getRa()[VERSION_MAJOR] > 350.0d && astro.getRa()[2] < Utils.DEF_IMSAAK_INTERVAL) {
            ra2 += 360.0d;
        }
        if (astro.getRa()[0] > 350.0d && astro.getRa()[VERSION_MAJOR] < Utils.DEF_IMSAAK_INTERVAL) {
            ra0 = 0.0d;
        }
        double B = astro.getDec()[VERSION_MAJOR] + (((((astro.getDec()[VERSION_MAJOR] - astro.getDec()[0]) + (astro.getDec()[2] - astro.getDec()[VERSION_MAJOR])) + (((astro.getDec()[2] - astro.getDec()[VERSION_MAJOR]) - (astro.getDec()[VERSION_MAJOR] - astro.getDec()[0])) * M)) * M) / 2.0d);
        double tH = AstroLib.limitAngle180between((loc.getDegreeLong() + sidG) - (astro.getRa()[VERSION_MAJOR] + (((((astro.getRa()[VERSION_MAJOR] - ra0) + (ra2 - astro.getRa()[VERSION_MAJOR])) + (((ra2 - astro.getRa()[VERSION_MAJOR]) - (astro.getRa()[VERSION_MAJOR] - ra0)) * M)) * M) / 2.0d))) - Utils.RAD_TO_DEG(astro.getDra()[VERSION_MAJOR]);
        double sunAlt = Utils.RAD_TO_DEG(Math.asin((Math.sin(Utils.DEG_TO_RAD(loc.getDegreeLat())) * Math.sin(Utils.DEG_TO_RAD(B))) + ((Math.cos(Utils.DEG_TO_RAD(loc.getDegreeLat())) * Math.cos(Utils.DEG_TO_RAD(B))) * Math.cos(Utils.DEG_TO_RAD(tH)))));
        return 24.0d * (M + ((((sunAlt + AstroLib.getRefraction(loc, sunAlt)) - Utils.CENTER_OF_SUN_ANGLE) + (Utils.ALTITUDE_REFRACTION * Math.pow(loc.getSeaLevel(), 0.5d))) / (((360.0d * Math.cos(Utils.DEG_TO_RAD(B))) * Math.cos(Utils.DEG_TO_RAD(loc.getDegreeLat()))) * Math.sin(Utils.DEG_TO_RAD(tH)))));
    }

    static double getThuhr(double lon, Astro astro) {
        double ra0 = astro.getRa()[0];
        double ra2 = astro.getRa()[2];
        double M = AstroLib.limitAngle111(((astro.getRa()[VERSION_MAJOR] - lon) - astro.getSid()[VERSION_MAJOR]) / 360.0d);
        double sidG = astro.getSid()[VERSION_MAJOR] + (360.985647d * M);
        if (astro.getRa()[VERSION_MAJOR] > 350.0d && astro.getRa()[2] < Utils.DEF_IMSAAK_INTERVAL) {
            ra2 += 360.0d;
        }
        if (astro.getRa()[0] > 350.0d && astro.getRa()[VERSION_MAJOR] < Utils.DEF_IMSAAK_INTERVAL) {
            ra0 = 0.0d;
        }
        return 24.0d * (M - (AstroLib.limitAngle180between((sidG + lon) - (astro.getRa()[VERSION_MAJOR] + (((((astro.getRa()[VERSION_MAJOR] - ra0) + (ra2 - astro.getRa()[VERSION_MAJOR])) + (((ra2 - astro.getRa()[VERSION_MAJOR]) - (astro.getRa()[VERSION_MAJOR] - ra0)) * M)) * M) / 2.0d))) / 360.0d));
    }

    static double getAssr(double Lat, double dec, Mathhab mathhab) {
        int mathhabValue = mathhab == Mathhab.SHAAFI ? VERSION_MAJOR : 2;
        double rlat = Utils.DEG_TO_RAD(Lat);
        double ndec = dec;
        if (Lat < 0.0d) {
            ndec = -dec;
        }
        double part1 = ((double) mathhabValue) + Math.tan(rlat - ndec);
        if (part1 < Utils.AGGRESSIVE_ROUND_SEC) {
            part1 = ((double) mathhabValue) - Math.tan(rlat - ndec);
        }
        return Utils.DEG_TO_10_BASE * Utils.RAD_TO_DEG(Math.acos((Math.sin(1.5707963267949d - Math.atan(part1)) - (Math.sin(rlat) * Math.sin(ndec))) / (Math.cos(rlat) * Math.cos(ndec))));
    }

    static int getDayofYear(int year, int month, int day) {
        int isLeap;
        if ((year & 3) != 0 || (year % 100 == 0 && year % 400 != 0)) {
            isLeap = 0;
        } else {
            isLeap = VERSION_MAJOR;
        }
        char[][] dayList = new char[][]{new char[]{'\u0000', '\u001f', '\u001c', '\u001f', '\u001e', '\u001f', '\u001e', '\u001f', '\u001f', '\u001e', '\u001f', '\u001e', '\u001f'}, new char[]{'\u0000', '\u001f', '\u001d', '\u001f', '\u001e', '\u001f', '\u001e', '\u001f', '\u001f', '\u001e', '\u001f', '\u001e', '\u001f'}};
        for (int i = VERSION_MAJOR; i < month; i += VERSION_MAJOR) {
            day += dayList[isLeap][i];
        }
        return day;
    }

    static DayCouple getDayInfo(SimpleDate date, double gmt) {
        return new DayCouple(getDayofYear(date.getYear(), 12, 31), AstroLib.getJulianDay(date, gmt));
    }

    public static Dms getNorthQibla(Location loc) {
        return new Dms(Utils.RAD_TO_DEG(Math.atan2(Math.sin(Utils.DEG_TO_RAD(loc.getDegreeLong()) - Utils.DEG_TO_RAD(Utils.KAABA_LONG)), (Math.cos(Utils.DEG_TO_RAD(loc.getDegreeLat())) * Math.tan(Utils.DEG_TO_RAD(Utils.KAABA_LAT))) - (Math.sin(Utils.DEG_TO_RAD(loc.getDegreeLat())) * Math.cos(Utils.DEG_TO_RAD(loc.getDegreeLong()) - Utils.DEG_TO_RAD(Utils.KAABA_LONG))))));
    }

    public Dms getNorthQibla() {
        return getNorthQibla(this.loc);
    }

    public static int getMajorVersion() {
        return VERSION_MAJOR;
    }

    public static int getMinorVersion() {
        return 0;
    }
}
