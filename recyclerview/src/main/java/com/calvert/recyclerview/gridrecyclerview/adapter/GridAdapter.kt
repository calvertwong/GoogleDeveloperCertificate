package com.calvert.recyclerview.gridrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutGridBinding
import com.calvert.recyclerview.gridrecyclerview.viewholder.GridViewHolder

class GridAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutGridBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemUserLayoutGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding.root)
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GridViewHolder) {
            holder.bindView(mockDataList[position])
        }
    }
}