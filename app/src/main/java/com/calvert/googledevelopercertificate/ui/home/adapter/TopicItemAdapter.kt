package com.calvert.googledevelopercertificate.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.R
import com.calvert.googledevelopercertificate.dto.TopicObject
import com.calvert.googledevelopercertificate.ui.home.viewholder.TopicItemViewHolder

class TopicItemAdapter(private val topicItemList: List<TopicObject>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TopicItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        )
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