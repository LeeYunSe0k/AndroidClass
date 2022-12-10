package kr.ac.hallym.prac08_naterial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.prac08_naterial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = MyFragmentpagerAdapter(this)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewpager){ tab, position ->
            tab.text = "Tab${(position + 1)}"
        }.attach()

        val toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened,
            R.string.drawer_closed)
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("kkang", "navigation item is clicked: ${it.title}")
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

class MyFragmentpagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}