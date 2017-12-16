package edu.chapman.cpsc356.spendingfriend.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.MoneyFormat;
import edu.chapman.cpsc356.spendingfriend.ParseHelper;
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
        this.monthlySpendingCapEditText.setText(MoneyFormat.format(this.account.getMonthlySpendingCap()));

        this.monthlyIncomeGoalEditText = v.findViewById(R.id.et_monthly_income_goal);
        this.monthlyIncomeGoalEditText.setText(MoneyFormat.format(this.account.getMonthlyIncomeGoal()));

        this.totalSavingsGoal = v.findViewById(R.id.et_total_savings_goal);
        this.totalSavingsGoal.setText(MoneyFormat.format(this.account.getTotalSavingsGoal()));

        this.monthlySpendingCapEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                MoneyFormat.preventExtraDecimalNumbers(editable);
                if (ParseHelper.tryParseDouble(editable.toString()))
                {
                    account.setMonthlySpendingCap(Double.parseDouble(editable.toString()));
                }
                else
                {
                    account.setMonthlySpendingCap(0);
                }
            }
        });

        this.monthlyIncomeGoalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                MoneyFormat.preventExtraDecimalNumbers(editable);
                if (ParseHelper.tryParseDouble(editable.toString()))
                {
                    account.setMonthlyIncomeGoal(Double.parseDouble(editable.toString()));
                }
                else
                {
                    account.setMonthlyIncomeGoal(0);
                }
            }
        });

        this.totalSavingsGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                MoneyFormat.preventExtraDecimalNumbers(editable);
                if (ParseHelper.tryParseDouble(editable.toString()))
                {
                    account.setTotalSavingsGoal(Double.parseDouble(editable.toString()));
                }
                else
                {
                    account.setTotalSavingsGoal(0);
                }
            }
        });

        return v;
    }

}
