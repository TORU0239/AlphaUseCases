package sg.toru.alphausecases.main.vm

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sg.toru.alphausecases.di.network.ApiHelper

class MainViewModel @ViewModelInject constructor(
    private val apiHelper: ApiHelper,
    @Assisted private val savedStateHandle: SavedStateHandle
):ViewModel() {

    fun test() {
//        liveData(Dispatchers.IO){
//            emit(apiHelper.getData())
//        }

        CoroutineScope(Dispatchers.IO).launch {
            val test = apiHelper.getData()
        }
    }
}