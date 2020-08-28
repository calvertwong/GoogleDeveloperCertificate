package com.calvert.dialogs.datapickerdialog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.dialogs.databinding.FragmentDatePickerDemoBinding
import com.calvert.dialogs.datapickerdialog.constant.DatePickerConstants
import com.calvert.dialogs.datapickerdialog.util.DatePickerFragment
import com.calvert.ui.AppViewBindingBaseFragment

class DatePickerDemoFragment : AppViewBindingBaseFragment<FragmentDatePickerDemoBinding>() {

    private lateinit var datePicker: DatePickerFragment

    private val REQUEST_CODE = 11

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentDatePickerDemoBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDatePickerFragment.setOnClickListener {
            datePicker = DatePickerFragment()
            datePicker.setTargetFragment(this, REQUEST_CODE)
            datePicker.show(parentFragmentManager, "datePicker")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val result =
                "Day: ${data?.getStringExtra(DatePickerConstants.SELECTED_DAY)}\nMonth: ${data?.getStringExtra(DatePickerConstants.SELECTED_MONTH)
                }\nYear: ${data?.getStringExtra(DatePickerConstants.SELECTED_YEAR)}"
            binding.tvSelectedDate.text = result
        }
    }
}