package com.calvert.recyclerview.verticalrecyclerview.multiviews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding
import com.calvert.recyclerview.databinding.ItemUserLayoutGreenBinding
import com.calvert.recyclerview.verticalrecyclerview.multiviews.viewholder.GreenViewHolder
import com.calvert.recyclerview.verticalrecyclerview.multiviews.viewholder.WhiteViewHolder

class MultiViewsAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutBinding
    private lateinit var bindingGreen: ItemUserLayoutGreenBinding

    private val TYPE_WHITE = 0
    private val TYPE_GREEN = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_WHITE -> {
                binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                WhiteViewHolder(binding.root)
            }
            else -> {
                bindingGreen = ItemUserLayoutGreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                GreenViewHolder(bindingGreen.root)
            }
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
        when (holder) {
            is WhiteViewHolder -> holder.bindView(mockDataList[position])
            is GreenViewHolder -> holder.bindView(mockDataList[position])
        }
    }
}