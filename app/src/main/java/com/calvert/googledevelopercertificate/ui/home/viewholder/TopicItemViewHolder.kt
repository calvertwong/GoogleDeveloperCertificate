package com.calvert.googledevelopercertificate.ui.home.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.R
import com.calvert.googledevelopercertificate.shared.dto.TopicObject
import com.calvert.googledevelopercertificate.ui.home.adapter.TopicButtonItemAdapter

class TopicItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(topicObject: TopicObject) {
        val topicTitle: TextView = itemView.findViewById(R.id.tv_topic_title)
        val rvTopicButton: RecyclerView = itemView.findViewById(R.id.rv_topic_button)

        topicTitle.text = topicObject.title
        rvTopicButton.apply {
            layoutManager = LinearLayoutManager(itemView.context)
            adapter = TopicButtonItemAdapter(topicObject.buttonTextList, topicObject.navActionId)
        }
    }
}