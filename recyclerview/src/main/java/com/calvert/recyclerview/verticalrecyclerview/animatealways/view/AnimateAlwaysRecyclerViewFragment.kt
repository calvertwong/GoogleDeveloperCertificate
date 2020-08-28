package com.calvert.recyclerview.verticalrecyclerview.animatealways.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentAnimateAlwaysRecyclerViewBinding
import com.calvert.recyclerview.verticalrecyclerview.animatealways.adapter.AnimateAlwaysAdapter
import com.calvert.ui.AppViewBindingBaseFragment

class AnimateAlwaysRecyclerViewFragment : AppViewBindingBaseFragment<FragmentAnimateAlwaysRecyclerViewBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentAnimateAlwaysRecyclerViewBinding.inflate(layoutInflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvLayoutManager = LinearLayoutManager(requireContext())
        val rvAdapter = AnimateAlwaysAdapter(MOCK_DATA_LIST)

        binding.rvAnimateAlways.apply {
            layoutManager = rvLayoutManager
            adapter = rvAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }
}
