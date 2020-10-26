package sg.toru.alphausecases.splash.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import sg.toru.alphausecases.R
import sg.toru.alphausecases.databinding.FragmentBreakThroughContentBinding
import sg.toru.alphausecases.main.ui.MainActivity
import sg.toru.alphausecases.startup.DataStoreManager

class BreakThroughContentFragment : Fragment() {

    private var _binding:FragmentBreakThroughContentBinding? = null
    private val binding get() = _binding!!


    private lateinit var dataStoreManager:DataStoreManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBreakThroughContentBinding.inflate(inflater, container, false)
        dataStoreManager = DataStoreManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtBreakThrough.text = "TEST!!"
        binding.btnSkip.setOnClickListener {
            lifecycleScope.launch {
                dataStoreManager.updateShowCompleted(true)
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                activity?.finish()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BreakThroughContentFragment()
    }
}