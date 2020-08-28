package com.calvert.recyclerview.verticalrecyclerview.listselection.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentListSelectionRecyclerViewBinding
import com.calvert.recyclerview.verticalrecyclerview.listselection.CustomItemLookup
import com.calvert.recyclerview.verticalrecyclerview.listselection.adapter.ListSelectionAdapter
import com.calvert.ui.AppViewBindingBaseFragment

class ListSelectionRecyclerViewFragment : AppViewBindingBaseFragment<FragmentListSelectionRecyclerViewBinding>() {

    private var tracker: SelectionTracker<Long>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentListSelectionRecyclerViewBinding.inflate(layoutInflater, container, false))
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

        tracker = SelectionTracker.Builder(
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
                var selectedItemSize: Int? = 0

                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    selectedItemSize = tracker?.selection?.size()
                }

                override fun onItemStateChanged(key: Long, selected: Boolean) {
                    super.onItemStateChanged(key, selected)
                    if (selected) {
                        Toast.makeText(
                            requireContext(), "Selected item ${MOCK_DATA_LIST[key.toInt()].name}." +
                                "\n\nTotal selected item: ${selectedItemSize?.plus(1)}",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            requireContext(), "Deselected item ${MOCK_DATA_LIST[key.toInt()].name}." +
                                "\n\nTotal selected item: ${selectedItemSize?.minus(1)}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        )

        // init tracker after the initialization of the adapter
        rvAdapter.tracker = tracker
    }
}
