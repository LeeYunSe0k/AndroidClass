package kr.ac.hallym.prac09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.hallym.prac09.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data1 = intent.getStringExtra("data1")
        val data2 = intent.getIntExtra("data2", 0)
        //val data3 = intent.getStringExtra("data3")

        Toast.makeText(this, "Received: data1: $data1, data2: $data2", Toast.LENGTH_SHORT).show()
        //binding.intentText.text = data3

        binding.detailButton.setOnClickListener {
//            intent.putExtra("result", "world")
            val name = binding.name.text.toString()
            val number = binding.number.text.toString()
            intent.putExtra("name", "이름: $name")
            intent.putExtra("number", "학번: $number")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}