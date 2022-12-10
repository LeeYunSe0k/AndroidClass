package kr.ac.hallym.prac04_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import kr.ac.hallym.prac04_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var moveX = 0f
    var moveY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dragButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    moveX = v.x - event.rawX
                    moveY = v.y - event.rawY
                    binding.textView.visibility = View.INVISIBLE
                }
                MotionEvent.ACTION_MOVE -> {
                    v.animate()
                        .x(event.rawX + moveX)
                        .y(event.rawY + moveY)
                        .setDuration(0)
                        .start()
                    binding.textView.visibility = View.INVISIBLE
                }
            }
            true
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                findViewById<TextView>(R.id.textView).visibility = View.VISIBLE
            }
            MotionEvent.ACTION_MOVE -> {
                findViewById<TextView>(R.id.textView).visibility = View.VISIBLE
            }
            MotionEvent.ACTION_UP -> {
                findViewById<TextView>(R.id.textView).visibility = View.INVISIBLE
            }
        }
        return super.onTouchEvent(event)
    }
}