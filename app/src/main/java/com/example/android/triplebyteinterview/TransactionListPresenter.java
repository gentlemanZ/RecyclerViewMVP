package com.example.android.triplebyteinterview;

import android.support.annotation.Nullable;

import com.example.android.triplebyteinterview.model.DailyWeatherList;
import com.example.android.triplebyteinterview.model.Transaction;

import java.util.LinkedList;

class TransactionListPresenter implements TransactionListContract.Presenter, GetDailyWeatherListCallback {
    private TransactionListContract.View view;
    private LinkedList<Transaction> mockedData = new LinkedList<>();

    TransactionListPresenter(TransactionListContract.View view) {
        this.view = view;
        initMockedData();
    }

    @Override
    public int getDataLength() {
        return mockedData.size();
    }

    @Override
    public Transaction getDataByIndex(int position) {
        return mockedData.get(position);
    }

    @Override
    public void onGetDailyWeatherListCallbackSuccess(DailyWeatherList dailyWeatherList) {

    }

    @Override
    public void onGetDailyWeatherListCallbackFailure(@Nullable Throwable throwable) {

    }
    private void initMockedData() {
        mockedData.add(new Transaction("Food", "12/6/2017", 35.90f));
        mockedData.add(new Transaction("drink", "12/6/2017", 5.90f));
    }


}
