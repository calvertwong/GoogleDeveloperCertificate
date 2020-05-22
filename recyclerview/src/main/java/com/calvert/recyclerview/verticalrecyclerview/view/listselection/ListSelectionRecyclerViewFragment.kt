package com.calvert.recyclerview.verticalrecyclerview.view.listselection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentListSelectionRecyclerViewBinding

class ListSelectionRecyclerViewFragment : Fragment() {

    private var _binding: FragmentListSelectionRecyclerViewBinding? = null
    private val binding get() = _binding!!

    private var tracker: SelectionTracker<Long>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListSelectionRecyclerViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvLayoutManager = LinearLayoutManager(requireContext())
        val rvAdapter = ListSelectionAdapter(MOCK_DATA_LIST)

        binding.rvVertical.apply {
            layoutManager = rvLayoutManager
            adapter = rvAdapter
            // add divider
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }

        tracker = SelectionTracker.Builder<Long>(
            "userSelection",
            binding.rvVertical,
            StableIdKeyProvider(binding.rvVertical),
            CustomItemLookup(binding.rvVertical),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    val itemSize: Int? = tracker?.selection?.size()
                    println("Click   ${itemSize}")
                }

                override fun onItemStateChanged(key: Long, selected: Boolean) {
                    super.onItemStateChanged(key, selected)
                    if (selected) {
                        println("Item Clicked   ${MOCK_DATA_LIST[key.toInt()]}")
                    }
                }
            }
        )

        // init tracker after the initialization of the adapter
        rvAdapter.tracker = tracker

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
