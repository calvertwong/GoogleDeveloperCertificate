package com.calvert.recyclerview.staggeredrecyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutStaggeredGridBinding

class StaggeredGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemUserLayoutStaggeredGridBinding = ItemUserLayoutStaggeredGridBinding.bind(itemView)

    fun bindView(mockDataObject: MockDataObject) {
        with(binding) {
            // loads random image
            Glide.with(itemView.context).load("https://picsum.photos/${(200..500).random()}/${(300..500).random()}")
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(ivStaggeredGrid)
            tvUserId.text = mockDataObject.id.toString()
            tvName.text = mockDataObject.name
            tvUsername.text = mockDataObject.username
            tvEmail.text = mockDataObject.email
            tvHobby.text = mockDataObject.hobby
        }
    }
}