package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.fragments.TransactionFragment;

public class TransactionActivity extends SingleFragmentActivity
{

    private TransactionFragment transactionFragment;

    @Override
    protected Fragment getFragment()
    {
        this.transactionFragment = new TransactionFragment();
        return this.transactionFragment;
    }
}
