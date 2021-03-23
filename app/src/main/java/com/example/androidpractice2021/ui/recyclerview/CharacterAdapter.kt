package com.example.androidpractice2021.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice2021.R
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

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
        holder.binding.executePendingBindings()
    }

    fun submitlist(characterList: ArrayList<Character>) {
        list = characterList
    }

    companion object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem.id == newItem.id
    }
}