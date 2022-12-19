package kr.ac.hallym.uneec

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.hallym.uneec.databinding.FragmentIngredientBinding
import kr.ac.hallym.uneec.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    lateinit var binding: FragmentRecipeBinding
    lateinit var adapter: MyAdapter
    var contents: MutableList<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)

        binding.iconPlusRecipe.setOnClickListener {
            val intent = Intent(requireContext(), RecipeInputActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}