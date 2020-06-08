package com.calvert.dialogs.timepickerdialog.util

import android.app.Activity
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.calvert.dialogs.timepickerdialog.constant.TimePickerConstants
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    // this method will be called when a user sets a date
    override fun onTimeSet(timePicker: TimePicker?, year: Int, month: Int) {
        val intent = Intent()
        intent.putExtra(TimePickerConstants.SELECTED_HOUR, year.toString())
        intent.putExtra(TimePickerConstants.SELECTED_MINUTE, month.toString())
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // set current time as the default date
        val calendar = Calendar.getInstance()

        with(calendar) {
            return TimePickerDialog(
                requireContext(), this@TimePickerFragment, this.get(Calendar.HOUR_OF_DAY), this.get(Calendar.MINUTE), android.text.format
                    .DateFormat.is24HourFormat(requireContext())
            )
        }
    }
}