package com.calvert.recyclerview.verticalrecyclerview.animateonce.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentAnimateOnceRecyclerViewBinding
import com.calvert.recyclerview.verticalrecyclerview.animateonce.adapter.AnimateOnceAdapter
import com.calvert.ui.AppViewBindingBaseFragment

class AnimateOnceRecyclerViewFragment : AppViewBindingBaseFragment<FragmentAnimateOnceRecyclerViewBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentAnimateOnceRecyclerViewBinding.inflate(layoutInflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvLayoutManager = LinearLayoutManager(requireContext())
        val rvAdapter = AnimateOnceAdapter(MOCK_DATA_LIST)

        binding.rvAnimateOnce.apply {
            layoutManager = rvLayoutManager
            adapter = rvAdapter
            // add divider
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }
}
