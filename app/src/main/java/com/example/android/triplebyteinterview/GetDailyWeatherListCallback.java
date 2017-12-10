package com.example.android.triplebyteinterview;

import android.support.annotation.Nullable;

import com.example.android.triplebyteinterview.model.DailyWeatherList;

public interface GetDailyWeatherListCallback {
    void onGetDailyWeatherListCallbackSuccess(DailyWeatherList dailyWeatherList);

    void onGetDailyWeatherListCallbackFailure(@Nullable Throwable throwable);
}
