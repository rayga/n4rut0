package net.sourceforge.jitl.astro;

public class Location {
    public static final double DEFAULT_PRESSURE = 1010.0d;
    public static final double DEFAULT_SEA_LEVEL = 0.0d;
    public static final double DEFAULT_TEMPERATURE = 10.0d;
    private double degreeLat;
    private double degreeLong;
    private int dst;
    private double gmtDiff;
    private double pressure;
    private double seaLevel;
    private double temperature;

    public Location(double degreeLat, double degreeLong, double gmtDiff, int dst) {
        this.degreeLong = degreeLong;
        this.degreeLat = degreeLat;
        this.gmtDiff = gmtDiff;
        this.dst = dst;
        this.seaLevel = DEFAULT_SEA_LEVEL;
        this.pressure = DEFAULT_PRESSURE;
        this.temperature = DEFAULT_TEMPERATURE;
    }

    private Location() {
    }

    public Location copy() {
        Location loc = new Location();
        loc.setDegreeLat(this.degreeLat);
        loc.setDegreeLong(this.degreeLong);
        loc.setGmtDiff(this.gmtDiff);
        loc.setDst(this.dst);
        loc.setSeaLevel(this.seaLevel);
        loc.setPressure(this.pressure);
        loc.setTemperature(this.temperature);
        return loc;
    }

    public double getDegreeLat() {
        return this.degreeLat;
    }

    public void setDegreeLat(double degreeLat) {
        this.degreeLat = degreeLat;
    }

    public double getDegreeLong() {
        return this.degreeLong;
    }

    public void setDegreeLong(double degreeLong) {
        this.degreeLong = degreeLong;
    }

    public int getDst() {
        return this.dst;
    }

    public void setDst(int dst) {
        this.dst = dst;
    }

    public double getGmtDiff() {
        return this.gmtDiff;
    }

    public void setGmtDiff(double gmtDiff) {
        this.gmtDiff = gmtDiff;
    }

    public double getPressure() {
        return this.pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSeaLevel() {
        return this.seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
