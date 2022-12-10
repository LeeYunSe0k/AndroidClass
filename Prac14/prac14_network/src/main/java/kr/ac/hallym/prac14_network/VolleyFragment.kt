package kr.ac.hallym.prac14_network

import android.app.DownloadManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kr.ac.hallym.prac14_network.databinding.FragmentVolleyBinding
import org.json.JSONObject

class VolleyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_volley, container, false)
        val binding = FragmentVolleyBinding.inflate(inflater, container, false)

        val url = MyApplication.BASE_URL+"/v2/everything?q="+
                "${MyApplication.QUERY}&apiKey=${MyApplication.API_KEY}&page=1&pageSize=5"

        val queue = Volley.newRequestQueue(activity)

        val jsonRequest = object: JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val jsonArray = response.getJSONArray("articles")
                val mutableList = mutableListOf<ItemModel>()
                for (i in 0 until jsonArray.length()) {
                    ItemModel().run {
                        val article = jsonArray.getJSONObject(i)
                        author = article.getString("author")
                        title = article.getString("title")
                        description = article.getString("description")
                        urlToImage = article.getString("urlToImage")
                        publishedAt = article.getString("publishedAt")
                        mutableList.add(this)
                    }
                }
                binding.volleyRecyclerView.layoutManager = LinearLayoutManager(activity)
                binding.volleyRecyclerView.adapter = MyAdapter(activity as Context, mutableList)
            },
        Response.ErrorListener {
            Log.d("kkang", "error... $it")
        }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val map = mutableMapOf<String, String>("User-agent" to MyApplication.USER_AGENT)
                return map
            }
        }
        queue.add(jsonRequest)

        return binding.root
    }
}