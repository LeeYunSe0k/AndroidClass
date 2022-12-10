package kr.ac.hallym.prac05_exer

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import kotlinx.coroutines.delay
import kr.ac.hallym.prac05_exer.databinding.ActivitySplashBinding
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextLong

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_splash)

        var binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val splashImage = binding.splashImage as LottieAnimationView
        splashImage.playAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, kr.ac.hallym.prac05_exer.ListActivity::class.java)
            startActivity(intent)
            finish()
        }, Random.nextLong(1000,3000))
    }
}