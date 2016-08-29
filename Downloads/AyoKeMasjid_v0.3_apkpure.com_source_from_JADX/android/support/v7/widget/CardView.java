package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.cardview.C0108R;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.bumptech.glide.request.target.Target;

public class CardView extends FrameLayout implements CardViewDelegate {
    private static final CardViewImpl IMPL;
    private boolean mCompatPadding;
    private final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    private final Rect mShadowBounds;

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new CardViewApi21();
        } else if (VERSION.SDK_INT >= 17) {
            IMPL = new CardViewJellybeanMr1();
        } else {
            IMPL = new CardViewEclairMr1();
        }
        IMPL.initStatic();
    }

    public CardView(Context context) {
        super(context);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        initialize(context, null, 0);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        initialize(context, attrs, 0);
    }

    public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        initialize(context, attrs, defStyleAttr);
    }

    public void setPadding(int left, int top, int right, int bottom) {
    }

    public void setPaddingRelative(int start, int top, int end, int bottom) {
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.mCompatPadding != useCompatPadding) {
            this.mCompatPadding = useCompatPadding;
            IMPL.onCompatPaddingChanged(this);
        }
    }

    public void setContentPadding(int left, int top, int right, int bottom) {
        this.mContentPadding.set(left, top, right, bottom);
        IMPL.updatePadding(this);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (IMPL instanceof CardViewApi21) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case Target.SIZE_ORIGINAL /*-2147483648*/:
            case 1073741824:
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinWidth(this)), MeasureSpec.getSize(widthMeasureSpec)), widthMode);
                break;
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case Target.SIZE_ORIGINAL /*-2147483648*/:
            case 1073741824:
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.getMinHeight(this)), MeasureSpec.getSize(heightMeasureSpec)), heightMode);
                break;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.obtainStyledAttributes(attrs, C0108R.styleable.CardView, defStyleAttr, C0108R.style.CardView_Light);
        int backgroundColor = a.getColor(C0108R.styleable.CardView_cardBackgroundColor, 0);
        float radius = a.getDimension(C0108R.styleable.CardView_cardCornerRadius, 0.0f);
        float elevation = a.getDimension(C0108R.styleable.CardView_cardElevation, 0.0f);
        float maxElevation = a.getDimension(C0108R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = a.getBoolean(C0108R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = a.getBoolean(C0108R.styleable.CardView_cardPreventCornerOverlap, true);
        int defaultPadding = a.getDimensionPixelSize(C0108R.styleable.CardView_contentPadding, 0);
        this.mContentPadding.left = a.getDimensionPixelSize(C0108R.styleable.CardView_contentPaddingLeft, defaultPadding);
        this.mContentPadding.top = a.getDimensionPixelSize(C0108R.styleable.CardView_contentPaddingTop, defaultPadding);
        this.mContentPadding.right = a.getDimensionPixelSize(C0108R.styleable.CardView_contentPaddingRight, defaultPadding);
        this.mContentPadding.bottom = a.getDimensionPixelSize(C0108R.styleable.CardView_contentPaddingBottom, defaultPadding);
        if (elevation > maxElevation) {
            maxElevation = elevation;
        }
        a.recycle();
        IMPL.initialize(this, context, backgroundColor, radius, elevation, maxElevation);
    }

    public void setCardBackgroundColor(int color) {
        IMPL.setBackgroundColor(this, color);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float radius) {
        IMPL.setRadius(this, radius);
    }

    public float getRadius() {
        return IMPL.getRadius(this);
    }

    public void setShadowPadding(int left, int top, int right, int bottom) {
        this.mShadowBounds.set(left, top, right, bottom);
        super.setPadding(this.mContentPadding.left + left, this.mContentPadding.top + top, this.mContentPadding.right + right, this.mContentPadding.bottom + bottom);
    }

    public void setCardElevation(float radius) {
        IMPL.setElevation(this, radius);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this);
    }

    public void setMaxCardElevation(float radius) {
        IMPL.setMaxElevation(this, radius);
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean preventCornerOverlap) {
        if (preventCornerOverlap != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = preventCornerOverlap;
            IMPL.onPreventCornerOverlapChanged(this);
        }
    }
}
