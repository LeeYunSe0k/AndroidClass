package kr.ac.hallym.uneec

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.hallym.uneec.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {
    lateinit var binding: FragmentCalculatorBinding
    var isClick = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)

        // 계산기 버튼별 clickListener, inputText로 연결
        binding.buttonZero.setOnClickListener { inputText(true, "0") }
        binding.buttonOne.setOnClickListener { inputText(true, "1") }
        binding.buttonTwo.setOnClickListener { inputText(true, "2") }
        binding.buttonThree.setOnClickListener { inputText(true, "3") }
        binding.buttonFour.setOnClickListener { inputText(true, "4") }
        binding.buttonFive.setOnClickListener { inputText(true, "5") }
        binding.buttonSix.setOnClickListener { inputText(true, "6") }
        binding.buttonSeven.setOnClickListener { inputText(true, "7") }
        binding.buttonEight.setOnClickListener { inputText(true, "8") }
        binding.buttonnine.setOnClickListener { inputText(true, "9") }
        binding.buttonDot.setOnClickListener { inputText(true, ".") }

        binding.buttonPlus.setOnClickListener { inputText(false, "+") }
        binding.buttonSub.setOnClickListener { inputText(false, "-") }
        binding.buttonMul.setOnClickListener { inputText(false, "*") }
        binding.buttonDiv.setOnClickListener { inputText(false, "/") }
        binding.buttonPer.setOnClickListener { inputText(false, "%") }

        // Clear버튼 클릭 시 연산 텍스트와 결과 텍스트 모두 초기화
        binding.buttonClear.setOnClickListener {
            binding.calTextView1.text = ""
            binding.calTextView2.text = ""
        }

        // = 버튼 클릭 시 calculate()로 연결
        binding.buttonRes.setOnClickListener { calculate() }

        return binding.root
    }

    // 키 클릭 시 실행되는 함수
    private fun inputText(clear: Boolean, text: String) {
        // 결과 버튼 클릭 여부 확인, 결과를 클릭했었을 때 연산 텍스트 초기화
        if (isClick == true) {
            binding.calTextView1.text = ""
        }
        // 이후 텍스트 append
        if(clear) {
            binding.calTextView2.text = ""
            binding.calTextView1.append(text)
        } else {
            binding.calTextView1.append(binding.calTextView2.text)
            binding.calTextView1.append(text)
            binding.calTextView2.text = ""
        }
        isClick = false
    }
    // 계산 함수
     private fun calculate() {
        // try-catch로 예외처리
         try {
             // 계산 라이브러리 사용하여 연산 후 출력
             val input = ExpressionBuilder(binding.calTextView1.text.toString()).build()
             val output = input.evaluate()
             val longOutput = output.toLong()
             if (output == longOutput.toDouble()){
                 binding.calTextView2.text = longOutput.toString()
             } else{
                 binding.calTextView2.text = output.toString()
             }
             isClick = true

         } catch (e:Exception){
             e.printStackTrace() // 예외 발생 시 printStackTrace()로 출력
         }
     }
}