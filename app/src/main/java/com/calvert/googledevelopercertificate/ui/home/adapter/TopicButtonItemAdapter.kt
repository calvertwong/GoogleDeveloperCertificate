package com.calvert.googledevelopercertificate.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.R
import com.calvert.googledevelopercertificate.ui.home.viewholder.TopicButtonItemViewHolder

class TopicButtonItemAdapter(
    private val buttonTextList: List<String>,
    private val navActionId: List<Int>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TopicButtonItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_topic_button, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return buttonTextList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TopicButtonItemViewHolder) {
            holder.bindView(buttonTextList[position], navActionId[position])
        }
    }
}