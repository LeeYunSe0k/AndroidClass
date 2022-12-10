package kr.ac.hallym.prac08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import kr.ac.hallym.prac08.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main5)
        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        toggle.syncState()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("kkang", "navigation item is clicked: ${it.title}")
            true
        }
        binding.extFab.setOnClickListener{
            when(binding.extFab.isExtended){
                true -> binding.extFab.shrink()
                false -> binding.extFab.extend()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("kkang", "query will be searched...")
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.title) {
        "help" -> {
            Log.d("kkang", "help is clicked...")
            true
        }
        "setting" -> {
            Log.d("kkang", "setting is clicked...")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}