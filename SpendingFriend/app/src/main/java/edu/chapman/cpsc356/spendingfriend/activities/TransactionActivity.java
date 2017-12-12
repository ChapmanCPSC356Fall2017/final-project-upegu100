package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.fragments.TransactionFragment;

public class TransactionActivity extends SingleFragmentActivity
{
    public static final String EXTRA_TRANSACTION_ID = "extra_transation_id";
    private TransactionFragment transactionFragment;

    @Override
    protected Fragment getFragment()
    {
        Bundle b = getIntent().getExtras();
        this.transactionFragment = new TransactionFragment();
        this.transactionFragment.setArguments(b);
        return this.transactionFragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                if (!this.transactionFragment.isValidAccountName())
                {
                    writeAccountErrorMessage();
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
    //TODO: String Resources
    public void writeAccountErrorMessage()
    {
        Toast.makeText(this, "Uh oh! The account you typed does not exist.", Toast.LENGTH_SHORT).show();
    }
}
