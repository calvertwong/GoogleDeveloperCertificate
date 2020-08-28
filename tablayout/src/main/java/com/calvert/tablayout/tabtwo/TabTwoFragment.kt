package com.calvert.tablayout.tabtwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.tablayout.databinding.FragmentTabTwoBinding
import com.calvert.ui.AppViewBindingBaseFragment

class TabTwoFragment : AppViewBindingBaseFragment<FragmentTabTwoBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentTabTwoBinding.inflate(inflater, container, false))
        return binding.root
    }
}