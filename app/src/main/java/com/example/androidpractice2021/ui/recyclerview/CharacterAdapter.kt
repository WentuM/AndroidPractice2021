package com.example.androidpractice2021.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice2021.R
import com.example.androidpractice2021.data.database.entity.Character

class CharacterAdapter(var list: ArrayList<Character>, var itemClick: (Int) -> Unit) :
    RecyclerView.Adapter<CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.character_item,parent, false)
            return CharacterHolder(
                binding,
                itemClick
            )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) =
        holder.bind(list[position])

    fun submitlist(characterList: ArrayList<Character>) {
        list = characterList
    }
}