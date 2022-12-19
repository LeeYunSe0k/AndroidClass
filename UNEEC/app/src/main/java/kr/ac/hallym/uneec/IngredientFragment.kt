package kr.ac.hallym.uneec

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.uneec.databinding.FragmentIngredientBinding

class IngredientFragment : Fragment() {
    lateinit var binding: FragmentIngredientBinding
    lateinit var adapter: MyAdapter
    lateinit var db: DBHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIngredientBinding.inflate(inflater, container, false)

        binding.iconPlus.setOnClickListener {
            val intent = Intent(requireContext(), IngredientInputActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = DBHelper(requireContext())

    }

    override fun onResume() {
        super.onResume()
        adapter = MyAdapter(db.allRecipe)
        binding.myRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}