package org.bpmikc.akm.View;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class PagerContainer extends FrameLayout implements OnPageChangeListener {
    private Point mCenter;
    private Point mInitialTouch;
    boolean mNeedsRedraw;
    private ViewPager mPager;

    public PagerContainer(Context context) {
        super(context);
        this.mNeedsRedraw = false;
        this.mCenter = new Point();
        this.mInitialTouch = new Point();
        init();
    }

    public PagerContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mNeedsRedraw = false;
        this.mCenter = new Point();
        this.mInitialTouch = new Point();
        init();
    }

    public PagerContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mNeedsRedraw = false;
        this.mCenter = new Point();
        this.mInitialTouch = new Point();
        init();
    }

    private void init() {
        setClipChildren(false);
        setLayerType(1, null);
    }

    protected void onFinishInflate() {
        try {
            this.mPager = (ViewPager) getChildAt(0);
            this.mPager.setOnPageChangeListener(this);
        } catch (Exception e) {
            throw new IllegalStateException("The root child of PagerContainer must be a ViewPager");
        }
    }

    public ViewPager getViewPager() {
        return this.mPager;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mCenter.x = w / 2;
        this.mCenter.y = h / 2;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                this.mInitialTouch.x = (int) ev.getX();
                this.mInitialTouch.y = (int) ev.getY();
                break;
        }
        ev.offsetLocation((float) (this.mCenter.x - this.mInitialTouch.x), (float) (this.mCenter.y - this.mInitialTouch.y));
        return this.mPager.dispatchTouchEvent(ev);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (this.mNeedsRedraw) {
            invalidate();
        }
    }

    public void onPageSelected(int position) {
    }

    public void onPageScrollStateChanged(int state) {
        this.mNeedsRedraw = state != 0;
    }
}
