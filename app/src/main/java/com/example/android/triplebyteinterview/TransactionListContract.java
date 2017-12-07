package com.example.android.triplebyteinterview;


import com.example.android.triplebyteinterview.model.Transaction;

interface TransactionListContract {
    interface View {

    }

    interface Presenter {
        int getDataLength();

        Transaction getDataByIndex(int position);
    }
}
