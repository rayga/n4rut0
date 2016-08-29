package net.sourceforge.jitl.astro;

public class Direction {
    public static final Direction EAST;
    public static final Direction NORTH;
    public static final Direction SOUTH;
    public static final Direction WEST;

    private Direction() {
    }

    static {
        NORTH = new Direction();
        SOUTH = new Direction();
        EAST = new Direction();
        WEST = new Direction();
    }
}
