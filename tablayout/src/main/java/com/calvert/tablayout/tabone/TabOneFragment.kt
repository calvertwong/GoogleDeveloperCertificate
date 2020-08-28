package com.calvert.tablayout.tabone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.tablayout.databinding.FragmentTabOneBinding
import com.calvert.ui.AppViewBindingBaseFragment

class TabOneFragment : AppViewBindingBaseFragment<FragmentTabOneBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentTabOneBinding.inflate(inflater, container, false))
        return binding.root
    }
}