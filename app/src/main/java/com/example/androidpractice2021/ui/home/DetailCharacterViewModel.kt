package com.example.androidpractice2021.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.domain.FindCharacterByIdUseCase
import kotlinx.coroutines.launch

class DetailCharacterViewModel(
    private val findCharacterByIdUseCase: FindCharacterByIdUseCase
) : ViewModel() {

    private val mProgress: MutableLiveData<Character> = MutableLiveData()

    fun progress(): LiveData<Character> = mProgress
    fun onClick(id: Int) {
        viewModelScope.launch {
            try {
                mProgress.value = findCharacterByIdUseCase.findCharacterById(id)
            } catch (e: Exception) {
            }
        }
    }
}