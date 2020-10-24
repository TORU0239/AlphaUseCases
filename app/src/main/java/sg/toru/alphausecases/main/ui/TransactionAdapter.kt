package sg.toru.alphausecases.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sg.toru.alphausecases.databinding.ItemTransactionHistoryBinding
import sg.toru.alphausecases.main.model.TransactionHistory

class TransactionAdapter: ListAdapter<TransactionHistory, TransactionVH>(TransactionDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH {
        val binding = ItemTransactionHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionVH(binding)
    }

    override fun onBindViewHolder(holder: TransactionVH, position: Int) {
        holder.binding(getItem(position))
    }
}

class TransactionDiffUtil :DiffUtil.ItemCallback<TransactionHistory>() {
    override fun areItemsTheSame(
        oldItem: TransactionHistory,
        newItem: TransactionHistory
    ): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(
        oldItem: TransactionHistory,
        newItem: TransactionHistory
    ): Boolean  = (oldItem.id == newItem.id)
}

class TransactionVH(private val binding: ItemTransactionHistoryBinding):RecyclerView.ViewHolder(binding.root){

    fun binding(data:TransactionHistory){
        binding.txtTransactionKind.text = data.transactionType
        binding.txtTransactionOutlet.text = data.transactionOutletName
        binding.txtTransactionAmount.text = "SGD ${data.transactionAmount}"
    }
}