package com.calvert.home.viewholder

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.databinding.ItemTopicButtonBinding

class TopicButtonItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemTopicButtonBinding = ItemTopicButtonBinding.bind(itemView)

    fun bindView(buttonText: String, navActionId: Int) {
        binding.btnTopic.apply {
            text = buttonText
            setOnClickListener {
                binding.root.findNavController().navigate(navActionId)
            }
        }
    }
}