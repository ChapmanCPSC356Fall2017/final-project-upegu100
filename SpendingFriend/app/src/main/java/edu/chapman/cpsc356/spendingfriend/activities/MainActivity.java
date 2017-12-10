package edu.chapman.cpsc356.spendingfriend.activities;

import android.app.Activity;
import android.content.Context;
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
        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }

    public void onBudgetClick(View view)
    {
        Intent intent = new Intent(this, BudgetActivity.class);
        startActivity(intent);
    }

    public void onSummaryClick(View view)
    {
        Intent intent = new Intent (this, SummaryActivity.class);
        startActivity(intent);
    }

}
