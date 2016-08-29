package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.drive.events.CompletionEvent;

public final class zzkt extends ImageView {
    private Uri zzact;
    private int zzacu;
    private int zzacv;
    private zza zzacw;
    private int zzacx;
    private float zzacy;

    public interface zza {
        Path zzl(int i, int i2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.zzacw != null) {
            canvas.clipPath(this.zzacw.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzacv != 0) {
            canvas.drawColor(this.zzacv);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.zzacx) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                measuredHeight = getMeasuredHeight();
                i = (int) (((float) measuredHeight) * this.zzacy);
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                i = getMeasuredWidth();
                measuredHeight = (int) (((float) i) / this.zzacy);
                break;
            default:
                return;
        }
        setMeasuredDimension(i, measuredHeight);
    }

    public void zzbv(int i) {
        this.zzacu = i;
    }

    public void zzj(Uri uri) {
        this.zzact = uri;
    }

    public int zzof() {
        return this.zzacu;
    }
}
