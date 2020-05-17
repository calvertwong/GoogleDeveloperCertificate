package com.calvert.toasts.positioning_your_toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.calvert.toasts.R

class PositioningYourToastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_positioning_your_toast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvShowTopLeftToast: TextView = view.findViewById(R.id.tv_show_top_left_toast)
        val tvShowTopCenterToast: TextView = view.findViewById(R.id.tv_show_top_center_toast)
        val tvShowTopRightToast: TextView = view.findViewById(R.id.tv_show_top_right_toast)
        val tvShowCenterLeftToast: TextView = view.findViewById(R.id.tv_show_center_left_toast)
        val tvShowCenterToast: TextView = view.findViewById(R.id.tv_show_center_toast)
        val tvShowCenterRightToast: TextView = view.findViewById(R.id.tv_show_center_right_toast)
        val tvShowBottomLeftToast: TextView = view.findViewById(R.id.tv_show_bottom_left_toast)
        val tvShowBottomCenterToast: TextView = view.findViewById(R.id.tv_show_bottom_center_toast)
        val tvShowBottomRightToast: TextView = view.findViewById(R.id.tv_show_bottom_right_toast)

        tvShowTopLeftToast.setOnClickListener {
            createAndShowToast(Gravity.TOP or Gravity.START, R.string.top_left_toast)
        }

        tvShowTopCenterToast.setOnClickListener {
            createAndShowToast(Gravity.TOP or Gravity.CENTER, R.string.top_center_toast)
        }

        tvShowTopRightToast.setOnClickListener {
            createAndShowToast(Gravity.TOP or Gravity.END, R.string.top_right_toast)
        }

        tvShowCenterLeftToast.setOnClickListener {
            createAndShowToast(Gravity.CENTER or Gravity.START, R.string.center_left_toast)
        }

        tvShowCenterToast.setOnClickListener {
            createAndShowToast(Gravity.CENTER, R.string.center_toast)
        }

        tvShowCenterRightToast.setOnClickListener {
            createAndShowToast(Gravity.CENTER or Gravity.END, R.string.center_right_toast)
        }

        tvShowBottomLeftToast.setOnClickListener {
            createAndShowToast(Gravity.BOTTOM or Gravity.START, R.string.bottom_left_toast)
        }

        tvShowBottomCenterToast.setOnClickListener {
            createAndShowToast(Gravity.BOTTOM or Gravity.CENTER, R.string.bottom_center_toast)
        }

        tvShowBottomRightToast.setOnClickListener {
            createAndShowToast(Gravity.BOTTOM or Gravity.END, R.string.bottom_right_toast)
        }
    }

    private fun createAndShowToast(position: Int, toastText: Int) {
        val toast = Toast.makeText(requireContext(), getString(toastText), Toast.LENGTH_LONG)
        toast.setGravity(position, 0, 0)
        toast.show()
    }
}
