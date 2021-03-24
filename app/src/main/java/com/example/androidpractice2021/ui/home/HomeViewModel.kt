package com.example.androidpractice2021.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.domain.FindAllCharacterUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val findAllCharacterUseCase: FindAllCharacterUseCase
) : ViewModel() {

    private val mProgress: MutableLiveData<List<Character>> = MutableLiveData()

    fun progress(): LiveData<List<Character>> = mProgress
    fun onClick() {
        viewModelScope.launch {
            try {
                mProgress.value = findAllCharacterUseCase.findAllCharacter(2)
            } catch (e: Exception) {

            }
        }
    }

//    fun userClicked(id: Int) {
//        router.openUserDetails(id)
//    }
}