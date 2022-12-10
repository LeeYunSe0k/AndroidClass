package kr.ac.hallym.uneec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.hallym.uneec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val screen = mutableListOf(
        IngredientFragment(),
        RecipeFragment(),
        CalculatorFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragment()
        bottomNavigationViewItemSelectedListener()
    }
    private fun initFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.home_layout, IngredientFragment())
        transaction.commit()
    }
    private fun bottomNavigationViewItemSelectedListener(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_ingredient -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.home_layout, IngredientFragment())
                    transaction.commit()
                }
                R.id.menu_recipe -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.home_layout, RecipeFragment())
                    transaction.commit()
                }
                R.id.menu_calculator -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.home_layout, CalculatorFragment())
                    transaction.commit()
                }
            }
            true
        }
    }
}