package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.spendingfriend.fragments.BudgetFragment;

public class BudgetActivity extends SingleFragmentActivity
{
    public static final String EXTRA_BUDGET_ACCOUNT_ID = "extra_budget_account_id";

    private BudgetFragment budgetFragment;
    @Override
    protected Fragment getFragment()
    {
        Bundle b = getIntent().getExtras();
        this.budgetFragment = new BudgetFragment();
        this.budgetFragment.setArguments(b);
        return this.budgetFragment;
    }
}
