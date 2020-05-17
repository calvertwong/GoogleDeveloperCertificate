package com.calvert.googledevelopercertificate.ui.home.viewholder

import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.R
import com.google.android.material.button.MaterialButton

class TopicButtonItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(buttonText: String, navActionId: Int) {
        val topicButton: MaterialButton = itemView.findViewById(R.id.btn_topic)
        topicButton.text = buttonText

        topicButton.setOnClickListener {
            Navigation.createNavigateOnClickListener(navActionId, null)
                .onClick(itemView)
        }
    }
}