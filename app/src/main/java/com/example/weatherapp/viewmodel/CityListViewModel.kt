package com.example.weatherapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.preferences.AppPreferences

class CityListViewModel : ViewModel() {

    private var cityList: MutableLiveData<List<String>> = MutableLiveData()
    private var appPreferences: AppPreferences? = null

    fun initPreferences(context: Context) {
        appPreferences = AppPreferences(context)
        loadCityList()
    }

    private fun loadCityList() {
        val savedCityList = appPreferences?.getCityList()

        cityList.value = savedCityList ?: listOf("Kyiv", "London", "Paris", "Berlin", "Rome", "Madrid", "Washington", "Tokyo")
        saveCityList()
    }

    fun getCitiesList() = cityList

    private fun saveCityList() {
        appPreferences?.setCityList(cityList.value ?: emptyList())
    }

    // Метод для оновлення списку міст
    fun updateCityList(newCityList: List<String>) {
        cityList.value = newCityList
        saveCityList()
    }
}