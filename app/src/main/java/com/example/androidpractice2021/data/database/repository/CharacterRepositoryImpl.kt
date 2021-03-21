package com.example.androidpractice2021.data.database.repository

import com.example.androidpractice2021.data.api.CharacterApi
import com.example.androidpractice2021.data.database.dao.CharacterDao
import com.example.androidpractice2021.data.database.entity.Character
import com.example.androidpractice2021.domain.CharacterRepository
import kotlinx.coroutines.flow.Flow
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

    override suspend fun getCharacterByName(cityName: String): Flow<Character> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterById(cityId: Int): Flow<Character> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCharacter(page: String): Flow<ArrayList<Character>> {
        TODO("Not yet implemented")
    }
}