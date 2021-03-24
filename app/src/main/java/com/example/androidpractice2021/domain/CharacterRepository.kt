package com.example.androidpractice2021.domain

import com.example.androidpractice2021.data.database.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacterByName(
            characterName: String
    ): Character

    suspend fun getCharacterById(
            characterId: Int
    ): Character

    suspend fun getAllCharacter(
            page: Int
    ): List<Character>
}