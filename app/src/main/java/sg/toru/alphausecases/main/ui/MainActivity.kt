package sg.toru.alphausecases.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import sg.toru.alphausecases.R
import sg.toru.alphausecases.di.network.ActivityDependency
import sg.toru.alphausecases.main.vm.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

//    @Inject
//    lateinit var dep:ActivityDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(MainActivity::class.java.simpleName, "create()")


        supportFragmentManager.beginTransaction().replace(
            R.id.mainFragmentContainer,
            MainFragment.newInstance()
        ).commit()

//        dep.test()
//        viewModel.test()
    }
}