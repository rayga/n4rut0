package net.sourceforge.jitl;

public class Rounding {
    public static final Rounding AGRESSIVE;
    public static final Rounding NONE;
    public static final Rounding NORMAL;
    public static final Rounding SPECIAL;

    private Rounding() {
    }

    static {
        NONE = new Rounding();
        NORMAL = new Rounding();
        SPECIAL = new Rounding();
        AGRESSIVE = new Rounding();
    }
}
