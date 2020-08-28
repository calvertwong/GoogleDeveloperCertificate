package com.calvert.responsiveuiconstraintlayout.keyframeanimation

import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintSet
import com.calvert.responsiveuiconstraintlayout.R
import com.calvert.responsiveuiconstraintlayout.databinding.FragmentKeyframeAnimationBinding
import com.calvert.ui.AppViewBindingBaseFragment

/**
 * ConstraintSet animations animate only the size and position of child elements. (Attributes such as color won't work)
 */
class KeyframeAnimationFragment : AppViewBindingBaseFragment<FragmentKeyframeAnimationBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentKeyframeAnimationBinding.inflate(inflater, container, false))
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnStartAnimation.setOnClickListener {
            val constraintSet = ConstraintSet()
            // load the final layout
            constraintSet.load(requireContext(), R.layout.fragment_keyframe_animation_final)
            val transition = ChangeBounds()
            transition.duration = 5000
            TransitionManager.beginDelayedTransition(binding.clKeyframeLayout, transition)
            constraintSet.applyTo(binding.clKeyframeLayout)
        }

        binding.btnRevertAnimation.setOnClickListener {
            val constraintSet = ConstraintSet()
            // load the final layout
            constraintSet.load(requireContext(), R.layout.fragment_keyframe_animation)
            val transition = ChangeBounds()
            transition.duration = 5000
            TransitionManager.beginDelayedTransition(binding.clKeyframeLayout, transition)
            constraintSet.applyTo(binding.clKeyframeLayout)
        }
    }
}
