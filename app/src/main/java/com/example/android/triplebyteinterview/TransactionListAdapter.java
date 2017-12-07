package com.example.android.triplebyteinterview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.triplebyteinterview.model.Transaction;

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.TransactionViewHolder> {
    private TransactionListContract.Presenter presenter;
    private LayoutInflater layoutInflater;

    TransactionListAdapter(Context context, TransactionListContract.Presenter presenter) {
        layoutInflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.transaction_list_row, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        Transaction transaction = presenter.getDataByIndex(position);
        String transactionName = transaction.getTransactionName();
        String date = transaction.getDate();
        Float amount = transaction.getAmount();
        holder.transactionNameTextView.setText(transactionName);
        holder.transactionDateTextView.setText(date);
        holder.transactionAmountTextView.setText(amount + "");
    }

    @Override
    public int getItemCount() {
        return presenter.getDataLength();
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {
        TextView transactionNameTextView;
        TextView transactionDateTextView;
        TextView transactionAmountTextView;

        TransactionViewHolder(View itemView) {
            super(itemView);
            transactionNameTextView = itemView.findViewById(R.id.transactionNameTextView);
            transactionDateTextView = itemView.findViewById(R.id.transactionDateTextView);
            transactionAmountTextView = itemView.findViewById(R.id.transactionAmountTextView);
        }
    }
}
