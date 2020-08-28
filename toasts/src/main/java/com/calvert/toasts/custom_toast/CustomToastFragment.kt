package com.calvert.toasts.custom_toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.calvert.toasts.R
import com.calvert.toasts.databinding.FragmentCustomToastBinding
import com.calvert.toasts.databinding.ItemCustomToastLayoutBinding
import com.calvert.ui.AppViewBindingBaseFragment

class CustomToastFragment : AppViewBindingBaseFragment<FragmentCustomToastBinding>() {

    private lateinit var customToastBinding: ItemCustomToastLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentCustomToastBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customToastBinding = ItemCustomToastLayoutBinding.inflate(LayoutInflater.from(requireContext()))
        customToastBinding.tvCustomToastText.text = getString(R.string.custom_toast_text)

        binding.tvShowCustomToast.setOnClickListener {
            with(Toast(requireContext())) {
                this.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 0)
                this.duration = Toast.LENGTH_LONG
                this.view = customToastBinding.root
                this.show()
            }
        }
    }

}
