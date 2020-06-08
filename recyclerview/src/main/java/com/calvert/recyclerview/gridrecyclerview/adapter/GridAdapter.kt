package com.calvert.recyclerview.gridrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R
import com.calvert.recyclerview.gridrecyclerview.viewholder.GridViewHolder

class GridAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GridViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout_grid, parent, false)
        )
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GridViewHolder) {
            holder.bindView(mockDataList[position])
        }
    }
}