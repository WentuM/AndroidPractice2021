package com.example.androidpractice2021.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.androidpractice2021.R
import com.example.androidpractice2021.application.CharacterApplication
import com.example.androidpractice2021.databinding.FragmentDetailCharacterBinding
import com.example.androidpractice2021.domain.FindAllCharacterUseCase
import com.example.androidpractice2021.domain.FindCharacterByIdUseCase
import com.example.androidpractice2021.domain.FindCharacterByNameUseCase
import kotlinx.coroutines.Dispatchers

class DetailCharacterFragment: Fragment() {
    private lateinit var application: CharacterApplication
    private lateinit var detailCharacterViewModel: DetailCharacterViewModel
    private var idCharacter: Int = -1
    private lateinit var binding: FragmentDetailCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        application = activity?.application as (CharacterApplication)
        detailCharacterViewModel =
            ViewModelProvider(this, initFactory()).get(DetailCharacterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_detail_character, container, false)
        val inflaterB = LayoutInflater.from(container?.context)
        binding = FragmentDetailCharacterBinding.inflate(inflaterB)
        arguments?.getInt("id")?.let {
            idCharacter = it
        }
        detailCharacterViewModel.onClick(idCharacter)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharacter()
    }

    private fun initFactory() = ViewModelFactory(
        findAllCharacterUseCase = FindAllCharacterUseCase(
            application.repository, Dispatchers.IO
        ),
        findCharacterByIdUseCase = FindCharacterByIdUseCase(
            application.repository, Dispatchers.IO
        ),
        findCharacterByNameUseCase = FindCharacterByNameUseCase(
            application.repository, Dispatchers.IO
        )
    )

    private fun initCharacter() {
        with(detailCharacterViewModel) {
            progress().observe(viewLifecycleOwner, Observer {
                var character = it
                Log.d("qwe10", character.toString())
                binding.detailCharacter = character
                binding.detailCharacterImage.load(character.image)
                binding.executePendingBindings()
            })
        }
    }
}