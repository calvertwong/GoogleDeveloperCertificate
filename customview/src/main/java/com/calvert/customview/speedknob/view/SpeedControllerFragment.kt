package com.calvert.customview.speedknob.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.calvert.customview.databinding.FragmentSpeedControllerBinding
import com.calvert.ui.AppViewBindingBaseFragment

class SpeedControllerFragment : AppViewBindingBaseFragment<FragmentSpeedControllerBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentSpeedControllerBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReadSpeed.setOnClickListener {
            Toast.makeText(requireContext(), binding.ivSpeedKnob.getCurrentFanSpeed().toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
