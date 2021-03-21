package com.example.androidpractice2021.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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
    var location: String
) {
    companion object {
        fun mapResponsetoEntity(rnMCharacterResponse: RnMCharacterResponse): Character {
            with(rnMCharacterResponse) {
                return Character(
                    results[0].id, results[0].name, results[0].image, results[0].gender, results[0].location.name
                )
            }
        }
    }
}
