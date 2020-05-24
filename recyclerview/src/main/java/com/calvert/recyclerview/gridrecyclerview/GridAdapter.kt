package com.calvert.recyclerview.gridrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R

class GridAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return GridViewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout_grid, parent, false)
        )
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GridViewholder) {
            holder.bindView(mockDataList[position])
        }
    }
}