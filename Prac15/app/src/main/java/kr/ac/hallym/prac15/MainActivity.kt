package kr.ac.hallym.prac15

import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(LOCATION_SERVICE) as LocationManager

        var result = "All Providers: "
        val providers = manager.allProviders
        for (provider in providers) {
            result += "$provider, "
        }
        Log.d("kkang", result)

        result = "Enabled Providers: "
        val enabledProviders = manager.getProviders(true)
        for(provider in enabledProviders) {
            result += "$provider, "
        }
        Log.d("kkang", result)

    }
}