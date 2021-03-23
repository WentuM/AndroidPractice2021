package com.example.androidpractice2021.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidpractice2021.data.api.response.ResultCharacter
import com.example.androidpractice2021.data.api.response.RnMCharacterResponse

@Entity(tableName = "character")
data class Character(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "image")
    var image: String,
    @ColumnInfo(name = "gender")
    var gender: String,
    @ColumnInfo(name = "location")
    var location: String,
    @ColumnInfo(name = "alive")
    var alive: String
) {
    companion object {
        fun mapResponsetoEntity(result: ResultCharacter): Character {
            with(result) {
                return Character(
                    id, name, image, gender, location.name, status
                )
            }
        }
    }
}
