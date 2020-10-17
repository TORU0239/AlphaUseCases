package sg.toru.alphausecases.di.network

import sg.toru.alphausecases.startup.AppInitializationService
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: AppInitializationService){
    suspend fun getData() = apiService.getInitialize()
}