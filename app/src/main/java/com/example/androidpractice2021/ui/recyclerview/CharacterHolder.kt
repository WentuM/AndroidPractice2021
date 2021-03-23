package com.example.androidpractice2021.ui.recyclerview

import android.app.Application
import android.content.Context
import android.graphics.BitmapFactory
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice2021.R
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.databinding.CharacterItemBinding
import com.squareup.picasso.Picasso
import java.net.URL


class CharacterHolder(val binding: CharacterItemBinding, var itemClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {


//    fun bind(character: Character) {
//
//        binding.apply {
//            setVariable(R.id.txt_name_list, character.name)
//            setVariable(R.id.txt_alive_list, character.alive)
////            Picasso.with(binding.root.context).load(character.image).placeholder(R.id.image_character)
//        }
//
//        itemView.setOnClickListener {
//            itemClick(character.id)
//        }
//    }
}
