package edu.chapman.cpsc356.spendingfriend.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.AccountActivity;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

public class AccountFragment extends Fragment
{
    AccountModel account;

    public AccountModel getAccount() { return this.account; }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        String accountId = getArguments().getString(AccountActivity.EXTRA_ACCOUNT_ID);
        this.account = AccountCollection.GetInstance().getAccount(accountId);

        return v;
    }
}
