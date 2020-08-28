package com.calvert.toasts.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.calvert.toasts.R
import com.calvert.toasts.databinding.FragmentToastBasicBinding
import com.calvert.ui.AppViewBindingBaseFragment

class BasicToastFragment : AppViewBindingBaseFragment<FragmentToastBasicBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentToastBasicBinding.inflate(inflater, container, false))
        return binding.root
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
