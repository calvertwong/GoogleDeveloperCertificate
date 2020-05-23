package com.calvert.recyclerview.verticalrecyclerview.view.animatealways

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.mockdata.MOCK_DATA_LIST
import com.calvert.recyclerview.databinding.FragmentAnimateAlwaysRecyclerViewBinding

class AnimateAlwaysRecyclerViewFragment : Fragment() {

    private var _binding: FragmentAnimateAlwaysRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimateAlwaysRecyclerViewBinding.inflate(layoutInflater, container, false)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
