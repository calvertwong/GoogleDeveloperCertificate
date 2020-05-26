package com.calvert.customview.speedknob.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.calvert.customview.databinding.FragmentSpeedControllerBinding

class SpeedControllerFragment : Fragment() {

    private var _binding: FragmentSpeedControllerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSpeedControllerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReadSpeed.setOnClickListener {
            Toast.makeText(requireContext(), binding.ivSpeedKnob.getCurrentFanSpeed().toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
