package com.example.android.triplebyteinterview.model;

public class Transaction {
    String transactionName;
    String date;
    Float amount;

    public Transaction(String transactionName, String date, Float amount) {
        this.transactionName = transactionName;
        this.date = date;
        this.amount = amount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public String getDate() {
        return date;
    }

    public Float getAmount() {
        return amount;
    }
}
