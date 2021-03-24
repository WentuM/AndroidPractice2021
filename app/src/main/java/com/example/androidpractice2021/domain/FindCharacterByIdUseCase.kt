package com.example.androidpractice2021.domain

import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.data.database.repository.CharacterRepositoryImpl
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FindCharacterByIdUseCase(
    private val characterRepositoryImpl: CharacterRepositoryImpl,
    private val context: CoroutineContext
) {

    suspend fun findCharacterById(id: Int): Character =
        withContext(context) {
            characterRepositoryImpl.getCharacterById(id)
        }
}