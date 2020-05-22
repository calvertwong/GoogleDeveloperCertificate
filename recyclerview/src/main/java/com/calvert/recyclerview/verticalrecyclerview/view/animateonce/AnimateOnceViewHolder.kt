package com.calvert.recyclerview.verticalrecyclerview.view.animateonce

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding

class AnimateOnceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemUserLayoutBinding = ItemUserLayoutBinding.bind(itemView)

    fun bindView(mockDataObject: MockDataObject) {
        with(binding) {
            tvId.text = mockDataObject.id.toString()
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