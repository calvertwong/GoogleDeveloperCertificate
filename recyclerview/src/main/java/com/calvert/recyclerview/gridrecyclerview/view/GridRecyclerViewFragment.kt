package com.calvert.recyclerview.gridrecyclerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentGridRecyclerViewBinding
import com.calvert.recyclerview.gridrecyclerview.adapter.GridAdapter
import com.calvert.ui.AppViewBindingBaseFragment

class GridRecyclerViewFragment : AppViewBindingBaseFragment<FragmentGridRecyclerViewBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentGridRecyclerViewBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter = GridAdapter(MOCK_DATA_LIST)
        val rvLayoutManager = GridLayoutManager(requireContext(), 2)

        binding.rvGrid.apply {
            adapter = rvAdapter
            layoutManager = rvLayoutManager
        }
    }

}
