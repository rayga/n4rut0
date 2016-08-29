package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzaLg;
    private int zzaLh;
    private int zzaLi;
    private OnPlusOneClickListener zzaLj;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzaLk;
        final /* synthetic */ PlusOneButton zzaLl;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.zzaLl = plusOneButton;
            this.zzaLk = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.zzaLl.zzaLg.getTag();
            if (this.zzaLk != null) {
                this.zzaLk.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.zzaLl.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.zzaLl.zzaLi);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.zzaLh = getAnnotation(context, attrs);
        this.zzaLi = DEFAULT_ACTIVITY_REQUEST_CODE;
        zzah(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String zza = zzae.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(zza)) {
            return SIZE_TALL;
        }
        return !"NONE".equalsIgnoreCase(zza) ? SIZE_MEDIUM : SIZE_SMALL;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String zza = zzae.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(zza)) {
            return SIZE_SMALL;
        }
        if ("MEDIUM".equalsIgnoreCase(zza)) {
            return SIZE_MEDIUM;
        }
        return "TALL".equalsIgnoreCase(zza) ? SIZE_TALL : SIZE_STANDARD;
    }

    private void zzah(Context context) {
        if (this.zzaLg != null) {
            removeView(this.zzaLg);
        }
        this.zzaLg = zzg.zza(context, this.mSize, this.zzaLh, this.zzF, this.zzaLi);
        setOnPlusOneClickListener(this.zzaLj);
        addView(this.zzaLg);
    }

    public void initialize(String url, int activityRequestCode) {
        zzx.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = url;
        this.zzaLi = activityRequestCode;
        zzah(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.zzF = url;
        this.zzaLi = SIZE_SMALL;
        zzah(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.zzaLg.layout(SIZE_SMALL, SIZE_SMALL, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.zzaLg;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzaLg.performClick();
    }

    public void setAnnotation(int annotation) {
        this.zzaLh = annotation;
        zzah(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzaLg.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.zzaLj = listener;
        this.zzaLg.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        zzah(getContext());
    }
}
