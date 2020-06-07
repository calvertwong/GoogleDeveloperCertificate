package com.calvert.dialogs.timepickerdialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.calvert.dialogs.databinding.FragmentTimePickerDemoBinding
import com.calvert.dialogs.timepickerdialog.constant.TimePickerConstants
import com.calvert.dialogs.timepickerdialog.util.TimePickerFragment

class TimePickerDemoFragment : Fragment() {

    private var _binding: FragmentTimePickerDemoBinding? = null
    private val binding get() = _binding!!

    lateinit var timePicker: TimePickerFragment

    private val REQUEST_CODE = 12

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTimePickerDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTimePickerFragment.setOnClickListener {
            timePicker = TimePickerFragment()
            timePicker.setTargetFragment(this, REQUEST_CODE)
            timePicker.show(requireFragmentManager(), "timePicker")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val result =
                "Hour: ${data?.getStringExtra(TimePickerConstants.SELECTED_HOUR)}\nMinute: ${data?.getStringExtra(TimePickerConstants.SELECTED_MINUTE)
                }"
            binding.tvSelectedTime.text = result
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}