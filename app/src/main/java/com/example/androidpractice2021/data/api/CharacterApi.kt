package com.example.androidpractice2021.data.api

import com.example.androidpractice2021.data.api.response.ResultCharacter
import com.example.androidpractice2021.data.api.response.RnMCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("")
    suspend fun getCharacterByName(
        @Query("name") characterName: String
    ): ResultCharacter

    @GET("character/")
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ): RnMCharacterResponse

    @GET("")
    suspend fun getCharacterById(
        @Query("id") characterId: Int
    ): ResultCharacter
}