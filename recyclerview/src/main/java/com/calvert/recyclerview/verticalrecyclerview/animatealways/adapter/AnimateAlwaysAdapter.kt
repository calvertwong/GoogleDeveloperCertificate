package com.calvert.recyclerview.verticalrecyclerview.animatealways.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R
import com.calvert.recyclerview.databinding.ItemUserLayoutBinding
import com.calvert.recyclerview.verticalrecyclerview.animatealways.viewholder.AnimateAlwaysViewHolder

class AnimateAlwaysAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemUserLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimateAlwaysViewHolder(binding.root)
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AnimateAlwaysViewHolder) {
            holder.bindView(mockDataList[position])
            setAnimation(holder.itemView)
        }
    }

    private fun setAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(view.context, R.anim.slide_in_left)
        view.startAnimation(animation)
    }

    // Clear animation when view is detached.
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        (holder as AnimateAlwaysViewHolder).clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }
}