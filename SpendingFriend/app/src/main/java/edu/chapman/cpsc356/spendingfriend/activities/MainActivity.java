package edu.chapman.cpsc356.spendingfriend.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.chapman.cpsc356.spendingfriend.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAccountsClick(View view)
    {
        Intent intent = new Intent(this, AccountListActivity.class);
        startActivity(intent);
    }

    public void onTransactionsClick(View view)
    {
        Intent intent = new Intent(this, TransactionActivity.class);
        startActivity(intent);
    }

    public void onBudgetClick(View view)
    {
    }

    public void onSummaryClick(View view)
    {
    }
}
