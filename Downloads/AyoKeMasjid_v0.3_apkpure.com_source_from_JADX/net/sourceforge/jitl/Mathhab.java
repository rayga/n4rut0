package net.sourceforge.jitl;

public class Mathhab {
    public static final Mathhab HANAFI;
    public static final Mathhab SHAAFI;

    private Mathhab() {
    }

    static {
        SHAAFI = new Mathhab();
        HANAFI = new Mathhab();
    }
}
