package org.bpmikc.akm.RecyclerView.Utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public abstract class EndlessRecyclerOnScrollListener extends OnScrollListener {
    public static String TAG;
    private int current_page;
    int firstVisibleItem;
    private boolean loading;
    private LinearLayoutManager mLinearLayoutManager;
    private int previousTotal;
    int totalItemCount;
    int visibleItemCount;
    private int visibleThreshold;

    public abstract void onLoadMore(int i);

    static {
        TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();
    }

    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.previousTotal = 0;
        this.loading = true;
        this.visibleThreshold = 5;
        this.current_page = 1;
        this.mLinearLayoutManager = linearLayoutManager;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        this.visibleItemCount = recyclerView.getChildCount();
        this.totalItemCount = this.mLinearLayoutManager.getItemCount();
        this.firstVisibleItem = this.mLinearLayoutManager.findFirstVisibleItemPosition();
        if (this.loading && this.totalItemCount > this.previousTotal) {
            this.loading = false;
            this.previousTotal = this.totalItemCount;
        }
        if (!this.loading && this.totalItemCount - this.visibleItemCount <= this.firstVisibleItem + this.visibleThreshold) {
            this.current_page++;
            onLoadMore(this.current_page);
            this.loading = true;
        }
    }
}
