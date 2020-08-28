package com.calvert.toasts.positioning_your_toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.calvert.toasts.R
import com.calvert.toasts.databinding.FragmentPositioningYourToastBinding
import com.calvert.ui.AppViewBindingBaseFragment

class PositioningYourToastFragment : AppViewBindingBaseFragment<FragmentPositioningYourToastBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentPositioningYourToastBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvShowTopLeftToast.setOnClickListener {
            createAndShowToast(Gravity.TOP or Gravity.START, R.string.top_left_toast)
        }

        binding.tvShowTopCenterToast.setOnClickListener {
            createAndShowToast(Gravity.TOP or Gravity.CENTER, R.string.top_center_toast)
        }

        binding.tvShowTopRightToast.setOnClickListener {
            createAndShowToast(Gravity.TOP or Gravity.END, R.string.top_right_toast)
        }

        binding.tvShowCenterLeftToast.setOnClickListener {
            createAndShowToast(Gravity.CENTER or Gravity.START, R.string.center_left_toast)
        }

        binding.tvShowCenterToast.setOnClickListener {
            createAndShowToast(Gravity.CENTER, R.string.center_toast)
        }

        binding.tvShowCenterRightToast.setOnClickListener {
            createAndShowToast(Gravity.CENTER or Gravity.END, R.string.center_right_toast)
        }

        binding.tvShowBottomLeftToast.setOnClickListener {
            createAndShowToast(Gravity.BOTTOM or Gravity.START, R.string.bottom_left_toast)
        }

        binding.tvShowBottomCenterToast.setOnClickListener {
            createAndShowToast(Gravity.BOTTOM or Gravity.CENTER, R.string.bottom_center_toast)
        }

        binding.tvShowBottomRightToast.setOnClickListener {
            createAndShowToast(Gravity.BOTTOM or Gravity.END, R.string.bottom_right_toast)
        }
    }

    private fun createAndShowToast(position: Int, toastText: Int) {
        val toast = Toast.makeText(requireContext(), getString(toastText), Toast.LENGTH_LONG)
        toast.setGravity(position, 0, 0)
        toast.show()
    }
}
