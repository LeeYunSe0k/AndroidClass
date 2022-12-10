package kr.ac.hallym.prac05_exer

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import kr.ac.hallym.prac05_exer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.myButton).setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }
    }

}