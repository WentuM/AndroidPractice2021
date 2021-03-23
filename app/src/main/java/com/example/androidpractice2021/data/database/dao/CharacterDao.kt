package com.example.androidpractice2021.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidpractice2021.data.database.entity.Character

@Dao
interface CharacterDao {


//    suspend fun insert(list: List<City>) {
//        insrt(*list.toTypedArray())
//    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: List<Character>)

    @Query("SELECT * FROM character")
    suspend fun getAllCharacter(): List<Character>

    @Query("SELECT * FROM character WHERE id = :idCity")
    suspend fun getCharacterById(idCity: Int): Character

    @Query("SELECT * FROM character WHERE name = :nameCity")
    suspend fun getCharacterByName(nameCity: String): Character

    @Query("DELETE FROM character")
    suspend fun deleteAllCharacter()

}
