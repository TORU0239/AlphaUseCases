package sg.toru.alphausecases.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.PagerSnapHelper
import dagger.hilt.android.AndroidEntryPoint
import sg.toru.alphausecases.R
import sg.toru.alphausecases.databinding.FragmentMainBinding
import sg.toru.alphausecases.main.model.InfoNearby
import sg.toru.alphausecases.main.model.TransactionHistory
import sg.toru.alphausecases.main.vm.MainViewModel

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()


    private val infoNearAdapter:InfoNearbyAdapter by lazy {
        InfoNearbyAdapter()
    }

    private val transactionAdapter: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        PagerSnapHelper().attachToRecyclerView(binding.rcvMainWallet)
        binding.rcvMainWallet.adapter = infoNearAdapter
        binding.rcvMainTransaction.adapter = transactionAdapter

        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.paymentData.observe(viewLifecycleOwner, { wallet ->
            infoNearAdapter.submitList(wallet.nearInfo)
            transactionAdapter.submitList(wallet.transactionHistory)
        })

        binding.imgMainSetting.setOnClickListener {
            val options = navOptions {
                anim {
                    enter = R.anim.slide_in_right // when proceeding to destination, destination runs this
                    exit = R.anim.slide_out_left // at same case, departure runs this
                    popEnter = R.anim.slide_in_left // when coming back, departure runs this
                    popExit = R.anim.slide_out_right // at same case, destination runs this
                }
            }
            val nextArg = 1024
            MainFragmentDirections.actionMainFragmentToAccountFragment(nextArg)
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAccountFragment(nextArg), options)
//            findNavController().navigate(R.id.action_mainFragment_to_accountFragment, null, options)
        }

        binding.imgGoToWalletDetail.setOnClickListener {
            val options = navOptions {
                anim {
                    enter = R.anim.slide_in_right // when proceeding to destination, destination runs this
                    exit = R.anim.slide_out_left // at same case, departure runs this
                    popEnter = R.anim.slide_in_left // when coming back, departure runs this
                    popExit = R.anim.slide_out_right // at same case, destination runs this
                }
            }

            findNavController().navigate(R.id.action_mainFragment_to_walletDetailFragment, null, options)
        }

        binding.txtGoToTransactionList.setOnClickListener {
            val options = navOptions {
                anim {
                    enter = R.anim.slide_in_right // when proceeding to destination, destination runs this
                    exit = R.anim.slide_out_left // at same case, departure runs this
                    popEnter = R.anim.slide_in_left // when coming back, departure runs this
                    popExit = R.anim.slide_out_right // at same case, destination runs this
                }
            }
            findNavController().navigate(R.id.action_mainFragment_to_transactionDetailFragment, null, options)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    companion object {
//        @JvmStatic
//        fun newInstance() = MainFragment()
//    }
}