package kr.ac.hallym.uneec

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.uneec.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding:ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter (val contents: MutableList<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemName.text = contents!![position]
        binding.itemSize.text = contents!![position+1]
        binding.itemPrice.text = contents!![position+2]

    }

    override fun getItemCount(): Int {
        return contents?.size ?: 0
    }
}