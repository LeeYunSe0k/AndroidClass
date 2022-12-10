package kr.ac.hallym.uneec

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "uneecdb", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table UNEEC_TB(" +
                "_id integer primary key autoincrement," +
                "ing_name not null," +
                "ing_brand not null," +
                "ing_size not null," +
                "ing_price not null)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}