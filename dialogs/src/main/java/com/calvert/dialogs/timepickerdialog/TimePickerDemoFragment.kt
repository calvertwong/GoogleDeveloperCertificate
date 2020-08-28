package com.calvert.dialogs.timepickerdialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.dialogs.databinding.FragmentTimePickerDemoBinding
import com.calvert.dialogs.timepickerdialog.constant.TimePickerConstants
import com.calvert.dialogs.timepickerdialog.util.TimePickerFragment
import com.calvert.ui.AppViewBindingBaseFragment

class TimePickerDemoFragment : AppViewBindingBaseFragment<FragmentTimePickerDemoBinding>() {

    private lateinit var timePicker: TimePickerFragment

    private val REQUEST_CODE = 12

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentTimePickerDemoBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTimePickerFragment.setOnClickListener {
            timePicker = TimePickerFragment()
            timePicker.setTargetFragment(this, REQUEST_CODE)
            timePicker.show(parentFragmentManager, "timePicker")
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
}