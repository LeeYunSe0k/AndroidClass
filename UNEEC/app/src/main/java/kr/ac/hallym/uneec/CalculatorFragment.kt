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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)

        binding.buttonOne.setOnClickListener { inputText(true, "0") }
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

        binding.buttonClear.setOnClickListener {
            binding.calTextView1.text = ""
            binding.calTextView2.text = ""
        }

        binding.buttonRes.setOnClickListener { calculate() }

        return binding.root
    }
        private fun inputText(clear: Boolean, text: String) {
            if(clear) {
                binding.calTextView2.text = ""
                binding.calTextView1.append(text)
            } else {
                binding.calTextView1.append(binding.calTextView2.text)
                binding.calTextView1.append(text)
                binding.calTextView2.text = ""
            }
        }

        private fun calculate() {
            try {
                val input = ExpressionBuilder(binding.calTextView1.text.toString()).build()
                val output = input.evaluate()
                val longOutput = output.toLong()
                if (output == longOutput.toDouble()){
                    binding.calTextView2.text = longOutput.toString()
                }else{
                    binding.calTextView2.text = output.toString()
                }

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
}