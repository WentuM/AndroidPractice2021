package com.example.androidpractice2021.application

import android.app.Application
import com.example.androidpractice2021.data.api.ApiFactory
import com.example.androidpractice2021.data.database.CharacterRoomDatabase
import com.example.androidpractice2021.data.database.repository.CharacterRepositoryImpl

class CharacterApplication : Application() {

    val database by lazy {
        CharacterRoomDatabase.getDataBase(this)
    }

    val repository by lazy {
        CharacterRepositoryImpl(
            ApiFactory.characterApi,
            database.characterDao()
        )
    }
}