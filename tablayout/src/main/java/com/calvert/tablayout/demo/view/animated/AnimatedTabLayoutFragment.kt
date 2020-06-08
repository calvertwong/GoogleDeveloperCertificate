package com.calvert.tablayout.demo.view.animated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.calvert.tablayout.databinding.FragmentAnimatedTabLayoutBinding
import com.calvert.tablayout.demo.adapter.ViewPagedAdapter
import com.calvert.tablayout.demo.transformer.AnimatedViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AnimatedTabLayoutFragment : Fragment() {

    private var _binding: FragmentAnimatedTabLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAnimatedTabLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabs: ArrayList<String> = arrayListOf("Tab One", "Tab Two", "Tab Three")

        binding.viewPagerAnimated.apply {
            adapter = ViewPagedAdapter(tabs, this@AnimatedTabLayoutFragment)
            setPageTransformer(AnimatedViewPagerAdapter())
        }
        // add this to set texts in tabs
        TabLayoutMediator(binding.tabLayoutAnimated, binding.viewPagerAnimated) { tab, position ->
            tab.text = tabs[position]
        }.attach()

        binding.tabLayoutAnimated.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "Same tab has been selected.", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "Moving to the next tab.", Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "Different tab is selected.", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}