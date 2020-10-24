package sg.toru.alphausecases.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sg.toru.alphausecases.R
import sg.toru.alphausecases.databinding.ItemDealsNearYouBinding
import sg.toru.alphausecases.databinding.ItemTransactionHistoryBinding
import sg.toru.alphausecases.main.model.InfoNearby
import sg.toru.alphausecases.main.model.TransactionHistory

class InfoNearbyAdapter: ListAdapter<InfoNearby, InfoNearVH>(InfoNearDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoNearVH {
        val binding = ItemDealsNearYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        when(viewType){
            0x01 -> binding.containerDealInfo.setBackgroundResource(R.drawable.gradient_deal)
            else -> binding.containerDealInfo.setBackgroundResource(R.drawable.gradient_deal_2nd)
        }
        return InfoNearVH(binding)
    }

    override fun onBindViewHolder(holder: InfoNearVH, position: Int) {
        holder.binding(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> 0x01
            else -> 0x00
        }
    }
}

class InfoNearDiffUtil :DiffUtil.ItemCallback<InfoNearby>() {
    override fun areItemsTheSame(
        oldItem: InfoNearby,
        newItem: InfoNearby
    ): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(
        oldItem: InfoNearby,
        newItem: InfoNearby
    ): Boolean  = (oldItem.id == newItem.id)
}

class InfoNearVH(private val binding: ItemDealsNearYouBinding):RecyclerView.ViewHolder(binding.root){

    fun binding(data:InfoNearby){
        binding.txtDealTitle.text = data.title
    }
}