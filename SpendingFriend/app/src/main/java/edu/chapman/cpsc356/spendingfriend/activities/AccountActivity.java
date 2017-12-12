package edu.chapman.cpsc356.spendingfriend.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

public class AccountActivity extends SingleFragmentActivity
{
    public static final String EXTRA_ACCOUNT_ID = "extra_account_id";
    AccountFragment accountFragment;
    @Override

    protected AccountFragment getFragment()
    {
        Bundle b = getIntent().getExtras();
        this.accountFragment = new AccountFragment();
        this.accountFragment.setArguments(b);
        return this.accountFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_account, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_delete_account:
                AccountCollection.GetInstance().getAccounts().remove(accountFragment.getAccount());

                Intent intent = new Intent(this, AccountListActivity.class);
                startActivity(intent);
                return true;

            default:
                return false;
        }
    }
}
