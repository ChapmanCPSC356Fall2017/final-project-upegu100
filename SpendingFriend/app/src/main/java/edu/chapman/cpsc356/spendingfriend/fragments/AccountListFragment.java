package edu.chapman.cpsc356.spendingfriend.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.adapters.AccountListAdapter;

public class AccountListFragment extends Fragment
{
    private AccountListAdapter accountListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_account_list, container, false);
        RecyclerView accountListView = v.findViewById(R.id.rv_accounts);

        this.accountListAdapter = new AccountListAdapter();
        accountListView.setAdapter(this.accountListAdapter);

        accountListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}
