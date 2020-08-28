package com.calvert.customview.lightbulb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.calvert.customview.databinding.FragmentLightBulbBinding
import com.calvert.ui.AppViewBindingBaseFragment

class LightBulbFragment : AppViewBindingBaseFragment<FragmentLightBulbBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentLightBulbBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReadBulb.setOnClickListener {
            Toast.makeText(requireContext(), binding.ivLightBulb.getDimLevel(), Toast.LENGTH_LONG).show()
        }
    }
}
