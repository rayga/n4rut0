package org.bpmikc.akm.RecyclerView.Utils;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Checkable;
import org.bpmikc.akm.C0615R;

public class ItemSelectionSupport {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int INVALID_POSITION = -1;
    private static final String STATE_KEY_CHECKED_COUNT = "checkedCount";
    private static final String STATE_KEY_CHECKED_ID_STATES = "checkedIdStates";
    private static final String STATE_KEY_CHECKED_STATES = "checkedStates";
    private static final String STATE_KEY_CHOICE_MODE = "choiceMode";
    private int mCheckedCount;
    private CheckedIdStates mCheckedIdStates;
    private CheckedStates mCheckedStates;
    private ChoiceMode mChoiceMode;
    private final RecyclerView mRecyclerView;
    private final TouchListener mTouchListener;

    private static class CheckedStates extends SparseBooleanArray implements Parcelable {
        public static final Creator<CheckedStates> CREATOR;
        private static final int FALSE = 0;
        private static final int TRUE = 1;

        /* renamed from: org.bpmikc.akm.RecyclerView.Utils.ItemSelectionSupport.CheckedStates.1 */
        static class C06181 implements Creator<CheckedStates> {
            C06181() {
            }

            public CheckedStates createFromParcel(Parcel in) {
                return new CheckedStates(null);
            }

            public CheckedStates[] newArray(int size) {
                return new CheckedStates[size];
            }
        }

        private CheckedStates(Parcel in) {
            int size = in.readInt();
            if (size > 0) {
                for (int i = FALSE; i < size; i += TRUE) {
                    put(in.readInt(), in.readInt() == TRUE);
                }
            }
        }

        public int describeContents() {
            return FALSE;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            int size = size();
            parcel.writeInt(size);
            for (int i = FALSE; i < size; i += TRUE) {
                parcel.writeInt(keyAt(i));
                parcel.writeInt(valueAt(i) ? TRUE : FALSE);
            }
        }

        static {
            CREATOR = new C06181();
        }
    }

    public enum ChoiceMode {
        NONE,
        SINGLE,
        MULTIPLE
    }

    private static class CheckedIdStates extends LongSparseArray<Integer> implements Parcelable {
        public static final Creator<CheckedIdStates> CREATOR;

        /* renamed from: org.bpmikc.akm.RecyclerView.Utils.ItemSelectionSupport.CheckedIdStates.1 */
        static class C06171 implements Creator<CheckedIdStates> {
            C06171() {
            }

            public CheckedIdStates createFromParcel(Parcel in) {
                return new CheckedIdStates(null);
            }

            public CheckedIdStates[] newArray(int size) {
                return new CheckedIdStates[size];
            }
        }

        private CheckedIdStates(Parcel in) {
            int size = in.readInt();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    put(in.readLong(), Integer.valueOf(in.readInt()));
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int flags) {
            int size = size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeLong(keyAt(i));
                parcel.writeInt(((Integer) valueAt(i)).intValue());
            }
        }

        static {
            CREATOR = new C06171();
        }
    }

    private class TouchListener extends ClickItemTouchListener {
        TouchListener(RecyclerView recyclerView) {
            super(recyclerView);
        }

        boolean performItemClick(RecyclerView parent, View view, int position, long id) {
            Adapter adapter = ItemSelectionSupport.this.mRecyclerView.getAdapter();
            boolean checkedStateChanged = false;
            boolean checked;
            if (ItemSelectionSupport.this.mChoiceMode == ChoiceMode.MULTIPLE) {
                checked = !ItemSelectionSupport.this.mCheckedStates.get(position, false);
                ItemSelectionSupport.this.mCheckedStates.put(position, checked);
                if (ItemSelectionSupport.this.mCheckedIdStates != null && adapter.hasStableIds()) {
                    if (checked) {
                        ItemSelectionSupport.this.mCheckedIdStates.put(adapter.getItemId(position), Integer.valueOf(position));
                    } else {
                        ItemSelectionSupport.this.mCheckedIdStates.delete(adapter.getItemId(position));
                    }
                }
                if (checked) {
                    ItemSelectionSupport.this.mCheckedCount = ItemSelectionSupport.this.mCheckedCount + 1;
                } else {
                    ItemSelectionSupport.this.mCheckedCount = ItemSelectionSupport.this.mCheckedCount + ItemSelectionSupport.INVALID_POSITION;
                }
                checkedStateChanged = true;
            } else if (ItemSelectionSupport.this.mChoiceMode == ChoiceMode.SINGLE) {
                if (ItemSelectionSupport.this.mCheckedStates.get(position, false)) {
                    checked = false;
                } else {
                    checked = true;
                }
                if (checked) {
                    ItemSelectionSupport.this.mCheckedStates.clear();
                    ItemSelectionSupport.this.mCheckedStates.put(position, true);
                    if (ItemSelectionSupport.this.mCheckedIdStates != null && adapter.hasStableIds()) {
                        ItemSelectionSupport.this.mCheckedIdStates.clear();
                        ItemSelectionSupport.this.mCheckedIdStates.put(adapter.getItemId(position), Integer.valueOf(position));
                    }
                    ItemSelectionSupport.this.mCheckedCount = 1;
                } else if (ItemSelectionSupport.this.mCheckedStates.size() == 0 || !ItemSelectionSupport.this.mCheckedStates.valueAt(0)) {
                    ItemSelectionSupport.this.mCheckedCount = 0;
                }
                checkedStateChanged = true;
            }
            if (checkedStateChanged) {
                ItemSelectionSupport.this.updateOnScreenCheckedViews();
            }
            return false;
        }

        boolean performItemLongClick(RecyclerView parent, View view, int position, long id) {
            return true;
        }
    }

    private ItemSelectionSupport(RecyclerView recyclerView) {
        this.mChoiceMode = ChoiceMode.NONE;
        this.mRecyclerView = recyclerView;
        this.mTouchListener = new TouchListener(recyclerView);
        recyclerView.addOnItemTouchListener(this.mTouchListener);
    }

    private void updateOnScreenCheckedViews() {
        int count = this.mRecyclerView.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = this.mRecyclerView.getChildAt(i);
            setViewChecked(child, this.mCheckedStates.get(this.mRecyclerView.getChildPosition(child)));
        }
    }

    public int getCheckedItemCount() {
        return this.mCheckedCount;
    }

    public boolean isItemChecked(int position) {
        if (this.mChoiceMode == ChoiceMode.NONE || this.mCheckedStates == null) {
            return false;
        }
        return this.mCheckedStates.get(position);
    }

    public int getCheckedItemPosition() {
        if (this.mChoiceMode == ChoiceMode.SINGLE && this.mCheckedStates != null && this.mCheckedStates.size() == 1) {
            return this.mCheckedStates.keyAt(0);
        }
        return INVALID_POSITION;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.mChoiceMode != ChoiceMode.NONE) {
            return this.mCheckedStates;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.mChoiceMode == ChoiceMode.NONE || this.mCheckedIdStates == null || this.mRecyclerView.getAdapter() == null) {
            return new long[0];
        }
        int count = this.mCheckedIdStates.size();
        long[] ids = new long[count];
        for (int i = 0; i < count; i++) {
            ids[i] = this.mCheckedIdStates.keyAt(i);
        }
        return ids;
    }

    public void setItemChecked(int position, boolean checked) {
        if (this.mChoiceMode != ChoiceMode.NONE) {
            Adapter adapter = this.mRecyclerView.getAdapter();
            if (this.mChoiceMode == ChoiceMode.MULTIPLE) {
                boolean oldValue = this.mCheckedStates.get(position);
                this.mCheckedStates.put(position, checked);
                if (this.mCheckedIdStates != null && adapter.hasStableIds()) {
                    if (checked) {
                        this.mCheckedIdStates.put(adapter.getItemId(position), Integer.valueOf(position));
                    } else {
                        this.mCheckedIdStates.delete(adapter.getItemId(position));
                    }
                }
                if (oldValue != checked) {
                    if (checked) {
                        this.mCheckedCount++;
                    } else {
                        this.mCheckedCount += INVALID_POSITION;
                    }
                }
            } else {
                boolean updateIds;
                if (this.mCheckedIdStates == null || !adapter.hasStableIds()) {
                    updateIds = false;
                } else {
                    updateIds = true;
                }
                if (checked || isItemChecked(position)) {
                    this.mCheckedStates.clear();
                    if (updateIds) {
                        this.mCheckedIdStates.clear();
                    }
                }
                if (checked) {
                    this.mCheckedStates.put(position, true);
                    if (updateIds) {
                        this.mCheckedIdStates.put(adapter.getItemId(position), Integer.valueOf(position));
                    }
                    this.mCheckedCount = 1;
                } else if (this.mCheckedStates.size() == 0 || !this.mCheckedStates.valueAt(0)) {
                    this.mCheckedCount = 0;
                }
            }
            updateOnScreenCheckedViews();
        }
    }

    @TargetApi(11)
    public void setViewChecked(View view, boolean checked) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(checked);
        } else if (VERSION.SDK_INT >= 11) {
            view.setActivated(checked);
        }
    }

    public void clearChoices() {
        if (this.mCheckedStates != null) {
            this.mCheckedStates.clear();
        }
        if (this.mCheckedIdStates != null) {
            this.mCheckedIdStates.clear();
        }
        this.mCheckedCount = 0;
        updateOnScreenCheckedViews();
    }

    public ChoiceMode getChoiceMode() {
        return this.mChoiceMode;
    }

    public void setChoiceMode(ChoiceMode choiceMode) {
        if (this.mChoiceMode != choiceMode) {
            this.mChoiceMode = choiceMode;
            if (this.mChoiceMode != ChoiceMode.NONE) {
                if (this.mCheckedStates == null) {
                    this.mCheckedStates = new CheckedStates();
                }
                Adapter adapter = this.mRecyclerView.getAdapter();
                if (this.mCheckedIdStates == null && adapter != null && adapter.hasStableIds()) {
                    this.mCheckedIdStates = new CheckedIdStates();
                }
            }
        }
    }

    public void onAdapterDataChanged() {
        Adapter adapter = this.mRecyclerView.getAdapter();
        if (this.mChoiceMode != ChoiceMode.NONE && adapter != null && adapter.hasStableIds()) {
            int itemCount = adapter.getItemCount();
            this.mCheckedStates.clear();
            int checkedIndex = 0;
            while (true) {
                if (checkedIndex < this.mCheckedIdStates.size()) {
                    long currentId = this.mCheckedIdStates.keyAt(checkedIndex);
                    int currentPosition = ((Integer) this.mCheckedIdStates.valueAt(checkedIndex)).intValue();
                    if (currentId != adapter.getItemId(currentPosition)) {
                        int start = Math.max(0, currentPosition - 20);
                        int end = Math.min(currentPosition + CHECK_POSITION_SEARCH_DISTANCE, itemCount);
                        boolean found = false;
                        for (int searchPos = start; searchPos < end; searchPos++) {
                            if (currentId == adapter.getItemId(searchPos)) {
                                found = true;
                                this.mCheckedStates.put(searchPos, true);
                                this.mCheckedIdStates.setValueAt(checkedIndex, Integer.valueOf(searchPos));
                                break;
                            }
                        }
                        if (!found) {
                            this.mCheckedIdStates.delete(currentId);
                            this.mCheckedCount += INVALID_POSITION;
                            checkedIndex += INVALID_POSITION;
                        }
                    } else {
                        this.mCheckedStates.put(currentPosition, true);
                    }
                    checkedIndex++;
                } else {
                    return;
                }
            }
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle state = new Bundle();
        state.putInt(STATE_KEY_CHOICE_MODE, this.mChoiceMode.ordinal());
        state.putParcelable(STATE_KEY_CHECKED_STATES, this.mCheckedStates);
        state.putParcelable(STATE_KEY_CHECKED_ID_STATES, this.mCheckedIdStates);
        state.putInt(STATE_KEY_CHECKED_COUNT, this.mCheckedCount);
        return state;
    }

    public void onRestoreInstanceState(Bundle state) {
        this.mChoiceMode = ChoiceMode.values()[state.getInt(STATE_KEY_CHOICE_MODE)];
        this.mCheckedStates = (CheckedStates) state.getParcelable(STATE_KEY_CHECKED_STATES);
        this.mCheckedIdStates = (CheckedIdStates) state.getParcelable(STATE_KEY_CHECKED_ID_STATES);
        this.mCheckedCount = state.getInt(STATE_KEY_CHECKED_COUNT);
    }

    public static ItemSelectionSupport addTo(RecyclerView recyclerView) {
        ItemSelectionSupport itemSelectionSupport = from(recyclerView);
        if (itemSelectionSupport != null) {
            return itemSelectionSupport;
        }
        itemSelectionSupport = new ItemSelectionSupport(recyclerView);
        recyclerView.setTag(C0615R.id.recyclerview_item_selection_support, itemSelectionSupport);
        return itemSelectionSupport;
    }

    public static void removeFrom(RecyclerView recyclerView) {
        ItemSelectionSupport itemSelection = from(recyclerView);
        if (itemSelection != null) {
            itemSelection.clearChoices();
            recyclerView.removeOnItemTouchListener(itemSelection.mTouchListener);
            recyclerView.setTag(C0615R.id.recyclerview_item_selection_support, null);
        }
    }

    public static ItemSelectionSupport from(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return null;
        }
        return (ItemSelectionSupport) recyclerView.getTag(C0615R.id.recyclerview_item_selection_support);
    }
}
