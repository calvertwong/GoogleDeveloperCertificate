package com.calvert.recyclerview.verticalrecyclerview.listselection

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.recyclerview.verticalrecyclerview.listselection.viewholder.ListSelectionViewHolder

class CustomItemLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view: View? = recyclerView.findChildViewUnder(e.x, e.y)
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as ListSelectionViewHolder).getItem()
        }
        return null
    }
}