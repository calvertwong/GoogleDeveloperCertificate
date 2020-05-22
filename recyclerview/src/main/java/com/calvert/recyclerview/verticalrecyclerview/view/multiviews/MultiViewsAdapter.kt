package com.calvert.recyclerview.verticalrecyclerview.view.multiviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R

class MultiViewsAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView
.ViewHolder>() {

    private val TYPE_WHITE = 0
    private val TYPE_GREEN = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_WHITE -> WhiteViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
            )
            else -> GreenViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout_green, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> TYPE_WHITE
            else -> TYPE_GREEN
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is WhiteViewHolder) {
            holder.bindView(mockDataList[position])
        }
    }
}