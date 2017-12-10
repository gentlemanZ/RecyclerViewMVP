package com.example.android.triplebyteinterview.REST;

import android.support.annotation.NonNull;

import com.example.android.triplebyteinterview.GetDailyWeatherListCallback;
import com.example.android.triplebyteinterview.model.DailyWeatherList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class WeatherRetrofiClient {
    private static final String BASE_URL = "https://api.forecast.io/";
    private static WeatherRetrofiClient INSTANCE;
    private WeatherRetrofitApi weatherRetrofitApi;


    private WeatherRetrofiClient() {
        clientInitialize();
    }

    public static WeatherRetrofiClient getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new WeatherRetrofiClient();
        } else {
            return INSTANCE;
        }
    }

    public void getDailyWeather(@NonNull final GetDailyWeatherListCallback callback) {
        Call<DailyWeatherList> call = weatherRetrofitApi.getDailyWeatherList();
        call.enqueue(new Callback<DailyWeatherList>() {
            @Override
            public void onResponse(@NonNull Call<DailyWeatherList> call, @NonNull Response<DailyWeatherList> response) {
                DailyWeatherList dailyWeatherList = response.body();
                callback.onGetDailyWeatherListCallbackSuccess(dailyWeatherList);
            }

            @Override
            public void onFailure(@NonNull Call<DailyWeatherList> call, @NonNull Throwable t) {
                callback.onGetDailyWeatherListCallbackFailure(t);
            }
        });
    }

    private void clientInitialize() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().excludeFieldsWithModifiers().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.weatherRetrofitApi = retrofit.create(WeatherRetrofitApi.class);
    }
}
