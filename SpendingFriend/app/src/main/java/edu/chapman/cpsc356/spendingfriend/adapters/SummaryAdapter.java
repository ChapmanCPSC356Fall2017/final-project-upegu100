package edu.chapman.cpsc356.spendingfriend.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

/**
 * Created by Nadiya on 12/13/2017.
 */

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder>
{
    @Override
    public SummaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_summary, parent, false);
        return new SummaryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SummaryViewHolder holder, int position)
    {
        AccountModel account = AccountCollection.GetInstance().getExtendedAccounts().get(position);
        holder.setUp(account);
    }

    @Override
    public int getItemCount()
    {
        return AccountCollection.GetInstance().getExtendedAccounts().size();
    }

    public class SummaryViewHolder extends RecyclerView.ViewHolder
    {
        private AccountModel account;
        private TextView summaryHeaderTextView;
        private TextView monthlySpentTextView;
        private TextView monthlySpendingCapTextView;
        private TextView differenceSpentTextView;
        private TextView monthlyEarnedTextView;
        private TextView monthlyIncomeGoalTextView;
        private TextView differenceEarnedTextView;
        private TextView totalSavingsTextView;
        private TextView totalSavingsGoalTextView;
        private TextView differenceSavingsTextView;

        public SummaryViewHolder(View itemView)
        {
            super(itemView);
            this.summaryHeaderTextView = itemView.findViewById(R.id.tv_summary_header);
            this.monthlySpentTextView = itemView.findViewById(R.id.tv_monthly_spent);
            this.monthlySpendingCapTextView = itemView.findViewById(R.id.tv_monthly_cap);
            this.differenceSpentTextView = itemView.findViewById(R.id.tv_spending_difference);
            this.monthlyEarnedTextView = itemView.findViewById(R.id.tv_income_earned);
            this.monthlyIncomeGoalTextView = itemView.findViewById(R.id.tv_monthly_income_goal_summary);
            this.differenceEarnedTextView = itemView.findViewById(R.id.tv_income_difference);
            this.totalSavingsTextView = itemView.findViewById(R.id.tv_savings);
            this.totalSavingsGoalTextView = itemView.findViewById(R.id.tv_monthly_savings_goal_summary);
            this.differenceSavingsTextView = itemView.findViewById(R.id.tv_total_difference);
        }

        public void setUp(AccountModel account)
        {
            this.account = account;
            this.summaryHeaderTextView.setText(account.getName());
            this.monthlySpentTextView.setText(Double.toString(this.account.calcSpent()));
            this.monthlySpendingCapTextView.setText(Double.toString(account.getMonthlySpendingCap()));
            this.differenceSpentTextView.setText(Double.toString(this.account.calcBudgetDiffSpent()));
            this.monthlyEarnedTextView.setText(Double.toString(this.account.calcEarned()));
            this.monthlyIncomeGoalTextView.setText(Double.toString(account.getMonthlyIncomeGoal()));
            this.differenceEarnedTextView.setText(Double.toString(this.account.callBudgetDiffEarned()));
            this.totalSavingsTextView.setText(Double.toString(this.account.getCurrentBalance()));
            this.totalSavingsGoalTextView.setText(Double.toString(account.getTotalSavingsGoal()));
            this.differenceSavingsTextView.setText(Double.toString(account.calcBudgetDiffSpent()));
        }
    }
}
