package com.calvert.dialogs.alertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.calvert.dialogs.alertdialog.util.AlertDialogFragment
import com.calvert.dialogs.databinding.FragmentAlertDialogDemoBinding

class AlertDialogDemoFragment : Fragment() {

    private var _binding: FragmentAlertDialogDemoBinding? = null
    private val binding get() = _binding!!

    lateinit var positiveAction: DialogInterface.OnClickListener
    lateinit var negativeAction: DialogInterface.OnClickListener
    lateinit var neutralAction: DialogInterface.OnClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAlertDialogDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // define actions on button clicked
        positiveAction = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(requireContext(), "Positive button", Toast.LENGTH_SHORT).show()
        }

        negativeAction = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(requireContext(), "Negative button", Toast.LENGTH_SHORT).show()
        }

        neutralAction = DialogInterface.OnClickListener { _, _ ->
            Toast.makeText(requireContext(), "Neutral button", Toast.LENGTH_SHORT).show()
        }

        binding.btnNormalDialogPositiveOnly.setOnClickListener {
            AlertDialogFragment(
                "This is a positive title.",
                "Positive message is located here.",
                "Yes",
                positiveAction
            ).show(requireFragmentManager(), "Normal dialog with positive button.")
        }

        binding.btnNormalDialogNegativeOnly.setOnClickListener {
            AlertDialogFragment(
                title = "This is a negative title.",
                message = "Negative message is located here.",
                negativeButtonText = "No",
                negativeAction = negativeAction
            ).show(requireFragmentManager(), "Normal dialog with negative button.")
        }

        binding.btnNormalDialogNeutralOnly.setOnClickListener {
            AlertDialogFragment(
                title = "This is a neutral title.",
                message = "Neutral message is located here.",
                neutralButtonText = "Cancel",
                neutralAction = neutralAction
            ).show(requireFragmentManager(), "Normal dialog with neutral button.")
        }

        binding.btnNormalTwoButtonsAlertDialogOnly.setOnClickListener {
            AlertDialogFragment(
                title = "Two buttons alert dialog title.",
                message = "Two buttons alert dialog message is located here.",
                positiveButtonText = "Yes",
                positiveAction = positiveAction,
                neutralButtonText = "Cancel",
                neutralAction = neutralAction
            ).show(requireFragmentManager(), "Normal dialog with neutral button.")
        }

        binding.btnNormalDialogAllButtons.setOnClickListener {
            val allButtonsAlertDialog = AlertDialogFragment(
                "This is a title.",
                "Message is located here.",
                "Yes",
                positiveAction,
                "No",
                negativeAction,
                "Cancel",
                neutralAction
            )
            // this prevents user to dismiss the dialog on outside click
            allButtonsAlertDialog.isCancelable = false
            allButtonsAlertDialog.show(requireFragmentManager(), "Normal dialog with all buttons and not cancellable.")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}