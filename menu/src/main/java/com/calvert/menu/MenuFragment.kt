package com.calvert.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.calvert.menu.databinding.FragmentMenuBinding
import com.calvert.ui.AppViewBindingBaseFragment

class MenuFragment : AppViewBindingBaseFragment<FragmentMenuBinding>() {

    private var isTextTypeMenu: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        setBinding(FragmentMenuBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToggleMenu.setOnClickListener {
            isTextTypeMenu = !isTextTypeMenu
            requireActivity().invalidateOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        when (isTextTypeMenu) {
            true -> inflater.inflate(R.menu.menu_tutorial, menu)
            false -> inflater.inflate(R.menu.menu_tutorial_icon, menu)
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_show_toast_alpha -> {
                Toast.makeText(requireContext(), "Alpha", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_show_toast_beta -> {
                Toast.makeText(requireContext(), "Beta", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_cart -> {
                Toast.makeText(requireContext(), "Cart", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_alarm -> {
                Toast.makeText(requireContext(), "Alarm", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_shuttle -> {
                Toast.makeText(requireContext(), "Shuttle", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}