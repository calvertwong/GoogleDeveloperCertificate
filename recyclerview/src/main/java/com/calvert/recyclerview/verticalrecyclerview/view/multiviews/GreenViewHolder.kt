package com.calvert.recyclerview.verticalrecyclerview.view.multiviews

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.databinding.ItemUserLayoutGreenBinding

class GreenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemUserLayoutGreenBinding = ItemUserLayoutGreenBinding.bind(itemView)

    fun bindView(mockDataObject: MockDataObject) {
        with(binding) {
            tvUserIdGreen.text = mockDataObject.id.toString()
            tvNameGreen.text = mockDataObject.name
            tvUsernameGreen.text = mockDataObject.username
            tvEmailGreen.text = mockDataObject.email
            tvHobbyGreen.text = mockDataObject.hobby
        }
    }
}