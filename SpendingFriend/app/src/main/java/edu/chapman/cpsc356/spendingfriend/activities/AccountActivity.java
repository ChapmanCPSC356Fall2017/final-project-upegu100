package edu.chapman.cpsc356.spendingfriend.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.fragments.AccountFragment;

/*
* AccountActivity
* Shows a single AccountFragment
*/
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
        if (!accountFragment.getAccount().equals(AccountCollection.GetCashAccount()))
        {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.activity_account, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            //Delete Account
            case R.id.menu_delete_account:
                if (this.accountFragment.getAccount().hasTransaction())
                {
                    writeCannotDeleteErrorMessage();
                    return true;
                }
                else
                {
                    AccountCollection.GetInstance().removeAccount(accountFragment.getAccount());

                    Intent intent = new Intent(this, AccountListActivity.class);
                    startActivity(intent);
                    return true;
                }

                //Home Button
            case android.R.id.home:
                if (!this.accountFragment.isValidAccountName())
                {
                    writeInvalidNameErrorMessage();
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed()
    {
        if (!this.accountFragment.isValidAccountName())
        {
            writeInvalidNameErrorMessage();
        }
        else
        {
            super.onBackPressed();
        }
    }

    /* writeInvalidNameErrorMessage()
    * Makes Toast for invalid account names
    */
    public void writeInvalidNameErrorMessage()
    {
        Toast.makeText(this, getString(R.string.invalid_name_error_message_part_1) +
                getString(R.string.invalid_name_error_message_part_2), Toast.LENGTH_SHORT).show();
    }

    /* writeCannotDeleteErrorMessage()
    * Makes Toast for when user cannot delete an account that has transactions associated to it
    */
    public void writeCannotDeleteErrorMessage()
    {
        Toast.makeText(this, getString(R.string.delete_error_message_part_1) +
                getString(R.string.delete_error_message_part_2), Toast.LENGTH_SHORT).show();
    }
}
