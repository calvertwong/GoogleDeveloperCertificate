package com.calvert.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.calvert.googledevelopercertificate.databinding.FragmentHomeBinding
import com.calvert.home.adapter.TopicItemAdapter
import com.calvert.home.dto.TOPIC_LIST
import com.calvert.ui.AppViewBindingBaseFragment

class HomeFragment : AppViewBindingBaseFragment<FragmentHomeBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentHomeBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTopicItem.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TopicItemAdapter(TOPIC_LIST)
        }
    }
}
