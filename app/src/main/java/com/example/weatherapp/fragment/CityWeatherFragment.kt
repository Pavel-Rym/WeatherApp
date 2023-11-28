package com.example.weatherapp.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.viewmodel.CityWeatherViewModel

class CityWeatherFragment : Fragment(R.layout.city_weather_fragment) {

    private lateinit var viewModel: CityWeatherViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityName: String = CityWeatherFragmentArgs.fromBundle(requireArguments()).cityName

        viewModel = ViewModelProvider(this).get(CityWeatherViewModel::class.java)

        observeViewModel()

        viewModel.getWeatherData(cityName)
    }

    private fun observeViewModel() {
        viewModel.weatherData.observe(viewLifecycleOwner) { weatherData ->
            updateUI(weatherData)
        }
    }

    private fun updateUI(weatherData: WeatherData) {
        val locationTextView: TextView = view?.findViewById(R.id.location) ?: return
        val lastUpdateTextView: TextView = view?.findViewById(R.id.lastUpdate) ?: return
        val temperatureTextView: TextView = view?.findViewById(R.id.temperature) ?: return
        val feelsLikeTextView: TextView = view?.findViewById(R.id.feelsLike) ?: return
        val pressureTextView: TextView = view?.findViewById(R.id.pressure) ?: return
        val windSpeedTextView: TextView = view?.findViewById(R.id.wind) ?: return
        val humidityTextView: TextView = view?.findViewById(R.id.humidity) ?: return

        locationTextView.text = weatherData.location.name + ", " + weatherData.location.region
        lastUpdateTextView.text = "Last update: " + weatherData.current.lastUpdated
        temperatureTextView.text = weatherData.current.tempC.toString() + "°C"
        feelsLikeTextView.text = "Feel like: " + weatherData.current.feelslikeC
        pressureTextView.text = "Pressure: " + weatherData.current.pressureMb + "Mb"
        windSpeedTextView.text =
            "Wind: " + weatherData.current.windKph + "Kph, " + weatherData.current.windDir
        humidityTextView.text = "Humidity: " + weatherData.current.humidity
    }
}