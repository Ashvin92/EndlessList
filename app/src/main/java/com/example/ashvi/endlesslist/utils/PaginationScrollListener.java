package com.example.ashvi.endlesslist.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {

    LinearLayoutManager linearLayout;

    public PaginationScrollListener(LinearLayoutManager linearLayout) {
        this.linearLayout = linearLayout;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = linearLayout.getChildCount();
        int totalItemCount =linearLayout.getItemCount();
        int firtVisibleItemPos = linearLayout.findFirstVisibleItemPosition();

        if(!isLoading() && !isLastPage())
        {
            if((visibleItemCount+visibleItemCount)>=totalItemCount && visibleItemCount>0&& totalItemCount>=getTotalPageCount())
            {
                loadMoreItems();
            }
        }
    }

    protected abstract void loadMoreItems();

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();
}
