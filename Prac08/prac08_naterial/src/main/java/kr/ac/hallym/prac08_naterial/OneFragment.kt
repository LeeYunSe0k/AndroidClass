package kr.ac.hallym.prac08_naterial

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.prac08_naterial.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater, container, false)

        val contents = mutableListOf<String>()
        for (i in 1..20)
            contents.add("Item $i")

        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerview.layoutManager = layoutManager
        val adapter = MyAdapter(contents)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.addItemDecoration(MyDecoration(activity as Context))
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false)
        return binding.root
    }
}