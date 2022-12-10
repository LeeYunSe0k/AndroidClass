package kr.ac.hallym.prac09_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.prac09_cardview.databinding.ActivityCardViewBinding

class CardViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityCardViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_card_view)
        binding = ActivityCardViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents1 = mutableListOf<Int>(R.drawable.school, R.drawable.stack, R.drawable.dawn, R.drawable.swidea, R.drawable.seogong)
        val contents2 = mutableListOf<String>("학력", "기술 스택", "한림대 창업동아리 Dawn", "SW 창업아이디어 경진대회", "소프트웨어학부 서공제")
        val contents3 = mutableListOf<String>("15.03~18.02  춘천고등학교 졸업\n18.03~  한림대학교 컴퓨터공학과 재학", "Figma\nPython, Java\nSwift, Kotlin\nBlender", "- 3D 가상 피팅 패션 플랫폼 기획\n- 3D 아바타 개발", "수상 : 동상", "수상 : 은상")

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = MyAdapter(contents1, contents2, contents3)
        binding.recycleView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }
}