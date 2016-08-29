package android.support.v7.widget;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.android.volley.DefaultRetryPolicy;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;
    private static final Interpolator sQuinticInterpolator;
    private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private OnItemTouchListener mActiveOnItemTouchListener;
    private Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    private boolean mAdapterUpdateDuringMeasure;
    private EdgeEffectCompat mBottomGlow;
    ChildHelper mChildHelper;
    private boolean mClipToPadding;
    private boolean mDataSetHasChangedAfterLayout;
    final List<View> mDisappearingViewsInLayoutPass;
    private boolean mEatRequestLayout;
    private boolean mFirstLayoutComplete;
    private boolean mHasFixedSize;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    private LayoutManager mLayout;
    private boolean mLayoutRequestEaten;
    private EdgeEffectCompat mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final RecyclerViewDataObserver mObserver;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private final boolean mPostUpdatesOnAnimation;
    private boolean mPostedAnimatorRunner;
    final Recycler mRecycler;
    private RecyclerListener mRecyclerListener;
    private EdgeEffectCompat mRightGlow;
    private boolean mRunningLayoutOrScroll;
    private OnScrollListener mScrollListener;
    private int mScrollPointerId;
    private int mScrollState;
    final State mState;
    private final Rect mTempRect;
    private EdgeEffectCompat mTopGlow;
    private int mTouchSlop;
    private final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    private final ViewFlinger mViewFlinger;

    /* renamed from: android.support.v7.widget.RecyclerView.1 */
    class C01521 implements Runnable {
        C01521() {
        }

        public void run() {
            if (!RecyclerView.this.mFirstLayoutComplete) {
                return;
            }
            if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                RecyclerView.this.dispatchLayout();
            } else if (RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.eatRequestLayout();
                RecyclerView.this.mAdapterHelper.preProcess();
                if (!RecyclerView.this.mLayoutRequestEaten) {
                    RecyclerView.this.rebindUpdatedViewHolders();
                }
                RecyclerView.this.resumeRequestLayout(true);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.2 */
    class C01532 implements Runnable {
        C01532() {
        }

        public void run() {
            if (RecyclerView.this.mItemAnimator != null) {
                RecyclerView.this.mItemAnimator.runPendingAnimations();
            }
            RecyclerView.this.mPostedAnimatorRunner = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.3 */
    static class C01543 implements Interpolator {
        C01543() {
        }

        public float getInterpolation(float t) {
            t -= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            return ((((t * t) * t) * t) * t) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;

        public abstract int getItemCount();

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public final VH createViewHolder(ViewGroup parent, int viewType) {
            VH holder = onCreateViewHolder(parent, viewType);
            holder.mItemViewType = viewType;
            return holder;
        }

        public final void bindViewHolder(VH holder, int position) {
            holder.mPosition = position;
            if (hasStableIds()) {
                holder.mItemId = getItemId(position);
            }
            onBindViewHolder(holder, position);
            holder.setFlags(RecyclerView.VERTICAL, 7);
        }

        public int getItemViewType(int position) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void setHasStableIds(boolean hasStableIds) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = hasStableIds;
        }

        public long getItemId(int position) {
            return RecyclerView.NO_ID;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public void onViewRecycled(VH vh) {
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public void registerAdapterDataObserver(AdapterDataObserver observer) {
            this.mObservable.registerObserver(observer);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver observer) {
            this.mObservable.unregisterObserver(observer);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int position) {
            this.mObservable.notifyItemRangeChanged(position, RecyclerView.VERTICAL);
        }

        public final void notifyItemRangeChanged(int positionStart, int itemCount) {
            this.mObservable.notifyItemRangeChanged(positionStart, itemCount);
        }

        public final void notifyItemInserted(int position) {
            this.mObservable.notifyItemRangeInserted(position, RecyclerView.VERTICAL);
        }

        public final void notifyItemMoved(int fromPosition, int toPosition) {
            this.mObservable.notifyItemMoved(fromPosition, toPosition);
        }

        public final void notifyItemRangeInserted(int positionStart, int itemCount) {
            this.mObservable.notifyItemRangeInserted(positionStart, itemCount);
        }

        public final void notifyItemRemoved(int position) {
            this.mObservable.notifyItemRangeRemoved(position, RecyclerView.VERTICAL);
        }

        public final void notifyItemRangeRemoved(int positionStart, int itemCount) {
            this.mObservable.notifyItemRangeRemoved(positionStart, itemCount);
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty() ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void notifyChanged() {
            for (int i = this.mObservers.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                ((AdapterDataObserver) this.mObservers.get(i)).onChanged();
            }
        }

        public void notifyItemRangeChanged(int positionStart, int itemCount) {
            for (int i = this.mObservers.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                ((AdapterDataObserver) this.mObservers.get(i)).onItemRangeChanged(positionStart, itemCount);
            }
        }

        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            for (int i = this.mObservers.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                ((AdapterDataObserver) this.mObservers.get(i)).onItemRangeInserted(positionStart, itemCount);
            }
        }

        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            for (int i = this.mObservers.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                ((AdapterDataObserver) this.mObservers.get(i)).onItemRangeRemoved(positionStart, itemCount);
            }
        }

        public void notifyItemMoved(int fromPosition, int toPosition) {
            for (int i = this.mObservers.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                ((AdapterDataObserver) this.mObservers.get(i)).onItemRangeMoved(fromPosition, toPosition, RecyclerView.VERTICAL);
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int positionStart, int itemCount) {
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        }
    }

    public static abstract class ItemAnimator {
        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;
        private boolean mSupportsChangeAnimations;

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAddFinished(ViewHolder viewHolder);

            void onChangeFinished(ViewHolder viewHolder);

            void onMoveFinished(ViewHolder viewHolder);

            void onRemoveFinished(ViewHolder viewHolder);
        }

        public abstract boolean animateAdd(ViewHolder viewHolder);

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4);

        public abstract boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4);

        public abstract boolean animateRemove(ViewHolder viewHolder);

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public abstract void runPendingAnimations();

        public ItemAnimator() {
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 120;
            this.mRemoveDuration = 120;
            this.mMoveDuration = 250;
            this.mChangeDuration = 250;
            this.mSupportsChangeAnimations = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public void setMoveDuration(long moveDuration) {
            this.mMoveDuration = moveDuration;
        }

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public void setAddDuration(long addDuration) {
            this.mAddDuration = addDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public void setRemoveDuration(long removeDuration) {
            this.mRemoveDuration = removeDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public void setChangeDuration(long changeDuration) {
            this.mChangeDuration = changeDuration;
        }

        public boolean getSupportsChangeAnimations() {
            return this.mSupportsChangeAnimations;
        }

        public void setSupportsChangeAnimations(boolean supportsChangeAnimations) {
            this.mSupportsChangeAnimations = supportsChangeAnimations;
        }

        void setListener(ItemAnimatorListener listener) {
            this.mListener = listener;
        }

        public final void dispatchRemoveFinished(ViewHolder item) {
            onRemoveFinished(item);
            if (this.mListener != null) {
                this.mListener.onRemoveFinished(item);
            }
        }

        public final void dispatchMoveFinished(ViewHolder item) {
            onMoveFinished(item);
            if (this.mListener != null) {
                this.mListener.onMoveFinished(item);
            }
        }

        public final void dispatchAddFinished(ViewHolder item) {
            onAddFinished(item);
            if (this.mListener != null) {
                this.mListener.onAddFinished(item);
            }
        }

        public final void dispatchChangeFinished(ViewHolder item, boolean oldItem) {
            onChangeFinished(item, oldItem);
            if (this.mListener != null) {
                this.mListener.onChangeFinished(item);
            }
        }

        public final void dispatchRemoveStarting(ViewHolder item) {
            onRemoveStarting(item);
        }

        public final void dispatchMoveStarting(ViewHolder item) {
            onMoveStarting(item);
        }

        public final void dispatchAddStarting(ViewHolder item) {
            onAddStarting(item);
        }

        public final void dispatchChangeStarting(ViewHolder item, boolean oldItem) {
            onChangeStarting(item, oldItem);
        }

        public final boolean isRunning(ItemAnimatorFinishedListener listener) {
            boolean running = isRunning();
            if (listener != null) {
                if (running) {
                    this.mFinishedListeners.add(listener);
                } else {
                    listener.onAnimationsFinished();
                }
            }
            return running;
        }

        public final void dispatchAnimationsFinished() {
            int count = this.mFinishedListeners.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < count; i += RecyclerView.VERTICAL) {
                ((ItemAnimatorFinishedListener) this.mFinishedListeners.get(i)).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public void onRemoveStarting(ViewHolder item) {
        }

        public void onRemoveFinished(ViewHolder item) {
        }

        public void onAddStarting(ViewHolder item) {
        }

        public void onAddFinished(ViewHolder item) {
        }

        public void onMoveStarting(ViewHolder item) {
        }

        public void onMoveFinished(ViewHolder item) {
        }

        public void onChangeStarting(ViewHolder item, boolean oldItem) {
        }

        public void onChangeFinished(ViewHolder item, boolean oldItem) {
        }
    }

    public static abstract class ItemDecoration {
        public void onDraw(Canvas c, RecyclerView parent, State state) {
            onDraw(c, parent);
        }

        @Deprecated
        public void onDraw(Canvas c, RecyclerView parent) {
        }

        public void onDrawOver(Canvas c, RecyclerView parent, State state) {
            onDrawOver(c, parent);
        }

        @Deprecated
        public void onDrawOver(Canvas c, RecyclerView parent) {
        }

        @Deprecated
        public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
            outRect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
            getItemOffsets(outRect, ((LayoutParams) view.getLayoutParams()).getViewPosition(), parent);
        }
    }

    private static class ItemHolderInfo {
        int bottom;
        ViewHolder holder;
        int left;
        int right;
        int top;

        ItemHolderInfo(ViewHolder holder, int left, int top, int right, int bottom) {
            this.holder = holder;
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    public static abstract class LayoutManager {
        ChildHelper mChildHelper;
        RecyclerView mRecyclerView;
        private boolean mRequestedSimpleAnimations;
        @Nullable
        SmoothScroller mSmoothScroller;

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutManager() {
            this.mRequestedSimpleAnimations = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                return;
            }
            this.mRecyclerView = recyclerView;
            this.mChildHelper = recyclerView.mChildHelper;
        }

        public void requestLayout() {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String message) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertInLayoutOrScroll(message);
            }
        }

        public void assertNotInLayoutOrScroll(String message) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertNotInLayoutOrScroll(message);
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void onAttachedToWindow(RecyclerView view) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView view) {
        }

        public void onDetachedFromWindow(RecyclerView view, Recycler recycler) {
            onDetachedFromWindow(view);
        }

        public boolean getClipToPadding() {
            return (this.mRecyclerView == null || !this.mRecyclerView.mClipToPadding) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public boolean checkLayoutParams(LayoutParams lp) {
            return lp != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) {
            if (lp instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) lp);
            }
            if (lp instanceof MarginLayoutParams) {
                return new LayoutParams((MarginLayoutParams) lp);
            }
            return new LayoutParams(lp);
        }

        public LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
            return new LayoutParams(c, attrs);
        }

        public int scrollHorizontallyBy(int dx, Recycler recycler, State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int scrollVerticallyBy(int dy, Recycler recycler, State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public boolean canScrollHorizontally() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean canScrollVertically() {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void scrollToPosition(int position) {
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int position) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            if (!(this.mSmoothScroller == null || smoothScroller == this.mSmoothScroller || !this.mSmoothScroller.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            return (this.mSmoothScroller == null || !this.mSmoothScroller.isRunning()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View child) {
            addDisappearingView(child, RecyclerView.NO_POSITION);
        }

        public void addDisappearingView(View child, int index) {
            addViewInt(child, index, true);
        }

        public void addView(View child) {
            addView(child, RecyclerView.NO_POSITION);
        }

        public void addView(View child, int index) {
            addViewInt(child, index, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        private void addViewInt(View child, int index, boolean disappearing) {
            ViewHolder holder = RecyclerView.getChildViewHolderInt(child);
            if (disappearing || holder.isRemoved()) {
                this.mRecyclerView.addToDisappearingList(child);
            } else {
                this.mRecyclerView.removeFromDisappearingList(child);
            }
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (holder.wasReturnedFromScrap() || holder.isScrap()) {
                if (holder.isScrap()) {
                    holder.unScrap();
                } else {
                    holder.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(child, index, child.getLayoutParams(), RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            } else if (child.getParent() == this.mRecyclerView) {
                int currentIndex = this.mChildHelper.indexOfChild(child);
                if (index == RecyclerView.NO_POSITION) {
                    index = this.mChildHelper.getChildCount();
                }
                if (currentIndex == RecyclerView.NO_POSITION) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(child));
                } else if (currentIndex != index) {
                    this.mRecyclerView.mLayout.moveView(currentIndex, index);
                }
            } else {
                this.mChildHelper.addView(child, index, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                lp.mInsetsDirty = true;
                if (this.mSmoothScroller != null && this.mSmoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(child);
                }
            }
            if (lp.mPendingInvalidate) {
                holder.itemView.invalidate();
                lp.mPendingInvalidate = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        public void removeView(View child) {
            this.mChildHelper.removeView(child);
        }

        public void removeViewAt(int index) {
            if (getChildAt(index) != null) {
                this.mChildHelper.removeViewAt(index);
            }
        }

        public void removeAllViews() {
            for (int i = getChildCount() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                View child = getChildAt(i);
                this.mChildHelper.removeViewAt(i);
            }
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewPosition();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findViewByPosition(int position) {
            int childCount = getChildCount();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < childCount; i += RecyclerView.VERTICAL) {
                View child = getChildAt(i);
                ViewHolder vh = RecyclerView.getChildViewHolderInt(child);
                if (vh != null && vh.getPosition() == position && !vh.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !vh.isRemoved())) {
                    return child;
                }
            }
            return null;
        }

        public void detachView(View child) {
            int ind = this.mChildHelper.indexOfChild(child);
            if (ind >= 0) {
                detachViewInternal(ind, child);
            }
        }

        public void detachViewAt(int index) {
            detachViewInternal(index, getChildAt(index));
        }

        private void detachViewInternal(int index, View view) {
            this.mChildHelper.detachViewFromParent(index);
        }

        public void attachView(View child, int index, LayoutParams lp) {
            ViewHolder vh = RecyclerView.getChildViewHolderInt(child);
            if (vh.isRemoved()) {
                this.mRecyclerView.addToDisappearingList(child);
            } else {
                this.mRecyclerView.removeFromDisappearingList(child);
            }
            this.mChildHelper.attachViewToParent(child, index, lp, vh.isRemoved());
        }

        public void attachView(View child, int index) {
            attachView(child, index, (LayoutParams) child.getLayoutParams());
        }

        public void attachView(View child) {
            attachView(child, RecyclerView.NO_POSITION);
        }

        public void removeDetachedView(View child) {
            this.mRecyclerView.removeDetachedView(child, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        public void moveView(int fromIndex, int toIndex) {
            View view = getChildAt(fromIndex);
            if (view == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + fromIndex);
            }
            detachViewAt(fromIndex);
            attachView(view, toIndex);
        }

        public void detachAndScrapView(View child, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(child), child);
        }

        public void detachAndScrapViewAt(int index, Recycler recycler) {
            scrapOrRecycleView(recycler, index, getChildAt(index));
        }

        public void removeAndRecycleView(View child, Recycler recycler) {
            removeView(child);
            recycler.recycleView(child);
        }

        public void removeAndRecycleViewAt(int index, Recycler recycler) {
            View view = getChildAt(index);
            removeViewAt(index);
            recycler.recycleView(view);
        }

        public int getChildCount() {
            return this.mChildHelper != null ? this.mChildHelper.getChildCount() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public View getChildAt(int index) {
            return this.mChildHelper != null ? this.mChildHelper.getChildAt(index) : null;
        }

        public int getWidth() {
            return this.mRecyclerView != null ? this.mRecyclerView.getWidth() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getHeight() {
            return this.mRecyclerView != null ? this.mRecyclerView.getHeight() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingLeft() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingLeft() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingTop() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingTop() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingRight() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingRight() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingBottom() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingBottom() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingStart() {
            return this.mRecyclerView != null ? ViewCompat.getPaddingStart(this.mRecyclerView) : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getPaddingEnd() {
            return this.mRecyclerView != null ? ViewCompat.getPaddingEnd(this.mRecyclerView) : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public boolean isFocused() {
            return (this.mRecyclerView == null || !this.mRecyclerView.isFocused()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public boolean hasFocus() {
            return (this.mRecyclerView == null || !this.mRecyclerView.hasFocus()) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }

        public View getFocusedChild() {
            if (this.mRecyclerView == null) {
                return null;
            }
            View focused = this.mRecyclerView.getFocusedChild();
            if (focused == null || this.mChildHelper.isHidden(focused)) {
                return null;
            }
            return focused;
        }

        public int getItemCount() {
            Adapter a = this.mRecyclerView != null ? this.mRecyclerView.getAdapter() : null;
            return a != null ? a.getItemCount() : RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void offsetChildrenHorizontal(int dx) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.offsetChildrenHorizontal(dx);
            }
        }

        public void offsetChildrenVertical(int dy) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.offsetChildrenVertical(dy);
            }
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.mRecyclerView || this.mRecyclerView.indexOfChild(view) == RecyclerView.NO_POSITION) {
                throw new IllegalArgumentException("View should be fully attached to be ignored");
            }
            ViewHolder vh = RecyclerView.getChildViewHolderInt(view);
            vh.addFlags(Barcode.ITF);
            this.mRecyclerView.mState.onViewIgnored(vh);
        }

        public void stopIgnoringView(View view) {
            ViewHolder vh = RecyclerView.getChildViewHolderInt(view);
            vh.stopIgnoring();
            vh.resetInternal();
            vh.addFlags(4);
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int i = getChildCount() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                scrapOrRecycleView(recycler, i, getChildAt(i));
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int index, View view) {
            ViewHolder viewHolder = RecyclerView.getChildViewHolderInt(view);
            if (!viewHolder.shouldIgnore()) {
                if (!viewHolder.isInvalid() || viewHolder.isRemoved() || viewHolder.isChanged() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(index);
                    recycler.scrapView(view);
                    return;
                }
                removeViewAt(index);
                recycler.recycleViewHolderInternal(viewHolder);
            }
        }

        void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < scrapCount; i += RecyclerView.VERTICAL) {
                View scrap = recycler.getScrapViewAt(i);
                ViewHolder vh = RecyclerView.getChildViewHolderInt(scrap);
                if (!vh.shouldIgnore()) {
                    if (vh.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrap, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    }
                    recycler.quickRecycleScrapView(scrap);
                }
            }
            recycler.clearScrap();
            if (scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View child, int widthUsed, int heightUsed) {
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            Rect insets = this.mRecyclerView.getItemDecorInsetsForChild(child);
            child.measure(getChildMeasureSpec(getWidth(), (getPaddingLeft() + getPaddingRight()) + (widthUsed + (insets.left + insets.right)), lp.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), (getPaddingTop() + getPaddingBottom()) + (heightUsed + (insets.top + insets.bottom)), lp.height, canScrollVertically()));
        }

        public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            Rect insets = this.mRecyclerView.getItemDecorInsetsForChild(child);
            child.measure(getChildMeasureSpec(getWidth(), (((getPaddingLeft() + getPaddingRight()) + lp.leftMargin) + lp.rightMargin) + (widthUsed + (insets.left + insets.right)), lp.width, canScrollHorizontally()), getChildMeasureSpec(getHeight(), (((getPaddingTop() + getPaddingBottom()) + lp.topMargin) + lp.bottomMargin) + (heightUsed + (insets.top + insets.bottom)), lp.height, canScrollVertically()));
        }

        public static int getChildMeasureSpec(int parentSize, int padding, int childDimension, boolean canScroll) {
            int size = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, parentSize - padding);
            int resultSize = RecyclerView.TOUCH_SLOP_DEFAULT;
            int resultMode = RecyclerView.TOUCH_SLOP_DEFAULT;
            if (canScroll) {
                if (childDimension >= 0) {
                    resultSize = childDimension;
                    resultMode = 1073741824;
                } else {
                    resultSize = RecyclerView.TOUCH_SLOP_DEFAULT;
                    resultMode = RecyclerView.TOUCH_SLOP_DEFAULT;
                }
            } else if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = 1073741824;
            } else if (childDimension == RecyclerView.NO_POSITION) {
                resultSize = size;
                resultMode = 1073741824;
            } else if (childDimension == -2) {
                resultSize = size;
                resultMode = Target.SIZE_ORIGINAL;
            }
            return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
        }

        public int getDecoratedMeasuredWidth(View child) {
            Rect insets = ((LayoutParams) child.getLayoutParams()).mDecorInsets;
            return (child.getMeasuredWidth() + insets.left) + insets.right;
        }

        public int getDecoratedMeasuredHeight(View child) {
            Rect insets = ((LayoutParams) child.getLayoutParams()).mDecorInsets;
            return (child.getMeasuredHeight() + insets.top) + insets.bottom;
        }

        public void layoutDecorated(View child, int left, int top, int right, int bottom) {
            Rect insets = ((LayoutParams) child.getLayoutParams()).mDecorInsets;
            child.layout(insets.left + left, insets.top + top, right - insets.right, bottom - insets.bottom);
        }

        public int getDecoratedLeft(View child) {
            return child.getLeft() - getLeftDecorationWidth(child);
        }

        public int getDecoratedTop(View child) {
            return child.getTop() - getTopDecorationHeight(child);
        }

        public int getDecoratedRight(View child) {
            return child.getRight() + getRightDecorationWidth(child);
        }

        public int getDecoratedBottom(View child) {
            return child.getBottom() + getBottomDecorationHeight(child);
        }

        public void calculateItemDecorationsForChild(View child, Rect outRect) {
            if (this.mRecyclerView == null) {
                outRect.set(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
            } else {
                outRect.set(this.mRecyclerView.getItemDecorInsetsForChild(child));
            }
        }

        public int getTopDecorationHeight(View child) {
            return ((LayoutParams) child.getLayoutParams()).mDecorInsets.top;
        }

        public int getBottomDecorationHeight(View child) {
            return ((LayoutParams) child.getLayoutParams()).mDecorInsets.bottom;
        }

        public int getLeftDecorationWidth(View child) {
            return ((LayoutParams) child.getLayoutParams()).mDecorInsets.left;
        }

        public int getRightDecorationWidth(View child) {
            return ((LayoutParams) child.getLayoutParams()).mDecorInsets.right;
        }

        public View onFocusSearchFailed(View focused, int direction, Recycler recycler, State state) {
            return null;
        }

        public View onInterceptFocusSearch(View focused, int direction) {
            return null;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate) {
            int dx;
            int dy;
            int parentLeft = getPaddingLeft();
            int parentTop = getPaddingTop();
            int parentRight = getWidth() - getPaddingRight();
            int parentBottom = getHeight() - getPaddingBottom();
            int childLeft = child.getLeft() + rect.left;
            int childTop = child.getTop() + rect.top;
            int childRight = childLeft + rect.width();
            int childBottom = childTop + rect.height();
            int offScreenLeft = Math.min(RecyclerView.TOUCH_SLOP_DEFAULT, childLeft - parentLeft);
            int offScreenTop = Math.min(RecyclerView.TOUCH_SLOP_DEFAULT, childTop - parentTop);
            int offScreenRight = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, childRight - parentRight);
            int offScreenBottom = Math.max(RecyclerView.TOUCH_SLOP_DEFAULT, childBottom - parentBottom);
            if (ViewCompat.getLayoutDirection(parent) != RecyclerView.VERTICAL) {
                dx = offScreenLeft != 0 ? offScreenLeft : offScreenRight;
            } else if (offScreenRight != 0) {
                dx = offScreenRight;
            } else {
                dx = offScreenLeft;
            }
            if (offScreenTop != 0) {
                dy = offScreenTop;
            } else {
                dy = offScreenBottom;
            }
            if (dx == 0 && dy == 0) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            if (immediate) {
                parent.scrollBy(dx, dy);
            } else {
                parent.smoothScrollBy(dx, dy);
            }
            return true;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView parent, View child, View focused) {
            return (isSmoothScrolling() || parent.mRunningLayoutOrScroll) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean onRequestChildFocus(RecyclerView parent, State state, View child, View focused) {
            return onRequestChildFocus(parent, child, focused);
        }

        public void onAdapterChanged(Adapter oldAdapter, Adapter newAdapter) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int direction, int focusableMode) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeHorizontalScrollOffset(State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeHorizontalScrollRange(State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeVerticalScrollExtent(State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeVerticalScrollOffset(State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int computeVerticalScrollRange(State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void onMeasure(Recycler recycler, State state, int widthSpec, int heightSpec) {
            int width;
            int height;
            int widthMode = MeasureSpec.getMode(widthSpec);
            int heightMode = MeasureSpec.getMode(heightSpec);
            int widthSize = MeasureSpec.getSize(widthSpec);
            int heightSize = MeasureSpec.getSize(heightSpec);
            switch (widthMode) {
                case Target.SIZE_ORIGINAL /*-2147483648*/:
                case 1073741824:
                    width = widthSize;
                    break;
                default:
                    width = getMinimumWidth();
                    break;
            }
            switch (heightMode) {
                case Target.SIZE_ORIGINAL /*-2147483648*/:
                case 1073741824:
                    height = heightSize;
                    break;
                default:
                    height = getMinimumHeight();
                    break;
            }
            setMeasuredDimension(width, height);
        }

        public void setMeasuredDimension(int widthSize, int heightSize) {
            this.mRecyclerView.setMeasuredDimension(widthSize, heightSize);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable state) {
        }

        void stopSmoothScroller() {
            if (this.mSmoothScroller != null) {
                this.mSmoothScroller.stop();
            }
        }

        private void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public void onScrollStateChanged(int state) {
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int i = getChildCount() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
                    removeAndRecycleViewAt(i, recycler);
                }
            }
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat info) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, info);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat info) {
            info.setClassName(RecyclerView.class.getName());
            if (ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.NO_POSITION) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.NO_POSITION)) {
                info.addAction((int) AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
                info.setScrollable(true);
            }
            if (ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.VERTICAL) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.VERTICAL)) {
                info.addAction((int) Connections.MAX_RELIABLE_MESSAGE_LEN);
                info.setScrollable(true);
            }
            info.setCollectionInfo(CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, event);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent event) {
            boolean z = true;
            AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(event);
            if (this.mRecyclerView != null && record != null) {
                if (!(ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.VERTICAL) || ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.NO_POSITION) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.NO_POSITION) || ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.VERTICAL))) {
                    z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                }
                record.setScrollable(z);
                if (this.mRecyclerView.mAdapter != null) {
                    record.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        void onInitializeAccessibilityNodeInfoForItem(View host, AccessibilityNodeInfoCompat info) {
            ViewHolder vh = RecyclerView.getChildViewHolderInt(host);
            if (vh != null && !vh.isRemoved()) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, host, info);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View host, AccessibilityNodeInfoCompat info) {
            int rowIndexGuess;
            int columnIndexGuess;
            if (canScrollVertically()) {
                rowIndexGuess = getPosition(host);
            } else {
                rowIndexGuess = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
            if (canScrollHorizontally()) {
                columnIndexGuess = getPosition(host);
            } else {
                columnIndexGuess = RecyclerView.TOUCH_SLOP_DEFAULT;
            }
            info.setCollectionItemInfo(CollectionItemInfoCompat.obtain(rowIndexGuess, RecyclerView.VERTICAL, columnIndexGuess, RecyclerView.VERTICAL, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            if (this.mRecyclerView == null || this.mRecyclerView.mAdapter == null || !canScrollVertically()) {
                return RecyclerView.VERTICAL;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            if (this.mRecyclerView == null || this.mRecyclerView.mAdapter == null || !canScrollHorizontally()) {
                return RecyclerView.VERTICAL;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean performAccessibilityAction(int action, Bundle args) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, action, args);
        }

        public boolean performAccessibilityAction(Recycler recycler, State state, int action, Bundle args) {
            if (this.mRecyclerView == null) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            int vScroll = RecyclerView.TOUCH_SLOP_DEFAULT;
            int hScroll = RecyclerView.TOUCH_SLOP_DEFAULT;
            switch (action) {
                case Connections.MAX_RELIABLE_MESSAGE_LEN /*4096*/:
                    if (ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.VERTICAL)) {
                        vScroll = (getHeight() - getPaddingTop()) - getPaddingBottom();
                    }
                    if (ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.VERTICAL)) {
                        hScroll = (getWidth() - getPaddingLeft()) - getPaddingRight();
                        break;
                    }
                    break;
                case AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD /*8192*/:
                    if (ViewCompat.canScrollVertically(this.mRecyclerView, RecyclerView.NO_POSITION)) {
                        vScroll = -((getHeight() - getPaddingTop()) - getPaddingBottom());
                    }
                    if (ViewCompat.canScrollHorizontally(this.mRecyclerView, RecyclerView.NO_POSITION)) {
                        hScroll = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                        break;
                    }
                    break;
            }
            if (vScroll == 0 && hScroll == 0) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            this.mRecyclerView.scrollBy(hScroll, vScroll);
            return true;
        }

        boolean performAccessibilityActionForItem(View view, int action, Bundle args) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, action, args);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int action, Bundle args) {
            return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super(source);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public LayoutParams(LayoutParams source) {
            super(source);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isChanged();
        }

        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        }
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        private SparseIntArray mMaxScrap;
        private SparseArray<ArrayList<ViewHolder>> mScrap;

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mMaxScrap = new SparseIntArray();
            this.mAttachCount = RecyclerView.TOUCH_SLOP_DEFAULT;
        }

        public void clear() {
            this.mScrap.clear();
        }

        public void setMaxRecycledViews(int viewType, int max) {
            this.mMaxScrap.put(viewType, max);
            ArrayList<ViewHolder> scrapHeap = (ArrayList) this.mScrap.get(viewType);
            if (scrapHeap != null) {
                while (scrapHeap.size() > max) {
                    scrapHeap.remove(scrapHeap.size() + RecyclerView.NO_POSITION);
                }
            }
        }

        public ViewHolder getRecycledView(int viewType) {
            ArrayList<ViewHolder> scrapHeap = (ArrayList) this.mScrap.get(viewType);
            if (scrapHeap == null || scrapHeap.isEmpty()) {
                return null;
            }
            int index = scrapHeap.size() + RecyclerView.NO_POSITION;
            ViewHolder scrap = (ViewHolder) scrapHeap.get(index);
            scrapHeap.remove(index);
            return scrap;
        }

        int size() {
            int count = RecyclerView.TOUCH_SLOP_DEFAULT;
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < this.mScrap.size(); i += RecyclerView.VERTICAL) {
                ArrayList<ViewHolder> viewHolders = (ArrayList) this.mScrap.valueAt(i);
                if (viewHolders != null) {
                    count += viewHolders.size();
                }
            }
            return count;
        }

        public void putRecycledView(ViewHolder scrap) {
            int viewType = scrap.getItemViewType();
            ArrayList scrapHeap = getScrapHeapForType(viewType);
            if (this.mMaxScrap.get(viewType) > scrapHeap.size()) {
                scrap.resetInternal();
                scrapHeap.add(scrap);
            }
        }

        void attach(Adapter adapter) {
            this.mAttachCount += RecyclerView.VERTICAL;
        }

        void detach() {
            this.mAttachCount += RecyclerView.NO_POSITION;
        }

        void onAdapterChanged(Adapter oldAdapter, Adapter newAdapter, boolean compatibleWithPrevious) {
            if (oldAdapter != null) {
                detach();
            }
            if (!compatibleWithPrevious && this.mAttachCount == 0) {
                clear();
            }
            if (newAdapter != null) {
                attach(newAdapter);
            }
        }

        private ArrayList<ViewHolder> getScrapHeapForType(int viewType) {
            ArrayList<ViewHolder> scrap = (ArrayList) this.mScrap.get(viewType);
            if (scrap == null) {
                scrap = new ArrayList();
                this.mScrap.put(viewType, scrap);
                if (this.mMaxScrap.indexOfKey(viewType) < 0) {
                    this.mMaxScrap.put(viewType, DEFAULT_MAX_SCRAP);
                }
            }
            return scrap;
        }
    }

    public final class Recycler {
        private static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        private ArrayList<ViewHolder> mChangedScrap;
        private RecycledViewPool mRecyclerPool;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        private int mViewCacheMax;

        public Recycler() {
            this.mAttachedScrap = new ArrayList();
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
            this.mViewCacheMax = DEFAULT_CACHE_SIZE;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void setViewCacheSize(int viewCount) {
            this.mViewCacheMax = viewCount;
            for (int i = this.mCachedViews.size() + RecyclerView.NO_POSITION; i >= 0 && this.mCachedViews.size() > viewCount; i += RecyclerView.NO_POSITION) {
                tryToRecycleCachedViewAt(i);
            }
            while (this.mCachedViews.size() > viewCount) {
                this.mCachedViews.remove(this.mCachedViews.size() + RecyclerView.NO_POSITION);
            }
        }

        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder holder) {
            if (holder.isRemoved()) {
                return true;
            }
            if (holder.mPosition < 0 || holder.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + holder);
            } else if (!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(holder.mPosition) != holder.getItemViewType()) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            } else {
                if (!RecyclerView.this.mAdapter.hasStableIds() || holder.getItemId() == RecyclerView.this.mAdapter.getItemId(holder.mPosition)) {
                    return true;
                }
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
        }

        public void bindViewToPosition(View view, int position) {
            boolean z = true;
            ViewHolder holder = RecyclerView.getChildViewHolderInt(view);
            if (holder == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
            }
            int offsetPosition = RecyclerView.this.mAdapterHelper.findPositionOffset(position);
            if (offsetPosition < 0 || offsetPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + position + "(offset:" + offsetPosition + ")." + "state:" + RecyclerView.this.mState.getItemCount());
            }
            LayoutParams rvLayoutParams;
            RecyclerView.this.mAdapter.bindViewHolder(holder, offsetPosition);
            attachAccessibilityDelegate(view);
            if (RecyclerView.this.mState.isPreLayout()) {
                holder.mPreLayoutPosition = position;
            }
            android.view.ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp == null) {
                rvLayoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                holder.itemView.setLayoutParams(rvLayoutParams);
            } else if (RecyclerView.this.checkLayoutParams(lp)) {
                rvLayoutParams = (LayoutParams) lp;
            } else {
                rvLayoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(lp);
                holder.itemView.setLayoutParams(rvLayoutParams);
            }
            rvLayoutParams.mInsetsDirty = true;
            rvLayoutParams.mViewHolder = holder;
            if (holder.itemView.getParent() != null) {
                z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            rvLayoutParams.mPendingInvalidate = z;
        }

        public int convertPreLayoutPositionToPostLayout(int position) {
            if (position >= 0 && position < RecyclerView.this.mState.getItemCount()) {
                return !RecyclerView.this.mState.isPreLayout() ? position : RecyclerView.this.mAdapterHelper.findPositionOffset(position);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + position + ". State " + "item count is " + RecyclerView.this.mState.getItemCount());
            }
        }

        public View getViewForPosition(int position) {
            return getViewForPosition(position, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
        }

        View getViewForPosition(int position, boolean dryRun) {
            boolean z = true;
            if (position < 0 || position >= RecyclerView.this.mState.getItemCount()) {
                throw new IndexOutOfBoundsException("Invalid item position " + position + "(" + position + "). Item count:" + RecyclerView.this.mState.getItemCount());
            }
            LayoutParams rvLayoutParams;
            boolean fromScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            ViewHolder holder = null;
            if (RecyclerView.this.mState.isPreLayout()) {
                holder = getChangedScrapViewForPosition(position);
                if (holder != null) {
                    fromScrap = true;
                } else {
                    fromScrap = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                }
            }
            if (holder == null) {
                holder = getScrapViewForPosition(position, RecyclerView.NO_POSITION, dryRun);
                if (holder != null) {
                    if (validateViewHolderForOffsetPosition(holder)) {
                        fromScrap = true;
                    } else {
                        if (!dryRun) {
                            holder.addFlags(4);
                            if (holder.isScrap()) {
                                RecyclerView.this.removeDetachedView(holder.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                                holder.unScrap();
                            } else if (holder.wasReturnedFromScrap()) {
                                holder.clearReturnedFromScrapFlag();
                            }
                            recycleViewHolderInternal(holder);
                        }
                        holder = null;
                    }
                }
            }
            if (holder == null) {
                int offsetPosition = RecyclerView.this.mAdapterHelper.findPositionOffset(position);
                if (offsetPosition < 0 || offsetPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + position + "(offset:" + offsetPosition + ")." + "state:" + RecyclerView.this.mState.getItemCount());
                }
                int type = RecyclerView.this.mAdapter.getItemViewType(offsetPosition);
                if (RecyclerView.this.mAdapter.hasStableIds()) {
                    holder = getScrapViewForId(RecyclerView.this.mAdapter.getItemId(offsetPosition), type, dryRun);
                    if (holder != null) {
                        holder.mPosition = offsetPosition;
                        fromScrap = true;
                    }
                }
                if (holder == null && this.mViewCacheExtension != null) {
                    View view = this.mViewCacheExtension.getViewForPositionAndType(this, position, type);
                    if (view != null) {
                        holder = RecyclerView.this.getChildViewHolder(view);
                        if (holder == null) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                        } else if (holder.shouldIgnore()) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                        }
                    }
                }
                if (holder == null) {
                    holder = getRecycledViewPool().getRecycledView(RecyclerView.this.mAdapter.getItemViewType(offsetPosition));
                    if (holder != null) {
                        holder.resetInternal();
                        if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                            invalidateDisplayListInt(holder);
                        }
                    }
                }
                if (holder == null) {
                    holder = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, RecyclerView.this.mAdapter.getItemViewType(offsetPosition));
                }
            }
            boolean bound = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (RecyclerView.this.mState.isPreLayout() && holder.isBound()) {
                holder.mPreLayoutPosition = position;
            } else if (!holder.isBound() || holder.needsUpdate() || holder.isInvalid()) {
                RecyclerView.this.mAdapter.bindViewHolder(holder, RecyclerView.this.mAdapterHelper.findPositionOffset(position));
                attachAccessibilityDelegate(holder.itemView);
                bound = true;
                if (RecyclerView.this.mState.isPreLayout()) {
                    holder.mPreLayoutPosition = position;
                }
            }
            android.view.ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp == null) {
                rvLayoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                holder.itemView.setLayoutParams(rvLayoutParams);
            } else if (RecyclerView.this.checkLayoutParams(lp)) {
                rvLayoutParams = (LayoutParams) lp;
            } else {
                rvLayoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(lp);
                holder.itemView.setLayoutParams(rvLayoutParams);
            }
            rvLayoutParams.mViewHolder = holder;
            if (!(fromScrap && bound)) {
                z = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            rvLayoutParams.mPendingInvalidate = z;
            return holder.itemView;
        }

        private void attachAccessibilityDelegate(View itemView) {
            if (RecyclerView.this.mAccessibilityManager != null && RecyclerView.this.mAccessibilityManager.isEnabled()) {
                if (ViewCompat.getImportantForAccessibility(itemView) == 0) {
                    ViewCompat.setImportantForAccessibility(itemView, RecyclerView.VERTICAL);
                }
                if (!ViewCompat.hasAccessibilityDelegate(itemView)) {
                    ViewCompat.setAccessibilityDelegate(itemView, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder holder) {
            if (holder.itemView instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) holder.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean invalidateThis) {
            for (int i = viewGroup.getChildCount() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                View view = viewGroup.getChildAt(i);
                if (view instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) view, true);
                }
            }
            if (!invalidateThis) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(RecyclerView.TOUCH_SLOP_DEFAULT);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void recycleView(View view) {
            ViewHolder holder = RecyclerView.getChildViewHolderInt(view);
            if (holder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
            if (holder.isScrap()) {
                holder.unScrap();
            } else if (holder.wasReturnedFromScrap()) {
                holder.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(holder);
        }

        void recycleViewInternal(View view) {
            recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(view));
        }

        void recycleAndClearCachedViews() {
            for (int i = this.mCachedViews.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                tryToRecycleCachedViewAt(i);
            }
            this.mCachedViews.clear();
        }

        boolean tryToRecycleCachedViewAt(int cachedViewIndex) {
            ViewHolder viewHolder = (ViewHolder) this.mCachedViews.get(cachedViewIndex);
            if (!viewHolder.isRecyclable()) {
                return RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            }
            getRecycledViewPool().putRecycledView(viewHolder);
            dispatchViewRecycled(viewHolder);
            this.mCachedViews.remove(cachedViewIndex);
            return true;
        }

        void recycleViewHolderInternal(ViewHolder holder) {
            if (holder.isScrap() || holder.itemView.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + holder.isScrap() + " isAttached:" + (holder.itemView.getParent() != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST));
            } else if (holder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + holder);
            } else if (holder.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                if (holder.isRecyclable()) {
                    boolean cached = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                    if (!holder.isInvalid() && ((RecyclerView.this.mState.mInPreLayout || !holder.isRemoved()) && !holder.isChanged())) {
                        if (this.mCachedViews.size() == this.mViewCacheMax && !this.mCachedViews.isEmpty()) {
                            int i = RecyclerView.TOUCH_SLOP_DEFAULT;
                            while (i < this.mCachedViews.size() && !tryToRecycleCachedViewAt(i)) {
                                i += RecyclerView.VERTICAL;
                            }
                        }
                        if (this.mCachedViews.size() < this.mViewCacheMax) {
                            this.mCachedViews.add(holder);
                            cached = true;
                        }
                    }
                    if (!cached) {
                        getRecycledViewPool().putRecycledView(holder);
                        dispatchViewRecycled(holder);
                    }
                }
                RecyclerView.this.mState.onViewRecycled(holder);
            }
        }

        void quickRecycleScrapView(View view) {
            ViewHolder holder = RecyclerView.getChildViewHolderInt(view);
            holder.mScrapContainer = null;
            holder.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(holder);
        }

        void scrapView(View view) {
            ViewHolder holder = RecyclerView.getChildViewHolderInt(view);
            holder.setScrapContainer(this);
            if (holder.isChanged() && RecyclerView.this.supportsChangeAnimations()) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList();
                }
                this.mChangedScrap.add(holder);
            } else if (!holder.isInvalid() || holder.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                this.mAttachedScrap.add(holder);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        void unscrapView(ViewHolder holder) {
            if (holder.isChanged() && RecyclerView.this.supportsChangeAnimations() && this.mChangedScrap != null) {
                this.mChangedScrap.remove(holder);
            } else {
                this.mAttachedScrap.remove(holder);
            }
            holder.mScrapContainer = null;
            holder.clearReturnedFromScrapFlag();
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        View getScrapViewAt(int index) {
            return ((ViewHolder) this.mAttachedScrap.get(index)).itemView;
        }

        void clearScrap() {
            this.mAttachedScrap.clear();
        }

        ViewHolder getChangedScrapViewForPosition(int position) {
            if (this.mChangedScrap != null) {
                int changedScrapSize = this.mChangedScrap.size();
                if (changedScrapSize != 0) {
                    ViewHolder holder;
                    int i = RecyclerView.TOUCH_SLOP_DEFAULT;
                    while (i < changedScrapSize) {
                        holder = (ViewHolder) this.mChangedScrap.get(i);
                        if (holder.wasReturnedFromScrap() || holder.getPosition() != position) {
                            i += RecyclerView.VERTICAL;
                        } else {
                            holder.addFlags(32);
                            return holder;
                        }
                    }
                    if (RecyclerView.this.mAdapter.hasStableIds()) {
                        int offsetPosition = RecyclerView.this.mAdapterHelper.findPositionOffset(position);
                        if (offsetPosition > 0 && offsetPosition < RecyclerView.this.mAdapter.getItemCount()) {
                            long id = RecyclerView.this.mAdapter.getItemId(offsetPosition);
                            i = RecyclerView.TOUCH_SLOP_DEFAULT;
                            while (i < changedScrapSize) {
                                holder = (ViewHolder) this.mChangedScrap.get(i);
                                if (holder.wasReturnedFromScrap() || holder.getItemId() != id) {
                                    i += RecyclerView.VERTICAL;
                                } else {
                                    holder.addFlags(32);
                                    return holder;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        ViewHolder getScrapViewForPosition(int position, int type, boolean dryRun) {
            int cacheSize;
            int scrapCount = this.mAttachedScrap.size();
            int i = RecyclerView.TOUCH_SLOP_DEFAULT;
            while (i < scrapCount) {
                View view;
                ViewHolder holder = (ViewHolder) this.mAttachedScrap.get(i);
                if (holder.wasReturnedFromScrap() || holder.getPosition() != position || holder.isInvalid() || (!RecyclerView.this.mState.mInPreLayout && holder.isRemoved())) {
                    i += RecyclerView.VERTICAL;
                } else if (type == RecyclerView.NO_POSITION || holder.getItemViewType() == type) {
                    holder.addFlags(32);
                    return holder;
                } else {
                    Log.e(RecyclerView.TAG, "Scrap view for position " + position + " isn't dirty but has" + " wrong view type! (found " + holder.getItemViewType() + " but expected " + type + ")");
                    if (!dryRun) {
                        view = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(position, type);
                        if (view != null) {
                            RecyclerView.this.mItemAnimator.endAnimation(RecyclerView.this.getChildViewHolder(view));
                        }
                    }
                    cacheSize = this.mCachedViews.size();
                    i = RecyclerView.TOUCH_SLOP_DEFAULT;
                    while (i < cacheSize) {
                        holder = (ViewHolder) this.mCachedViews.get(i);
                        if (holder.isInvalid() || holder.getPosition() != position) {
                            i += RecyclerView.VERTICAL;
                        } else if (dryRun) {
                            return holder;
                        } else {
                            this.mCachedViews.remove(i);
                            return holder;
                        }
                    }
                    return null;
                }
            }
            if (dryRun) {
                view = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(position, type);
                if (view != null) {
                    RecyclerView.this.mItemAnimator.endAnimation(RecyclerView.this.getChildViewHolder(view));
                }
            }
            cacheSize = this.mCachedViews.size();
            i = RecyclerView.TOUCH_SLOP_DEFAULT;
            while (i < cacheSize) {
                holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder.isInvalid()) {
                }
                i += RecyclerView.VERTICAL;
            }
            return null;
        }

        ViewHolder getScrapViewForId(long id, int type, boolean dryRun) {
            int i;
            for (i = this.mAttachedScrap.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                ViewHolder holder = (ViewHolder) this.mAttachedScrap.get(i);
                if (holder.getItemId() == id && !holder.wasReturnedFromScrap()) {
                    if (type == holder.getItemViewType()) {
                        holder.addFlags(32);
                        if (!holder.isRemoved() || RecyclerView.this.mState.isPreLayout()) {
                            return holder;
                        }
                        holder.setFlags(DEFAULT_CACHE_SIZE, 14);
                        return holder;
                    } else if (!dryRun) {
                        this.mAttachedScrap.remove(i);
                        RecyclerView.this.removeDetachedView(holder.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                        quickRecycleScrapView(holder.itemView);
                    }
                }
            }
            for (i = this.mCachedViews.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder.getItemId() == id) {
                    if (type == holder.getItemViewType()) {
                        if (dryRun) {
                            return holder;
                        }
                        this.mCachedViews.remove(i);
                        return holder;
                    } else if (!dryRun) {
                        tryToRecycleCachedViewAt(i);
                    }
                }
            }
            return null;
        }

        void dispatchViewRecycled(ViewHolder holder) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.onViewRecycled(holder);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(holder);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mState.onViewRecycled(holder);
            }
        }

        void onAdapterChanged(Adapter oldAdapter, Adapter newAdapter, boolean compatibleWithPrevious) {
            clear();
            getRecycledViewPool().onAdapterChanged(oldAdapter, newAdapter, compatibleWithPrevious);
        }

        void offsetPositionRecordsForMove(int from, int to) {
            int inBetweenOffset;
            int start;
            int end;
            if (from < to) {
                start = from;
                end = to;
                inBetweenOffset = RecyclerView.NO_POSITION;
            } else {
                start = to;
                end = from;
                inBetweenOffset = RecyclerView.VERTICAL;
            }
            int cachedCount = this.mCachedViews.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < cachedCount; i += RecyclerView.VERTICAL) {
                ViewHolder holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder != null && holder.mPosition >= start && holder.mPosition <= end) {
                    if (holder.mPosition == from) {
                        holder.offsetPosition(to - from, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    } else {
                        holder.offsetPosition(inBetweenOffset, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                    }
                }
            }
        }

        void offsetPositionRecordsForInsert(int insertedAt, int count) {
            int cachedCount = this.mCachedViews.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < cachedCount; i += RecyclerView.VERTICAL) {
                ViewHolder holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder != null && holder.getPosition() >= insertedAt) {
                    holder.offsetPosition(count, true);
                }
            }
        }

        void offsetPositionRecordsForRemove(int removedFrom, int count, boolean applyToPreLayout) {
            int removedEnd = removedFrom + count;
            int i = this.mCachedViews.size() + RecyclerView.NO_POSITION;
            while (i >= 0) {
                ViewHolder holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder != null) {
                    if (holder.getPosition() >= removedEnd) {
                        holder.offsetPosition(-count, applyToPreLayout);
                    } else if (holder.getPosition() >= removedFrom && !tryToRecycleCachedViewAt(i)) {
                        holder.addFlags(4);
                    }
                }
                i += RecyclerView.NO_POSITION;
            }
        }

        void setViewCacheExtension(ViewCacheExtension extension) {
            this.mViewCacheExtension = extension;
        }

        void setRecycledViewPool(RecycledViewPool pool) {
            if (this.mRecyclerPool != null) {
                this.mRecyclerPool.detach();
            }
            this.mRecyclerPool = pool;
            if (pool != null) {
                this.mRecyclerPool.attach(RecyclerView.this.getAdapter());
            }
        }

        RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        void viewRangeUpdate(int positionStart, int itemCount) {
            int positionEnd = positionStart + itemCount;
            int cachedCount = this.mCachedViews.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < cachedCount; i += RecyclerView.VERTICAL) {
                ViewHolder holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder != null) {
                    int pos = holder.getPosition();
                    if (pos >= positionStart && pos < positionEnd) {
                        holder.addFlags(DEFAULT_CACHE_SIZE);
                    }
                }
            }
        }

        void markKnownViewsInvalid() {
            int i;
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                for (i = this.mCachedViews.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                    if (!tryToRecycleCachedViewAt(i)) {
                        ((ViewHolder) this.mCachedViews.get(i)).addFlags(6);
                    }
                }
                return;
            }
            int cachedCount = this.mCachedViews.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < cachedCount; i += RecyclerView.VERTICAL) {
                ViewHolder holder = (ViewHolder) this.mCachedViews.get(i);
                if (holder != null) {
                    holder.addFlags(6);
                }
            }
        }

        void clearOldPositions() {
            int i;
            int cachedCount = this.mCachedViews.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < cachedCount; i += RecyclerView.VERTICAL) {
                ((ViewHolder) this.mCachedViews.get(i)).clearOldPosition();
            }
            int scrapCount = this.mAttachedScrap.size();
            for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < scrapCount; i += RecyclerView.VERTICAL) {
                ((ViewHolder) this.mAttachedScrap.get(i)).clearOldPosition();
            }
            if (this.mChangedScrap != null) {
                int changedScrapCount = this.mChangedScrap.size();
                for (i = RecyclerView.TOUCH_SLOP_DEFAULT; i < changedScrapCount; i += RecyclerView.VERTICAL) {
                    ((ViewHolder) this.mChangedScrap.get(i)).clearOldPosition();
                }
            }
        }

        void markItemDecorInsetsDirty() {
            int cachedCount = this.mCachedViews.size();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < cachedCount; i += RecyclerView.VERTICAL) {
                LayoutParams layoutParams = (LayoutParams) ((ViewHolder) this.mCachedViews.get(i)).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        Parcelable mLayoutState;

        /* renamed from: android.support.v7.widget.RecyclerView.SavedState.1 */
        static class C01551 implements Creator<SavedState> {
            C01551() {
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcel in) {
            super(in);
            this.mLayoutState = in.readParcelable(LayoutManager.class.getClassLoader());
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeParcelable(this.mLayoutState, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        private void copyFrom(SavedState other) {
            this.mLayoutState = other.mLayoutState;
        }

        static {
            CREATOR = new C01551();
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction;
        private boolean mRunning;
        private int mTargetPosition;
        private View mTargetView;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean changed;
            private int consecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;

            public Action(int dx, int dy) {
                this(dx, dy, UNDEFINED_DURATION, null);
            }

            public Action(int dx, int dy, int duration) {
                this(dx, dy, duration, null);
            }

            public Action(int dx, int dy, int duration, Interpolator interpolator) {
                this.changed = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.consecutiveUpdates = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.mDx = dx;
                this.mDy = dy;
                this.mDuration = duration;
                this.mInterpolator = interpolator;
            }

            private void runIfNecessary(RecyclerView recyclerView) {
                if (this.changed) {
                    validate();
                    if (this.mInterpolator != null) {
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    } else if (this.mDuration == UNDEFINED_DURATION) {
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
                    } else {
                        recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
                    }
                    this.consecutiveUpdates += RecyclerView.VERTICAL;
                    if (this.consecutiveUpdates > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.changed = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                    return;
                }
                this.consecutiveUpdates = RecyclerView.TOUCH_SLOP_DEFAULT;
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < RecyclerView.VERTICAL) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.mDuration < RecyclerView.VERTICAL) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int getDx() {
                return this.mDx;
            }

            public void setDx(int dx) {
                this.changed = true;
                this.mDx = dx;
            }

            public int getDy() {
                return this.mDy;
            }

            public void setDy(int dy) {
                this.changed = true;
                this.mDy = dy;
            }

            public int getDuration() {
                return this.mDuration;
            }

            public void setDuration(int duration) {
                this.changed = true;
                this.mDuration = duration;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.changed = true;
                this.mInterpolator = interpolator;
            }

            public void update(int dx, int dy, int duration, Interpolator interpolator) {
                this.mDx = dx;
                this.mDy = dy;
                this.mDuration = duration;
                this.mInterpolator = interpolator;
                this.changed = true;
            }
        }

        protected abstract void onSeekTargetStep(int i, int i2, State state, Action action);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, State state, Action action);

        public SmoothScroller() {
            this.mTargetPosition = RecyclerView.NO_POSITION;
            this.mRecyclingAction = new Action(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.mTargetPosition == RecyclerView.NO_POSITION) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
        }

        public void setTargetPosition(int targetPosition) {
            this.mTargetPosition = targetPosition;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
            if (this.mRunning) {
                onStop();
                this.mRecyclerView.mState.mTargetPosition = RecyclerView.NO_POSITION;
                this.mTargetView = null;
                this.mTargetPosition = RecyclerView.NO_POSITION;
                this.mPendingInitialRun = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.mRunning = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        private void onAnimation(int dx, int dy) {
            if (!this.mRunning || this.mTargetPosition == RecyclerView.NO_POSITION) {
                stop();
            }
            this.mPendingInitialRun = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.mTargetView != null) {
                if (getChildPosition(this.mTargetView) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, this.mRecyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(this.mRecyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(dx, dy, this.mRecyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.runIfNecessary(this.mRecyclerView);
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int position) {
            return this.mRecyclerView.mLayout.findViewByPosition(position);
        }

        public void instantScrollToPosition(int position) {
            this.mRecyclerView.scrollToPosition(position);
        }

        protected void onChildAttachedToWindow(View child) {
            if (getChildPosition(child) == getTargetPosition()) {
                this.mTargetView = child;
            }
        }

        protected void normalize(PointF scrollVector) {
            double magnitute = Math.sqrt((double) ((scrollVector.x * scrollVector.x) + (scrollVector.y * scrollVector.y)));
            scrollVector.x = (float) (((double) scrollVector.x) / magnitute);
            scrollVector.y = (float) (((double) scrollVector.y) / magnitute);
        }
    }

    public static class State {
        private SparseArray<Object> mData;
        private int mDeletedInvisibleItemCountSincePreviousLayout;
        private boolean mInPreLayout;
        int mItemCount;
        ArrayMap<Long, ViewHolder> mOldChangedHolders;
        ArrayMap<ViewHolder, ItemHolderInfo> mPostLayoutHolderMap;
        ArrayMap<ViewHolder, ItemHolderInfo> mPreLayoutHolderMap;
        private int mPreviousLayoutItemCount;
        private boolean mRunPredictiveAnimations;
        private boolean mRunSimpleAnimations;
        private boolean mStructureChanged;
        private int mTargetPosition;

        public State() {
            this.mTargetPosition = RecyclerView.NO_POSITION;
            this.mPreLayoutHolderMap = new ArrayMap();
            this.mPostLayoutHolderMap = new ArrayMap();
            this.mOldChangedHolders = new ArrayMap();
            this.mItemCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mPreviousLayoutItemCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mDeletedInvisibleItemCountSincePreviousLayout = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mStructureChanged = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mInPreLayout = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mRunSimpleAnimations = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mRunPredictiveAnimations = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        static /* synthetic */ int access$1012(State x0, int x1) {
            int i = x0.mDeletedInvisibleItemCountSincePreviousLayout + x1;
            x0.mDeletedInvisibleItemCountSincePreviousLayout = i;
            return i;
        }

        State reset() {
            this.mTargetPosition = RecyclerView.NO_POSITION;
            if (this.mData != null) {
                this.mData.clear();
            }
            this.mItemCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mStructureChanged = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            return this;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }

        public void remove(int resourceId) {
            if (this.mData != null) {
                this.mData.remove(resourceId);
            }
        }

        public <T> T get(int resourceId) {
            if (this.mData == null) {
                return null;
            }
            return this.mData.get(resourceId);
        }

        public void put(int resourceId, Object data) {
            if (this.mData == null) {
                this.mData = new SparseArray();
            }
            this.mData.put(resourceId, data);
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            return this.mTargetPosition != RecyclerView.NO_POSITION ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public int getItemCount() {
            return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        }

        public void onViewRecycled(ViewHolder holder) {
            this.mPreLayoutHolderMap.remove(holder);
            this.mPostLayoutHolderMap.remove(holder);
            if (this.mOldChangedHolders != null) {
                removeFrom(this.mOldChangedHolders, holder);
            }
        }

        public void onViewIgnored(ViewHolder holder) {
            onViewRecycled(holder);
        }

        private void removeFrom(ArrayMap<Long, ViewHolder> holderMap, ViewHolder holder) {
            for (int i = holderMap.size() + RecyclerView.NO_POSITION; i >= 0; i += RecyclerView.NO_POSITION) {
                if (holder == holderMap.valueAt(i)) {
                    holderMap.removeAt(i);
                    return;
                }
            }
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mPreLayoutHolderMap=" + this.mPreLayoutHolderMap + ", mPostLayoutHolderMap=" + this.mPostLayoutHolderMap + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler recycler, int i, int i2);
    }

    private class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        private Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        private boolean mReSchedulePostAnimationCallback;
        private ScrollerCompat mScroller;

        public ViewFlinger() {
            this.mInterpolator = RecyclerView.sQuinticInterpolator;
            this.mEatRunOnAnimationRequest = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mReSchedulePostAnimationCallback = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void run() {
            disableRunOnAnimationRequests();
            RecyclerView.this.consumePendingUpdateOperations();
            ScrollerCompat scroller = this.mScroller;
            SmoothScroller smoothScroller = RecyclerView.this.mLayout.mSmoothScroller;
            if (scroller.computeScrollOffset()) {
                int x = scroller.getCurrX();
                int y = scroller.getCurrY();
                int dx = x - this.mLastFlingX;
                int dy = y - this.mLastFlingY;
                int hresult = RecyclerView.TOUCH_SLOP_DEFAULT;
                int vresult = RecyclerView.TOUCH_SLOP_DEFAULT;
                this.mLastFlingX = x;
                this.mLastFlingY = y;
                int overscrollX = RecyclerView.TOUCH_SLOP_DEFAULT;
                int overscrollY = RecyclerView.TOUCH_SLOP_DEFAULT;
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.eatRequestLayout();
                    RecyclerView.this.mRunningLayoutOrScroll = true;
                    if (dx != 0) {
                        hresult = RecyclerView.this.mLayout.scrollHorizontallyBy(dx, RecyclerView.this.mRecycler, RecyclerView.this.mState);
                        overscrollX = dx - hresult;
                    }
                    if (dy != 0) {
                        vresult = RecyclerView.this.mLayout.scrollVerticallyBy(dy, RecyclerView.this.mRecycler, RecyclerView.this.mState);
                        overscrollY = dy - vresult;
                    }
                    if (RecyclerView.this.supportsChangeAnimations()) {
                        int count = RecyclerView.this.mChildHelper.getChildCount();
                        for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < count; i += RecyclerView.VERTICAL) {
                            View view = RecyclerView.this.mChildHelper.getChildAt(i);
                            ViewHolder holder = RecyclerView.this.getChildViewHolder(view);
                            if (!(holder == null || holder.mShadowingHolder == null)) {
                                View shadowingView = holder.mShadowingHolder != null ? holder.mShadowingHolder.itemView : null;
                                if (shadowingView != null) {
                                    int left = view.getLeft();
                                    int top = view.getTop();
                                    if (left != shadowingView.getLeft() || top != shadowingView.getTop()) {
                                        shadowingView.layout(left, top, shadowingView.getWidth() + left, shadowingView.getHeight() + top);
                                    }
                                }
                            }
                        }
                    }
                    if (!(smoothScroller == null || smoothScroller.isPendingInitialRun() || !smoothScroller.isRunning())) {
                        int adapterSize = RecyclerView.this.mState.getItemCount();
                        if (adapterSize == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= adapterSize) {
                            smoothScroller.setTargetPosition(adapterSize + RecyclerView.NO_POSITION);
                            smoothScroller.onAnimation(dx - overscrollX, dy - overscrollY);
                        } else {
                            smoothScroller.onAnimation(dx - overscrollX, dy - overscrollY);
                        }
                    }
                    RecyclerView.this.mRunningLayoutOrScroll = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                    RecyclerView.this.resumeRequestLayout(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
                }
                boolean fullyConsumedScroll = (dx == hresult && dy == vresult) ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (ViewCompat.getOverScrollMode(RecyclerView.this) != RecyclerView.SCROLL_STATE_SETTLING) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(dx, dy);
                }
                if (!(overscrollX == 0 && overscrollY == 0)) {
                    int vel = (int) scroller.getCurrVelocity();
                    int velX = RecyclerView.TOUCH_SLOP_DEFAULT;
                    if (overscrollX != x) {
                        velX = overscrollX < 0 ? -vel : overscrollX > 0 ? vel : RecyclerView.TOUCH_SLOP_DEFAULT;
                    }
                    int velY = RecyclerView.TOUCH_SLOP_DEFAULT;
                    if (overscrollY != y) {
                        velY = overscrollY < 0 ? -vel : overscrollY > 0 ? vel : RecyclerView.TOUCH_SLOP_DEFAULT;
                    }
                    if (ViewCompat.getOverScrollMode(RecyclerView.this) != RecyclerView.SCROLL_STATE_SETTLING) {
                        RecyclerView.this.absorbGlows(velX, velY);
                    }
                    if ((velX != 0 || overscrollX == x || scroller.getFinalX() == 0) && (velY != 0 || overscrollY == y || scroller.getFinalY() == 0)) {
                        scroller.abortAnimation();
                    }
                }
                if (!(hresult == 0 && vresult == 0)) {
                    RecyclerView.this.onScrollChanged(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
                    if (RecyclerView.this.mScrollListener != null) {
                        RecyclerView.this.mScrollListener.onScrolled(RecyclerView.this, hresult, vresult);
                    }
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (scroller.isFinished() || !fullyConsumedScroll) {
                    RecyclerView.this.setScrollState(RecyclerView.TOUCH_SLOP_DEFAULT);
                } else {
                    postOnAnimation();
                }
            }
            if (smoothScroller != null && smoothScroller.isPendingInitialRun()) {
                smoothScroller.onAnimation(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT);
            }
            enableRunOnAnimationRequests();
        }

        private void disableRunOnAnimationRequests() {
            this.mReSchedulePostAnimationCallback = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            this.mEatRunOnAnimationRequest = true;
        }

        private void enableRunOnAnimationRequests() {
            this.mEatRunOnAnimationRequest = RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            if (this.mReSchedulePostAnimationCallback) {
                postOnAnimation();
            }
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                ViewCompat.postOnAnimation(RecyclerView.this, this);
            }
        }

        public void fling(int velocityX, int velocityY) {
            RecyclerView.this.setScrollState(RecyclerView.SCROLL_STATE_SETTLING);
            this.mLastFlingY = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mLastFlingX = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mScroller.fling(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, velocityX, velocityY, Target.SIZE_ORIGINAL, Strategy.TTL_SECONDS_INFINITE, Target.SIZE_ORIGINAL, Strategy.TTL_SECONDS_INFINITE);
            postOnAnimation();
        }

        public void smoothScrollBy(int dx, int dy) {
            smoothScrollBy(dx, dy, (int) RecyclerView.TOUCH_SLOP_DEFAULT, (int) RecyclerView.TOUCH_SLOP_DEFAULT);
        }

        public void smoothScrollBy(int dx, int dy, int vx, int vy) {
            smoothScrollBy(dx, dy, computeScrollDuration(dx, dy, vx, vy));
        }

        private float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int computeScrollDuration(int dx, int dy, int vx, int vy) {
            int duration;
            int absDx = Math.abs(dx);
            int absDy = Math.abs(dy);
            boolean horizontal = absDx > absDy ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
            int velocity = (int) Math.sqrt((double) ((vx * vx) + (vy * vy)));
            int delta = (int) Math.sqrt((double) ((dx * dx) + (dy * dy)));
            int containerSize = horizontal ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int halfContainerSize = containerSize / RecyclerView.SCROLL_STATE_SETTLING;
            float distance = ((float) halfContainerSize) + (((float) halfContainerSize) * distanceInfluenceForSnapDuration(Math.min(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT * ((float) delta)) / ((float) containerSize))));
            if (velocity > 0) {
                duration = Math.round(1000.0f * Math.abs(distance / ((float) velocity))) * 4;
            } else {
                if (!horizontal) {
                    absDx = absDy;
                }
                duration = (int) (((((float) absDx) / ((float) containerSize)) + DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * BitmapDescriptorFactory.HUE_MAGENTA);
            }
            return Math.min(duration, RecyclerView.MAX_SCROLL_DURATION);
        }

        public void smoothScrollBy(int dx, int dy, int duration) {
            smoothScrollBy(dx, dy, duration, RecyclerView.sQuinticInterpolator);
        }

        public void smoothScrollBy(int dx, int dy, int duration, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(RecyclerView.SCROLL_STATE_SETTLING);
            this.mLastFlingY = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mLastFlingX = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mScroller.startScroll(RecyclerView.TOUCH_SLOP_DEFAULT, RecyclerView.TOUCH_SLOP_DEFAULT, dx, dy, duration);
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_BOUND = 1;
        static final int FLAG_CHANGED = 64;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        public final View itemView;
        private int mFlags;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        int mOldPosition;
        int mPosition;
        int mPreLayoutPosition;
        private Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;

        public ViewHolder(View itemView) {
            this.mPosition = RecyclerView.NO_POSITION;
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mItemId = RecyclerView.NO_ID;
            this.mItemViewType = RecyclerView.NO_POSITION;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mScrapContainer = null;
            if (itemView == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = itemView;
        }

        void flagRemovedAndOffsetPosition(int mNewPosition, int offset, boolean applyToPreLayout) {
            addFlags(FLAG_REMOVED);
            offsetPosition(offset, applyToPreLayout);
            this.mPosition = mNewPosition;
        }

        void offsetPosition(int offset, boolean applyToPreLayout) {
            if (this.mOldPosition == RecyclerView.NO_POSITION) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == RecyclerView.NO_POSITION) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (applyToPreLayout) {
                this.mPreLayoutPosition += offset;
            }
            this.mPosition += offset;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
        }

        void saveOldPosition() {
            if (this.mOldPosition == RecyclerView.NO_POSITION) {
                this.mOldPosition = this.mPosition;
            }
        }

        boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        public final int getPosition() {
            return this.mPreLayoutPosition == RecyclerView.NO_POSITION ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & FLAG_RETURNED_FROM_SCRAP) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(Recycler recycler) {
            this.mScrapContainer = recycler;
        }

        boolean isInvalid() {
            return (this.mFlags & FLAG_INVALID) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean needsUpdate() {
            return (this.mFlags & FLAG_UPDATE) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isChanged() {
            return (this.mFlags & FLAG_CHANGED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isBound() {
            return (this.mFlags & FLAG_BOUND) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isRemoved() {
            return (this.mFlags & FLAG_REMOVED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0 ? true : RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST;
        }

        void setFlags(int flags, int mask) {
            this.mFlags = (this.mFlags & (mask ^ RecyclerView.NO_POSITION)) | (flags & mask);
        }

        void addFlags(int flags) {
            this.mFlags |= flags;
        }

        void resetInternal() {
            this.mFlags = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mPosition = RecyclerView.NO_POSITION;
            this.mOldPosition = RecyclerView.NO_POSITION;
            this.mItemId = RecyclerView.NO_ID;
            this.mPreLayoutPosition = RecyclerView.NO_POSITION;
            this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isChanged()) {
                sb.append(" changed");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean recyclable) {
            this.mIsRecyclableCount = recyclable ? this.mIsRecyclableCount + RecyclerView.NO_POSITION : this.mIsRecyclableCount + FLAG_BOUND;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = RecyclerView.TOUCH_SLOP_DEFAULT;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!recyclable && this.mIsRecyclableCount == FLAG_BOUND) {
                this.mFlags |= FLAG_NOT_RECYCLABLE;
            } else if (recyclable && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return ((this.mFlags & FLAG_NOT_RECYCLABLE) != 0 || ViewCompat.hasTransientState(this.itemView)) ? RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST : true;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.4 */
    class C06624 implements Callback {
        C06624() {
        }

        public int getChildCount() {
            return RecyclerView.this.getChildCount();
        }

        public void addView(View child, int index) {
            RecyclerView.this.addView(child, index);
            RecyclerView.this.dispatchChildAttached(child);
        }

        public int indexOfChild(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        public void removeViewAt(int index) {
            View child = RecyclerView.this.getChildAt(index);
            if (child != null) {
                RecyclerView.this.dispatchChildDetached(child);
            }
            RecyclerView.this.removeViewAt(index);
        }

        public View getChildAt(int offset) {
            return RecyclerView.this.getChildAt(offset);
        }

        public void removeAllViews() {
            int count = getChildCount();
            for (int i = RecyclerView.TOUCH_SLOP_DEFAULT; i < count; i += RecyclerView.VERTICAL) {
                RecyclerView.this.dispatchChildDetached(getChildAt(i));
            }
            RecyclerView.this.removeAllViews();
        }

        public ViewHolder getChildViewHolder(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        public void attachViewToParent(View child, int index, android.view.ViewGroup.LayoutParams layoutParams) {
            ViewHolder vh = RecyclerView.getChildViewHolderInt(child);
            if (vh != null) {
                if (vh.isTmpDetached() || vh.shouldIgnore()) {
                    vh.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + vh);
                }
            }
            RecyclerView.this.attachViewToParent(child, index, layoutParams);
        }

        public void detachViewFromParent(int offset) {
            View view = getChildAt(offset);
            if (view != null) {
                ViewHolder vh = RecyclerView.getChildViewHolderInt(view);
                if (vh != null) {
                    if (!vh.isTmpDetached() || vh.shouldIgnore()) {
                        vh.addFlags(Barcode.QR_CODE);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + vh);
                    }
                }
            }
            RecyclerView.this.detachViewFromParent(offset);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView.5 */
    class C06635 implements Callback {
        C06635() {
        }

        public ViewHolder findViewHolder(int position) {
            return RecyclerView.this.findViewHolderForPosition(position, true);
        }

        public void offsetPositionsForRemovingInvisible(int start, int count) {
            RecyclerView.this.offsetPositionRecordsForRemove(start, count, true);
            RecyclerView.this.mItemsAddedOrRemoved = true;
            State.access$1012(RecyclerView.this.mState, count);
        }

        public void offsetPositionsForRemovingLaidOutOrNewView(int positionStart, int itemCount) {
            RecyclerView.this.offsetPositionRecordsForRemove(positionStart, itemCount, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        public void markViewHoldersUpdated(int positionStart, int itemCount) {
            RecyclerView.this.viewRangeUpdate(positionStart, itemCount);
            RecyclerView.this.mItemsChanged = true;
        }

        public void onDispatchFirstPass(UpdateOp op) {
            dispatchUpdate(op);
        }

        void dispatchUpdate(UpdateOp op) {
            switch (op.cmd) {
                case RecyclerView.TOUCH_SLOP_DEFAULT /*0*/:
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, op.positionStart, op.itemCount);
                case RecyclerView.VERTICAL /*1*/:
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, op.positionStart, op.itemCount);
                case RecyclerView.SCROLL_STATE_SETTLING /*2*/:
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, op.positionStart, op.itemCount);
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, op.positionStart, op.itemCount, RecyclerView.VERTICAL);
                default:
            }
        }

        public void onDispatchSecondPass(UpdateOp op) {
            dispatchUpdate(op);
        }

        public void offsetPositionsForAdd(int positionStart, int itemCount) {
            RecyclerView.this.offsetPositionRecordsForInsert(positionStart, itemCount);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        public void offsetPositionsForMove(int from, int to) {
            RecyclerView.this.offsetPositionRecordsForMove(from, to);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimatorListener {
        private ItemAnimatorRestoreListener() {
        }

        public void onRemoveFinished(ViewHolder item) {
            item.setIsRecyclable(true);
            if (!RecyclerView.this.removeAnimatingView(item.itemView) && item.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(item.itemView, RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST);
            }
        }

        public void onAddFinished(ViewHolder item) {
            item.setIsRecyclable(true);
            if (item.isRecyclable()) {
                RecyclerView.this.removeAnimatingView(item.itemView);
            }
        }

        public void onMoveFinished(ViewHolder item) {
            item.setIsRecyclable(true);
            if (item.isRecyclable()) {
                RecyclerView.this.removeAnimatingView(item.itemView);
            }
        }

        public void onChangeFinished(ViewHolder item) {
            item.setIsRecyclable(true);
            if (item.mShadowedHolder != null && item.mShadowingHolder == null) {
                item.mShadowedHolder = null;
                item.setFlags(-65, item.mFlags);
            }
            item.mShadowingHolder = null;
            if (item.isRecyclable()) {
                RecyclerView.this.removeAnimatingView(item.itemView);
            }
        }
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        private RecyclerViewDataObserver() {
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapter.hasStableIds()) {
                RecyclerView.this.mState.mStructureChanged = true;
                RecyclerView.this.mDataSetHasChangedAfterLayout = true;
            } else {
                RecyclerView.this.mState.mStructureChanged = true;
                RecyclerView.this.mDataSetHasChangedAfterLayout = true;
            }
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int positionStart, int itemCount) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(positionStart, itemCount)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeInserted(int positionStart, int itemCount) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(positionStart, itemCount)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeRemoved(int positionStart, int itemCount) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(positionStart, itemCount)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(fromPosition, toPosition, itemCount)) {
                triggerUpdateProcessor();
            }
        }

        void triggerUpdateProcessor() {
            if (RecyclerView.this.mPostUpdatesOnAnimation && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
                ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
                return;
            }
            RecyclerView.this.mAdapterUpdateDuringMeasure = true;
            RecyclerView.this.requestLayout();
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) {
            z = true;
        } else {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = z;
        sQuinticInterpolator = new C01543();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, TOUCH_SLOP_DEFAULT);
    }

    public RecyclerView(Context context, AttributeSet attrs, int defStyle) {
        boolean z;
        boolean z2 = FORCE_INVALIDATE_DISPLAY_LIST;
        super(context, attrs, defStyle);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mDisappearingViewsInLayoutPass = new ArrayList();
        this.mUpdateChildViewsRunnable = new C01521();
        this.mTempRect = new Rect();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mDataSetHasChangedAfterLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mRunningLayoutOrScroll = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = TOUCH_SLOP_DEFAULT;
        this.mScrollPointerId = NO_POSITION;
        this.mViewFlinger = new ViewFlinger();
        this.mState = new State();
        this.mItemsAddedOrRemoved = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemsChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemAnimatorRunner = new C01532();
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        this.mPostUpdatesOnAnimation = z;
        ViewConfiguration vc = ViewConfiguration.get(context);
        this.mTouchSlop = vc.getScaledTouchSlop();
        this.mMinFlingVelocity = vc.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = vc.getScaledMaximumFlingVelocity();
        if (ViewCompat.getOverScrollMode(this) == SCROLL_STATE_SETTLING) {
            z2 = true;
        }
        setWillNotDraw(z2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, VERTICAL);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate accessibilityDelegate) {
        this.mAccessibilityDelegate = accessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new C06624());
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new C06635());
    }

    public void setHasFixedSize(boolean hasFixedSize) {
        this.mHasFixedSize = hasFixedSize;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean clipToPadding) {
        if (clipToPadding != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = clipToPadding;
        super.setClipToPadding(clipToPadding);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int slopConstant) {
        ViewConfiguration vc = ViewConfiguration.get(getContext());
        switch (slopConstant) {
            case TOUCH_SLOP_DEFAULT /*0*/:
                break;
            case VERTICAL /*1*/:
                this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(vc);
                return;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + slopConstant + "; using default value");
                break;
        }
        this.mTouchSlop = vc.getScaledTouchSlop();
    }

    public void swapAdapter(Adapter adapter, boolean removeAndRecycleExistingViews) {
        setAdapterInternal(adapter, true, removeAndRecycleExistingViews);
        this.mDataSetHasChangedAfterLayout = true;
        requestLayout();
    }

    public void setAdapter(Adapter adapter) {
        setAdapterInternal(adapter, FORCE_INVALIDATE_DISPLAY_LIST, true);
        requestLayout();
    }

    private void setAdapterInternal(Adapter adapter, boolean compatibleWithPrevious, boolean removeAndRecycleViews) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!compatibleWithPrevious || removeAndRecycleViews) {
            if (this.mItemAnimator != null) {
                this.mItemAnimator.endAnimations();
            }
            if (this.mLayout != null) {
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            }
        }
        this.mAdapterHelper.reset();
        Adapter oldAdapter = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        if (this.mLayout != null) {
            this.mLayout.onAdapterChanged(oldAdapter, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(oldAdapter, this.mAdapter, compatibleWithPrevious);
        this.mState.mStructureChanged = true;
        markKnownViewsInvalid();
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(RecyclerListener listener) {
        this.mRecyclerListener = listener;
    }

    public void setLayoutManager(LayoutManager layout) {
        if (layout != this.mLayout) {
            if (this.mLayout != null) {
                if (this.mIsAttached) {
                    this.mLayout.onDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
            }
            this.mRecycler.clear();
            this.mChildHelper.removeAllViewsUnfiltered();
            this.mLayout = layout;
            if (layout != null) {
                if (layout.mRecyclerView != null) {
                    throw new IllegalArgumentException("LayoutManager " + layout + " is already attached to a RecyclerView: " + layout.mRecyclerView);
                }
                this.mLayout.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.onAttachedToWindow(this);
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            state.copyFrom(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            state.mLayoutState = this.mLayout.onSaveInstanceState();
        } else {
            state.mLayoutState = null;
        }
        return state;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        this.mPendingSavedState = (SavedState) state;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        if (this.mLayout != null && this.mPendingSavedState.mLayoutState != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
        }
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean alreadyParented = view.getParent() == this ? true : FORCE_INVALIDATE_DISPLAY_LIST;
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, NO_POSITION, view.getLayoutParams(), true);
        } else if (alreadyParented) {
            this.mChildHelper.hide(view);
        } else {
            this.mChildHelper.addView(view, true);
        }
    }

    private boolean removeAnimatingView(View view) {
        eatRequestLayout();
        boolean removed = this.mChildHelper.removeViewIfHidden(view);
        if (removed) {
            ViewHolder viewHolder = getChildViewHolderInt(view);
            this.mRecycler.unscrapView(viewHolder);
            this.mRecycler.recycleViewHolderInternal(viewHolder);
        }
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        return removed;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public void setRecycledViewPool(RecycledViewPool pool) {
        this.mRecycler.setRecycledViewPool(pool);
    }

    public void setViewCacheExtension(ViewCacheExtension extension) {
        this.mRecycler.setViewCacheExtension(extension);
    }

    public void setItemViewCacheSize(int size) {
        this.mRecycler.setViewCacheSize(size);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    private void setScrollState(int state) {
        if (state != this.mScrollState) {
            this.mScrollState = state;
            if (state != SCROLL_STATE_SETTLING) {
                stopScrollersInternal();
            }
            if (this.mScrollListener != null) {
                this.mScrollListener.onScrollStateChanged(this, state);
            }
            this.mLayout.onScrollStateChanged(state);
        }
    }

    public void addItemDecoration(ItemDecoration decor, int index) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        if (index < 0) {
            this.mItemDecorations.add(decor);
        } else {
            this.mItemDecorations.add(index, decor);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration decor) {
        addItemDecoration(decor, NO_POSITION);
    }

    public void removeItemDecoration(ItemDecoration decor) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(decor);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(ViewCompat.getOverScrollMode(this) == SCROLL_STATE_SETTLING ? true : FORCE_INVALIDATE_DISPLAY_LIST);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setOnScrollListener(OnScrollListener listener) {
        this.mScrollListener = listener;
    }

    public void scrollToPosition(int position) {
        stopScroll();
        this.mLayout.scrollToPosition(position);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int position) {
        this.mLayout.smoothScrollToPosition(this, this.mState, position);
    }

    public void scrollTo(int x, int y) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollBy(int x, int y) {
        if (this.mLayout == null) {
            throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        boolean canScrollHorizontal = this.mLayout.canScrollHorizontally();
        boolean canScrollVertical = this.mLayout.canScrollVertically();
        if (canScrollHorizontal || canScrollVertical) {
            if (!canScrollHorizontal) {
                x = TOUCH_SLOP_DEFAULT;
            }
            if (!canScrollVertical) {
                y = TOUCH_SLOP_DEFAULT;
            }
            scrollByInternal(x, y);
        }
    }

    private void consumePendingUpdateOperations() {
        this.mUpdateChildViewsRunnable.run();
    }

    void scrollByInternal(int x, int y) {
        int overscrollX = TOUCH_SLOP_DEFAULT;
        int overscrollY = TOUCH_SLOP_DEFAULT;
        int hresult = TOUCH_SLOP_DEFAULT;
        int vresult = TOUCH_SLOP_DEFAULT;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            eatRequestLayout();
            this.mRunningLayoutOrScroll = true;
            if (x != 0) {
                hresult = this.mLayout.scrollHorizontallyBy(x, this.mRecycler, this.mState);
                overscrollX = x - hresult;
            }
            if (y != 0) {
                vresult = this.mLayout.scrollVerticallyBy(y, this.mRecycler, this.mState);
                overscrollY = y - vresult;
            }
            if (supportsChangeAnimations()) {
                int count = this.mChildHelper.getChildCount();
                for (int i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
                    View view = this.mChildHelper.getChildAt(i);
                    ViewHolder holder = getChildViewHolder(view);
                    if (!(holder == null || holder.mShadowingHolder == null)) {
                        ViewHolder shadowingHolder = holder.mShadowingHolder;
                        View shadowingView = shadowingHolder != null ? shadowingHolder.itemView : null;
                        if (shadowingView != null) {
                            int left = view.getLeft();
                            int top = view.getTop();
                            if (left != shadowingView.getLeft() || top != shadowingView.getTop()) {
                                shadowingView.layout(left, top, shadowingView.getWidth() + left, shadowingView.getHeight() + top);
                            }
                        }
                    }
                }
            }
            this.mRunningLayoutOrScroll = FORCE_INVALIDATE_DISPLAY_LIST;
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (ViewCompat.getOverScrollMode(this) != SCROLL_STATE_SETTLING) {
            considerReleasingGlowsOnScroll(x, y);
            pullGlows(overscrollX, overscrollY);
        }
        if (!(hresult == 0 && vresult == 0)) {
            onScrollChanged(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
            if (this.mScrollListener != null) {
                this.mScrollListener.onScrolled(this, hresult, vresult);
            }
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
    }

    protected int computeHorizontalScrollOffset() {
        return this.mLayout.canScrollHorizontally() ? this.mLayout.computeHorizontalScrollOffset(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    protected int computeHorizontalScrollExtent() {
        return this.mLayout.canScrollHorizontally() ? this.mLayout.computeHorizontalScrollExtent(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    protected int computeHorizontalScrollRange() {
        return this.mLayout.canScrollHorizontally() ? this.mLayout.computeHorizontalScrollRange(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    protected int computeVerticalScrollOffset() {
        return this.mLayout.canScrollVertically() ? this.mLayout.computeVerticalScrollOffset(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    protected int computeVerticalScrollExtent() {
        return this.mLayout.canScrollVertically() ? this.mLayout.computeVerticalScrollExtent(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    protected int computeVerticalScrollRange() {
        return this.mLayout.canScrollVertically() ? this.mLayout.computeVerticalScrollRange(this.mState) : TOUCH_SLOP_DEFAULT;
    }

    void eatRequestLayout() {
        if (!this.mEatRequestLayout) {
            this.mEatRequestLayout = true;
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    void resumeRequestLayout(boolean performLayoutChildren) {
        if (this.mEatRequestLayout) {
            if (performLayoutChildren && this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            this.mEatRequestLayout = FORCE_INVALIDATE_DISPLAY_LIST;
            this.mLayoutRequestEaten = FORCE_INVALIDATE_DISPLAY_LIST;
        }
    }

    public void smoothScrollBy(int dx, int dy) {
        if (dx != 0 || dy != 0) {
            this.mViewFlinger.smoothScrollBy(dx, dy);
        }
    }

    public boolean fling(int velocityX, int velocityY) {
        if (Math.abs(velocityX) < this.mMinFlingVelocity) {
            velocityX = TOUCH_SLOP_DEFAULT;
        }
        if (Math.abs(velocityY) < this.mMinFlingVelocity) {
            velocityY = TOUCH_SLOP_DEFAULT;
        }
        velocityX = Math.max(-this.mMaxFlingVelocity, Math.min(velocityX, this.mMaxFlingVelocity));
        velocityY = Math.max(-this.mMaxFlingVelocity, Math.min(velocityY, this.mMaxFlingVelocity));
        if (velocityX == 0 && velocityY == 0) {
            return FORCE_INVALIDATE_DISPLAY_LIST;
        }
        this.mViewFlinger.fling(velocityX, velocityY);
        return true;
    }

    public void stopScroll() {
        setScrollState(TOUCH_SLOP_DEFAULT);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        this.mLayout.stopSmoothScroller();
    }

    private void pullGlows(int overscrollX, int overscrollY) {
        if (overscrollX < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onPull(((float) (-overscrollX)) / ((float) getWidth()));
        } else if (overscrollX > 0) {
            ensureRightGlow();
            this.mRightGlow.onPull(((float) overscrollX) / ((float) getWidth()));
        }
        if (overscrollY < 0) {
            ensureTopGlow();
            this.mTopGlow.onPull(((float) (-overscrollY)) / ((float) getHeight()));
        } else if (overscrollY > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onPull(((float) overscrollY) / ((float) getHeight()));
        }
        if (overscrollX != 0 || overscrollY != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void releaseGlows() {
        boolean needsInvalidate = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLeftGlow != null) {
            needsInvalidate = this.mLeftGlow.onRelease();
        }
        if (this.mTopGlow != null) {
            needsInvalidate |= this.mTopGlow.onRelease();
        }
        if (this.mRightGlow != null) {
            needsInvalidate |= this.mRightGlow.onRelease();
        }
        if (this.mBottomGlow != null) {
            needsInvalidate |= this.mBottomGlow.onRelease();
        }
        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void considerReleasingGlowsOnScroll(int dx, int dy) {
        boolean needsInvalidate = FORCE_INVALIDATE_DISPLAY_LIST;
        if (!(this.mLeftGlow == null || this.mLeftGlow.isFinished() || dx <= 0)) {
            needsInvalidate = this.mLeftGlow.onRelease();
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished() || dx >= 0)) {
            needsInvalidate |= this.mRightGlow.onRelease();
        }
        if (!(this.mTopGlow == null || this.mTopGlow.isFinished() || dy <= 0)) {
            needsInvalidate |= this.mTopGlow.onRelease();
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.isFinished() || dy >= 0)) {
            needsInvalidate |= this.mBottomGlow.onRelease();
        }
        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void absorbGlows(int velocityX, int velocityY) {
        if (velocityX < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-velocityX);
        } else if (velocityX > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(velocityX);
        }
        if (velocityY < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-velocityY);
        } else if (velocityY > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(velocityY);
        }
        if (velocityX != 0 || velocityY != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = new EdgeEffectCompat(getContext());
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public View focusSearch(View focused, int direction) {
        View result = this.mLayout.onInterceptFocusSearch(focused, direction);
        if (result != null) {
            return result;
        }
        result = FocusFinder.getInstance().findNextFocus(this, focused, direction);
        if (result == null && this.mAdapter != null) {
            eatRequestLayout();
            result = this.mLayout.onFocusSearchFailed(focused, direction, this.mRecycler, this.mState);
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        return result != null ? result : super.focusSearch(focused, direction);
    }

    public void requestChildFocus(View child, View focused) {
        boolean z = FORCE_INVALIDATE_DISPLAY_LIST;
        if (!(this.mLayout.onRequestChildFocus(this, this.mState, child, focused) || focused == null)) {
            this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, focused.getWidth(), focused.getHeight());
            offsetDescendantRectToMyCoords(focused, this.mTempRect);
            offsetRectIntoDescendantCoords(child, this.mTempRect);
            Rect rect = this.mTempRect;
            if (!this.mFirstLayoutComplete) {
                z = true;
            }
            requestChildRectangleOnScreen(child, rect, z);
        }
        super.requestChildFocus(child, focused);
    }

    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        return this.mLayout.requestChildRectangleOnScreen(this, child, rect, immediate);
    }

    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        if (!this.mLayout.onAddFocusables(this, views, direction, focusableMode)) {
            super.addFocusables(views, direction, focusableMode);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        this.mFirstLayoutComplete = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout != null) {
            this.mLayout.onAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = FORCE_INVALIDATE_DISPLAY_LIST;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.endAnimations();
        }
        this.mFirstLayoutComplete = FORCE_INVALIDATE_DISPLAY_LIST;
        stopScroll();
        this.mIsAttached = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mLayout != null) {
            this.mLayout.onDetachedFromWindow(this, this.mRecycler);
        }
        removeCallbacks(this.mItemAnimatorRunner);
    }

    void assertInLayoutOrScroll(String message) {
        if (!this.mRunningLayoutOrScroll) {
            if (message == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(message);
        }
    }

    void assertNotInLayoutOrScroll(String message) {
        if (!this.mRunningLayoutOrScroll) {
            return;
        }
        if (message == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(message);
    }

    public void addOnItemTouchListener(OnItemTouchListener listener) {
        this.mOnItemTouchListeners.add(listener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener listener) {
        this.mOnItemTouchListeners.remove(listener);
        if (this.mActiveOnItemTouchListener == listener) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent e) {
        int action = e.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int listenerCount = this.mOnItemTouchListeners.size();
        int i = TOUCH_SLOP_DEFAULT;
        while (i < listenerCount) {
            OnItemTouchListener listener = (OnItemTouchListener) this.mOnItemTouchListeners.get(i);
            if (!listener.onInterceptTouchEvent(this, e) || action == 3) {
                i += VERTICAL;
            } else {
                this.mActiveOnItemTouchListener = listener;
                return true;
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    private boolean dispatchOnItemTouch(MotionEvent e) {
        int action = e.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.onTouchEvent(this, e);
                if (action != 3 && action != VERTICAL) {
                    return true;
                }
                this.mActiveOnItemTouchListener = null;
                return true;
            }
        }
        if (action != 0) {
            int listenerCount = this.mOnItemTouchListeners.size();
            for (int i = TOUCH_SLOP_DEFAULT; i < listenerCount; i += VERTICAL) {
                OnItemTouchListener listener = (OnItemTouchListener) this.mOnItemTouchListeners.get(i);
                if (listener.onInterceptTouchEvent(this, e)) {
                    this.mActiveOnItemTouchListener = listener;
                    return true;
                }
            }
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (dispatchOnItemTouchIntercept(e)) {
            cancelTouch();
            return true;
        }
        boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(e);
        int action = MotionEventCompat.getActionMasked(e);
        int actionIndex = MotionEventCompat.getActionIndex(e);
        int x;
        switch (action) {
            case TOUCH_SLOP_DEFAULT /*0*/:
                this.mScrollPointerId = MotionEventCompat.getPointerId(e, TOUCH_SLOP_DEFAULT);
                x = (int) (e.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                x = (int) (e.getY() + 0.5f);
                this.mLastTouchY = x;
                this.mInitialTouchY = x;
                if (this.mScrollState == SCROLL_STATE_SETTLING) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(VERTICAL);
                    break;
                }
                break;
            case VERTICAL /*1*/:
                this.mVelocityTracker.clear();
                break;
            case SCROLL_STATE_SETTLING /*2*/:
                int index = MotionEventCompat.findPointerIndex(e, this.mScrollPointerId);
                if (index >= 0) {
                    int x2 = (int) (MotionEventCompat.getX(e, index) + 0.5f);
                    int y = (int) (MotionEventCompat.getY(e, index) + 0.5f);
                    if (this.mScrollState != VERTICAL) {
                        int dx = x2 - this.mInitialTouchX;
                        int dy = y - this.mInitialTouchY;
                        boolean startScroll = FORCE_INVALIDATE_DISPLAY_LIST;
                        if (canScrollHorizontally && Math.abs(dx) > this.mTouchSlop) {
                            this.mLastTouchX = ((dx < 0 ? NO_POSITION : VERTICAL) * this.mTouchSlop) + this.mInitialTouchX;
                            startScroll = true;
                        }
                        if (canScrollVertically && Math.abs(dy) > this.mTouchSlop) {
                            this.mLastTouchY = ((dy < 0 ? NO_POSITION : VERTICAL) * this.mTouchSlop) + this.mInitialTouchY;
                            startScroll = true;
                        }
                        if (startScroll) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            setScrollState(VERTICAL);
                            break;
                        }
                    }
                }
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return FORCE_INVALIDATE_DISPLAY_LIST;
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                cancelTouch();
                break;
            case Barcode.PRODUCT /*5*/:
                this.mScrollPointerId = MotionEventCompat.getPointerId(e, actionIndex);
                x = (int) (MotionEventCompat.getX(e, actionIndex) + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                x = (int) (MotionEventCompat.getY(e, actionIndex) + 0.5f);
                this.mLastTouchY = x;
                this.mInitialTouchY = x;
                break;
            case Barcode.SMS /*6*/:
                onPointerUp(e);
                break;
        }
        if (this.mScrollState == VERTICAL) {
            return true;
        }
        return FORCE_INVALIDATE_DISPLAY_LIST;
    }

    public boolean onTouchEvent(MotionEvent e) {
        if (dispatchOnItemTouch(e)) {
            cancelTouch();
            return true;
        }
        boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(e);
        int action = MotionEventCompat.getActionMasked(e);
        int actionIndex = MotionEventCompat.getActionIndex(e);
        int x;
        switch (action) {
            case TOUCH_SLOP_DEFAULT /*0*/:
                this.mScrollPointerId = MotionEventCompat.getPointerId(e, TOUCH_SLOP_DEFAULT);
                x = (int) (e.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                x = (int) (e.getY() + 0.5f);
                this.mLastTouchY = x;
                this.mInitialTouchY = x;
                break;
            case VERTICAL /*1*/:
                this.mVelocityTracker.computeCurrentVelocity(GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, (float) this.mMaxFlingVelocity);
                float xvel = canScrollHorizontally ? -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                float yvel = canScrollVertically ? -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId) : 0.0f;
                if ((xvel == 0.0f && yvel == 0.0f) || !fling((int) xvel, (int) yvel)) {
                    setScrollState(TOUCH_SLOP_DEFAULT);
                }
                this.mVelocityTracker.clear();
                releaseGlows();
                break;
            case SCROLL_STATE_SETTLING /*2*/:
                int index = MotionEventCompat.findPointerIndex(e, this.mScrollPointerId);
                if (index >= 0) {
                    int x2 = (int) (MotionEventCompat.getX(e, index) + 0.5f);
                    int y = (int) (MotionEventCompat.getY(e, index) + 0.5f);
                    if (this.mScrollState != VERTICAL) {
                        int dx = x2 - this.mInitialTouchX;
                        int dy = y - this.mInitialTouchY;
                        boolean startScroll = FORCE_INVALIDATE_DISPLAY_LIST;
                        if (canScrollHorizontally && Math.abs(dx) > this.mTouchSlop) {
                            this.mLastTouchX = ((dx < 0 ? NO_POSITION : VERTICAL) * this.mTouchSlop) + this.mInitialTouchX;
                            startScroll = true;
                        }
                        if (canScrollVertically && Math.abs(dy) > this.mTouchSlop) {
                            this.mLastTouchY = ((dy < 0 ? NO_POSITION : VERTICAL) * this.mTouchSlop) + this.mInitialTouchY;
                            startScroll = true;
                        }
                        if (startScroll) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            setScrollState(VERTICAL);
                        }
                    }
                    if (this.mScrollState == VERTICAL) {
                        scrollByInternal(canScrollHorizontally ? -(x2 - this.mLastTouchX) : TOUCH_SLOP_DEFAULT, canScrollVertically ? -(y - this.mLastTouchY) : TOUCH_SLOP_DEFAULT);
                    }
                    this.mLastTouchX = x2;
                    this.mLastTouchY = y;
                    break;
                }
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return FORCE_INVALIDATE_DISPLAY_LIST;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                cancelTouch();
                break;
            case Barcode.PRODUCT /*5*/:
                this.mScrollPointerId = MotionEventCompat.getPointerId(e, actionIndex);
                x = (int) (MotionEventCompat.getX(e, actionIndex) + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                x = (int) (MotionEventCompat.getY(e, actionIndex) + 0.5f);
                this.mLastTouchY = x;
                this.mInitialTouchY = x;
                break;
            case Barcode.SMS /*6*/:
                onPointerUp(e);
                break;
        }
        return true;
    }

    private void cancelTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        releaseGlows();
        setScrollState(TOUCH_SLOP_DEFAULT);
    }

    private void onPointerUp(MotionEvent e) {
        int actionIndex = MotionEventCompat.getActionIndex(e);
        if (MotionEventCompat.getPointerId(e, actionIndex) == this.mScrollPointerId) {
            int newIndex = actionIndex == 0 ? VERTICAL : TOUCH_SLOP_DEFAULT;
            this.mScrollPointerId = MotionEventCompat.getPointerId(e, newIndex);
            int x = (int) (MotionEventCompat.getX(e, newIndex) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            x = (int) (MotionEventCompat.getY(e, newIndex) + 0.5f);
            this.mLastTouchY = x;
            this.mInitialTouchY = x;
        }
    }

    protected void onMeasure(int widthSpec, int heightSpec) {
        if (this.mAdapterUpdateDuringMeasure) {
            eatRequestLayout();
            processAdapterUpdatesAndSetAnimationFlags();
            if (this.mState.mRunPredictiveAnimations) {
                this.mState.mInPreLayout = true;
            } else {
                this.mAdapterHelper.consumeUpdatesInOnePass();
                this.mState.mInPreLayout = FORCE_INVALIDATE_DISPLAY_LIST;
            }
            this.mAdapterUpdateDuringMeasure = FORCE_INVALIDATE_DISPLAY_LIST;
            resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        }
        if (this.mAdapter != null) {
            this.mState.mItemCount = this.mAdapter.getItemCount();
        } else {
            this.mState.mItemCount = TOUCH_SLOP_DEFAULT;
        }
        this.mLayout.onMeasure(this.mRecycler, this.mState, widthSpec, heightSpec);
        this.mState.mInPreLayout = FORCE_INVALIDATE_DISPLAY_LIST;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(ItemAnimator animator) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = animator;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.setListener(this.mItemAnimatorListener);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    private boolean supportsChangeAnimations() {
        return (this.mItemAnimator == null || !this.mItemAnimator.getSupportsChangeAnimations()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    private void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        boolean z2 = true;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            markKnownViewsInvalid();
            this.mLayout.onItemsChanged(this);
        }
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        } else {
            this.mAdapterHelper.preProcess();
        }
        boolean animationTypeSupported;
        if ((this.mItemsAddedOrRemoved && !this.mItemsChanged) || this.mItemsAddedOrRemoved || (this.mItemsChanged && supportsChangeAnimations())) {
            animationTypeSupported = true;
        } else {
            animationTypeSupported = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        State state = this.mState;
        if (!this.mFirstLayoutComplete || this.mItemAnimator == null || (!(this.mDataSetHasChangedAfterLayout || animationTypeSupported || this.mLayout.mRequestedSimpleAnimations) || (this.mDataSetHasChangedAfterLayout && !this.mAdapter.hasStableIds()))) {
            z = FORCE_INVALIDATE_DISPLAY_LIST;
        } else {
            z = true;
        }
        state.mRunSimpleAnimations = z;
        State state2 = this.mState;
        if (!(this.mState.mRunSimpleAnimations && animationTypeSupported && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled())) {
            z2 = FORCE_INVALIDATE_DISPLAY_LIST;
        }
        state2.mRunPredictiveAnimations = z2;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        int count;
        int i;
        ViewHolder holder;
        this.mDisappearingViewsInLayoutPass.clear();
        eatRequestLayout();
        this.mRunningLayoutOrScroll = true;
        processAdapterUpdatesAndSetAnimationFlags();
        State state = this.mState;
        ArrayMap arrayMap = (this.mState.mRunSimpleAnimations && this.mItemsChanged && supportsChangeAnimations()) ? new ArrayMap() : null;
        state.mOldChangedHolders = arrayMap;
        this.mItemsChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mItemsAddedOrRemoved = FORCE_INVALIDATE_DISPLAY_LIST;
        ArrayMap<View, Rect> appearingViewInitialBounds = null;
        this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.getItemCount();
        if (this.mState.mRunSimpleAnimations) {
            this.mState.mPreLayoutHolderMap.clear();
            this.mState.mPostLayoutHolderMap.clear();
            count = this.mChildHelper.getChildCount();
            for (i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
                holder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (!holder.shouldIgnore() && (!holder.isInvalid() || this.mAdapter.hasStableIds())) {
                    View view = holder.itemView;
                    this.mState.mPreLayoutHolderMap.put(holder, new ItemHolderInfo(holder, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            if (this.mState.mOldChangedHolders != null) {
                count = this.mChildHelper.getChildCount();
                for (i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
                    holder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                    if (!(!holder.isChanged() || holder.isRemoved() || holder.shouldIgnore())) {
                        this.mState.mOldChangedHolders.put(Long.valueOf(getChangedHolderKey(holder)), holder);
                        this.mState.mPreLayoutHolderMap.remove(holder);
                    }
                }
            }
            boolean didStructureChange = this.mState.mStructureChanged;
            this.mState.mStructureChanged = FORCE_INVALIDATE_DISPLAY_LIST;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.mStructureChanged = didStructureChange;
            appearingViewInitialBounds = new ArrayMap();
            for (i = TOUCH_SLOP_DEFAULT; i < this.mChildHelper.getChildCount(); i += VERTICAL) {
                boolean found = FORCE_INVALIDATE_DISPLAY_LIST;
                View child = this.mChildHelper.getChildAt(i);
                if (!getChildViewHolderInt(child).shouldIgnore()) {
                    for (int j = TOUCH_SLOP_DEFAULT; j < this.mState.mPreLayoutHolderMap.size(); j += VERTICAL) {
                        if (((ViewHolder) this.mState.mPreLayoutHolderMap.keyAt(j)).itemView == child) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        appearingViewInitialBounds.put(child, new Rect(child.getLeft(), child.getTop(), child.getRight(), child.getBottom()));
                    }
                }
            }
            clearOldPositions();
            this.mAdapterHelper.consumePostponedUpdates();
        } else {
            clearOldPositions();
            this.mAdapterHelper.consumeUpdatesInOnePass();
            if (this.mState.mOldChangedHolders != null) {
                count = this.mChildHelper.getChildCount();
                for (i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
                    holder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                    if (!(!holder.isChanged() || holder.isRemoved() || holder.shouldIgnore())) {
                        this.mState.mOldChangedHolders.put(Long.valueOf(getChangedHolderKey(holder)), holder);
                        this.mState.mPreLayoutHolderMap.remove(holder);
                    }
                }
            }
        }
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = TOUCH_SLOP_DEFAULT;
        this.mState.mInPreLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mPendingSavedState = null;
        state = this.mState;
        boolean z = (!this.mState.mRunSimpleAnimations || this.mItemAnimator == null) ? FORCE_INVALIDATE_DISPLAY_LIST : true;
        state.mRunSimpleAnimations = z;
        if (this.mState.mRunSimpleAnimations) {
            long key;
            ArrayMap<Long, ViewHolder> newChangedHolders = this.mState.mOldChangedHolders != null ? new ArrayMap() : null;
            count = this.mChildHelper.getChildCount();
            for (i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
                holder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (!holder.shouldIgnore()) {
                    view = holder.itemView;
                    key = getChangedHolderKey(holder);
                    if (newChangedHolders == null || this.mState.mOldChangedHolders.get(Long.valueOf(key)) == null) {
                        this.mState.mPostLayoutHolderMap.put(holder, new ItemHolderInfo(holder, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    } else {
                        newChangedHolders.put(Long.valueOf(key), holder);
                    }
                }
            }
            processDisappearingList(appearingViewInitialBounds);
            for (i = this.mState.mPreLayoutHolderMap.size() + NO_POSITION; i >= 0; i += NO_POSITION) {
                if (!this.mState.mPostLayoutHolderMap.containsKey((ViewHolder) this.mState.mPreLayoutHolderMap.keyAt(i))) {
                    ItemHolderInfo disappearingItem = (ItemHolderInfo) this.mState.mPreLayoutHolderMap.valueAt(i);
                    this.mState.mPreLayoutHolderMap.removeAt(i);
                    View disappearingItemView = disappearingItem.holder.itemView;
                    this.mRecycler.unscrapView(disappearingItem.holder);
                    animateDisappearance(disappearingItem);
                }
            }
            int postLayoutCount = this.mState.mPostLayoutHolderMap.size();
            if (postLayoutCount > 0) {
                for (i = postLayoutCount + NO_POSITION; i >= 0; i += NO_POSITION) {
                    ViewHolder itemHolder = (ViewHolder) this.mState.mPostLayoutHolderMap.keyAt(i);
                    ItemHolderInfo info = (ItemHolderInfo) this.mState.mPostLayoutHolderMap.valueAt(i);
                    if (this.mState.mPreLayoutHolderMap.isEmpty() || !this.mState.mPreLayoutHolderMap.containsKey(itemHolder)) {
                        this.mState.mPostLayoutHolderMap.removeAt(i);
                        animateAppearance(itemHolder, appearingViewInitialBounds != null ? (Rect) appearingViewInitialBounds.get(itemHolder.itemView) : null, info.left, info.top);
                    }
                }
            }
            count = this.mState.mPostLayoutHolderMap.size();
            for (i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
                ViewHolder postHolder = (ViewHolder) this.mState.mPostLayoutHolderMap.keyAt(i);
                ItemHolderInfo postInfo = (ItemHolderInfo) this.mState.mPostLayoutHolderMap.valueAt(i);
                ItemHolderInfo preInfo = (ItemHolderInfo) this.mState.mPreLayoutHolderMap.get(postHolder);
                if (!(preInfo == null || postInfo == null || (preInfo.left == postInfo.left && preInfo.top == postInfo.top))) {
                    postHolder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
                    if (this.mItemAnimator.animateMove(postHolder, preInfo.left, preInfo.top, postInfo.left, postInfo.top)) {
                        postAnimationRunner();
                    }
                }
            }
            for (i = (this.mState.mOldChangedHolders != null ? this.mState.mOldChangedHolders.size() : TOUCH_SLOP_DEFAULT) + NO_POSITION; i >= 0; i += NO_POSITION) {
                key = ((Long) this.mState.mOldChangedHolders.keyAt(i)).longValue();
                ViewHolder oldHolder = (ViewHolder) this.mState.mOldChangedHolders.get(Long.valueOf(key));
                View oldView = oldHolder.itemView;
                if (!(oldHolder.shouldIgnore() || this.mRecycler.mChangedScrap == null || !this.mRecycler.mChangedScrap.contains(oldHolder))) {
                    animateChange(oldHolder, (ViewHolder) newChangedHolders.get(Long.valueOf(key)));
                }
            }
        }
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
        this.mDataSetHasChangedAfterLayout = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.mRunSimpleAnimations = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mState.mRunPredictiveAnimations = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mRunningLayoutOrScroll = FORCE_INVALIDATE_DISPLAY_LIST;
        this.mLayout.mRequestedSimpleAnimations = FORCE_INVALIDATE_DISPLAY_LIST;
        if (this.mRecycler.mChangedScrap != null) {
            this.mRecycler.mChangedScrap.clear();
        }
        this.mState.mOldChangedHolders = null;
    }

    protected void removeDetachedView(View child, boolean animate) {
        ViewHolder vh = getChildViewHolderInt(child);
        if (vh != null) {
            if (vh.isTmpDetached()) {
                vh.clearTmpDetachFlag();
            } else if (!vh.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + vh);
            }
        }
        dispatchChildDetached(child);
        super.removeDetachedView(child, animate);
    }

    long getChangedHolderKey(ViewHolder holder) {
        return this.mAdapter.hasStableIds() ? holder.getItemId() : (long) holder.mPosition;
    }

    private void processDisappearingList(ArrayMap<View, Rect> appearingViews) {
        int count = this.mDisappearingViewsInLayoutPass.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
            View view = (View) this.mDisappearingViewsInLayoutPass.get(i);
            ViewHolder vh = getChildViewHolderInt(view);
            ItemHolderInfo info = (ItemHolderInfo) this.mState.mPreLayoutHolderMap.remove(vh);
            if (!this.mState.isPreLayout()) {
                this.mState.mPostLayoutHolderMap.remove(vh);
            }
            if (appearingViews.remove(view) != null) {
                this.mLayout.removeAndRecycleView(view, this.mRecycler);
            } else if (info != null) {
                animateDisappearance(info);
            } else {
                animateDisappearance(new ItemHolderInfo(vh, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }
        this.mDisappearingViewsInLayoutPass.clear();
    }

    private void animateAppearance(ViewHolder itemHolder, Rect beforeBounds, int afterLeft, int afterTop) {
        View newItemView = itemHolder.itemView;
        if (beforeBounds == null || (beforeBounds.left == afterLeft && beforeBounds.top == afterTop)) {
            itemHolder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
            if (this.mItemAnimator.animateAdd(itemHolder)) {
                postAnimationRunner();
                return;
            }
            return;
        }
        itemHolder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        if (this.mItemAnimator.animateMove(itemHolder, beforeBounds.left, beforeBounds.top, afterLeft, afterTop)) {
            postAnimationRunner();
        }
    }

    private void animateDisappearance(ItemHolderInfo disappearingItem) {
        View disappearingItemView = disappearingItem.holder.itemView;
        addAnimatingView(disappearingItem.holder);
        int oldLeft = disappearingItem.left;
        int oldTop = disappearingItem.top;
        int newLeft = disappearingItemView.getLeft();
        int newTop = disappearingItemView.getTop();
        if (oldLeft == newLeft && oldTop == newTop) {
            disappearingItem.holder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
            if (this.mItemAnimator.animateRemove(disappearingItem.holder)) {
                postAnimationRunner();
                return;
            }
            return;
        }
        disappearingItem.holder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        disappearingItemView.layout(newLeft, newTop, disappearingItemView.getWidth() + newLeft, disappearingItemView.getHeight() + newTop);
        if (this.mItemAnimator.animateMove(disappearingItem.holder, oldLeft, oldTop, newLeft, newTop)) {
            postAnimationRunner();
        }
    }

    private void animateChange(ViewHolder oldHolder, ViewHolder newHolder) {
        int toLeft;
        int toTop;
        oldHolder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
        addAnimatingView(oldHolder);
        oldHolder.mShadowedHolder = newHolder;
        this.mRecycler.unscrapView(oldHolder);
        int fromLeft = oldHolder.itemView.getLeft();
        int fromTop = oldHolder.itemView.getTop();
        if (newHolder == null || newHolder.shouldIgnore()) {
            toLeft = fromLeft;
            toTop = fromTop;
        } else {
            toLeft = newHolder.itemView.getLeft();
            toTop = newHolder.itemView.getTop();
            newHolder.setIsRecyclable(FORCE_INVALIDATE_DISPLAY_LIST);
            newHolder.mShadowingHolder = oldHolder;
        }
        if (this.mItemAnimator.animateChange(oldHolder, newHolder, fromLeft, fromTop, toLeft, toTop)) {
            postAnimationRunner();
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        eatRequestLayout();
        dispatchLayout();
        resumeRequestLayout(FORCE_INVALIDATE_DISPLAY_LIST);
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mEatRequestLayout) {
            this.mLayoutRequestEaten = true;
        } else {
            super.requestLayout();
        }
    }

    void markItemDecorInsetsDirty() {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void draw(Canvas c) {
        int padding;
        int i;
        int i2 = VERTICAL;
        super.draw(c);
        int count = this.mItemDecorations.size();
        for (int i3 = TOUCH_SLOP_DEFAULT; i3 < count; i3 += VERTICAL) {
            ((ItemDecoration) this.mItemDecorations.get(i3)).onDrawOver(c, this, this.mState);
        }
        boolean needsInvalidate = FORCE_INVALIDATE_DISPLAY_LIST;
        if (!(this.mLeftGlow == null || this.mLeftGlow.isFinished())) {
            int restore = c.save();
            if (this.mClipToPadding) {
                padding = getPaddingBottom();
            } else {
                padding = TOUCH_SLOP_DEFAULT;
            }
            c.rotate(BitmapDescriptorFactory.HUE_VIOLET);
            c.translate((float) ((-getHeight()) + padding), 0.0f);
            if (this.mLeftGlow == null || !this.mLeftGlow.draw(c)) {
                needsInvalidate = FORCE_INVALIDATE_DISPLAY_LIST;
            } else {
                needsInvalidate = true;
            }
            c.restoreToCount(restore);
        }
        if (!(this.mTopGlow == null || this.mTopGlow.isFinished())) {
            restore = c.save();
            if (this.mClipToPadding) {
                c.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.mTopGlow == null || !this.mTopGlow.draw(c)) {
                i = TOUCH_SLOP_DEFAULT;
            } else {
                i = VERTICAL;
            }
            needsInvalidate |= i;
            c.restoreToCount(restore);
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished())) {
            restore = c.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                padding = getPaddingTop();
            } else {
                padding = TOUCH_SLOP_DEFAULT;
            }
            c.rotate(90.0f);
            c.translate((float) (-padding), (float) (-width));
            if (this.mRightGlow == null || !this.mRightGlow.draw(c)) {
                i = TOUCH_SLOP_DEFAULT;
            } else {
                i = VERTICAL;
            }
            needsInvalidate |= i;
            c.restoreToCount(restore);
        }
        if (!(this.mBottomGlow == null || this.mBottomGlow.isFinished())) {
            restore = c.save();
            c.rotate(BitmapDescriptorFactory.HUE_CYAN);
            if (this.mClipToPadding) {
                c.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                c.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow == null || !this.mBottomGlow.draw(c)) {
                i2 = TOUCH_SLOP_DEFAULT;
            }
            needsInvalidate |= i2;
            c.restoreToCount(restore);
        }
        if (!needsInvalidate && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.isRunning()) {
            needsInvalidate = true;
        }
        if (needsInvalidate) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        int count = this.mItemDecorations.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < count; i += VERTICAL) {
            ((ItemDecoration) this.mItemDecorations.get(i)).onDraw(c, this, this.mState);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return ((p instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) p)) ? true : FORCE_INVALIDATE_DISPLAY_LIST;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(getContext(), attrs);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(p);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void saveOldPositions() {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!holder.shouldIgnore()) {
                holder.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!holder.shouldIgnore()) {
                holder.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    void offsetPositionRecordsForMove(int from, int to) {
        int inBetweenOffset;
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        int start;
        int end;
        if (from < to) {
            start = from;
            end = to;
            inBetweenOffset = NO_POSITION;
        } else {
            start = to;
            end = from;
            inBetweenOffset = VERTICAL;
        }
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (holder != null && holder.mPosition >= start && holder.mPosition <= end) {
                if (holder.mPosition == from) {
                    holder.offsetPosition(to - from, FORCE_INVALIDATE_DISPLAY_LIST);
                } else {
                    holder.offsetPosition(inBetweenOffset, FORCE_INVALIDATE_DISPLAY_LIST);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(from, to);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int positionStart, int itemCount) {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!(holder == null || holder.shouldIgnore() || holder.mPosition < positionStart)) {
                holder.offsetPosition(itemCount, FORCE_INVALIDATE_DISPLAY_LIST);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(positionStart, itemCount);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int positionStart, int itemCount, boolean applyToPreLayout) {
        int positionEnd = positionStart + itemCount;
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!(holder == null || holder.shouldIgnore())) {
                if (holder.mPosition >= positionEnd) {
                    holder.offsetPosition(-itemCount, applyToPreLayout);
                    this.mState.mStructureChanged = true;
                } else if (holder.mPosition >= positionStart) {
                    holder.flagRemovedAndOffsetPosition(positionStart + NO_POSITION, -itemCount, applyToPreLayout);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(positionStart, itemCount, applyToPreLayout);
        requestLayout();
    }

    void viewRangeUpdate(int positionStart, int itemCount) {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        int positionEnd = positionStart + itemCount;
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            View child = this.mChildHelper.getUnfilteredChildAt(i);
            ViewHolder holder = getChildViewHolderInt(child);
            if (holder != null && !holder.shouldIgnore() && holder.mPosition >= positionStart && holder.mPosition < positionEnd) {
                holder.addFlags(SCROLL_STATE_SETTLING);
                if (supportsChangeAnimations()) {
                    holder.addFlags(64);
                }
                ((LayoutParams) child.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.viewRangeUpdate(positionStart, itemCount);
    }

    void rebindUpdatedViewHolders() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (!(holder == null || holder.shouldIgnore())) {
                if (holder.isRemoved() || holder.isInvalid()) {
                    requestLayout();
                } else if (holder.needsUpdate()) {
                    if (holder.getItemViewType() != this.mAdapter.getItemViewType(holder.mPosition)) {
                        holder.addFlags(4);
                        requestLayout();
                    } else if (holder.isChanged() && supportsChangeAnimations()) {
                        requestLayout();
                    } else {
                        this.mAdapter.bindViewHolder(holder, holder.mPosition);
                    }
                }
            }
        }
    }

    void markKnownViewsInvalid() {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!(holder == null || holder.shouldIgnore())) {
                holder.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public ViewHolder getChildViewHolder(View child) {
        Object parent = child.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(child);
        }
        throw new IllegalArgumentException("View " + child + " is not a direct child of " + this);
    }

    static ViewHolder getChildViewHolderInt(View child) {
        if (child == null) {
            return null;
        }
        return ((LayoutParams) child.getLayoutParams()).mViewHolder;
    }

    public int getChildPosition(View child) {
        ViewHolder holder = getChildViewHolderInt(child);
        return holder != null ? holder.getPosition() : NO_POSITION;
    }

    public long getChildItemId(View child) {
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return NO_ID;
        }
        ViewHolder holder = getChildViewHolderInt(child);
        if (holder != null) {
            return holder.getItemId();
        }
        return NO_ID;
    }

    public ViewHolder findViewHolderForPosition(int position) {
        return findViewHolderForPosition(position, FORCE_INVALIDATE_DISPLAY_LIST);
    }

    ViewHolder findViewHolderForPosition(int position, boolean checkNewPosition) {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!(holder == null || holder.isRemoved())) {
                if (checkNewPosition) {
                    if (holder.mPosition == position) {
                        return holder;
                    }
                } else if (holder.getPosition() == position) {
                    return holder;
                }
            }
        }
        return null;
    }

    public ViewHolder findViewHolderForItemId(long id) {
        int childCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            ViewHolder holder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (holder != null && holder.getItemId() == id) {
                return holder;
            }
        }
        return null;
    }

    public View findChildViewUnder(float x, float y) {
        for (int i = this.mChildHelper.getChildCount() + NO_POSITION; i >= 0; i += NO_POSITION) {
            View child = this.mChildHelper.getChildAt(i);
            float translationX = ViewCompat.getTranslationX(child);
            float translationY = ViewCompat.getTranslationY(child);
            if (x >= ((float) child.getLeft()) + translationX && x <= ((float) child.getRight()) + translationX && y >= ((float) child.getTop()) + translationY && y <= ((float) child.getBottom()) + translationY) {
                return child;
            }
        }
        return null;
    }

    public void offsetChildrenVertical(int dy) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            this.mChildHelper.getChildAt(i).offsetTopAndBottom(dy);
        }
    }

    public void onChildAttachedToWindow(View child) {
    }

    public void onChildDetachedFromWindow(View child) {
    }

    public void offsetChildrenHorizontal(int dx) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = TOUCH_SLOP_DEFAULT; i < childCount; i += VERTICAL) {
            this.mChildHelper.getChildAt(i).offsetLeftAndRight(dx);
        }
    }

    Rect getItemDecorInsetsForChild(View child) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        if (!lp.mInsetsDirty) {
            return lp.mDecorInsets;
        }
        Rect insets = lp.mDecorInsets;
        insets.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
        int decorCount = this.mItemDecorations.size();
        for (int i = TOUCH_SLOP_DEFAULT; i < decorCount; i += VERTICAL) {
            this.mTempRect.set(TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT, TOUCH_SLOP_DEFAULT);
            ((ItemDecoration) this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, child, this, this.mState);
            insets.left += this.mTempRect.left;
            insets.top += this.mTempRect.top;
            insets.right += this.mTempRect.right;
            insets.bottom += this.mTempRect.bottom;
        }
        lp.mInsetsDirty = FORCE_INVALIDATE_DISPLAY_LIST;
        return insets;
    }

    private void dispatchChildDetached(View child) {
        if (this.mAdapter != null) {
            this.mAdapter.onViewDetachedFromWindow(getChildViewHolderInt(child));
        }
        onChildDetachedFromWindow(child);
    }

    private void dispatchChildAttached(View child) {
        if (this.mAdapter != null) {
            this.mAdapter.onViewAttachedToWindow(getChildViewHolderInt(child));
        }
        onChildAttachedToWindow(child);
    }

    private void removeFromDisappearingList(View child) {
        this.mDisappearingViewsInLayoutPass.remove(child);
    }

    private void addToDisappearingList(View child) {
        if (!this.mDisappearingViewsInLayoutPass.contains(child)) {
            this.mDisappearingViewsInLayoutPass.add(child);
        }
    }
}
