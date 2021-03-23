package com.example.androidpractice2021.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.data.database.repository.CharacterRepositoryImpl
import com.example.androidpractice2021.domain.FindAllCharacterUseCase
import com.example.androidpractice2021.domain.FindCharacterByIdUseCase
import com.example.androidpractice2021.domain.FindCharacterByNameUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val findAllCharacterUseCase: FindAllCharacterUseCase,
    private val findCharacterByIdUseCase: FindCharacterByIdUseCase,
    private val findCharacterByNameUseCase: FindCharacterByNameUseCase
) : ViewModel() {

    private val mProgress: MutableLiveData<List<Character>> = MutableLiveData()

    fun progress(): LiveData<List<Character>> = mProgress

//    private val _list = MutableLiveData<ArrayList<Character>>().apply {
//        var characterList = arrayListOf<Character>()
    fun onClick() {
        viewModelScope.launch {
            try {
                mProgress.value = findAllCharacterUseCase.findAllCharacter(2)
//                Log.d("qwe4", findAllCharacterUseCase.findAllCharacter(2).toString())
            } catch (e: Exception) {

            }
        }
//        value = characterList
    }

//    val list: LiveData<ArrayList<Character>> = _list
}