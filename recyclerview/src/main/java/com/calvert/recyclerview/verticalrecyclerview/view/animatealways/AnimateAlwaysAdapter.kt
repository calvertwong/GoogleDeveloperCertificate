package com.calvert.recyclerview.verticalrecyclerview.view.animatealways

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R

class AnimateAlwaysAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView
.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return AnimateAlwaysViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_user_layout, parent, false)
        )
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
        val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
        view.startAnimation(animation)
    }

    // Clear animation when view is detached.
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        (holder as AnimateAlwaysViewHolder).clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }
}