package com.calvert.recyclerview.verticalrecyclerview.landingpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.recyclerview.databinding.ItemLandingpageRvBinding
import com.calvert.recyclerview.dto.RvItemObject
import com.calvert.recyclerview.verticalrecyclerview.landingpage.viewholder.LandingPageVerticalViewHolder

class LandingPageVerticalAdapter(private val rvItemList: List<RvItemObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemLandingpageRvBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemLandingpageRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandingPageVerticalViewHolder(binding.root)
    }

    override fun getItemCount(): Int = rvItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LandingPageVerticalViewHolder) {
            holder.bindView(rvItemList[position])
        }
    }
}