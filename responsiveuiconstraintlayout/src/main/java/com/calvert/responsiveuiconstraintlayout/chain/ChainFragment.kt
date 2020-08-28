package com.calvert.responsiveuiconstraintlayout.chain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.responsiveuiconstraintlayout.databinding.FragmentChainBinding
import com.calvert.ui.AppViewBindingBaseFragment

class ChainFragment : AppViewBindingBaseFragment<FragmentChainBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentChainBinding.inflate(inflater, container, false))
        return binding.root
    }

}
