package com.calvert.tablayout.tabthree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.tablayout.databinding.FragmentTabThreeBinding
import com.calvert.ui.AppViewBindingBaseFragment

class TabThreeFragment : AppViewBindingBaseFragment<FragmentTabThreeBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentTabThreeBinding.inflate(inflater, container, false))
        return binding.root
    }
}