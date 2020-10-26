package sg.toru.alphausecases.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sg.toru.alphausecases.databinding.FragmentWalletDetailBinding
import sg.toru.alphausecases.main.model.TransactionHistory

class WalletDetailFragment : Fragment() {

    private var _binding:FragmentWalletDetailBinding? = null
    private val binding get() = _binding!!

    private val transactionAdapter: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWalletDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcvWalletTransactions.adapter = transactionAdapter
        transactionAdapter.submitList(createDummyTransactionData())
    }

    private fun createDummyTransactionData() = listOf(
        TransactionHistory(0,"Payment", "FoodPanda Singapore",25.0F),
        TransactionHistory(1,"Payment", "Habitat Coffee",10.0F),
        TransactionHistory(2,"Top Up", "Using Visa 1234",50.0F),
        TransactionHistory(3,"Payment", "YumCha Chinatown",30.50F),
        TransactionHistory(4,"Payment", "Char Kway Teow",5.0F),
    )
}