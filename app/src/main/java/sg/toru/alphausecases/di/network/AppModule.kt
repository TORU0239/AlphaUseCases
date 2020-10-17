package sg.toru.alphausecases.di.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sg.toru.alphausecases.startup.AppInitializationService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    // Retrofit object
    @Singleton
    @Provides
    fun getRetrofit(moshi:Moshi, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()


    // Moshi object
    @Singleton
    @Provides
    fun getMoshi():Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    // OkHttp3 object
    @Singleton
    @Provides
    fun getOkHttp3() =
        OkHttpClient().newBuilder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .writeTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()

    @Singleton
    @Provides
    fun getApiService(retrofit:Retrofit): AppInitializationService = retrofit.create(AppInitializationService::class.java)
}