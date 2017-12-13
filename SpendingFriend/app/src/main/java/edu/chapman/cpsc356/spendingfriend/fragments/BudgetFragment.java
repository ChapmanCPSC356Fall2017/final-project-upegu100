package edu.chapman.cpsc356.spendingfriend.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.BudgetActivity;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

public class BudgetFragment extends Fragment
{
    private AccountModel account;
    private TextView budgetName;
    private EditText monthlySpendingCapEditText;
    private EditText monthlyIncomeGoalEditText;
    private EditText totalSavingsGoal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String accountId = getArguments().getString(BudgetActivity.EXTRA_BUDGET_ACCOUNT_ID);
        this.account = AccountCollection.GetInstance().getAccountById(accountId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_budget, container, false);

        this.budgetName = v.findViewById(R.id.tv_budget_header);
        if (this.account.equals(AccountCollection.GetTotalAccount()))
        {
            this.budgetName.setText("Total Budget for \nCombined Accounts");
        }
        else
        {
            this.budgetName.setText("Budget for " + this.account.getName());
        }
        this.monthlySpendingCapEditText = v.findViewById(R.id.et_monthly_spending_cap);
        this.monthlySpendingCapEditText.setText(Double.toString(this.account.getMonthlySpendingCap()));

        this.monthlyIncomeGoalEditText = v.findViewById(R.id.et_monthly_income_goal);
        this.monthlyIncomeGoalEditText.setText(Double.toString(this.account.getMonthlyIncomeGoal()));

        this.totalSavingsGoal = v.findViewById(R.id.et_total_savings_goal);
        this.totalSavingsGoal.setText(Double.toString(this.account.getTotalSavingsGoal()));

        return v;
    }

}
