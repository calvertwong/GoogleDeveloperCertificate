package com.calvert.recyclerview.horizontalrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding
import com.calvert.recyclerview.horizontalrecyclerview.viewholder.HorizontalViewHolder

class HorizontalAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HorizontalViewHolder(binding.root)
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HorizontalViewHolder) {
            holder.bindView(mockDataList[position])
        }
    }
}