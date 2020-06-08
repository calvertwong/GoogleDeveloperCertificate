package com.calvert.toasts.custom_toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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

        val customToastLayout =
            View.inflate(requireContext(), R.layout.item_custom_toast_layout, null)
        val tvCustomToastText: TextView = customToastLayout.findViewById(R.id.tv_custom_toast_text)
        tvCustomToastText.text = getString(R.string.custom_toast_text)

        val tvShowCustomToast: TextView = view.findViewById(R.id.tv_show_custom_toast)
        tvShowCustomToast.setOnClickListener {
            with(Toast(requireContext())) {
                this.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
                this.duration = Toast.LENGTH_LONG
                this.view = customToastLayout
                this.show()
            }
        }
    }

}
