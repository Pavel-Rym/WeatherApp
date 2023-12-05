package com.example.weatherapp.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AppPreferences {

    private static final String PREF_NAME = "WeatherAppPrefs";
    private static final String KEY_CITY_LIST = "city_list";

    private final SharedPreferences preferences;

    public AppPreferences(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public List<String> getCityList() {
        String citiesJson = preferences.getString(KEY_CITY_LIST, "");
        if (!citiesJson.isEmpty()) {
            Type listType = new TypeToken<List<String>>() {}.getType();
            return new Gson().fromJson(citiesJson, listType);
        }
        return new ArrayList<>();
    }

    public void setCityList(List<String> cityList) {
        String citiesJson = new Gson().toJson(cityList);
        preferences.edit().putString(KEY_CITY_LIST, citiesJson).apply();
    }
}
