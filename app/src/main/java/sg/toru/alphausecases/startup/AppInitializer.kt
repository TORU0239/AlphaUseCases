package sg.toru.alphausecases.startup

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import sg.toru.alphausecases.util.AppConfig

class AppInitializer:Initializer<String> {

    override fun create(context: Context): String {
        Log.e(AppInitializer::class.java.simpleName, "create()")
        AppConfig.initialParams = listOf("1", "2", "3", "4", "5", "6")
        return "app initialized!"
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}