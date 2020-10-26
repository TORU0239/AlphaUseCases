package sg.toru.alphausecases.splash.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import sg.toru.alphausecases.R
import sg.toru.alphausecases.main.ui.MainActivity
import sg.toru.alphausecases.startup.DataStoreManager

class SplashActivity : AppCompatActivity() {

    private lateinit var dataStoreManager:DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        dataStoreManager = DataStoreManager(applicationContext)
        Log.e(SplashActivity::class.java.simpleName, "create()")

        dataStoreManager.userPreferenceFlow.asLiveData().observe(this){ preference ->
            Log.e("Toru", "showCompleted: ${preference.showCompleted}, isFirstLaunch: ${preference.isFirstLaunch}")

            if (!preference.isFirstLaunch) {
                lifecycleScope.launch {
                    dataStoreManager.updateFirstLaunch(true)
                }
            }

            val destination = if(preference.showCompleted) {
                MainActivity::class.java
            } else {
                BreakthroughActivity::class.java
            }

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@SplashActivity, destination))
                finish()
            }, 1000)
        }
    }
}