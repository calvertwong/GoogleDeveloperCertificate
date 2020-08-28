package com.calvert.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.databinding.ItemTopicBinding
import com.calvert.home.dto.TopicObject
import com.calvert.home.viewholder.TopicItemViewHolder

class TopicItemAdapter(private val topicItemList: List<TopicObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemTopicBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return topicItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TopicItemViewHolder) {
            holder.bindView(topicItemList[position])
        }
    }
}