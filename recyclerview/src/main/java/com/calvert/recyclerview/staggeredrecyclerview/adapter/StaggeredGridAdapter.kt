package com.calvert.recyclerview.staggeredrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutStaggeredGridBinding
import com.calvert.recyclerview.staggeredrecyclerview.viewholder.StaggeredGridViewHolder

class StaggeredGridAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutStaggeredGridBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemUserLayoutStaggeredGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StaggeredGridViewHolder(binding.root)
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StaggeredGridViewHolder) {
            holder.bindView(mockDataList[position])
        }
    }
}