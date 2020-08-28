package com.calvert.responsiveuiconstraintlayout.barrier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.calvert.responsiveuiconstraintlayout.R
import com.calvert.responsiveuiconstraintlayout.databinding.FragmentBarrierBinding
import com.calvert.ui.AppViewBindingBaseFragment

class BarrierFragment : AppViewBindingBaseFragment<FragmentBarrierBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setBinding(FragmentBarrierBinding.inflate(inflater, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDefaultOne.apply {
            setOnClickListener {
                val buttonLayoutParams = this.layoutParams as ConstraintLayout.LayoutParams
                // if button has width percent of 30, set it to 45, else, set button width percent to 45
                if (buttonLayoutParams.matchConstraintPercentWidth == 0.30F) {
                    this.text = getString(R.string._45)
                    buttonLayoutParams.matchConstraintPercentWidth = 0.45F
                    this.layoutParams = buttonLayoutParams
                } else {
                    this.text = getString(R.string._30)
                    buttonLayoutParams.matchConstraintPercentWidth = 0.30F
                    this.layoutParams = buttonLayoutParams
                }
            }
        }

        binding.btnDefaultTwo.apply {
            setOnClickListener {
                val buttonLayoutParams = this.layoutParams as ConstraintLayout.LayoutParams
                // if button has width percent of 40, set it to 55, else, set button width percent to 45
                if (buttonLayoutParams.matchConstraintPercentWidth == 0.40F) {
                    this.text = getString(R.string._55)
                    buttonLayoutParams.matchConstraintPercentWidth = 0.55F
                    this.layoutParams = buttonLayoutParams
                } else {
                    this.text = getString(R.string._40)
                    buttonLayoutParams.matchConstraintPercentWidth = 0.40F
                    this.layoutParams = buttonLayoutParams
                }
            }
        }
    }
}

