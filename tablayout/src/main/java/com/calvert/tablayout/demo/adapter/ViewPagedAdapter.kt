package com.calvert.tablayout.demo.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.calvert.tablayout.tabone.TabOneFragment
import com.calvert.tablayout.tabthree.TabThreeFragment
import com.calvert.tablayout.tabtwo.TabTwoFragment

class ViewPagedAdapter(private val tabList: ArrayList<String>, fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return tabList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabOneFragment()
            1 -> TabTwoFragment()
            else -> TabThreeFragment()
        }
    }
}