package com.example.androidpractice2021.data.database

import android.content.Context
import androidx.room.*
import com.example.androidpractice2021.data.database.dao.CharacterDao
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.ui.converter.Converters

@Database(entities = arrayOf(Character::class), version = 5, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CharacterRoomDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {

        @Volatile
        private var INSTANCE: CharacterRoomDatabase? = null

        fun getDataBase(context: Context): CharacterRoomDatabase {
            return INSTANCE
                ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterRoomDatabase::class.java,
                    "character_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}