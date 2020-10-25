package sg.toru.alphausecases.splash.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sg.toru.alphausecases.R
import sg.toru.alphausecases.databinding.FragmentBreakThroughContentBinding

class BreakThroughContentFragment : Fragment() {

    private var _binding:FragmentBreakThroughContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBreakThroughContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtBreakThrough.text = "TEST!!"
    }

    companion object {
        @JvmStatic
        fun newInstance() = BreakThroughContentFragment()
    }
}