package kr.ac.hallym.prac13

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    class MyBinder: Binder() {
        fun funA(arg: Int) {
            Log.d("kkang", "funA....$arg")
        }
        fun funB(arg: Int): Int {
            Log.d("kkang", "funB....$arg")
            return arg * arg
        }
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d("kkang", "service onBind...")
        return MyBinder()
    }
}