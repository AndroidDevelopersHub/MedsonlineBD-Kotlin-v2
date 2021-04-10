package com.parallaxlogic.ekshop.utils.Pagination

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


abstract class GridPaginationScrollListener(private val layoutManager: StaggeredGridLayoutManager) :
    RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        recyclerviewScrolling()
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPositions(null)
        var firstVisibleItemPosition = firstVisibleItem[0]
        if (!isLoadingNow && !isLastPageNow) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                && firstVisibleItemPosition >= 0
            ) {
                loadMoreItems()
            }
        }
    }

    protected abstract fun loadMoreItems()
    abstract fun recyclerviewScrolling()
    abstract val isLastPageNow: Boolean
    abstract val isLoadingNow: Boolean

}

