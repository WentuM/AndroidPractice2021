package com.example.androidpractice2021.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(var list: ArrayList<Character>, var itemClick: (Int) -> Unit) :
    RecyclerView.Adapter<CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater)
        return CharacterHolder(
            binding,
            itemClick
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val character = list[position]
        holder.binding.character = character
        when (character.alive) {
            "Alive" -> holder.binding.txtAliveList.setTextColor(-16711936)
            "Dead" -> holder.binding.txtAliveList.setTextColor(-65536)
            else -> holder.binding.txtAliveList.setTextColor(-256)
        }
        Picasso.with(holder.binding.root.context).load(character.image).into(holder.binding.imageCharacter)
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener {
            itemClick(character.id)
        }
    }

    fun submitList(character: ArrayList<Character>) {
        if (list != character) {
            list = character
            notifyDataSetChanged()
        }
    }

    companion object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem.id == newItem.id
    }
}