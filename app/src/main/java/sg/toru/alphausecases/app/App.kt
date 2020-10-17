package sg.toru.alphausecases.app

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e(App::class.java.simpleName, "create()")

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}