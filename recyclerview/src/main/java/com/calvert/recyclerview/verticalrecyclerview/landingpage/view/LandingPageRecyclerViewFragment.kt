package com.calvert.recyclerview.verticalrecyclerview.landingpage.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.recyclerview.databinding.FragmentLandingpageRecyclerViewBinding
import com.calvert.recyclerview.dto.RV_ITEMS_LIST
import com.calvert.recyclerview.verticalrecyclerview.landingpage.adapter.LandingPageVerticalAdapter

class LandingPageRecyclerViewFragment : Fragment() {

    private var _binding: FragmentLandingpageRecyclerViewBinding? = null
    private val binding: FragmentLandingpageRecyclerViewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingpageRecyclerViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvLayoutManager = LinearLayoutManager(requireContext())
        val rvAdapter =
            LandingPageVerticalAdapter(RV_ITEMS_LIST)

        binding.rvBasic.apply {
            layoutManager = rvLayoutManager
            adapter = rvAdapter
            // add divider
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
