package com.bumptech.glide.gifencoder;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.io.OutputStream;

class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    byte[] accum;
    boolean clear_flg;
    int[] codetab;
    private int curPixel;
    int cur_accum;
    int cur_bits;
    int free_ent;
    int g_init_bits;
    int hsize;
    int[] htab;
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int[] masks;
    int maxbits;
    int maxcode;
    int maxmaxcode;
    int n_bits;
    private byte[] pixAry;
    private int remaining;

    LZWEncoder(int width, int height, byte[] pixels, int color_depth) {
        this.maxbits = BITS;
        this.maxmaxcode = Connections.MAX_RELIABLE_MESSAGE_LEN;
        this.htab = new int[HSIZE];
        this.codetab = new int[HSIZE];
        this.hsize = HSIZE;
        this.free_ent = 0;
        this.clear_flg = false;
        this.cur_accum = 0;
        this.cur_bits = 0;
        this.masks = new int[]{0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, Place.TYPE_SUBLOCALITY_LEVEL_1, 2047, 4095, 8191, 16383, 32767, GameRequest.TYPE_ALL};
        this.accum = new byte[Barcode.QR_CODE];
        this.imgW = width;
        this.imgH = height;
        this.pixAry = pixels;
        this.initCodeSize = Math.max(2, color_depth);
    }

    void char_out(byte c, OutputStream outs) throws IOException {
        byte[] bArr = this.accum;
        int i = this.a_count;
        this.a_count = i + 1;
        bArr[i] = c;
        if (this.a_count >= 254) {
            flush_char(outs);
        }
    }

    void cl_block(OutputStream outs) throws IOException {
        cl_hash(this.hsize);
        this.free_ent = this.ClearCode + 2;
        this.clear_flg = true;
        output(this.ClearCode, outs);
    }

    void cl_hash(int hsize) {
        for (int i = 0; i < hsize; i++) {
            this.htab[i] = EOF;
        }
    }

    void compress(int init_bits, OutputStream outs) throws IOException {
        int fcode;
        this.g_init_bits = init_bits;
        this.clear_flg = false;
        this.n_bits = this.g_init_bits;
        this.maxcode = MAXCODE(this.n_bits);
        this.ClearCode = 1 << (init_bits + EOF);
        this.EOFCode = this.ClearCode + 1;
        this.free_ent = this.ClearCode + 2;
        this.a_count = 0;
        int ent = nextPixel();
        int hshift = 0;
        for (fcode = this.hsize; fcode < ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH; fcode *= 2) {
            hshift++;
        }
        hshift = 8 - hshift;
        int hsize_reg = this.hsize;
        cl_hash(hsize_reg);
        output(this.ClearCode, outs);
        while (true) {
            int c = nextPixel();
            if (c != EOF) {
                fcode = (c << this.maxbits) + ent;
                int i = (c << hshift) ^ ent;
                if (this.htab[i] == fcode) {
                    ent = this.codetab[i];
                } else if (this.htab[i] >= 0) {
                    int disp = hsize_reg - i;
                    if (i == 0) {
                        disp = 1;
                    }
                    do {
                        i -= disp;
                        if (i < 0) {
                            i += hsize_reg;
                        }
                        if (this.htab[i] == fcode) {
                            ent = this.codetab[i];
                            break;
                        }
                    } while (this.htab[i] >= 0);
                    output(ent, outs);
                    ent = c;
                    if (this.free_ent >= this.maxmaxcode) {
                        r7 = this.codetab;
                        r8 = this.free_ent;
                        this.free_ent = r8 + 1;
                        r7[i] = r8;
                        this.htab[i] = fcode;
                    } else {
                        cl_block(outs);
                    }
                } else {
                    output(ent, outs);
                    ent = c;
                    if (this.free_ent >= this.maxmaxcode) {
                        cl_block(outs);
                    } else {
                        r7 = this.codetab;
                        r8 = this.free_ent;
                        this.free_ent = r8 + 1;
                        r7[i] = r8;
                        this.htab[i] = fcode;
                    }
                }
            } else {
                output(ent, outs);
                output(this.EOFCode, outs);
                return;
            }
        }
    }

    void encode(OutputStream os) throws IOException {
        os.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, os);
        os.write(0);
    }

    void flush_char(OutputStream outs) throws IOException {
        if (this.a_count > 0) {
            outs.write(this.a_count);
            outs.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    final int MAXCODE(int n_bits) {
        return (1 << n_bits) + EOF;
    }

    private int nextPixel() {
        if (this.remaining == 0) {
            return EOF;
        }
        this.remaining += EOF;
        byte[] bArr = this.pixAry;
        int i = this.curPixel;
        this.curPixel = i + 1;
        return bArr[i] & MotionEventCompat.ACTION_MASK;
    }

    void output(int code, OutputStream outs) throws IOException {
        this.cur_accum &= this.masks[this.cur_bits];
        if (this.cur_bits > 0) {
            this.cur_accum |= code << this.cur_bits;
        } else {
            this.cur_accum = code;
        }
        this.cur_bits += this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & MotionEventCompat.ACTION_MASK), outs);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i = this.g_init_bits;
                this.n_bits = i;
                this.maxcode = MAXCODE(i);
                this.clear_flg = false;
            } else {
                this.n_bits++;
                if (this.n_bits == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                } else {
                    this.maxcode = MAXCODE(this.n_bits);
                }
            }
        }
        if (code == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & MotionEventCompat.ACTION_MASK), outs);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outs);
        }
    }
}
