package kr.ac.hallym.uneec

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.ac.hallym.uneec.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding:ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter (val contents: MutableList<Ingredient>?): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        // 각각의 리사이클러뷰 내 뷰들에게 값 전달
        binding.itemName.text = contents!![position].name
        binding.itemSize.text = contents!![position].size + "kg"
        binding.itemPrice.text = contents!![position].price  + "원"
        // Glide를 이용하여 이미지 전달
        Glide.with(binding.itemImageView)
            .load(Uri.parse(contents!![position].image))
            .into(binding.itemImageView)

    }

    override fun getItemCount(): Int = contents!!.size

}