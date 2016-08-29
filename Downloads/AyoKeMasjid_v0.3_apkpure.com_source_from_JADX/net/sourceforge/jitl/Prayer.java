package net.sourceforge.jitl;

import org.bpmikc.akm.BuildConfig;

public class Prayer {
    private boolean extreme;
    private int hour;
    private int minute;
    private int second;

    public Prayer(int hour, int minute, int second, boolean extreme) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.extreme = extreme;
    }

    public Prayer copy() {
        return new Prayer(this.hour, this.minute, this.second, this.extreme);
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isExtreme() {
        return this.extreme;
    }

    public void setExtreme(boolean extreme) {
        this.extreme = extreme;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String toString() {
        return this.hour + ":" + (this.minute < 10 ? "0" + this.minute : this.minute + BuildConfig.FLAVOR) + ":" + (this.second < 10 ? "0" + this.second : this.second + BuildConfig.FLAVOR);
    }
}
