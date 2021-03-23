package com.example.androidpractice2021.data.api.response

data class RnMCharacterResponse(
    val info: Info,
    val results: ArrayList<ResultCharacter>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)

data class ResultCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)