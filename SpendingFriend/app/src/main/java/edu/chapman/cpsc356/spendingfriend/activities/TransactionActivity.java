package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import edu.chapman.cpsc356.spendingfriend.R;
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
            //Home Button
            case android.R.id.home:
                //Invalid Name
                if(!this.transactionFragment.isValidTransactionName())
                {
                    writeNameErrorMessage();
                    return true;
                }
                //Invalid Account Name
                else if (!this.transactionFragment.isValidAccountName())
                {
                    writeAccountErrorMessage();
                    return true;
                }
                //Invalid Transaction Date
                else if (!this.transactionFragment.isValidTransactionDate())
                {
                    writeInvalidDateErrorMessage();
                    return true;
                }
                //Future Date
                else if (this.transactionFragment.getTransaction().getDate().isAfterNow())
                {
                    writeFutureDateErrorMessage();
                    return true;
                }
                //No Errors
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
        //Invalid Transaction Name
        if(!this.transactionFragment.isValidTransactionName())
        {
            writeNameErrorMessage();
        }
        //Invalid Account Name
        else if (!this.transactionFragment.isValidAccountName())
        {
            writeAccountErrorMessage();
        }
        //Invalid Transaction Date
        else if (!this.transactionFragment.isValidTransactionDate())
        {
            writeInvalidDateErrorMessage();
        }
        //Future Date
        else if (this.transactionFragment.getTransaction().getDate().isAfterNow())
        {
            writeFutureDateErrorMessage();
        }
        //No Errors
        else
        {
            this.transactionFragment.getTransaction().getAccount().updateCurrentBalance();
            super.onBackPressed();
        }
    }
    /*
    * writeFutureDateErrorMessage()
    * Creates Toast for future date error
    */
    public void writeFutureDateErrorMessage()
    {
        Toast.makeText(this, getString(R.string.future_date_error_part_1) +
                getString(R.string.future_date_error_part_2) +
                getString(R.string.future_date_error_part_3), Toast.LENGTH_LONG).show();
    }

    /*
    * writeAccountErrorMessage()
    * Creates Toast for invalid account name
    */
    public void writeAccountErrorMessage()
    {
        Toast.makeText(this, R.string.account_name_error, Toast.LENGTH_SHORT).show();
    }

    /*
    * writeNameErrorMessage()
    * Creates Toast for invalid transaction names
    */
    public void writeNameErrorMessage()
    {
        Toast.makeText(this, R.string.transcation_name_error, Toast.LENGTH_SHORT).show();

    }

    /*
    * writeInvalidDateErrorMessage()
    * Creates Toast for dates not in 2017
    */
    public void writeInvalidDateErrorMessage()
    {
        Toast.makeText(this, R.string.wrong_year_error, Toast.LENGTH_SHORT).show();

    }
}
