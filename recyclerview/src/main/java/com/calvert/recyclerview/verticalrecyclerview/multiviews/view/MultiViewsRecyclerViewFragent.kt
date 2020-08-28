package com.calvert.recyclerview.verticalrecyclerview.multiviews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentMultiViewsRecyclerViewBinding
import com.calvert.recyclerview.verticalrecyclerview.multiviews.adapter.MultiViewsAdapter
import com.calvert.ui.AppViewBindingBaseFragment

class MultiViewsRecyclerViewFragent : AppViewBindingBaseFragment<FragmentMultiViewsRecyclerViewBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentMultiViewsRecyclerViewBinding.inflate(layoutInflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvLayoutManager = LinearLayoutManager(requireContext())
        val rvAdapter = MultiViewsAdapter(MOCK_DATA_LIST)

        binding.rvDifferentViews.apply {
            layoutManager = rvLayoutManager
            adapter = rvAdapter
            // add divider
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }
}
