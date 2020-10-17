package sg.toru.alphausecases.startup

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import sg.toru.alphausecases.util.AppConfig
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class AppInitializer:Initializer<AppStartupDependencies> {

    override fun create(context: Context): AppStartupDependencies {
        Log.e(AppInitializer::class.java.simpleName, "create()")
        AppConfig.initialParams = listOf("1", "2", "3", "4", "5", "6")
        return AppStartupDependencies()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}

class AppStartupDependencies {
    private lateinit var retrofit:Retrofit
    private val scope = CoroutineScope(Job() + Dispatchers.Main)
    init {
        Log.e("AppStartupDependency", "create()")
        initNetwork()
        scope.launch {
            getResponse()
            Log.e("AppStartupDependency", "completed")
        }
    }

    private fun initNetwork() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com")
                        .client(Network.okHttpClient)
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build()
    }

    private suspend fun getResponse() = retrofit.create(AppInitializationService::class.java).getInitialize()
}

object Network {
    val okHttpClient = OkHttpClient().newBuilder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .writeTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .build()

}

interface AppInitializationService {
    @GET("/posts/1")
    suspend fun getInitialize():DataType
}

// fake data type
data class DataType(
    val userId:Int,
    val id:Int,
    val title:String,
    val body:String
)