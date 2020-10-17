package sg.toru.alphausecases.splash.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import sg.toru.alphausecases.R
import sg.toru.alphausecases.main.ui.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.e(SplashActivity::class.java.simpleName, "create()")

        Handler(Looper.getMainLooper()).postDelayed({startActivity(Intent(this@SplashActivity, MainActivity::class.java))}, 2000)
    }
}