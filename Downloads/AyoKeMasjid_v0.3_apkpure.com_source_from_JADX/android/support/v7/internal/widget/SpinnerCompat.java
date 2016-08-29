package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0107R;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.SpinnerAdapter;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.vision.barcode.Barcode;

class SpinnerCompat extends AbsSpinnerCompat implements OnClickListener {
    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "Spinner";
    private boolean mDisableChildrenWhenDisabled;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private int mGravity;
    private SpinnerPopup mPopup;
    private DropDownAdapter mTempAdapter;
    private Rect mTempRect;
    private final TintManager mTintManager;

    /* renamed from: android.support.v7.internal.widget.SpinnerCompat.2 */
    class C01222 implements OnGlobalLayoutListener {
        C01222() {
        }

        public void onGlobalLayout() {
            if (!SpinnerCompat.this.mPopup.isShowing()) {
                SpinnerCompat.this.mPopup.show();
            }
            ViewTreeObserver vto = SpinnerCompat.this.getViewTreeObserver();
            if (vto != null) {
                vto.removeGlobalOnLayoutListener(this);
            }
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter adapter) {
            this.mAdapter = adapter;
            if (adapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) adapter;
            }
        }

        public int getCount() {
            return this.mAdapter == null ? SpinnerCompat.MODE_DIALOG : this.mAdapter.getCount();
        }

        public Object getItem(int position) {
            return this.mAdapter == null ? null : this.mAdapter.getItem(position);
        }

        public long getItemId(int position) {
            return this.mAdapter == null ? -1 : this.mAdapter.getItemId(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return this.mAdapter == null ? null : this.mAdapter.getDropDownView(position, convertView, parent);
        }

        public boolean hasStableIds() {
            return this.mAdapter != null && this.mAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver observer) {
            if (this.mAdapter != null) {
                this.mAdapter.registerDataSetObserver(observer);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
            if (this.mAdapter != null) {
                this.mAdapter.unregisterDataSetObserver(observer);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter adapter = this.mListAdapter;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int position) {
            ListAdapter adapter = this.mListAdapter;
            if (adapter != null) {
                return adapter.isEnabled(position);
            }
            return true;
        }

        public int getItemViewType(int position) {
            return SpinnerCompat.MODE_DIALOG;
        }

        public int getViewTypeCount() {
            return SpinnerCompat.MODE_DROPDOWN;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i);

        void show();
    }

    /* renamed from: android.support.v7.internal.widget.SpinnerCompat.1 */
    class C06491 extends ForwardingListener {
        final /* synthetic */ DropdownPopup val$popup;

        C06491(View x0, DropdownPopup dropdownPopup) {
            this.val$popup = dropdownPopup;
            super(x0);
        }

        public ListPopupWindow getPopup() {
            return this.val$popup;
        }

        public boolean onForwardingStarted() {
            if (!SpinnerCompat.this.mPopup.isShowing()) {
                SpinnerCompat.this.mPopup.show();
            }
            return true;
        }
    }

    private class DialogPopup implements SpinnerPopup, OnClickListener {
        private ListAdapter mListAdapter;
        private AlertDialog mPopup;
        private CharSequence mPrompt;

        private DialogPopup() {
        }

        public void dismiss() {
            if (this.mPopup != null) {
                this.mPopup.dismiss();
                this.mPopup = null;
            }
        }

        public boolean isShowing() {
            return this.mPopup != null ? this.mPopup.isShowing() : false;
        }

        public void setAdapter(ListAdapter adapter) {
            this.mListAdapter = adapter;
        }

        public void setPromptText(CharSequence hintText) {
            this.mPrompt = hintText;
        }

        public CharSequence getHintText() {
            return this.mPrompt;
        }

        public void show() {
            if (this.mListAdapter != null) {
                Builder builder = new Builder(SpinnerCompat.this.getContext());
                if (this.mPrompt != null) {
                    builder.setTitle(this.mPrompt);
                }
                this.mPopup = builder.setSingleChoiceItems(this.mListAdapter, SpinnerCompat.this.getSelectedItemPosition(), this).create();
                this.mPopup.show();
            }
        }

        public void onClick(DialogInterface dialog, int which) {
            SpinnerCompat.this.setSelection(which);
            if (SpinnerCompat.this.mOnItemClickListener != null) {
                SpinnerCompat.this.performItemClick(null, which, this.mListAdapter.getItemId(which));
            }
            dismiss();
        }

        public void setBackgroundDrawable(Drawable bg) {
            Log.e(SpinnerCompat.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void setVerticalOffset(int px) {
            Log.e(SpinnerCompat.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void setHorizontalOffset(int px) {
            Log.e(SpinnerCompat.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public Drawable getBackground() {
            return null;
        }

        public int getVerticalOffset() {
            return SpinnerCompat.MODE_DIALOG;
        }

        public int getHorizontalOffset() {
            return SpinnerCompat.MODE_DIALOG;
        }
    }

    private class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private ListAdapter mAdapter;
        private CharSequence mHintText;

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.1 */
        class C01231 implements OnItemClickListener {
            final /* synthetic */ SpinnerCompat val$this$0;

            C01231(SpinnerCompat spinnerCompat) {
                this.val$this$0 = spinnerCompat;
            }

            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                SpinnerCompat.this.setSelection(position);
                if (SpinnerCompat.this.mOnItemClickListener != null) {
                    SpinnerCompat.this.performItemClick(v, position, DropdownPopup.this.mAdapter.getItemId(position));
                }
                DropdownPopup.this.dismiss();
            }
        }

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.2 */
        class C01242 implements OnGlobalLayoutListener {
            C01242() {
            }

            public void onGlobalLayout() {
                DropdownPopup.this.computeContentWidth();
                super.show();
            }
        }

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.3 */
        class C01253 implements OnDismissListener {
            final /* synthetic */ OnGlobalLayoutListener val$layoutListener;

            C01253(OnGlobalLayoutListener onGlobalLayoutListener) {
                this.val$layoutListener = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver vto = SpinnerCompat.this.getViewTreeObserver();
                if (vto != null) {
                    vto.removeGlobalOnLayoutListener(this.val$layoutListener);
                }
            }
        }

        public DropdownPopup(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            setAnchorView(SpinnerCompat.this);
            setModal(true);
            setPromptPosition(SpinnerCompat.MODE_DIALOG);
            setOnItemClickListener(new C01231(SpinnerCompat.this));
        }

        public void setAdapter(ListAdapter adapter) {
            super.setAdapter(adapter);
            this.mAdapter = adapter;
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public void setPromptText(CharSequence hintText) {
            this.mHintText = hintText;
        }

        void computeContentWidth() {
            Drawable background = getBackground();
            int hOffset = SpinnerCompat.MODE_DIALOG;
            if (background != null) {
                background.getPadding(SpinnerCompat.this.mTempRect);
                hOffset = ViewUtils.isLayoutRtl(SpinnerCompat.this) ? SpinnerCompat.this.mTempRect.right : -SpinnerCompat.this.mTempRect.left;
            } else {
                Rect access$400 = SpinnerCompat.this.mTempRect;
                SpinnerCompat.this.mTempRect.right = SpinnerCompat.MODE_DIALOG;
                access$400.left = SpinnerCompat.MODE_DIALOG;
            }
            int spinnerPaddingLeft = SpinnerCompat.this.getPaddingLeft();
            int spinnerPaddingRight = SpinnerCompat.this.getPaddingRight();
            int spinnerWidth = SpinnerCompat.this.getWidth();
            if (SpinnerCompat.this.mDropDownWidth == -2) {
                int contentWidth = SpinnerCompat.this.measureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
                int contentWidthLimit = (SpinnerCompat.this.getContext().getResources().getDisplayMetrics().widthPixels - SpinnerCompat.this.mTempRect.left) - SpinnerCompat.this.mTempRect.right;
                if (contentWidth > contentWidthLimit) {
                    contentWidth = contentWidthLimit;
                }
                setContentWidth(Math.max(contentWidth, (spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight));
            } else if (SpinnerCompat.this.mDropDownWidth == SpinnerCompat.MODE_THEME) {
                setContentWidth((spinnerWidth - spinnerPaddingLeft) - spinnerPaddingRight);
            } else {
                setContentWidth(SpinnerCompat.this.mDropDownWidth);
            }
            if (ViewUtils.isLayoutRtl(SpinnerCompat.this)) {
                hOffset += (spinnerWidth - spinnerPaddingRight) - getWidth();
            } else {
                hOffset += spinnerPaddingLeft;
            }
            setHorizontalOffset(hOffset);
        }

        public void show(int textDirection, int textAlignment) {
            boolean wasShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(SpinnerCompat.MODE_DROPDOWN);
            setSelection(SpinnerCompat.this.getSelectedItemPosition());
            if (!wasShowing) {
                ViewTreeObserver vto = SpinnerCompat.this.getViewTreeObserver();
                if (vto != null) {
                    OnGlobalLayoutListener layoutListener = new C01242();
                    vto.addOnGlobalLayoutListener(layoutListener);
                    setOnDismissListener(new C01253(layoutListener));
                }
            }
        }
    }

    static class SavedState extends SavedState {
        public static final Creator<SavedState> CREATOR;
        boolean showDropdown;

        /* renamed from: android.support.v7.internal.widget.SpinnerCompat.SavedState.1 */
        static class C01261 implements Creator<SavedState> {
            C01261() {
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.showDropdown = in.readByte() != null;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeByte((byte) (this.showDropdown ? SpinnerCompat.MODE_DROPDOWN : SpinnerCompat.MODE_DIALOG));
        }

        static {
            CREATOR = new C01261();
        }
    }

    SpinnerCompat(Context context) {
        this(context, null);
    }

    SpinnerCompat(Context context, int mode) {
        this(context, null, C0107R.attr.spinnerStyle, mode);
    }

    SpinnerCompat(Context context, AttributeSet attrs) {
        this(context, attrs, C0107R.attr.spinnerStyle);
    }

    SpinnerCompat(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, MODE_THEME);
    }

    SpinnerCompat(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        this.mTempRect = new Rect();
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, C0107R.styleable.Spinner, defStyle, MODE_DIALOG);
        if (a.hasValue(C0107R.styleable.Spinner_android_background)) {
            setBackgroundDrawable(a.getDrawable(C0107R.styleable.Spinner_android_background));
        }
        if (mode == MODE_THEME) {
            mode = a.getInt(C0107R.styleable.Spinner_spinnerMode, MODE_DIALOG);
        }
        switch (mode) {
            case MODE_DIALOG /*0*/:
                this.mPopup = new DialogPopup();
                break;
            case MODE_DROPDOWN /*1*/:
                DropdownPopup popup = new DropdownPopup(context, attrs, defStyle);
                this.mDropDownWidth = a.getLayoutDimension(C0107R.styleable.Spinner_android_dropDownWidth, -2);
                popup.setBackgroundDrawable(a.getDrawable(C0107R.styleable.Spinner_android_popupBackground));
                this.mPopup = popup;
                this.mForwardingListener = new C06491(this, popup);
                break;
        }
        this.mGravity = a.getInt(C0107R.styleable.Spinner_android_gravity, 17);
        this.mPopup.setPromptText(a.getString(C0107R.styleable.Spinner_prompt));
        this.mDisableChildrenWhenDisabled = a.getBoolean(C0107R.styleable.Spinner_disableChildrenWhenDisabled, false);
        a.recycle();
        if (this.mTempAdapter != null) {
            this.mPopup.setAdapter(this.mTempAdapter);
            this.mTempAdapter = null;
        }
        this.mTintManager = a.getTintManager();
    }

    public void setPopupBackgroundDrawable(Drawable background) {
        if (this.mPopup instanceof DropdownPopup) {
            ((DropdownPopup) this.mPopup).setBackgroundDrawable(background);
        } else {
            Log.e(TAG, "setPopupBackgroundDrawable: incompatible spinner mode; ignoring...");
        }
    }

    public void setPopupBackgroundResource(int resId) {
        setPopupBackgroundDrawable(this.mTintManager.getDrawable(resId));
    }

    public Drawable getPopupBackground() {
        return this.mPopup.getBackground();
    }

    public void setDropDownVerticalOffset(int pixels) {
        this.mPopup.setVerticalOffset(pixels);
    }

    public int getDropDownVerticalOffset() {
        return this.mPopup.getVerticalOffset();
    }

    public void setDropDownHorizontalOffset(int pixels) {
        this.mPopup.setHorizontalOffset(pixels);
    }

    public int getDropDownHorizontalOffset() {
        return this.mPopup.getHorizontalOffset();
    }

    public void setDropDownWidth(int pixels) {
        if (this.mPopup instanceof DropdownPopup) {
            this.mDropDownWidth = pixels;
        } else {
            Log.e(TAG, "Cannot set dropdown width for MODE_DIALOG, ignoring");
        }
    }

    public int getDropDownWidth() {
        return this.mDropDownWidth;
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.mDisableChildrenWhenDisabled) {
            int count = getChildCount();
            for (int i = MODE_DIALOG; i < count; i += MODE_DROPDOWN) {
                getChildAt(i).setEnabled(enabled);
            }
        }
    }

    public void setGravity(int gravity) {
        if (this.mGravity != gravity) {
            if ((gravity & 7) == 0) {
                gravity |= MediaRouterJellybean.ALL_ROUTE_TYPES;
            }
            this.mGravity = gravity;
            requestLayout();
        }
    }

    public void setAdapter(SpinnerAdapter adapter) {
        super.setAdapter(adapter);
        this.mRecycler.clear();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && adapter != null && adapter.getViewTypeCount() != MODE_DROPDOWN) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        } else if (this.mPopup != null) {
            this.mPopup.setAdapter(new DropDownAdapter(adapter));
        } else {
            this.mTempAdapter = new DropDownAdapter(adapter);
        }
    }

    public int getBaseline() {
        View child = null;
        if (getChildCount() > 0) {
            child = getChildAt(MODE_DIALOG);
        } else if (this.mAdapter != null && this.mAdapter.getCount() > 0) {
            child = makeView(MODE_DIALOG, false);
            this.mRecycler.put(MODE_DIALOG, child);
        }
        if (child == null) {
            return MODE_THEME;
        }
        int childBaseline = child.getBaseline();
        if (childBaseline >= 0) {
            return child.getTop() + childBaseline;
        }
        return MODE_THEME;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void setOnItemClickListener(AdapterViewCompat.OnItemClickListener l) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    void setOnItemClickListenerInt(AdapterViewCompat.OnItemClickListener l) {
        super.setOnItemClickListener(l);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.mForwardingListener == null || !this.mForwardingListener.onTouch(this, event)) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mPopup != null && MeasureSpec.getMode(widthMeasureSpec) == Target.SIZE_ORIGINAL) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.mInLayout = true;
        layout(MODE_DIALOG, false);
        this.mInLayout = false;
    }

    void layout(int delta, boolean animate) {
        int childrenLeft = this.mSpinnerPadding.left;
        int childrenWidth = ((getRight() - getLeft()) - this.mSpinnerPadding.left) - this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        removeAllViewsInLayout();
        this.mFirstPosition = this.mSelectedPosition;
        if (this.mAdapter != null) {
            View sel = makeView(this.mSelectedPosition, true);
            int width = sel.getMeasuredWidth();
            int selectedOffset = childrenLeft;
            switch (GravityCompat.getAbsoluteGravity(this.mGravity, ViewCompat.getLayoutDirection(this)) & 7) {
                case MODE_DROPDOWN /*1*/:
                    selectedOffset = ((childrenWidth / 2) + childrenLeft) - (width / 2);
                    break;
                case Barcode.PRODUCT /*5*/:
                    selectedOffset = (childrenLeft + childrenWidth) - width;
                    break;
            }
            sel.offsetLeftAndRight(selectedOffset);
        }
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
    }

    private View makeView(int position, boolean addChild) {
        View child;
        if (!this.mDataChanged) {
            child = this.mRecycler.get(position);
            if (child != null) {
                setUpChild(child, addChild);
                return child;
            }
        }
        child = this.mAdapter.getView(position, null, this);
        setUpChild(child, addChild);
        return child;
    }

    private void setUpChild(View child, boolean addChild) {
        LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }
        if (addChild) {
            addViewInLayout(child, MODE_DIALOG, lp);
        }
        child.setSelected(hasFocus());
        if (this.mDisableChildrenWhenDisabled) {
            child.setEnabled(isEnabled());
        }
        child.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, lp.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, lp.height));
        int childTop = this.mSpinnerPadding.top + ((((getMeasuredHeight() - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - child.getMeasuredHeight()) / 2);
        child.layout(MODE_DIALOG, childTop, MODE_DIALOG + child.getMeasuredWidth(), childTop + child.getMeasuredHeight());
    }

    public boolean performClick() {
        boolean handled = super.performClick();
        if (!handled) {
            handled = true;
            if (!this.mPopup.isShowing()) {
                this.mPopup.show();
            }
        }
        return handled;
    }

    public void onClick(DialogInterface dialog, int which) {
        setSelection(which);
        dialog.dismiss();
    }

    public void setPrompt(CharSequence prompt) {
        this.mPopup.setPromptText(prompt);
    }

    public void setPromptId(int promptId) {
        setPrompt(getContext().getText(promptId));
    }

    public CharSequence getPrompt() {
        return this.mPopup.getHintText();
    }

    int measureContentWidth(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return MODE_DIALOG;
        }
        int width = MODE_DIALOG;
        View itemView = null;
        int itemType = MODE_DIALOG;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(MODE_DIALOG, MODE_DIALOG);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(MODE_DIALOG, MODE_DIALOG);
        int start = Math.max(MODE_DIALOG, getSelectedItemPosition());
        int end = Math.min(adapter.getCount(), start + MAX_ITEMS_MEASURED);
        for (int i = Math.max(MODE_DIALOG, start - (15 - (end - start))); i < end; i += MODE_DROPDOWN) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        if (background == null) {
            return width;
        }
        background.getPadding(this.mTempRect);
        return width + (this.mTempRect.left + this.mTempRect.right);
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        boolean z = this.mPopup != null && this.mPopup.isShowing();
        ss.showDropdown = z;
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.showDropdown) {
            ViewTreeObserver vto = getViewTreeObserver();
            if (vto != null) {
                vto.addOnGlobalLayoutListener(new C01222());
            }
        }
    }
}
