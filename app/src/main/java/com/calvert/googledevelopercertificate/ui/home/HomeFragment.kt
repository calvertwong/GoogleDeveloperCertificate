package com.calvert.googledevelopercertificate.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calvert.googledevelopercertificate.R
import com.calvert.googledevelopercertificate.dto.TOPIC_LIST
import com.calvert.googledevelopercertificate.ui.home.adapter.TopicItemAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvTopicItem: RecyclerView = view.findViewById(R.id.rv_topic_item)
        rvTopicItem.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter =
                TopicItemAdapter(
                    TOPIC_LIST
                )
        }
    }
}
