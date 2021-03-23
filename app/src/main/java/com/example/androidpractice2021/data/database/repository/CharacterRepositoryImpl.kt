package com.example.androidpractice2021.data.database.repository

import android.util.Log
import com.example.androidpractice2021.data.api.CharacterApi
import com.example.androidpractice2021.data.database.dao.CharacterDao
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.domain.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import java.net.UnknownHostException

class CharacterRepositoryImpl(
    private val characterApi: CharacterApi,
    private val characterDao: CharacterDao
) : CharacterRepository {


//    override suspend fun getWeatherByName(cityName: String) =
//        try {
//            val weatherResponse = weatherApi.getWeather(cityName)
//            City(
//                weatherResponse.id,
//                weatherResponse.name,
//                weatherResponse.main.temp,
//                weatherResponse.weather[0].description,
//                weatherResponse.main.humidity,
//                weatherResponse.wind.deg
//            )
//
//        } catch (e: Exception) {
//            when (e) {
//                is UnknownHostException -> weatherDao.getCityByName(cityName)
//                else -> City(
//                    -1,
//                    "",
//                    -1.0,
//                    "",
//                    -1,
//                    1
//                )
//            }
//        }
//
//    override suspend fun getCityById(cityId: Int): City =
//        try {
//            val weatherResponse = weatherApi.getCityById(cityId)
//            City(
//                weatherResponse.id,
//                weatherResponse.name,
//                weatherResponse.main.temp,
//                weatherResponse.weather[0].description,
//                weatherResponse.main.humidity,
//                weatherResponse.wind.deg
//            )
//        } catch (e: UnknownHostException) {
//            weatherDao.getCityById(cityId)
//        }
//
//    override suspend fun getCitiesWeather(
//        latitudeUser: Double,
//        longitude: Double,
//        countCities: Int
//    ): ArrayList<City> {
//        var result: ArrayList<City> = arrayListOf()
//        try {
//            var weatherResponse =
//                weatherApi.getCitiesWeather(latitudeUser, longitude, countCities).list
//            var i = 0
//            while (i < weatherResponse.size) {
//                result.add(City.mapResponsetoEntity(weatherResponse[i]))
//                i++
//            }
//            weatherDao.deleteAllCity()
//            weatherDao.insert(result)
//        } catch (e: UnknownHostException) {
//            result = weatherDao.getAllCities() as ArrayList<City>
//        }
//        return result
//    }

    override suspend fun getCharacterByName(characterName: String): Character =
        try {
            val response = characterApi.getCharacterByName(characterName)
            Character(
                response.id,
                response.name,
                response.image,
                response.gender,
                response.location.name,
                response.status
            )
        } catch (e: UnknownHostException) {
            characterDao.getCharacterByName(characterName)
        }

    override suspend fun getCharacterById(characterId: Int): Character =
        try {
            val response = characterApi.getCharacterById(characterId)
            Character(
                response.id,
                response.name,
                response.image,
                response.gender,
                response.location.name,
                response.status
            )
        } catch (e: UnknownHostException) {
            characterDao.getCharacterById(characterId)
        }

    override suspend fun getAllCharacter(page: Int): ArrayList<Character> {
        var result = arrayListOf<Character>()
        try {
            var characterResponse = characterApi.getAllCharacter(page).results
            var i = 0
            while (i < characterResponse.size) {
                result.add(Character.mapResponsetoEntity(characterResponse[i]))
                i++
            }
            characterDao.deleteAllCharacter()
            characterDao.insert(result)
        } catch (e: Exception) {
            characterDao.getAllCharacter() as ArrayList<Character>
        } finally {
            return result
        }
    }
}