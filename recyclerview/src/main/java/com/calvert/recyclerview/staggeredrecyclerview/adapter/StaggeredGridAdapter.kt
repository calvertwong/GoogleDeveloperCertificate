package com.calvert.recyclerview.staggeredrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R
import com.calvert.recyclerview.staggeredrecyclerview.viewholder.StaggeredGridViewHolder

class StaggeredGridAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StaggeredGridViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout_staggered_grid, parent, false)
        )
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StaggeredGridViewHolder) {
            holder.bindView(mockDataList[position])
        }
    }
}