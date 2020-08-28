package com.calvert.viewbinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.ui.AppViewBindingBaseFragment
import com.calvert.viewbinding.databinding.FragmentViewBindingDemoBinding

/**
 * View binding should be used when we have simple use cases.
 *
 * View binding provides advantages such as:
 * 1) Get rid of findViewById()
 *
 * 2) Null safety to the views to ensure there is no risk of a null pointer exception due to
 * an invalid view ID.
 *
 * 3) Type safety to ensure there is no risk of a class cast exception
 *
 * 4) Faster compilation because it doesn't require annotation processing.
 *
 * 5) Doesn't require specially-tagged XML layout files like data binding.
 *
 * 6) All we need to do is enable view binding in the .build/gradle, done
 *
 * Limitation
 * 1) Doesn't support layout variables or expression. (to use this feature, refer to data binding)
 *
 * 2) Doesn't support two-way data binding.
 */
class ViewBindingDemoFragment : AppViewBindingBaseFragment<FragmentViewBindingDemoBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentViewBindingDemoBinding.inflate(inflater, container, false))
        return binding.root
    }

    //  This is called after onCreateView()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvViewBindingDemo.text = getString(R.string.view_binding_demo_text)
    }
}
