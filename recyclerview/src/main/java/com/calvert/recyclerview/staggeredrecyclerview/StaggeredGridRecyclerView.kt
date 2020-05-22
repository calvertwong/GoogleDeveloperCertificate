package com.calvert.recyclerview.staggeredrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.calvert.recyclerview.R

class StaggeredGridRecyclerView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_staggered_grid_recycler_view, container, false)
    }

}
