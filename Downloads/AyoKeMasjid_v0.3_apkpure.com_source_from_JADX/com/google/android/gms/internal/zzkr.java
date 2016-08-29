package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.drive.events.CompletionEvent;

public final class zzkr extends Drawable implements Callback {
    private int mFrom;
    private long zzMS;
    private boolean zzabV;
    private int zzacc;
    private int zzacd;
    private int zzace;
    private int zzacf;
    private int zzacg;
    private boolean zzach;
    private zzb zzaci;
    private Drawable zzacj;
    private Drawable zzack;
    private boolean zzacl;
    private boolean zzacm;
    private boolean zzacn;
    private int zzaco;

    private static final class zza extends Drawable {
        private static final zza zzacp;
        private static final zza zzacq;

        private static final class zza extends ConstantState {
            private zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.zzacp;
            }
        }

        static {
            zzacp = new zza();
            zzacq = new zza();
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return zzacq;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    static final class zzb extends ConstantState {
        int zzacr;
        int zzacs;

        zzb(zzb com_google_android_gms_internal_zzkr_zzb) {
            if (com_google_android_gms_internal_zzkr_zzb != null) {
                this.zzacr = com_google_android_gms_internal_zzkr_zzb.zzacr;
                this.zzacs = com_google_android_gms_internal_zzkr_zzb.zzacs;
            }
        }

        public int getChangingConfigurations() {
            return this.zzacr;
        }

        public Drawable newDrawable() {
            return new zzkr(this);
        }
    }

    public zzkr(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = zza.zzacp;
        }
        this.zzacj = drawable;
        drawable.setCallback(this);
        zzb com_google_android_gms_internal_zzkr_zzb = this.zzaci;
        com_google_android_gms_internal_zzkr_zzb.zzacs |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zza.zzacp;
        }
        this.zzack = drawable2;
        drawable2.setCallback(this);
        com_google_android_gms_internal_zzkr_zzb = this.zzaci;
        com_google_android_gms_internal_zzkr_zzb.zzacs |= drawable2.getChangingConfigurations();
    }

    zzkr(zzb com_google_android_gms_internal_zzkr_zzb) {
        this.zzacc = 0;
        this.zzace = MotionEventCompat.ACTION_MASK;
        this.zzacg = 0;
        this.zzabV = true;
        this.zzaci = new zzb(com_google_android_gms_internal_zzkr_zzb);
    }

    public boolean canConstantState() {
        if (!this.zzacl) {
            boolean z = (this.zzacj.getConstantState() == null || this.zzack.getConstantState() == null) ? false : true;
            this.zzacm = z;
            this.zzacl = true;
        }
        return this.zzacm;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.zzacc) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                this.zzMS = SystemClock.uptimeMillis();
                this.zzacc = 2;
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                if (this.zzMS >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzMS)) / ((float) this.zzacf);
                    if (uptimeMillis < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.zzacc = 0;
                    }
                    float min = Math.min(uptimeMillis, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                    this.zzacg = (int) ((min * ((float) (this.zzacd - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.zzacg;
        boolean z = this.zzabV;
        Drawable drawable = this.zzacj;
        Drawable drawable2 = this.zzack;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzace) {
                drawable2.setAlpha(this.zzace);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzace - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzace);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzace);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.zzaci.zzacr) | this.zzaci.zzacs;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzaci.zzacr = getChangingConfigurations();
        return this.zzaci;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.zzacj.getIntrinsicHeight(), this.zzack.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.zzacj.getIntrinsicWidth(), this.zzack.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.zzacn) {
            this.zzaco = Drawable.resolveOpacity(this.zzacj.getOpacity(), this.zzack.getOpacity());
            this.zzacn = true;
        }
        return this.zzaco;
    }

    public void invalidateDrawable(Drawable who) {
        if (zzlv.zzpO()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.zzach && super.mutate() == this) {
            if (canConstantState()) {
                this.zzacj.mutate();
                this.zzack.mutate();
                this.zzach = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.zzacj.setBounds(bounds);
        this.zzack.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (zzlv.zzpO()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.zzacg == this.zzace) {
            this.zzacg = alpha;
        }
        this.zzace = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.zzacj.setColorFilter(cf);
        this.zzack.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.zzacd = this.zzace;
        this.zzacg = 0;
        this.zzacf = durationMillis;
        this.zzacc = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (zzlv.zzpO()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }

    public Drawable zzod() {
        return this.zzack;
    }
}
