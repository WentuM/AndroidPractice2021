package com.example.androidpractice2021.domain

import com.example.androidpractice2021.data.database.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacterByName(
            cityName: String
    ): Flow<Character>

    suspend fun getCharacterById(
            cityId: Int
    ): Flow<Character>

    suspend fun getAllCharacter(
            page: String
    ): Flow<ArrayList<Character>>
}