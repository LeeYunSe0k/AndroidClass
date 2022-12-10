package kr.ac.hallym.prac3_exer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonOne).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("1")
        }
        findViewById<Button>(R.id.buttonTwo).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("2")
        }
        findViewById<Button>(R.id.buttonThree).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("3")
        }
        findViewById<Button>(R.id.buttonFour).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("4")
        }
        findViewById<Button>(R.id.buttonFive).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("5")
        }
        findViewById<Button>(R.id.buttonSix).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("6")
        }
        findViewById<Button>(R.id.buttonSeven).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("7")
        }
        findViewById<Button>(R.id.buttonEight).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("8")
        }
        findViewById<Button>(R.id.buttonnine).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("9")
        }
        findViewById<Button>(R.id.buttonZero).setOnClickListener{
            findViewById<TextView>(R.id.textView).append("0")
        }
        findViewById<Button>(R.id.buttonClear).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonPer).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonMul).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonSub).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonPlus).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonRes).setOnClickListener{
            findViewById<TextView>(R.id.textView).setText("")
        }
        findViewById<Button>(R.id.buttonDot).setOnClickListener{
            findViewById<TextView>(R.id.textView).append(".")
        }
    }
}