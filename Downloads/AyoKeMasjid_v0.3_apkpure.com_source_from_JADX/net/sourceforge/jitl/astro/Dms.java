package net.sourceforge.jitl.astro;

public class Dms {
    private int degree;
    private int minute;
    private double second;

    public int getDegree() {
        return this.degree;
    }

    public int getMinute() {
        return this.minute;
    }

    public double getSecond() {
        return this.second;
    }

    public Dms(int degree, int minute, double second) {
        this.degree = degree;
        this.minute = minute;
        this.second = second;
    }

    public Dms(double decimal) {
        double v = Math.floor(decimal);
        this.degree = (int) v;
        double tempmin = (decimal - v) * 60.0d;
        v = Math.floor(tempmin);
        this.minute = (int) v;
        this.second = (tempmin - v) * 60.0d;
    }

    public double getDecimalValue(Direction dir) {
        double sum = ((double) this.degree) + ((((double) this.minute) / 60.0d) + (this.second / 3600.0d));
        if (dir == Direction.WEST || dir == Direction.SOUTH) {
            return sum * -1.0d;
        }
        return sum;
    }

    public String toString() {
        return this.degree + "\u00b0" + this.minute + "'" + this.second + "''";
    }
}
