package kr.ac.hallym.prac09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.prac09.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plusCountButton.setOnClickListener {
            count++
            binding.countResultView.text = "$count"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        binding.countResultView.text = "$count"
    }
}