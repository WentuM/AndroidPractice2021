package com.example.androidpractice2021.ui.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice2021.databinding.CharacterItemBinding


class CharacterHolder(val binding: CharacterItemBinding, var itemClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
}
