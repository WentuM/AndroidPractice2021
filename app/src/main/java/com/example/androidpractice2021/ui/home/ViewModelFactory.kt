package com.example.androidpractice2021.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidpractice2021.data.database.repository.CharacterRepositoryImpl
import com.example.androidpractice2021.domain.FindAllCharacterUseCase
import com.example.androidpractice2021.domain.FindCharacterByIdUseCase
import com.example.androidpractice2021.domain.FindCharacterByNameUseCase
import com.example.androidpractice2021.router.AppRouter

class ViewModelFactory(
    private val findAllCharacterUseCase: FindAllCharacterUseCase,
    private val findCharacterByIdUseCase: FindCharacterByIdUseCase,
    private val findCharacterByNameUseCase: FindCharacterByNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(findAllCharacterUseCase) as? T
                    ?: throw IllegalArgumentException("Unknown ViewModel class")
            }
            modelClass.isAssignableFrom(DetailCharacterViewModel::class.java) -> {
                DetailCharacterViewModel(findCharacterByIdUseCase) as? T
                    ?: throw java.lang.IllegalArgumentException("Unknown ViewModel class")
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }

}