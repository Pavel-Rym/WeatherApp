package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherData(
    @SerializedName("location")
    var location: Location,

    @SerializedName("current")
    var current: Current

) : Serializable


data class Location(

    @SerializedName("name")
    var name: String,

    @SerializedName("region")
    var region: String,

    @SerializedName("country")
    var country: String,

    @SerializedName("lat")
    var lat: Double,

    @SerializedName("lon")
    var lon: Double,

    @SerializedName("tz_id")
    var tzId: String,

    @SerializedName("localtime_epoch")
    var localtimeEpoch: Long,

    @SerializedName("localtime")
    var localtime: String
)

data class Current(

    @SerializedName("last_updated_epoch")
    var lastUpdatedEpoch: Long,

    @SerializedName("last_updated")
    var lastUpdated: String,

    @SerializedName("temp_c")
    var tempC: Double,

    @SerializedName("temp_f")
    var tempF: Double,

    @SerializedName("is_day")
    var isDay: Int,

    @SerializedName("wind_mph")
    var windMph: Double,

    @SerializedName("wind_kph")
    var windKph: Double,

    @SerializedName("wind_degree")
    var windDegree: Int,

    @SerializedName("wind_dir")
    var windDir: String,

    @SerializedName("pressure_mb")
    var pressureMb: Double,

    @SerializedName("pressure_in")
    var pressureIn: Double,

    @SerializedName("precip_mm")
    var precipMm: Double,

    @SerializedName("precip_in")
    var precipIn: Double,

    @SerializedName("humidity")
    var humidity: Int,

    @SerializedName("cloud")
    var cloud: Int,

    @SerializedName("feelslike_c")
    var feelslikeC: Double,

    @SerializedName("feelslike_f")
    var feelslikeF: Double,

    @SerializedName("vis_km")
    var visKm: Double,

    @SerializedName("vis_miles")
    var visMiles: Double,

    @SerializedName("uv")
    var uv: Double,

    @SerializedName("gust_mph")
    var gustMph: Double,

    @SerializedName("gust_kph")
    var gustKph: Double,

)
