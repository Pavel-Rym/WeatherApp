package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.remote.RetrofitInstance
import com.example.weatherapp.remote.WeatherApiService
import kotlinx.coroutines.launch

class CityWeatherViewModel : ViewModel() {

    val weatherData = MutableLiveData<WeatherData>()

    fun getWeatherData(cityName: String) {
        viewModelScope.launch {
            try {
                val retrofit = RetrofitInstance.getInstance()
                val apiInterface = retrofit.create(WeatherApiService::class.java)

                val response = apiInterface.getWeatherData(cityName)
                if (response.isSuccessful) {
                    val data = response.body() ?: throw NullPointerException("Weather data is null")
                    weatherData.value = data
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}