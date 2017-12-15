package com.example.android.triplebyteinterview.REST;

import android.support.annotation.NonNull;

import com.example.android.triplebyteinterview.GetDailyWeatherListCallback;
import com.example.android.triplebyteinterview.model.DailyWeatherList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRetrofitClient {
    private static final String BASE_URL = "https://api.forecast.io/";
    private static WeatherRetrofitClient INSTANCE;
    private WeatherRetrofitApi weatherRetrofitApi;


    private WeatherRetrofitClient() {
        clientInitialize();
    }

    public static WeatherRetrofitClient getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new WeatherRetrofitClient();
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
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().excludeFieldsWithModifiers().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.weatherRetrofitApi = retrofit.create(WeatherRetrofitApi.class);
    }
}
