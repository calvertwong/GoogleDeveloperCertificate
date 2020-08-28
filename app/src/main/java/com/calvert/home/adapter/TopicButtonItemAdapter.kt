package com.calvert.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.databinding.ItemTopicButtonBinding
import com.calvert.home.viewholder.TopicButtonItemViewHolder

class TopicButtonItemAdapter(
    private val buttonTextList: List<String>,
    private val navActionId: List<Int>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemTopicButtonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemTopicButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopicButtonItemViewHolder(binding.root)
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