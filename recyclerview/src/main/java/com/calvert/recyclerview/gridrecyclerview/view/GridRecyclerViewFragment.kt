package com.calvert.recyclerview.gridrecyclerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentGridRecyclerViewBinding
import com.calvert.recyclerview.gridrecyclerview.adapter.GridAdapter

class GridRecyclerViewFragment : Fragment() {

    private var _binding: FragmentGridRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGridRecyclerViewBinding.inflate(inflater, container, false)
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
