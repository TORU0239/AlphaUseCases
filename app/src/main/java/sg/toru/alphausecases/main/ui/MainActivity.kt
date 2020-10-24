package sg.toru.alphausecases.main.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import sg.toru.alphausecases.R


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(MainActivity::class.java.simpleName, "create()")

        supportFragmentManager.beginTransaction().replace(
            R.id.mainFragmentContainer,
            MainFragment.newInstance()
        ).commit()
    }
}