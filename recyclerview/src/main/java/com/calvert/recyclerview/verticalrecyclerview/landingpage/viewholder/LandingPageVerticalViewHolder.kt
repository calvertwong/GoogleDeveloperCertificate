package com.calvert.recyclerview.verticalrecyclerview.landingpage.viewholder

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.calvert.recyclerview.databinding.ItemLandingpageRvBinding
import com.calvert.recyclerview.dto.RvItemObject

class LandingPageVerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemLandingpageRvBinding = ItemLandingpageRvBinding.bind(itemView)

    fun bindView(item: RvItemObject) {
        with(binding) {
            tvLandingpageRvTitle.text = item.title
            tvLandingpageRvDesc.text = item.desc
            root.setOnClickListener {
                it.findNavController().navigate(item.rvNavActionId)
            }
        }
    }
}