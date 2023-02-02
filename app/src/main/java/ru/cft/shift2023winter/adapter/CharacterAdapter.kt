package ru.cft.shift2023winter.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.cft.shift2023winter.CharacterModel
import ru.cft.shift2023winter.R
import ru.cft.shift2023winter.databinding.ItemCharactersBinding

class CharacterAdapter(private val items: ArrayList<CharacterModel>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){
    inner class CharacterViewHolder(item:View) : RecyclerView.ViewHolder(item){
        val binding = ItemCharactersBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false)
        return CharacterViewHolder(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val binding = holder.binding
        if (!items[position].imageUrl.isNullOrEmpty()){
            Log.i("Hello", items[position].name.toString())
            Glide.with(binding.image.context).load(items[position].imageUrl).into(binding.image)
        }
        binding.name.text = items[position].name
        binding.image.setOnClickListener { onClickImageCallback(items[position]._id) }
    }

    private var onClickImageCallback: (id: Int) -> Unit = {}
    fun setOnClickImageListener(callback: (id: Int) -> Unit){
        onClickImageCallback = callback
    }

}