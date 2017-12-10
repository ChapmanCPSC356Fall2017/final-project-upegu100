package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
}
