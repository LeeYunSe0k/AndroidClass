package kr.ac.hallym.prac07_exer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.prac07_exer.databinding.ActivityMainBinding
import kr.ac.hallym.prac07_exer.databinding.ItemRecyclerviewBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents = mutableListOf<String>("춘천고등학교 입학", "춘천고등학교 프로그래밍 동아리 \n'GON' 기장","한림대학교 컴퓨터공학과 입학", "한림대학교 컴퓨터공학과 학생회 \n'Semicolon' 복지부원", "한림대학교 소프트웨어융합대학 학생회 \n'열기' 홍보부장","한림대학교 창업동아리 'Dawn' 대표", "SW 창업아이디어 경진대회 동상",
            "소프트웨어학부 서공제 \n아이디어 부문 은상")
        val contents_sub = mutableListOf<String>("2015.03", "2016.03 ~ 2016.12", "2018.03", "2018.04 ~ 2018.12", "2019.02 ~ 2019.12", "2022.06 ~ 2023.02", "2022.11", "2022.11")
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = MyAdapter(contents, contents_sub)
        binding.recycleView.addItemDecoration(MyDecoration(this))

    }
}
class MyViewHolder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val contents: MutableList<String>, val contents_sub: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        Log.d("kkang", "init contents size: ${contents.size}")
        return contents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    = MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang", "onBindViewHolder: $position")
        val binding = (holder as MyViewHolder).binding
        // 뷰에 데이터 출력
        binding.itemData.text = contents[position]
        binding.itemSubdata.text = contents_sub[position]
        // 뷰에 이벤트 추가
        binding.itemRoot.setOnClickListener {
            Log.d("kkang", "item root click: $position")
        }
    }
}

class MyDecoration(val context: Context): RecyclerView.ItemDecoration(){
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State){
        super.onDraw(c, parent, state)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ){
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(10, 10, 10, 0)
        view.setBackgroundColor(Color.WHITE)
        ViewCompat.setElevation(view, 20.0f)
    }
}