package com.example.android.triplebyteinterview;

import com.example.android.triplebyteinterview.model.DailyWeatherData;

interface TransactionListContract {
    interface View {
        void displayToast(String throwable);
    }

    interface Presenter {
        int getDataLength();

        DailyWeatherData getDataByIndex(int position);
    }
}
