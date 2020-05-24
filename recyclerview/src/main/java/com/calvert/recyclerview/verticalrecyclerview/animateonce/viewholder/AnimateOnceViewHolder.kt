package com.calvert.recyclerview.verticalrecyclerview.animateonce.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding

class AnimateOnceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemUserLayoutBinding = ItemUserLayoutBinding.bind(itemView)

    fun bindView(mockDataObject: MockDataObject) {
        with(binding) {
            tvUserId.text = mockDataObject.id.toString()
            tvName.text = mockDataObject.name
            tvUsername.text = mockDataObject.username
            tvEmail.text = mockDataObject.email
            tvHobby.text = mockDataObject.hobby
        }
    }

    fun clearAnimation() {
        binding.root.clearAnimation()
    }
}