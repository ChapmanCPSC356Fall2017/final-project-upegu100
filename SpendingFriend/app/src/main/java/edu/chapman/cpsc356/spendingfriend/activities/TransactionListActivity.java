package edu.chapman.cpsc356.spendingfriend.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.TransactionCollection;
import edu.chapman.cpsc356.spendingfriend.fragments.TransactionListFragment;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;

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
    protected void onResume()
    {
        transactionListFragment.getTransactionListAdapter().notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_transaction_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_add_transaction:
                TransactionModel newTransaction = new TransactionModel();
                TransactionCollection.GetInstance().getTransactions().add(newTransaction);

                Intent intent = new Intent(this, TransactionActivity.class);
                intent.putExtra(TransactionActivity.EXTRA_TRANSACTION_ID, newTransaction.getId());
                startActivity(intent);

                return true;

            default:
                return false;
        }
    }
}
