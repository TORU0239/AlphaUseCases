package sg.toru.alphausecases.splash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import sg.toru.alphausecases.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.e(SplashActivity::class.java.simpleName, "create()")
    }
}