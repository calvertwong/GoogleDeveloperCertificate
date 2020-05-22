package com.calvert.recyclerview.verticalrecyclerview.view.landingpage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.calvert.recyclerview.R
import com.calvert.recyclerview.verticalrecyclerview.dto.VerticalItemObject

class LandingPageVerticalAdapter(private val verticalItemList: List<VerticalItemObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return LandingPageVerticalViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_landingpage_rv, parent, false)
        )
    }

    override fun getItemCount(): Int = verticalItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LandingPageVerticalViewHolder) {
            holder.bindView(verticalItemList[position])
        }
    }
}