package sg.toru.alphausecases.main.vm

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sg.toru.alphausecases.di.network.ApiHelper
import sg.toru.alphausecases.main.model.InfoNearby
import sg.toru.alphausecases.main.model.TransactionHistory
import sg.toru.alphausecases.main.model.Wallet

class MainViewModel @ViewModelInject constructor(
    private val apiHelper: ApiHelper,
    @Assisted private val savedStateHandle: SavedStateHandle
):ViewModel() {

    private var _paymentData = MutableLiveData<Wallet>()

    val paymentData get() = _paymentData


    init {
        getPaymentInfo()
    }

    fun test() {
//        liveData(Dispatchers.IO){
//            emit(apiHelper.getData())
//        }

        CoroutineScope(Dispatchers.IO).launch {
            val test = apiHelper.getData()
        }
    }




    private fun getPaymentInfo(){
        val info = createDummyInfoData()
        val transaction = createDummyTransactionData()
        val wallet = Wallet(info, transaction)
        _paymentData.value = wallet
    }


    private fun createDummyInfoData() = listOf(
        InfoNearby(0, "Discover GDGPay stores nearby"),
        InfoNearby(1, "Get exclusive offers with your membership"),
        InfoNearby(2, "Top up with PayNow"),
        InfoNearby(3, "Sponsorship with DBS"),
    )

    private fun createDummyTransactionData() = listOf(
        TransactionHistory(0,"Payment", "FoodPanda Singapore",25.0F),
        TransactionHistory(1,"Payment", "Habitat Coffee",10.0F),
        TransactionHistory(2,"Top Up", "Using Visa 1234",50.0F),
        TransactionHistory(3,"Payment", "YumCha Chinatown",30.50F),
        TransactionHistory(4,"Payment", "Char Kway Teow",5.0F),
    )

}