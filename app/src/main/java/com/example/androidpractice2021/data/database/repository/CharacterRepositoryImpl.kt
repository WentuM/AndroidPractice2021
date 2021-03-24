package com.example.androidpractice2021.data.database.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.SuccessResult
import com.example.androidpractice2021.data.api.CharacterApi
import com.example.androidpractice2021.data.database.dao.CharacterDao
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.domain.CharacterRepository
import com.google.android.gms.common.images.ImageRequest
import java.net.UnknownHostException

class CharacterRepositoryImpl(
        private val characterApi: CharacterApi,
        private val characterDao: CharacterDao,
        private val context: Context
) : CharacterRepository {

    override suspend fun getCharacterByName(characterName: String): Character =
            try {
                val response = characterApi.getCharacterByName(characterName)
                Character(
                        response.id,
                        response.name,
                        getBitmap(response.image),
                        response.gender,
                        response.location.name,
                        response.status
                )
            } catch (e: UnknownHostException) {
                characterDao.getCharacterByName(characterName)
            }

    override suspend fun getCharacterById(characterId: Int): Character =
            characterDao.getCharacterById(characterId)

    override suspend fun getAllCharacter(page: Int): ArrayList<Character> {
        var result = arrayListOf<Character>()
        var character: Character
        try {
            var characterResponse = characterApi.getAllCharacter(page).results
            var i = 0
            while (i < characterResponse.size) {
                characterResponse[i].apply {
                    character = Character(
                            id,
                            name,
                            getBitmap(image),
                            gender,
                            location.name,
                            status
                    )
                }
                result.add(character)
                i++
            }
            characterDao.deleteAllCharacter()
            characterDao.insert(result)
        } catch (e: UnknownHostException) {
            result = characterDao.getAllCharacter() as ArrayList<Character>
        } finally {
            return result
        }
    }

    private suspend fun getBitmap(urlImage: String): Bitmap {
        val loading = ImageLoader(context)
        val request = coil.request.ImageRequest.Builder(context)
                .data(urlImage)
                .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
}