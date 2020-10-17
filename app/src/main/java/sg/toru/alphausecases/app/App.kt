package sg.toru.alphausecases.app

import android.app.Application
import android.util.Log

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e(App::class.java.simpleName, "create()")
    }
}