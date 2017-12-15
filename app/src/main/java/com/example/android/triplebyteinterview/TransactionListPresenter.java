package com.example.android.triplebyteinterview;

import android.support.annotation.Nullable;

import com.example.android.triplebyteinterview.REST.WeatherRetrofitClient;
import com.example.android.triplebyteinterview.model.DailyWeatherData;
import com.example.android.triplebyteinterview.model.DailyWeatherList;

import java.util.LinkedList;
import java.util.List;

class TransactionListPresenter implements TransactionListContract.Presenter, GetDailyWeatherListCallback {
    private TransactionListContract.View view;
    private List<DailyWeatherData> mockedData = new LinkedList<>();
    private WeatherRetrofitClient client;

    TransactionListPresenter(TransactionListContract.View view) {
        this.view = view;
        client = WeatherRetrofitClient.getInstance();

        //try out a call from init function
        client.getDailyWeather(this);
    }

    @Override
    public int getDataLength() {
        return mockedData.size();
    }

    @Override
    public DailyWeatherData getDataByIndex(int position) {
        return mockedData.get(position);
    }

    @Override
    public void onGetDailyWeatherListCallbackSuccess(DailyWeatherList dailyWeatherList) {
        mockedData = dailyWeatherList.getDailyWeatherData();
    }

    @Override
    public void onGetDailyWeatherListCallbackFailure(@Nullable Throwable throwable) {
        view.displayToast(throwable + "");
    }
}
