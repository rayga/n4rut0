package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.bumptech.glide.load.Key;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;

public final class zzrp {
    private final byte[] buffer;
    private int zzbbQ;
    private int zzbbR;
    private int zzbbS;
    private int zzbbT;
    private int zzbbU;
    private int zzbbV;
    private int zzbbW;
    private int zzbbX;
    private int zzbbY;

    private zzrp(byte[] bArr, int i, int i2) {
        this.zzbbV = Strategy.TTL_SECONDS_INFINITE;
        this.zzbbX = 64;
        this.zzbbY = 67108864;
        this.buffer = bArr;
        this.zzbbQ = i;
        this.zzbbR = i + i2;
        this.zzbbT = i;
    }

    private void zzDe() {
        this.zzbbR += this.zzbbS;
        int i = this.zzbbR;
        if (i > this.zzbbV) {
            this.zzbbS = i - this.zzbbV;
            this.zzbbR -= this.zzbbS;
            return;
        }
        this.zzbbS = 0;
    }

    public static long zzV(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzrp zza(byte[] bArr, int i, int i2) {
        return new zzrp(bArr, i, i2);
    }

    public static int zzlk(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzrp zzz(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public int getPosition() {
        return this.zzbbT - this.zzbbQ;
    }

    public byte[] readBytes() throws IOException {
        int zzDa = zzDa();
        if (zzDa > this.zzbbR - this.zzbbT || zzDa <= 0) {
            return zzlo(zzDa);
        }
        Object obj = new byte[zzDa];
        System.arraycopy(this.buffer, this.zzbbT, obj, 0, zzDa);
        this.zzbbT = zzDa + this.zzbbT;
        return obj;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzDd());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzDc());
    }

    public String readString() throws IOException {
        int zzDa = zzDa();
        if (zzDa > this.zzbbR - this.zzbbT || zzDa <= 0) {
            return new String(zzlo(zzDa), Key.STRING_CHARSET_NAME);
        }
        String str = new String(this.buffer, this.zzbbT, zzDa, Key.STRING_CHARSET_NAME);
        this.zzbbT = zzDa + this.zzbbT;
        return str;
    }

    public int zzCT() throws IOException {
        if (zzDg()) {
            this.zzbbU = 0;
            return 0;
        }
        this.zzbbU = zzDa();
        if (this.zzbbU != 0) {
            return this.zzbbU;
        }
        throw zzrw.zzDs();
    }

    public void zzCU() throws IOException {
        int zzCT;
        do {
            zzCT = zzCT();
            if (zzCT == 0) {
                return;
            }
        } while (zzlj(zzCT));
    }

    public long zzCV() throws IOException {
        return zzDb();
    }

    public int zzCW() throws IOException {
        return zzDa();
    }

    public boolean zzCX() throws IOException {
        return zzDa() != 0;
    }

    public int zzCY() throws IOException {
        return zzlk(zzDa());
    }

    public long zzCZ() throws IOException {
        return zzV(zzDb());
    }

    public int zzDa() throws IOException {
        byte zzDh = zzDh();
        if (zzDh >= null) {
            return zzDh;
        }
        int i = zzDh & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte zzDh2 = zzDh();
        if (zzDh2 >= null) {
            return i | (zzDh2 << 7);
        }
        i |= (zzDh2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        zzDh2 = zzDh();
        if (zzDh2 >= null) {
            return i | (zzDh2 << 14);
        }
        i |= (zzDh2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        zzDh2 = zzDh();
        if (zzDh2 >= null) {
            return i | (zzDh2 << 21);
        }
        i |= (zzDh2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        zzDh2 = zzDh();
        i |= zzDh2 << 28;
        if (zzDh2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzDh() >= null) {
                return i;
            }
        }
        throw zzrw.zzDr();
    }

    public long zzDb() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzDh = zzDh();
            j |= ((long) (zzDh & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((zzDh & Barcode.ITF) == 0) {
                return j;
            }
        }
        throw zzrw.zzDr();
    }

    public int zzDc() throws IOException {
        return (((zzDh() & MotionEventCompat.ACTION_MASK) | ((zzDh() & MotionEventCompat.ACTION_MASK) << 8)) | ((zzDh() & MotionEventCompat.ACTION_MASK) << 16)) | ((zzDh() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long zzDd() throws IOException {
        byte zzDh = zzDh();
        byte zzDh2 = zzDh();
        return ((((((((((long) zzDh2) & 255) << 8) | (((long) zzDh) & 255)) | ((((long) zzDh()) & 255) << 16)) | ((((long) zzDh()) & 255) << 24)) | ((((long) zzDh()) & 255) << 32)) | ((((long) zzDh()) & 255) << 40)) | ((((long) zzDh()) & 255) << 48)) | ((((long) zzDh()) & 255) << 56);
    }

    public int zzDf() {
        if (this.zzbbV == Strategy.TTL_SECONDS_INFINITE) {
            return -1;
        }
        return this.zzbbV - this.zzbbT;
    }

    public boolean zzDg() {
        return this.zzbbT == this.zzbbR;
    }

    public byte zzDh() throws IOException {
        if (this.zzbbT == this.zzbbR) {
            throw zzrw.zzDp();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbbT;
        this.zzbbT = i + 1;
        return bArr[i];
    }

    public void zza(zzrx com_google_android_gms_internal_zzrx) throws IOException {
        int zzDa = zzDa();
        if (this.zzbbW >= this.zzbbX) {
            throw zzrw.zzDv();
        }
        zzDa = zzll(zzDa);
        this.zzbbW++;
        com_google_android_gms_internal_zzrx.zzb(this);
        zzli(0);
        this.zzbbW--;
        zzlm(zzDa);
    }

    public void zza(zzrx com_google_android_gms_internal_zzrx, int i) throws IOException {
        if (this.zzbbW >= this.zzbbX) {
            throw zzrw.zzDv();
        }
        this.zzbbW++;
        com_google_android_gms_internal_zzrx.zzb(this);
        zzli(zzsa.zzE(i, 4));
        this.zzbbW--;
    }

    public void zzli(int i) throws zzrw {
        if (this.zzbbU != i) {
            throw zzrw.zzDt();
        }
    }

    public boolean zzlj(int i) throws IOException {
        switch (zzsa.zzlD(i)) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                zzCW();
                return true;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                zzDd();
                return true;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                zzlp(zzDa());
                return true;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                zzCU();
                zzli(zzsa.zzE(zzsa.zzlE(i), 4));
                return true;
            case Barcode.PHONE /*4*/:
                return false;
            case Barcode.PRODUCT /*5*/:
                zzDc();
                return true;
            default:
                throw zzrw.zzDu();
        }
    }

    public int zzll(int i) throws zzrw {
        if (i < 0) {
            throw zzrw.zzDq();
        }
        int i2 = this.zzbbT + i;
        int i3 = this.zzbbV;
        if (i2 > i3) {
            throw zzrw.zzDp();
        }
        this.zzbbV = i2;
        zzDe();
        return i3;
    }

    public void zzlm(int i) {
        this.zzbbV = i;
        zzDe();
    }

    public void zzln(int i) {
        if (i > this.zzbbT - this.zzbbQ) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbbT - this.zzbbQ));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzbbT = this.zzbbQ + i;
        }
    }

    public byte[] zzlo(int i) throws IOException {
        if (i < 0) {
            throw zzrw.zzDq();
        } else if (this.zzbbT + i > this.zzbbV) {
            zzlp(this.zzbbV - this.zzbbT);
            throw zzrw.zzDp();
        } else if (i <= this.zzbbR - this.zzbbT) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.zzbbT, obj, 0, i);
            this.zzbbT += i;
            return obj;
        } else {
            throw zzrw.zzDp();
        }
    }

    public void zzlp(int i) throws IOException {
        if (i < 0) {
            throw zzrw.zzDq();
        } else if (this.zzbbT + i > this.zzbbV) {
            zzlp(this.zzbbV - this.zzbbT);
            throw zzrw.zzDp();
        } else if (i <= this.zzbbR - this.zzbbT) {
            this.zzbbT += i;
        } else {
            throw zzrw.zzDp();
        }
    }

    public byte[] zzy(int i, int i2) {
        if (i2 == 0) {
            return zzsa.zzbcu;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.zzbbQ + i, obj, 0, i2);
        return obj;
    }
}
