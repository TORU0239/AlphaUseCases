package sg.toru.alphausecases.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import sg.toru.alphausecases.databinding.FragmentMainBinding
import sg.toru.alphausecases.main.model.TransactionHistory
import sg.toru.alphausecases.main.vm.MainViewModel

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()


    private val transactionAdapter: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)


        binding.rcvMainTransaction.adapter = TransactionAdapter()
        (binding.rcvMainTransaction.adapter as TransactionAdapter).submitList(createDummyTransactionData())
    }

    private fun createDummyTransactionData() = listOf(
        TransactionHistory(0,"Payment", "FoodPanda Singapore",25.0F),
        TransactionHistory(1,"Payment", "Habitat Coffee",10.0F),
        TransactionHistory(2,"Top Up", "Using Visa 1234",50.0F),
        TransactionHistory(3,"Payment", "YumCha Chinatown",30.50F),
        TransactionHistory(4,"Payment", "Char Kway Teow",5.0F),


    )


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}