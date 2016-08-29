package com.google.android.gms.common.images;

public final class Size {
    private final int zznP;
    private final int zznQ;

    public Size(int width, int height) {
        this.zznP = width;
        this.zznQ = height;
    }

    public static Size parseSize(String string) throws NumberFormatException {
        if (string == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = string.indexOf(42);
        if (indexOf < 0) {
            indexOf = string.indexOf(120);
        }
        if (indexOf < 0) {
            throw zzcg(string);
        }
        try {
            return new Size(Integer.parseInt(string.substring(0, indexOf)), Integer.parseInt(string.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw zzcg(string);
        }
    }

    private static NumberFormatException zzcg(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.zznP == size.zznP && this.zznQ == size.zznQ)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.zznQ;
    }

    public int getWidth() {
        return this.zznP;
    }

    public int hashCode() {
        return this.zznQ ^ ((this.zznP << 16) | (this.zznP >>> 16));
    }

    public String toString() {
        return this.zznP + "x" + this.zznQ;
    }
}
