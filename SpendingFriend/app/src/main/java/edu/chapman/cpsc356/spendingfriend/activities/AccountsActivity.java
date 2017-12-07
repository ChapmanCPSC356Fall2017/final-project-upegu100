package edu.chapman.cpsc356.spendingfriend.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;

public class AccountsActivity extends SingleFragmentActivity
{
    AccountFragment accountFragment;
    @Override
    protected Fragment getFragment()
    {
        this.accountFragment = new AccountFragment();
        return this.accountFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
    }
}
