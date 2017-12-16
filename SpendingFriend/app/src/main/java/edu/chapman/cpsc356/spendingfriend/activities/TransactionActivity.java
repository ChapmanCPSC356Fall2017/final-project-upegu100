package edu.chapman.cpsc356.spendingfriend.activities;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import edu.chapman.cpsc356.spendingfriend.fragments.TransactionFragment;

public class TransactionActivity extends SingleFragmentActivity
{
    public static final String EXTRA_TRANSACTION_ID = "extra_transaction_id";
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
                if(!this.transactionFragment.isValidTransactionName())
                {
                    writeNameErrorMessage();
                    return true;
                }
                else if (!this.transactionFragment.isValidAccountName())
                {
                    writeAccountErrorMessage();
                    return true;
                }
                else if (!this.transactionFragment.isValidTransactionDate())
                {
                    writeInvalidDateErrorMessage();
                    return true;
                }
                else if (this.transactionFragment.getTransaction().getDate().isAfterNow())
                {
                    writeFutureDateErrorMessage();
                    return true;
                }
                else
                {
                    this.transactionFragment.getTransaction().getAccount().updateCurrentBalance();
                    return false;
                }

            default:
                return false;
        }
    }

    @Override
    public void onBackPressed()
    {
        if(!this.transactionFragment.isValidTransactionName())
        {
            writeNameErrorMessage();
        }
        else if (!this.transactionFragment.isValidAccountName())
        {
            writeAccountErrorMessage();
        }
        else if (!this.transactionFragment.isValidTransactionDate())
        {
            writeInvalidDateErrorMessage();
        }
        else if (this.transactionFragment.getTransaction().getDate().isAfterNow())
        {
            writeFutureDateErrorMessage();
        }
        else
        {
            this.transactionFragment.getTransaction().getAccount().updateCurrentBalance();
            notify();
            super.onBackPressed();
        }
    }

    //TODO: String Resources

    public void writeFutureDateErrorMessage()
    {
        Toast.makeText(this, "Yikes, you can see into the future! " +
                "Your transaction date is later than today. Please keep us in the present " +
                "and type a new one.", Toast.LENGTH_LONG).show();
    }
    public void writeAccountErrorMessage()
    {
        Toast.makeText(this, "Uh oh! The account you typed does not exist.", Toast.LENGTH_SHORT).show();
    }
    public void writeNameErrorMessage()
    {
        Toast.makeText(this, "Looks like you forgot to name you transaction!", Toast.LENGTH_SHORT).show();

    }
    public void writeInvalidDateErrorMessage()
    {
        Toast.makeText(this, "Your date is not from this year.", Toast.LENGTH_SHORT).show();

    }
}
