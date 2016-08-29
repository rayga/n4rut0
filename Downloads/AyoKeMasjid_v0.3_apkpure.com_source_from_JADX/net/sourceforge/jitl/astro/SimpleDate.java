package net.sourceforge.jitl.astro;

import java.util.GregorianCalendar;

public class SimpleDate {
    int day;
    int month;
    int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SimpleDate(GregorianCalendar gCalendar) {
        this.day = gCalendar.get(5);
        this.month = gCalendar.get(2) + 1;
        this.year = gCalendar.get(1);
    }

    public SimpleDate copy() {
        return new SimpleDate(this.day, this.month, this.year);
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
