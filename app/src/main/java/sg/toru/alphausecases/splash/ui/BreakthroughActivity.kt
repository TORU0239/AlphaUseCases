package sg.toru.alphausecases.splash.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import sg.toru.alphausecases.R
import sg.toru.alphausecases.databinding.ActivityBreakthroughBinding

class BreakthroughActivity : AppCompatActivity() {

    private var _binding:ActivityBreakthroughBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBreakthroughBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BreakthroughAdapter(this)
        binding.vpBreakThrough.adapter = adapter
    }

    override fun onBackPressed() {
        if(binding.vpBreakThrough.currentItem != 0) {
            binding.vpBreakThrough.currentItem = (binding.vpBreakThrough.currentItem - 1)
        } else {
            super.onBackPressed()
        }
    }

    private inner class BreakthroughAdapter(fa:FragmentActivity):FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3
        override fun createFragment(position: Int): Fragment = BreakThroughContentFragment.newInstance()
    }
}