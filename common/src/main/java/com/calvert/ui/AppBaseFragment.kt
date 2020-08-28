package com.calvert.ui

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class AppBaseFragment : Fragment() {
    fun navigateTo(actionId: Int) {
        findNavController().navigate(actionId)
    }
}