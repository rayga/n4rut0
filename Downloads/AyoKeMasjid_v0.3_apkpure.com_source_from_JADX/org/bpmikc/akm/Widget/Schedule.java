package org.bpmikc.akm.Widget;

import android.content.Context;
import java.util.Calendar;
import java.util.GregorianCalendar;
import net.sourceforge.jitl.Jitl;
import net.sourceforge.jitl.Method;
import net.sourceforge.jitl.Prayer;
import org.bpmikc.akm.Fragment.Utils;

public class Schedule {
    private static Schedule today;
    private final boolean[] extremes;
    private final GregorianCalendar[] schedule;

    public Schedule(Context context, GregorianCalendar day) {
        this.schedule = new GregorianCalendar[7];
        this.extremes = new boolean[7];
        Preferences preferences = Preferences.getInstance(context);
        Method method = CONSTANT.CALCULATION_METHODS[preferences.getCalculationMethodIndex()].copy();
        method.setRound(CONSTANT.ROUNDING_METHODS[preferences.getRoundingMethodIndex()]);
        Prayer[] dayPrayers = new Jitl(preferences.getJitlLocation(), method).getPrayerTimes(day).getPrayers();
        Prayer[] allTimes = new Prayer[]{dayPrayers[0], dayPrayers[1], dayPrayers[2], dayPrayers[3], dayPrayers[4], dayPrayers[5], jitl.getNextDayFajr(day)};
        for (short i = (short) 0; i <= (short) 6; i = (short) (i + 1)) {
            this.schedule[i] = new GregorianCalendar(day.get(1), day.get(2), day.get(5), allTimes[i].getHour(), allTimes[i].getMinute(), allTimes[i].getSecond());
            this.schedule[i].add(12, preferences.getOffsetMinutes());
            this.extremes[i] = allTimes[i].isExtreme();
        }
        this.schedule[6].add(5, 1);
    }

    public GregorianCalendar[] getTimes() {
        return this.schedule;
    }

    public boolean isExtreme(int i) {
        return this.extremes[i];
    }

    public short nextTimeIndex() {
        Calendar now = new GregorianCalendar();
        if (now.before(this.schedule[0])) {
            return (short) 0;
        }
        short i = (short) 0;
        while (i < (short) 6) {
            if (now.after(this.schedule[i]) && now.before(this.schedule[i + 1])) {
                return (short) (i + 1);
            }
            i = (short) (i + 1);
        }
        return (short) 6;
    }

    private boolean currentlyAfterSunset() {
        return new GregorianCalendar().after(this.schedule[4]);
    }

    public static Schedule today(Context context) {
        GregorianCalendar now = new GregorianCalendar();
        if (today == null) {
            today = new Schedule(context, now);
        } else {
            GregorianCalendar fajr = today.getTimes()[0];
            if (!(fajr.get(1) == now.get(1) && fajr.get(2) == now.get(2) && fajr.get(5) == now.get(5))) {
                today = new Schedule(context, now);
            }
        }
        return today;
    }

    public static void setSettingsDirty() {
        today = null;
        Utils.isRestartNeeded = true;
    }

    public static double getGMTOffset() {
        Calendar now = new GregorianCalendar();
        return (double) (now.getTimeZone().getOffset(now.getTimeInMillis()) / 3600000);
    }

    public static boolean isDaylightSavings() {
        Calendar now = new GregorianCalendar();
        return now.getTimeZone().inDaylightTime(now.getTime());
    }
}
