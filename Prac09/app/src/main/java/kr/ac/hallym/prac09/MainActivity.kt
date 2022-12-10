package kr.ac.hallym.prac09

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.hallym.prac09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            val resultData = it.data?.getStringExtra("result")
            //binding.mainResultText.text = "result: $resultData"
            binding.nameText.text = it.data?.getStringExtra("name")
            binding.numberText.text = it.data?.getStringExtra("number")
        }

        binding.button1.setOnClickListener {
            //val data3 = binding.text.text.toString()
            val intent: Intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data1", "hello")
            intent.putExtra("data2", 10)
            //intent.putExtra("data3", data3)
            //startActivityForResult(intent, 11)
            //startActivity(intent)
            requestLauncher.launch(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 11 && resultCode == Activity.RESULT_OK) {
//            val result = data?.getStringExtra("result")
//            Toast.makeText(this, "Received: result: $result", Toast.LENGTH_SHORT).show()
//        }
//    }
}