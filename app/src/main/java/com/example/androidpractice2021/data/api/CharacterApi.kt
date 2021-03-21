package com.example.androidpractice2021.data.api

import com.example.androidpractice2021.data.api.response.RnMCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("")
    suspend fun getWeather(
        @Query("name") characterName: String
    ): RnMCharacterResponse

    @GET("")
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ): RnMCharacterResponse

    @GET("")
    suspend fun getCityById(
        @Query("id") characterId: Int
    ): RnMCharacterResponse
}