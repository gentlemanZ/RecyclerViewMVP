package com.example.android.triplebyteinterview.REST;

import com.example.android.triplebyteinterview.model.DailyWeatherList;

import retrofit2.Call;
import retrofit2.http.GET;

interface WeatherRetrofitApi {
    @GET("forecast/27974c4bc33201748eaf542a6769c3b7/42.348,-71.117")
    Call<DailyWeatherList> getDailyWeatherList();
}
