package kr.ac.hallym.uneec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.uneec.databinding.ActivityIngredientInputBinding

class IngredientInputActivity : AppCompatActivity() {
    lateinit var binding: ActivityIngredientInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ingredient_input)
        binding = ActivityIngredientInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, IngredientFragment::class.java)
            startActivity(intent)
            finish()
        }

        binding.inputButton.setOnClickListener {
            val intent = Intent(this, IngredientFragment::class.java)

//            intent.putExtra("result", binding.ingName.text.toString())
//            intent.putExtra("size", binding.ingSize.text.toString())
//            intent.putExtra("price", binding.ingPrice.text.toString())
            startActivity(intent)
            finish()
        }
    }
}