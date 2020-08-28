package com.calvert.home.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.databinding.ItemTopicBinding
import com.calvert.home.adapter.TopicButtonItemAdapter
import com.calvert.home.dto.TopicObject

class TopicItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemTopicBinding = ItemTopicBinding.bind(itemView)

    fun bindView(topicObject: TopicObject) {
        binding.tvTopicTitle.text = topicObject.title
        binding.rvTopicButton.apply {
            layoutManager = LinearLayoutManager(itemView.context)
            adapter = TopicButtonItemAdapter(topicObject.buttonTextList, topicObject.navActionId)
        }
    }
}