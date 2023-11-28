package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    private lateinit var txtData: TextView
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        txtData = findViewById(R.id.textView)
//        getUserList()
//    }
//
//    private fun getUserList() {
//        val retrofit = RetrofitInstance.getInstance()
//        val apiInterface = retrofit.create(WeatherApiService::class.java)
//
//        lifecycleScope.launch {
//            try {
//                val response = apiInterface.getWeatherData("Kyiv")
//                if (response.isSuccessful) {
//                    val weatherData = response.body()
//                    txtData.text = weatherData.toString()
//                } else {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Error: ${response.code()}",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            } catch (ex: Exception) {
//                Log.e("Error", ex.localizedMessage ?: "Unknown error")
//            }
//        }
//    }

}