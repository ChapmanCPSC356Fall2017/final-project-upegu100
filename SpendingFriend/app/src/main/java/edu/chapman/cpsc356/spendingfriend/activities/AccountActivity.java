package edu.chapman.cpsc356.spendingfriend.activities;
import android.os.Bundle;

import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;

public class AccountActivity extends SingleFragmentActivity
{
    public static final String EXTRA_ACCOUNT_NUMBER = "extra_account_number";
    AccountFragment accountFragment;
    @Override
    protected AccountFragment getFragment()
    {
        Bundle b = getIntent().getExtras();
        this.accountFragment = new AccountFragment();
        this.accountFragment.setArguments(b);
        return this.accountFragment;
    }
}
