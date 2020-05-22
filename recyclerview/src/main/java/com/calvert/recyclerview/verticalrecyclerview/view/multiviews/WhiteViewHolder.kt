package com.calvert.recyclerview.verticalrecyclerview.view.multiviews

import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding

class WhiteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemUserLayoutBinding = ItemUserLayoutBinding.bind(itemView)

    fun bindView(mockDataObject: MockDataObject, isActivated: Boolean = false) {
        with(binding) {
            tvId.text = mockDataObject.id.toString()
            tvName.text = mockDataObject.name
            tvUsername.text = mockDataObject.username
            tvEmail.text = mockDataObject.email
            tvHobby.text = mockDataObject.hobby
        }
        itemView.isActivated = isActivated
        if (isActivated) {
            binding.ivCheckmark.setImageResource(R.drawable.ic_check_dark_green_24dp)
        } else {
            binding.ivCheckmark.setImageResource(0)
        }
    }

    fun clearAnimation() {
        binding.root.clearAnimation()
    }

    fun getItem(): ItemDetailsLookup.ItemDetails<Long>? =
        object : ItemDetailsLookup.ItemDetails<Long>() {
            override fun getSelectionKey(): Long? = itemId

            override fun getPosition(): Int = adapterPosition
        }
}