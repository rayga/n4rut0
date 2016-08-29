package org.bpmikc.akm.RecyclerView.Utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

abstract class ClickItemTouchListener implements OnItemTouchListener {
    private static final String LOGTAG = "ClickItemTouchListener";
    private final GestureDetectorCompat mGestureDetector;

    private class ItemClickGestureListener extends SimpleOnGestureListener {
        private final RecyclerView mHostView;
        private View mTargetChild;

        public ItemClickGestureListener(RecyclerView hostView) {
            this.mHostView = hostView;
        }

        public void dispatchSingleTapUpIfNeeded(MotionEvent event) {
            if (this.mTargetChild != null) {
                onSingleTapUp(event);
            }
        }

        public boolean onDown(MotionEvent event) {
            this.mTargetChild = this.mHostView.findChildViewUnder((float) ((int) event.getX()), (float) ((int) event.getY()));
            return this.mTargetChild != null;
        }

        public void onShowPress(MotionEvent event) {
            if (this.mTargetChild != null) {
                this.mTargetChild.setPressed(true);
            }
        }

        public boolean onSingleTapUp(MotionEvent event) {
            if (this.mTargetChild == null) {
                return false;
            }
            this.mTargetChild.setPressed(false);
            int position = this.mHostView.getChildPosition(this.mTargetChild);
            boolean handled = ClickItemTouchListener.this.performItemClick(this.mHostView, this.mTargetChild, position, this.mHostView.getAdapter().getItemId(position));
            this.mTargetChild = null;
            return handled;
        }

        public boolean onScroll(MotionEvent event, MotionEvent event2, float v, float v2) {
            if (this.mTargetChild == null) {
                return false;
            }
            this.mTargetChild.setPressed(false);
            this.mTargetChild = null;
            return true;
        }

        public void onLongPress(MotionEvent event) {
            if (this.mTargetChild != null) {
                int position = this.mHostView.getChildPosition(this.mTargetChild);
                if (ClickItemTouchListener.this.performItemLongClick(this.mHostView, this.mTargetChild, position, this.mHostView.getAdapter().getItemId(position))) {
                    this.mTargetChild.setPressed(false);
                    this.mTargetChild = null;
                }
            }
        }
    }

    private class ItemClickGestureDetector extends GestureDetectorCompat {
        private final ItemClickGestureListener mGestureListener;

        public ItemClickGestureDetector(Context context, ItemClickGestureListener listener) {
            super(context, listener);
            this.mGestureListener = listener;
        }

        public boolean onTouchEvent(MotionEvent event) {
            boolean handled = super.onTouchEvent(event);
            if ((event.getAction() & MotionEventCompat.ACTION_MASK) == 1) {
                this.mGestureListener.dispatchSingleTapUpIfNeeded(event);
            }
            return handled;
        }
    }

    abstract boolean performItemClick(RecyclerView recyclerView, View view, int i, long j);

    abstract boolean performItemLongClick(RecyclerView recyclerView, View view, int i, long j);

    ClickItemTouchListener(RecyclerView hostView) {
        this.mGestureDetector = new ItemClickGestureDetector(hostView.getContext(), new ItemClickGestureListener(hostView));
    }

    private boolean isAttachedToWindow(RecyclerView hostView) {
        if (VERSION.SDK_INT >= 19) {
            return hostView.isAttachedToWindow();
        }
        return hostView.getHandler() != null;
    }

    private boolean hasAdapter(RecyclerView hostView) {
        return hostView.getAdapter() != null;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
        if (isAttachedToWindow(recyclerView) && hasAdapter(recyclerView)) {
            this.mGestureDetector.onTouchEvent(event);
        }
        return false;
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent event) {
    }
}
