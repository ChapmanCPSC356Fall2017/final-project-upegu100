package edu.chapman.cpsc356.spendingfriend.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountListFragment;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

public class AccountListActivity extends SingleFragmentActivity {

    private AccountListFragment accountListFragment;

    @Override
    protected AccountListFragment getFragment()
    {
        this.accountListFragment = new AccountListFragment();
        return this.accountListFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_account_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_add_account:
                AccountModel newAccount = new AccountModel();
                AccountCollection.GetInstance().getAccounts().add(0, newAccount);

                Intent intent = new Intent(this, AccountActivity.class);
                intent.putExtra(AccountActivity.EXTRA_ACCOUNT_NUMBER, newAccount.getNumber());
                startActivity(intent);

                return true;

            default:
                return false;
        }
    }
}
