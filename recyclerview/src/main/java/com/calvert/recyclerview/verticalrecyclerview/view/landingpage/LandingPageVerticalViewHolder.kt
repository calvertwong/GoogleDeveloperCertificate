package com.calvert.recyclerview.verticalrecyclerview.view.landingpage

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.calvert.recyclerview.databinding.ItemLandingpageRvBinding
import com.calvert.recyclerview.verticalrecyclerview.dto.VerticalItemObject

class LandingPageVerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemLandingpageRvBinding = ItemLandingpageRvBinding.bind(itemView)

    fun bindView(item: VerticalItemObject) {
        with(binding) {
            tvNormalRvTitle.text = item.title
            tvNormalRvDesc.text = item.desc
        }
    }
}