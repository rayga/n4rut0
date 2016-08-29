package net.sourceforge.jitl.astro;

public class Astro {
    private double[] dec;
    private double[] dra;
    private double jd;
    private double[] ra;
    private double[] rsum;
    private double[] sid;

    public Astro() {
        this.dec = new double[3];
        this.ra = new double[3];
        this.sid = new double[3];
        this.dra = new double[3];
        this.rsum = new double[3];
    }

    public double[] getDec() {
        return this.dec;
    }

    public void setDec(double[] dec) {
        this.dec = dec;
    }

    public double[] getDra() {
        return this.dra;
    }

    public void setDra(double[] dra) {
        this.dra = dra;
    }

    public double getJd() {
        return this.jd;
    }

    public void setJd(double jd) {
        this.jd = jd;
    }

    public double[] getRa() {
        return this.ra;
    }

    public void setRa(double[] ra) {
        this.ra = ra;
    }

    public double[] getRsum() {
        return this.rsum;
    }

    public void setRsum(double[] rsum) {
        this.rsum = rsum;
    }

    public double[] getSid() {
        return this.sid;
    }

    public void setSid(double[] sid) {
        this.sid = sid;
    }
}
