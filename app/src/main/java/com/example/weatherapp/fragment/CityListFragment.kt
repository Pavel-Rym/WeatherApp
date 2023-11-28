package com.example.weatherapp.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.adapter.CityWeatherAdapter
import com.example.weatherapp.viewmodel.CityListViewModel

class CityListFragment : Fragment(R.layout.city_list_fragment) {

    private lateinit var viewModel: CityListViewModel
    private lateinit var cityWeatherAdapter: CityWeatherAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(CityListViewModel::class.java)

        viewModel.getCitiesList().observe(viewLifecycleOwner) { cities ->
            cityWeatherAdapter = CityWeatherAdapter(cities) { selectedCity ->
                navigateToCityWeather(selectedCity)
            }
            recyclerView.adapter = cityWeatherAdapter
        }
    }

    private fun navigateToCityWeather(city: String) {
        val action = CityListFragmentDirections.actionCityListFragmentToCityWeatherFragment(city)
        findNavController().navigate(action)
    }
}