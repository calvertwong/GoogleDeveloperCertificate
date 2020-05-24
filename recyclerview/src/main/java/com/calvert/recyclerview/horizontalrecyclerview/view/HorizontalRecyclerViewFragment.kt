package com.calvert.recyclerview.horizontalrecyclerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentHorizontalRecyclerViewBinding
import com.calvert.recyclerview.horizontalrecyclerview.adapter.HorizontalAdapter
import com.calvert.recyclerview.horizontalrecyclerview.adapter.HorizontalEndlessAdapter

class HorizontalRecyclerViewFragment : Fragment() {

    private var _binding: FragmentHorizontalRecyclerViewBinding? = null
    private val binding: FragmentHorizontalRecyclerViewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHorizontalRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter = HorizontalAdapter(MOCK_DATA_LIST)
        val rvLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val rvLayoutManagerReversed = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)

        val rvEndlessRightDirectionLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val rvEndlessLeftDirectionLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)

        val rvEndlessAdapter = HorizontalEndlessAdapter(MOCK_DATA_LIST)
        val rvEndlessLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // normal horizontal recycler view
        binding.rvHorizontal.apply {
            adapter = rvAdapter
            layoutManager = rvLayoutManager
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        }

        // normal horizontal recycler view with reversed direction (from right to left)
        binding.rvHorizontalReverse.apply {
            adapter = rvAdapter
            layoutManager = rvLayoutManagerReversed
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        }

        // endless horizontal recycler view that scrolls one direction (right direction)
        binding.rvHorizontalEndlessRightDirection.apply {
            adapter = rvEndlessAdapter
            layoutManager = rvEndlessRightDirectionLayoutManager
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        }

        // endless horizontal recycler view that scrolls one direction (left direction)
        binding.rvHorizontalEndlessLeftDirection.apply {
            adapter = rvEndlessAdapter
            layoutManager = rvEndlessLeftDirectionLayoutManager
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        }

        // endless horizontal recycler view that scrolls both directions
        binding.rvHorizontalEndless.apply {
            adapter = rvEndlessAdapter
            layoutManager = rvEndlessLayoutManager
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
            // formula = Integer.MAX_VALUE / (list.size / 2) * list.size
            // This formula ensures that the starting item will be the first item in the list
            this.layoutManager?.scrollToPosition(Integer.MAX_VALUE / MOCK_DATA_LIST.size / 2 * MOCK_DATA_LIST.size)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
