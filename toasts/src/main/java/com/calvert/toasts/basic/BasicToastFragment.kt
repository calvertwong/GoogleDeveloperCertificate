package com.calvert.toasts.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.calvert.toasts.R

class BasicToastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_toast_basic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvShowBasicToast: TextView = view.findViewById(R.id.tv_show_basic_toast)
        tvShowBasicToast.setOnClickListener {
            // This creates the toast and calls .show() to display the toast
            Toast.makeText(requireContext(), "This is a basic toast.", Toast.LENGTH_LONG).show()
        }
    }
}
