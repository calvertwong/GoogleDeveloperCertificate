package com.calvert.responsiveuiconstraintlayout.barrier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.calvert.responsiveuiconstraintlayout.R
import com.calvert.responsiveuiconstraintlayout.databinding.FragmentBarrierBinding

class BarrierFragment : Fragment() {

    private var _binding: FragmentBarrierBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBarrierBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDefaultOne = binding.btnDefaultOne
        val btnDefaultTwo = binding.btnDefaultTwo
        btnDefaultOne.setOnClickListener {
            val buttonLayoutParams = it.layoutParams as ConstraintLayout.LayoutParams
            // if button has width percent of 30, set it to 45, else, set button width percent to 45
            if (buttonLayoutParams.matchConstraintPercentWidth == 0.30F) {
                btnDefaultOne.text = getString(R.string._45)
                buttonLayoutParams.matchConstraintPercentWidth = 0.45F
                it.layoutParams = buttonLayoutParams
            } else {
                btnDefaultOne.text = getString(R.string._30)
                buttonLayoutParams.matchConstraintPercentWidth = 0.30F
                it.layoutParams = buttonLayoutParams
            }
        }

        btnDefaultTwo.setOnClickListener {
            val buttonLayoutParams = it.layoutParams as ConstraintLayout.LayoutParams
            // if button has width percent of 40, set it to 55, else, set button width percent to 45
            if (buttonLayoutParams.matchConstraintPercentWidth == 0.40F) {
                btnDefaultTwo.text = getString(R.string._55)
                buttonLayoutParams.matchConstraintPercentWidth = 0.55F
                it.layoutParams = buttonLayoutParams
            } else {
                btnDefaultTwo.text = getString(R.string._40)
                buttonLayoutParams.matchConstraintPercentWidth = 0.40F
                it.layoutParams = buttonLayoutParams
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
