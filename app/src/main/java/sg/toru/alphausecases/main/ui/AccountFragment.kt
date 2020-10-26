package sg.toru.alphausecases.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import sg.toru.alphausecases.R
import sg.toru.alphausecases.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private var _binding:FragmentAccountBinding? = null
    private val binding get() = _binding!!

    private val safeArgs:AccountFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val testArg = safeArgs.accountTest
        binding.txtAccount.text = testArg.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }
}