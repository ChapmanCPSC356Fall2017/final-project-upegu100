package edu.chapman.cpsc356.spendingfriend.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.TransactionActivity;
import edu.chapman.cpsc356.spendingfriend.collections.TransactionCollection;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;


public class TransactionFragment extends Fragment {

    private TransactionModel transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_transaction, container, false);
        String transactionId = getArguments().getString(TransactionActivity.EXTRA_TRANSACTION_ID);
        this.transaction = TransactionCollection.GetInstance().getTransaction(transactionId);
        return v;
    }
}
