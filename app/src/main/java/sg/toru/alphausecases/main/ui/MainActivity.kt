package sg.toru.alphausecases.main.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import sg.toru.alphausecases.R


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(MainActivity::class.java.simpleName, "create()")
        initNavigation()
    }

    private fun initNavigation() {
        val host:NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentMainNavHost) as NavHostFragment? ?: return
    }
}