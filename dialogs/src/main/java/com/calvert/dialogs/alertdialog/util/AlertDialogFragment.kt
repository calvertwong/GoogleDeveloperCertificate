package com.calvert.dialogs.alertdialog.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.calvert.dialogs.R

// We can create an alert dialog without using a dialog fragment but when you rotate the screen
// the alert dialog will be removed unlike a dialog fragment which has a lifecycle
class AlertDialogFragment @JvmOverloads constructor(
    private val title: String? = null,
    private val message: String? = null,
    private val positiveButtonText: String? = null,
    private val positiveAction: DialogInterface.OnClickListener? = null,
    private val negativeButtonText: String? = null,
    private val negativeAction: DialogInterface.OnClickListener? = null,
    private val neutralButtonText: String? = null,
    private val neutralAction: DialogInterface.OnClickListener? = null
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // you can define the alert dialog style here
            val builder = AlertDialog.Builder(it, R.style.ThemeOverlay_MaterialComponents_Dialog)
            with(builder) {
                title?.let { title ->
                    this.setTitle(title)
                }
                message?.let { message ->
                    this.setMessage(message)
                }
                positiveButtonText?.let { positiveText ->
                    this.setPositiveButton(positiveText, positiveAction)
                }
                negativeButtonText?.let { negativeText ->
                    this.setNegativeButton(negativeText, negativeAction)
                }
                neutralButtonText?.let { neutralText ->
                    this.setNeutralButton(neutralText, neutralAction)
                }
                this.create()
            }
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}