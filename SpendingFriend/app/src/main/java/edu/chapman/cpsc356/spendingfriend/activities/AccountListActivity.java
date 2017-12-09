package edu.chapman.cpsc356.spendingfriend.activities;

import android.os.Bundle;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountListFragment;

public class AccountListActivity extends SingleFragmentActivity {

    private AccountListFragment accountListFragment;

    @Override
    protected AccountListFragment getFragment()
    {
        this.accountListFragment = new AccountListFragment();
        return this.accountListFragment;
    }
}
