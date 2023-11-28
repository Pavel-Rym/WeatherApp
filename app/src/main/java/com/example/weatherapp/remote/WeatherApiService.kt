package com.example.weatherapp.remote

import com.example.weatherapp.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("/v1/current.json")
    suspend fun getWeatherData(@Query("q") cityName: String): Response<WeatherData>
}