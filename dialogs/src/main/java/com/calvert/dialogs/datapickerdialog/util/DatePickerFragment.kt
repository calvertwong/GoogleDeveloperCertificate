package com.calvert.dialogs.datapickerdialog.util

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.calvert.dialogs.datapickerdialog.constant.DatePickerConstants
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    // this method will be called when a user sets a date
    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        val intent = Intent()
        intent.putExtra(DatePickerConstants.SELECTED_YEAR, year.toString())
        intent.putExtra(DatePickerConstants.SELECTED_MONTH, month.toString())
        intent.putExtra(DatePickerConstants.SELECTED_DAY, day.toString())
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // set current date as the default date
        val calendar = Calendar.getInstance()

        with(calendar) {
            return DatePickerDialog(
                requireContext(), this@DatePickerFragment, this.get(Calendar.YEAR), this.get(Calendar.MONTH), this.get(
                    Calendar.DAY_OF_MONTH
                )
            )
        }
    }
}