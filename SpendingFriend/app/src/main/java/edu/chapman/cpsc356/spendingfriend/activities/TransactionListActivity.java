package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.fragments.TransactionListFragment;

public class TransactionListActivity extends SingleFragmentActivity
{
    private TransactionListFragment transactionListFragment;

    @Override
    protected Fragment getFragment()
    {
        this.transactionListFragment = new TransactionListFragment();
        return this.transactionListFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_transaction_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
