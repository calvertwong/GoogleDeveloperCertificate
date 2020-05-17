package com.calvert.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.calvert.viewbinding.databinding.FragmentViewBindingDemoBinding

/**
 * View binding should be used when we have simple use cases.
 *
 * View binding provides advantages such as:
 * 1) Null safety to the views to ensure there is no risk of a null pointer exception due to
 * an invalid view ID.
 *
 * 2) Type safety to ensure there is no risk of a class cast exception
 *
 * 3) Faster compilation because it doesn't require annotation processing.
 *
 * 4) Doesn't require specially-tagged XML layout files like data binding.
 *
 * 5) All we need to do is enable view binding in the .build/gradle
 *
 * Limitation
 * 1) Doesn't support layout variables or expression. (to use this feature, refer to data binding)
 *
 * 2) Doesn't support two-way data binding.
 */
class ViewBindingDemoFragment : Fragment() {

    private var _binding: FragmentViewBindingDemoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewBindingDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    //  This is called after onCreateView()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvViewBindingDemo.text = getString(R.string.view_binding_demo_text)
    }

    // Clean up any references to the binding class here
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}