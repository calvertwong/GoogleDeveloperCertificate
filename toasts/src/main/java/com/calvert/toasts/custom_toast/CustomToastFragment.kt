package com.calvert.toasts.custom_toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.calvert.toasts.R

class CustomToastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_toast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCustomToastText: TextView = view.findViewById(R.id.tv_custom_toast_text)
        tvCustomToastText.text = getString(R.string.custom_toast_text)

        val inflater = layoutInflater
        val clCustomToastLayout: ConstraintLayout = view.findViewById(R.id.cl_custom_toast_layout)
        val customToastLayout =
            inflater.inflate(R.layout.item_custom_toast_layout, clCustomToastLayout)
        with(Toast(requireContext())) {
            this.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
            this.duration = Toast.LENGTH_LONG
            this.view = customToastLayout
            this.show()
        }
        clCustomToastLayout.setOnClickListener {

        }
    }

}
