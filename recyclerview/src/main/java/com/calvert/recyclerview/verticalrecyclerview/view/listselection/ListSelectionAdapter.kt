package com.calvert.recyclerview.verticalrecyclerview.view.listselection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.calvert.mockdata.MockDataObject
import com.calvert.recyclerview.R

class ListSelectionAdapter(private val mockDataList: List<MockDataObject>) : RecyclerView.Adapter<RecyclerView
.ViewHolder>() {
    lateinit var context: Context
    var lastPosition = -1

    var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return ListSelectionViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_user_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = mockDataList.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ListSelectionViewHolder) {
            holder.bindView(mockDataList[position], tracker!!.isSelected(position.toLong()))
            setAnimation(holder.itemView, position)
        }
    }

    private fun setAnimation(view: View, position: Int) {
        // Animate only if the view holder was never displayed before
        // To always animate, remove the if statement and lastPosition assignment
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_left)
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    // Clear animation when view is detached.
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        (holder as ListSelectionViewHolder).clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }
}