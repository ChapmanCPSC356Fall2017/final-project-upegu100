package edu.chapman.cpsc356.spendingfriend.activities;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
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
    protected void onResume()
    {
        this.accountListFragment.getAccountListAdapter().notifyDataSetChanged();
        super.onResume();
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
            //Adds an Account
            case R.id.menu_add_account:
                AccountModel newAccount = new AccountModel();
                AccountCollection.GetInstance().addAccount(newAccount);

                Intent intent = new Intent(this, AccountActivity.class);
                intent.putExtra(AccountActivity.EXTRA_ACCOUNT_ID, newAccount.getId());
                startActivity(intent);

                return true;

            default:
                return false;
        }
    }
}
