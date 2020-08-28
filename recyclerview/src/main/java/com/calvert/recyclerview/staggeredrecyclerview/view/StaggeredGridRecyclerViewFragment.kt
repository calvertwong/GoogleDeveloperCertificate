package com.calvert.recyclerview.staggeredrecyclerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentStaggeredGridRecyclerViewBinding
import com.calvert.recyclerview.staggeredrecyclerview.adapter.StaggeredGridAdapter
import com.calvert.ui.AppViewBindingBaseFragment

class StaggeredGridRecyclerViewFragment : AppViewBindingBaseFragment<FragmentStaggeredGridRecyclerViewBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentStaggeredGridRecyclerViewBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter = StaggeredGridAdapter(MOCK_DATA_LIST)
        val rvLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        binding.rvStaggeredGrid.apply {
            adapter = rvAdapter
            layoutManager = rvLayoutManager
        }
    }

}
