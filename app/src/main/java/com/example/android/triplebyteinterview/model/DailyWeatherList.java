package com.example.android.triplebyteinterview.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyWeatherList {
    @SerializedName("data")
    @Expose
    private List<DailyWeatherData> dailyWeatherData;

    public List<DailyWeatherData> getDailyWeatherData() {
        return dailyWeatherData;
    }

    public void setMeetings(List<DailyWeatherData> dailyWeatherData) {
        this.dailyWeatherData = dailyWeatherData;
    }
}
