package com.calvert.recyclerview.verticalrecyclerview.animateonce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding
import com.calvert.recyclerview.verticalrecyclerview.animateonce.viewholder.AnimateOnceViewHolder

class AnimateOnceAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutBinding
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimateOnceViewHolder(binding.root)
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AnimateOnceViewHolder) {
            holder.bindView(mockDataList[position])
            setAnimation(holder.itemView, position)
        }
    }

    private fun setAnimation(view: View, position: Int) {
        // Animate only if the view holder with contents that was never displayed before
        // To always animate, remove the if statement and lastPosition assignment
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(view.context, R.anim.slide_in_left)
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    // Clear animation when view is detached.
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        (holder as AnimateOnceViewHolder).clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }
}