package net.sourceforge.jitl;

import java.util.Iterator;
import org.bpmikc.akm.BuildConfig;

public class DayPrayers {
    private Prayer[] prayers;

    /* renamed from: net.sourceforge.jitl.DayPrayers.1 */
    class C04851 implements Iterator<Prayer> {
        private int f3i;

        C04851() {
            this.f3i = 0;
        }

        public boolean hasNext() {
            if (this.f3i < 6) {
                return true;
            }
            return false;
        }

        public Prayer next() {
            Prayer[] access$000 = DayPrayers.this.prayers;
            int i = this.f3i;
            this.f3i = i + 1;
            return access$000[i];
        }

        public void remove() {
            if (this.f3i > 0) {
                this.f3i--;
            }
        }
    }

    public DayPrayers() {
        this.prayers = new Prayer[6];
        for (int i = 0; i < 6; i++) {
            this.prayers[i] = new Prayer();
        }
    }

    void setAllExtreme(boolean extreme) {
        for (int i = 0; i < 6; i++) {
            this.prayers[i].setExtreme(extreme);
        }
    }

    public Prayer fajr() {
        return this.prayers[0];
    }

    public Prayer shuruq() {
        return this.prayers[1];
    }

    public Prayer thuhr() {
        return this.prayers[2];
    }

    public Prayer assr() {
        return this.prayers[3];
    }

    public Prayer maghrib() {
        return this.prayers[4];
    }

    public Prayer ishaa() {
        return this.prayers[5];
    }

    public Prayer[] getPrayers() {
        return this.prayers;
    }

    public String toString() {
        String ret = BuildConfig.FLAVOR;
        for (int i = 0; i < 6; i++) {
            ret = ret + this.prayers[i].toString() + "\n";
        }
        return ret;
    }

    public Iterator<Prayer> iterator() {
        return new C04851();
    }
}
