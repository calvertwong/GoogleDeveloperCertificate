package com.calvert.recyclerview.staggeredrecyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.calvert.imageloader.loadImage
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutStaggeredGridBinding

class StaggeredGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemUserLayoutStaggeredGridBinding = ItemUserLayoutStaggeredGridBinding.bind(itemView)

    fun bindView(mockDataObject: MockDataObject) {
        with(binding) {
            // loads random image
            ivStaggeredGrid.loadImage("https://picsum.photos/${(200..500).random()}/${(300..500).random()}", false)
            tvUserId.text = mockDataObject.id.toString()
            tvName.text = mockDataObject.name
            tvUsername.text = mockDataObject.username
            tvEmail.text = mockDataObject.email
            tvHobby.text = mockDataObject.hobby
        }
    }
}