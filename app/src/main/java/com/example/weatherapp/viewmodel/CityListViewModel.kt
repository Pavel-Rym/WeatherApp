package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityListViewModel : ViewModel() {

    private var cityList: MutableLiveData<List<String>> = MutableLiveData()


    //У майбутньому статичний список можна буде замінити викликом методу DAO/API, який повертає список міст
    init {
        cityList.value = listOf (
            "Kyiv", "London", "Paris", "Berlin", "Rome", "Madrid", "Washington", "Tokio"
        )
    }

    fun getCitiesList() = cityList
}