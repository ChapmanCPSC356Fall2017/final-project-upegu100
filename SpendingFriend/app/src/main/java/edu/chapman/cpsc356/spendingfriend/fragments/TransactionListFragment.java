package edu.chapman.cpsc356.spendingfriend.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.TransactionTouchHelper;
import edu.chapman.cpsc356.spendingfriend.adapters.TransactionListAdapter;

public class TransactionListFragment extends Fragment
{
    private TransactionListAdapter transactionListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_transaction_list, container, false);
        RecyclerView transactionListView = v.findViewById(R.id.rv_transactions);

        this.transactionListAdapter = new TransactionListAdapter();
        transactionListView.setAdapter(this.transactionListAdapter);

        transactionListView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemTouchHelper.Callback callback = new TransactionTouchHelper(this.transactionListAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(transactionListView);

        return v;
    }
}