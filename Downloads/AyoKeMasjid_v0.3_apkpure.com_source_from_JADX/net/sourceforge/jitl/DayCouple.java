package net.sourceforge.jitl;

class DayCouple {
    private double julianDay;
    private int lastDay;

    public DayCouple(int lastDay, double julianDay) {
        this.lastDay = lastDay;
        this.julianDay = julianDay;
    }

    public double getJulianDay() {
        return this.julianDay;
    }

    public void setJulianDay(double julianDay) {
        this.julianDay = julianDay;
    }

    public int getLastDay() {
        return this.lastDay;
    }

    public void setLastDay(int lastDay) {
        this.lastDay = lastDay;
    }
}
