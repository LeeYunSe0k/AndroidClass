package kr.ac.hallym.prac14

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.*
import kr.ac.hallym.prac14.databinding.ActivityMain3Binding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testButton.setOnClickListener {
            var url = "https://jsonplaceholder.typicode.com/posts"

//            val stringRequest = StringRequest(Request.Method.GET, url,
//                Response.Listener<String> {
//                    Log.d("kkang", "server data : $it")
//                },
//                Response.ErrorListener { error ->
//                    Log.d("kkang", "error...$error")
//                }
//            )
            // POST 방식으로 데이터 전송
//            val stringRequest = object : StringRequest(Request.Method.POST, url,
//                Response.Listener<String> {
//                    Log.d("kkang", "server data : $it")
//                },
//            Response.ErrorListener { error ->
//                Log.d("kkang", "error...$error")
//            }
//            ) {
//                override fun getParams(): MutableMap<String, String> {
//                    return mutableMapOf<String, String>("one" to "hello", "two" to "world")
//                }
//            }
//
//            val queue = Volley.newRequestQueue(this)
//            queue.add(stringRequest)

            url = "https://via.placeholder.com/600/92c952.jpg"
//            val imageRequest = ImageRequest(url,
//                Response.Listener { response -> binding.imageView.setImageBitmap(response)},
//                0,
//            0,
//            ImageView.ScaleType.CENTER_CROP,
//            null,
//            Response.ErrorListener { error -> Log.d("kkang", "error...$error") }
//            )
//
//            val queue = Volley.newRequestQueue(this)
//            queue.add(imageRequest)
            // network Image view
//            val queue = Volley.newRequestQueue(this)
//            val imgMap = HashMap<String, Bitmap>()
//            val imageLoader = ImageLoader(queue, object : ImageLoader.ImageCache {
//                override fun getBitmap(url: String?): Bitmap? {
//                    return imgMap[url]
//                }
//
//                override fun putBitmap(url: String, bitmap: Bitmap) {
//                    imgMap[url] = bitmap
//                }
//            })
//            binding.networkImageView.setImageUrl(url, imageLoader)

//            url = "https://jsonplaceholder.typicode.com/posts/1"
//            val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null,
//                Response.Listener<JSONObject> { response ->
//                    val title = response.getString("title")
//                    val body = response.getString("body")
//                    Log.d("kkang", "[title]: $title, [body]:$body") },
//                Response.ErrorListener { error -> Log.d("kkang", "error...$error") }
//            )
//            val queue = Volley.newRequestQueue(this)
//            queue.add(jsonRequest)

            url = "https://jsonplaceholder.typicode.com/posts"
            val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
                Response.Listener<JSONArray> { response ->
                    for (i in 0 until response.length()) {
                        val jsonObject = response[i] as JSONObject
                        val title = jsonObject.getString("title")
                        val body = jsonObject.getString("body")
                        Log.d("kkang", "[title]: $title, [body]:$body")
                    }
                },
                Response.ErrorListener { error -> Log.d("kkang", "error...$error") }
            )
            val queue = Volley.newRequestQueue(this)
            queue.add(jsonArrayRequest)
        }
    }
}