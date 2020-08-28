package com.calvert.ui

import androidx.viewbinding.ViewBinding

abstract class AppViewBindingBaseFragment<BindingType : ViewBinding> : AppBaseFragment() {
    private var _binding: BindingType? = null
    val binding: BindingType get() = _binding!!

    fun setBinding(bindingType: BindingType?) {
        _binding = bindingType
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}