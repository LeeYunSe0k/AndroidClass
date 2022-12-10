package kr.ac.hallym.prac10

import android.app.Activity
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kr.ac.hallym.prac10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)
        db.execSQL("create table if not exists USER_TB (" +
            "_id integer primary key autoincrement," +
            "name not null," +
            "phone)")

        binding.button1.setOnClickListener {
            val edit_name = binding.editView1.text.toString()
            val edit_phone = binding.editView2.text.toString()

            db.execSQL("insert into USER_TB (name, phone) values (?, ?)",
                arrayOf<String>(edit_name, edit_phone))

//            db.execSQL("insert into USER_TB (name, phone) values (?, ?)",
//                arrayOf<String>("kkang", "01023456789"))
            Toast.makeText(this, "데이터베이스에 저장되었습니다", Toast.LENGTH_SHORT).show()
        }

        binding.button2.setOnClickListener {
            val db = DBHelper(this).readableDatabase
            val cursor = db.rawQuery("select * from USER_TB", null)
            var i = 0

            val cursor_list = mutableListOf<String>()
            var result = ""
            while(cursor.moveToNext()) {
                val name = cursor.getString(1)
                val phone = cursor.getString(2)

                cursor_list.add("[${i++}] name: $name, phone: $phone")
                Log.d("kkang", "name: $name, phone: $phone")
            }
            for(str in cursor_list){
                result += (str + "\n")
            }
            binding.textView.text = result
        }

        binding.button3.setOnClickListener {
            db.execSQL("delete from USER_TB where _id=1")
            Toast.makeText(this, "첫번째 데이터가 삭제되었습니다", Toast.LENGTH_SHORT).show()
        }
    }
}

class DBHelper(context: Context): SQLiteOpenHelper(context, "testdb", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table if not exists USER_TB (" +
            "_id integer primary key autoincrement,"+
            "name not null," +
            "phone)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists USER_TB")
        onCreate(p0)
    }
}