package com.calvert.recyclerview.verticalrecyclerview.view.landingpage

import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.calvert.recyclerview.databinding.ItemLandingpageRvBinding
import com.calvert.recyclerview.verticalrecyclerview.dto.VerticalItemObject

class LandingPageVerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemLandingpageRvBinding = ItemLandingpageRvBinding.bind(itemView)

    fun bindView(item: VerticalItemObject) {
        with(binding) {
            tvLandingpageRvTitle.text = item.title
            tvLandingpageRvDesc.text = item.desc
            itemView.setOnClickListener {
                Navigation.createNavigateOnClickListener(item.rvNavActionId, null)
                    .onClick(it)
            }
        }
    }
}