package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.bumptech.glide.request.target.Target;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    static final int MAIN_DIR_SPEC;
    private static final String TAG = "GridLayoutManager";
    final Rect mDecorInsets;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSizePerSpan;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanIndexCache;

        public abstract int getSpanSize(int i);

        public SpanSizeLookup() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = GridLayoutManager.DEBUG;
        }

        public void setSpanIndexCacheEnabled(boolean cacheSpanIndices) {
            this.mCacheSpanIndices = cacheSpanIndices;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        int getCachedSpanIndex(int position, int spanCount) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(position, spanCount);
            }
            int existing = this.mSpanIndexCache.get(position, GridLayoutManager.DEFAULT_SPAN_COUNT);
            if (existing != GridLayoutManager.DEFAULT_SPAN_COUNT) {
                return existing;
            }
            int value = getSpanIndex(position, spanCount);
            this.mSpanIndexCache.put(position, value);
            return value;
        }

        public int getSpanIndex(int position, int spanCount) {
            int positionSpanSize = getSpanSize(position);
            if (positionSpanSize == spanCount) {
                return GridLayoutManager.MAIN_DIR_SPEC;
            }
            int span = GridLayoutManager.MAIN_DIR_SPEC;
            int startPos = GridLayoutManager.MAIN_DIR_SPEC;
            if (this.mCacheSpanIndices && this.mSpanIndexCache.size() > 0) {
                int prevKey = findReferenceIndexFromCache(position);
                if (prevKey >= 0) {
                    span = this.mSpanIndexCache.get(prevKey) + getSpanSize(prevKey);
                    startPos = prevKey + 1;
                }
            }
            for (int i = startPos; i < position; i++) {
                int size = getSpanSize(i);
                span += size;
                if (span == spanCount) {
                    span = GridLayoutManager.MAIN_DIR_SPEC;
                } else if (span > spanCount) {
                    span = size;
                }
            }
            if (span + positionSpanSize > spanCount) {
                return GridLayoutManager.MAIN_DIR_SPEC;
            }
            return span;
        }

        int findReferenceIndexFromCache(int position) {
            int lo = GridLayoutManager.MAIN_DIR_SPEC;
            int hi = this.mSpanIndexCache.size() + GridLayoutManager.DEFAULT_SPAN_COUNT;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (this.mSpanIndexCache.keyAt(mid) < position) {
                    lo = mid + 1;
                } else {
                    hi = mid + GridLayoutManager.DEFAULT_SPAN_COUNT;
                }
            }
            int index = lo + GridLayoutManager.DEFAULT_SPAN_COUNT;
            if (index < 0 || index >= this.mSpanIndexCache.size()) {
                return GridLayoutManager.DEFAULT_SPAN_COUNT;
            }
            return this.mSpanIndexCache.keyAt(index);
        }

        public int getSpanGroupIndex(int adapterPosition, int spanCount) {
            int span = GridLayoutManager.MAIN_DIR_SPEC;
            int group = GridLayoutManager.MAIN_DIR_SPEC;
            int positionSpanSize = getSpanSize(adapterPosition);
            for (int i = GridLayoutManager.MAIN_DIR_SPEC; i < adapterPosition; i++) {
                int size = getSpanSize(i);
                span += size;
                if (span == spanCount) {
                    span = GridLayoutManager.MAIN_DIR_SPEC;
                    group++;
                } else if (span > spanCount) {
                    span = size;
                    group++;
                }
            }
            if (span + positionSpanSize > spanCount) {
                return group + 1;
            }
            return group;
        }
    }

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanSize(int position) {
            return 1;
        }

        public int getSpanIndex(int position, int spanCount) {
            return position % spanCount;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        private int mSpanIndex;
        private int mSpanSize;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super(source);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams source) {
            super(source);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    static {
        MAIN_DIR_SPEC = MeasureSpec.makeMeasureSpec(MAIN_DIR_SPEC, MAIN_DIR_SPEC);
    }

    public GridLayoutManager(Context context, int spanCount) {
        super(context);
        this.mSpanCount = DEFAULT_SPAN_COUNT;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(spanCount);
    }

    public GridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.mSpanCount = DEFAULT_SPAN_COUNT;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(spanCount);
    }

    public void setStackFromEnd(boolean stackFromEnd) {
        if (stackFromEnd) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(DEBUG);
    }

    public int getRowCountForAccessibility(Recycler recycler, State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return MAIN_DIR_SPEC;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() + DEFAULT_SPAN_COUNT);
    }

    public int getColumnCountForAccessibility(Recycler recycler, State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return MAIN_DIR_SPEC;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() + DEFAULT_SPAN_COUNT);
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View host, AccessibilityNodeInfoCompat info) {
        android.view.ViewGroup.LayoutParams lp = host.getLayoutParams();
        if (lp instanceof LayoutParams) {
            LayoutParams glp = (LayoutParams) lp;
            int spanGroupIndex = getSpanGroupIndex(recycler, state, glp.getViewPosition());
            if (this.mOrientation == 0) {
                int spanIndex = glp.getSpanIndex();
                int spanSize = glp.getSpanSize();
                boolean z = (this.mSpanCount <= 1 || glp.getSpanSize() != this.mSpanCount) ? DEBUG : true;
                info.setCollectionItemInfo(CollectionItemInfoCompat.obtain(spanIndex, spanSize, spanGroupIndex, 1, z, DEBUG));
                return;
            }
            int spanIndex2 = glp.getSpanIndex();
            int spanSize2 = glp.getSpanSize();
            boolean z2 = (this.mSpanCount <= 1 || glp.getSpanSize() != this.mSpanCount) ? DEBUG : true;
            info.setCollectionItemInfo(CollectionItemInfoCompat.obtain(spanGroupIndex, 1, spanIndex2, spanSize2, z2, DEBUG));
            return;
        }
        super.onInitializeAccessibilityNodeInfoForItem(host, info);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = MAIN_DIR_SPEC; i < childCount; i++) {
            LayoutParams lp = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewPosition = lp.getViewPosition();
            this.mPreLayoutSpanSizeCache.put(viewPosition, lp.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewPosition, lp.getSpanIndex());
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return new LayoutParams(c, attrs);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) {
        if (lp instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) lp);
        }
        return new LayoutParams(lp);
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void updateMeasurements() {
        int totalSpace;
        if (getOrientation() == 1) {
            totalSpace = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            totalSpace = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        this.mSizePerSpan = totalSpace / this.mSpanCount;
    }

    void onAnchorReady(State state, AnchorInfo anchorInfo) {
        super.onAnchorReady(state, anchorInfo);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInFirstSpan(anchorInfo);
        }
        if (this.mSet == null || this.mSet.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private void ensureAnchorIsInFirstSpan(AnchorInfo anchorInfo) {
        int span = this.mSpanSizeLookup.getCachedSpanIndex(anchorInfo.mPosition, this.mSpanCount);
        while (span > 0 && anchorInfo.mPosition > 0) {
            anchorInfo.mPosition += DEFAULT_SPAN_COUNT;
            span = this.mSpanSizeLookup.getCachedSpanIndex(anchorInfo.mPosition, this.mSpanCount);
        }
    }

    private int getSpanGroupIndex(Recycler recycler, State state, int viewPosition) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanGroupIndex(viewPosition, this.mSpanCount);
        }
        int adapterPosition = recycler.convertPreLayoutPositionToPostLayout(viewPosition);
        if (adapterPosition != DEFAULT_SPAN_COUNT) {
            return this.mSpanSizeLookup.getSpanGroupIndex(adapterPosition, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + viewPosition);
        return MAIN_DIR_SPEC;
    }

    private int getSpanIndex(Recycler recycler, State state, int pos) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(pos, this.mSpanCount);
        }
        int cached = this.mPreLayoutSpanIndexCache.get(pos, DEFAULT_SPAN_COUNT);
        if (cached != DEFAULT_SPAN_COUNT) {
            return cached;
        }
        int adapterPosition = recycler.convertPreLayoutPositionToPostLayout(pos);
        if (adapterPosition != DEFAULT_SPAN_COUNT) {
            return this.mSpanSizeLookup.getCachedSpanIndex(adapterPosition, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + pos);
        return MAIN_DIR_SPEC;
    }

    private int getSpanSize(Recycler recycler, State state, int pos) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(pos);
        }
        int cached = this.mPreLayoutSpanSizeCache.get(pos, DEFAULT_SPAN_COUNT);
        if (cached != DEFAULT_SPAN_COUNT) {
            return cached;
        }
        int adapterPosition = recycler.convertPreLayoutPositionToPostLayout(pos);
        if (adapterPosition != DEFAULT_SPAN_COUNT) {
            return this.mSpanSizeLookup.getSpanSize(adapterPosition);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + pos);
        return 1;
    }

    void layoutChunk(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult result) {
        View view;
        boolean layingOutInPrimaryDirection = layoutState.mItemDirection == 1 ? true : DEBUG;
        int count = MAIN_DIR_SPEC;
        int consumedSpanCount = MAIN_DIR_SPEC;
        int remainingSpan = this.mSpanCount;
        if (!layingOutInPrimaryDirection) {
            remainingSpan = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        while (count < this.mSpanCount && layoutState.hasMore(state) && remainingSpan > 0) {
            int pos = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, pos);
            if (spanSize <= this.mSpanCount) {
                remainingSpan -= spanSize;
                if (remainingSpan >= 0) {
                    view = layoutState.next(recycler);
                    if (view == null) {
                        break;
                    }
                    consumedSpanCount += spanSize;
                    this.mSet[count] = view;
                    count++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + pos + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
        }
        if (count == 0) {
            result.mFinished = true;
            return;
        }
        int i;
        int maxSize = MAIN_DIR_SPEC;
        assignSpans(recycler, state, count, consumedSpanCount, layingOutInPrimaryDirection);
        for (i = MAIN_DIR_SPEC; i < count; i++) {
            view = this.mSet[i];
            if (layoutState.mScrapList == null) {
                if (layingOutInPrimaryDirection) {
                    addView(view);
                } else {
                    addView(view, MAIN_DIR_SPEC);
                }
            } else if (layingOutInPrimaryDirection) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, MAIN_DIR_SPEC);
            }
            int spec = MeasureSpec.makeMeasureSpec(this.mSizePerSpan * getSpanSize(recycler, state, getPosition(view)), 1073741824);
            LayoutParams lp = (LayoutParams) view.getLayoutParams();
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, spec, getMainDirSpec(lp.height));
            } else {
                measureChildWithDecorationsAndMargin(view, getMainDirSpec(lp.width), spec);
            }
            int size = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (size > maxSize) {
                maxSize = size;
            }
        }
        int maxMeasureSpec = getMainDirSpec(maxSize);
        for (i = MAIN_DIR_SPEC; i < count; i++) {
            view = this.mSet[i];
            if (this.mOrientationHelper.getDecoratedMeasurement(view) != maxSize) {
                spec = MeasureSpec.makeMeasureSpec(this.mSizePerSpan * getSpanSize(recycler, state, getPosition(view)), 1073741824);
                if (this.mOrientation == 1) {
                    measureChildWithDecorationsAndMargin(view, spec, maxMeasureSpec);
                } else {
                    measureChildWithDecorationsAndMargin(view, maxMeasureSpec, spec);
                }
            }
        }
        result.mConsumed = maxSize;
        int left = MAIN_DIR_SPEC;
        int right = MAIN_DIR_SPEC;
        int top = MAIN_DIR_SPEC;
        int bottom = MAIN_DIR_SPEC;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == DEFAULT_SPAN_COUNT) {
                bottom = layoutState.mOffset;
                top = bottom - maxSize;
            } else {
                top = layoutState.mOffset;
                bottom = top + maxSize;
            }
        } else if (layoutState.mLayoutDirection == DEFAULT_SPAN_COUNT) {
            right = layoutState.mOffset;
            left = right - maxSize;
        } else {
            left = layoutState.mOffset;
            right = left + maxSize;
        }
        for (i = MAIN_DIR_SPEC; i < count; i++) {
            view = this.mSet[i];
            LayoutParams params = (LayoutParams) view.getLayoutParams();
            if (this.mOrientation == 1) {
                left = getPaddingLeft() + (this.mSizePerSpan * params.mSpanIndex);
                right = left + this.mOrientationHelper.getDecoratedMeasurementInOther(view);
            } else {
                top = getPaddingTop() + (this.mSizePerSpan * params.mSpanIndex);
                bottom = top + this.mOrientationHelper.getDecoratedMeasurementInOther(view);
            }
            layoutDecorated(view, left + params.leftMargin, top + params.topMargin, right - params.rightMargin, bottom - params.bottomMargin);
            if (params.isItemRemoved() || params.isItemChanged()) {
                result.mIgnoreConsumed = true;
            }
            result.mFocusable |= view.isFocusable();
        }
        Arrays.fill(this.mSet, null);
    }

    private int getMainDirSpec(int dim) {
        if (dim < 0) {
            return MAIN_DIR_SPEC;
        }
        return MeasureSpec.makeMeasureSpec(dim, 1073741824);
    }

    private void measureChildWithDecorationsAndMargin(View child, int widthSpec, int heightSpec) {
        calculateItemDecorationsForChild(child, this.mDecorInsets);
        android.support.v7.widget.RecyclerView.LayoutParams lp = (android.support.v7.widget.RecyclerView.LayoutParams) child.getLayoutParams();
        child.measure(updateSpecWithExtra(widthSpec, lp.leftMargin + this.mDecorInsets.left, lp.rightMargin + this.mDecorInsets.right), updateSpecWithExtra(heightSpec, lp.topMargin + this.mDecorInsets.top, lp.bottomMargin + this.mDecorInsets.bottom));
    }

    private int updateSpecWithExtra(int spec, int startInset, int endInset) {
        if (startInset == 0 && endInset == 0) {
            return spec;
        }
        int mode = MeasureSpec.getMode(spec);
        if (mode == Target.SIZE_ORIGINAL || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(spec) - startInset) - endInset, mode);
        }
        return spec;
    }

    private void assignSpans(Recycler recycler, State state, int count, int consumedSpanCount, boolean layingOutInPrimaryDirection) {
        int start;
        int end;
        int diff;
        int span;
        int spanDiff;
        if (layingOutInPrimaryDirection) {
            start = MAIN_DIR_SPEC;
            end = count;
            diff = 1;
        } else {
            start = count + DEFAULT_SPAN_COUNT;
            end = DEFAULT_SPAN_COUNT;
            diff = DEFAULT_SPAN_COUNT;
        }
        if (this.mOrientation == 1 && isLayoutRTL()) {
            span = consumedSpanCount + DEFAULT_SPAN_COUNT;
            spanDiff = DEFAULT_SPAN_COUNT;
        } else {
            span = MAIN_DIR_SPEC;
            spanDiff = 1;
        }
        for (int i = start; i != end; i += diff) {
            View view = this.mSet[i];
            LayoutParams params = (LayoutParams) view.getLayoutParams();
            params.mSpanSize = getSpanSize(recycler, state, getPosition(view));
            if (spanDiff != DEFAULT_SPAN_COUNT || params.mSpanSize <= 1) {
                params.mSpanIndex = span;
            } else {
                params.mSpanIndex = span - (params.mSpanSize + DEFAULT_SPAN_COUNT);
            }
            span += params.mSpanSize * spanDiff;
        }
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int spanCount) {
        if (spanCount != this.mSpanCount) {
            if (spanCount < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + spanCount);
            }
            this.mSpanCount = spanCount;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null ? true : DEBUG;
    }
}
