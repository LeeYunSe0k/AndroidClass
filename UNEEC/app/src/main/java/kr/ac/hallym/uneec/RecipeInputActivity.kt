package kr.ac.hallym.uneec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.hallym.uneec.databinding.ActivityRecipeInputBinding

class RecipeInputActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecipeInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recipe_input)

        binding = ActivityRecipeInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recBackButton.setOnClickListener {
            val intent = Intent(this, RecipeFragment::class.java)
            startActivity(intent)
            finish()
        }
    }
}