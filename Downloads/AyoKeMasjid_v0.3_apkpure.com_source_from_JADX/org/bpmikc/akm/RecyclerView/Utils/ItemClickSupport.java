package org.bpmikc.akm.RecyclerView.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import org.bpmikc.akm.C0615R;

public class ItemClickSupport {
    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;
    private final RecyclerView mRecyclerView;
    private final TouchListener mTouchListener;

    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int i, long j);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(RecyclerView recyclerView, View view, int i, long j);
    }

    private class TouchListener extends ClickItemTouchListener {
        TouchListener(RecyclerView recyclerView) {
            super(recyclerView);
        }

        boolean performItemClick(RecyclerView parent, View view, int position, long id) {
            if (ItemClickSupport.this.mItemClickListener == null) {
                return false;
            }
            view.playSoundEffect(0);
            ItemClickSupport.this.mItemClickListener.onItemClick(parent, view, position, id);
            return true;
        }

        boolean performItemLongClick(RecyclerView parent, View view, int position, long id) {
            if (ItemClickSupport.this.mItemLongClickListener == null) {
                return false;
            }
            view.performHapticFeedback(0);
            return ItemClickSupport.this.mItemLongClickListener.onItemLongClick(parent, view, position, id);
        }
    }

    private ItemClickSupport(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        this.mTouchListener = new TouchListener(recyclerView);
        recyclerView.addOnItemTouchListener(this.mTouchListener);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        if (!this.mRecyclerView.isLongClickable()) {
            this.mRecyclerView.setLongClickable(true);
        }
        this.mItemLongClickListener = listener;
    }

    public static ItemClickSupport addTo(RecyclerView recyclerView) {
        ItemClickSupport itemClickSupport = from(recyclerView);
        if (itemClickSupport != null) {
            return itemClickSupport;
        }
        itemClickSupport = new ItemClickSupport(recyclerView);
        recyclerView.setTag(C0615R.id.recyclerview_item_click_support, itemClickSupport);
        return itemClickSupport;
    }

    public static void removeFrom(RecyclerView recyclerView) {
        ItemClickSupport itemClickSupport = from(recyclerView);
        if (itemClickSupport != null) {
            recyclerView.removeOnItemTouchListener(itemClickSupport.mTouchListener);
            recyclerView.setTag(C0615R.id.recyclerview_item_click_support, null);
        }
    }

    public static ItemClickSupport from(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return null;
        }
        return (ItemClickSupport) recyclerView.getTag(C0615R.id.recyclerview_item_click_support);
    }
}
