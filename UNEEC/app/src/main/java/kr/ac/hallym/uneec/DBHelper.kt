package kr.ac.hallym.uneec

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// SQLite를 이용한 ingredient 데이터베이스 DBHelper
class DBHelper(val context: Context): SQLiteOpenHelper(context, "uneecdb", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table RECIPE_TB(" +
                "_id integer primary key autoincrement," +
                "ing_image not null," +
                "ing_name not null," +
                "ing_size not null," +
                "ing_price not null)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addRecipe(recipe: Ingredient){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("ing_image", recipe.image)
        values.put("ing_name", recipe.name)
        values.put("ing_size", recipe.size)
        values.put("ing_price", recipe.price)

        db.insert("RECIPE_TB", null, values)
        db.close()
    }

    val allRecipe: MutableList<Ingredient>
        @SuppressLint("Range")
        get() {
            val dataList = mutableListOf<Ingredient>()
            val selectQueryHandler = "SELECT * FROM RECIPE_TB"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQueryHandler,null)
            if(cursor.moveToFirst()){
                do{
                    val recipe = Ingredient()
                    recipe.image = cursor.getString(cursor.getColumnIndex("ing_image"))
                    recipe.name = cursor.getString(cursor.getColumnIndex("ing_name"))
                    recipe.size = cursor.getString(cursor.getColumnIndex("ing_size"))
                    recipe.price = cursor.getString(cursor.getColumnIndex("ing_price"))

                    dataList.add(recipe)
                }while(cursor.moveToNext())
            }
            db.close()

            return dataList
        }
}