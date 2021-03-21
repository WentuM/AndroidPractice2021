package com.example.androidpractice2021.domain

import com.example.androidpractice2021.data.database.repository.CharacterRepositoryImpl
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class FindAllCharacterUseCase(
    private val characterRepositoryImpl: CharacterRepositoryImpl,
    private val context: CoroutineContext
) {
    suspend fun findAllCharacter() {
        withContext(context) {




        }

    }
}