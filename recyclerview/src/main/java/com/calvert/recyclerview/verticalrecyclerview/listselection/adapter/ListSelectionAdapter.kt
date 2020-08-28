package com.calvert.recyclerview.verticalrecyclerview.listselection.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding
import com.calvert.recyclerview.verticalrecyclerview.listselection.viewholder.ListSelectionViewHolder

class ListSelectionAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutBinding

    var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListSelectionViewHolder(binding.root)
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ListSelectionViewHolder) {
            holder.bindView(mockDataList[position], tracker!!.isSelected(position.toLong()))
        }
    }
}