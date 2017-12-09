package edu.chapman.cpsc356.spendingfriend.activities;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;

public class AccountActivity extends SingleFragmentActivity
{
    AccountFragment accountFragment;
    @Override
    protected AccountFragment getFragment()
    {
        this.accountFragment = new AccountFragment();
        return this.accountFragment;
    }
}
