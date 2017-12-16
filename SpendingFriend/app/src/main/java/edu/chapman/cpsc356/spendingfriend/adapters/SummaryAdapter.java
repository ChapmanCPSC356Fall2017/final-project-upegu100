package edu.chapman.cpsc356.spendingfriend.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.joda.time.DateTime;

import edu.chapman.cpsc356.spendingfriend.MoneyFormat;
import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

/**
 * Created by Nadiya on 12/13/2017.
 */

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder>
{
    private int month;
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
        holder.setUp(account, month);
    }

    @Override
    public int getItemCount()
    {
        return AccountCollection.GetInstance().getExtendedAccounts().size();
    }

    public int getMonth(){return this.month;}
    public void setMonth(int month){this.month=month;}

    public class SummaryViewHolder extends RecyclerView.ViewHolder
    {
        private AccountModel account;
        private int month;
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

            //Initialize Text Views
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

        public void setUp(AccountModel account, int month)
        {
            this.account = account;
            this.month = month;
            this.summaryHeaderTextView.setText(account.getName());

            //Sets up Total Account
            if (this.account.equals(AccountCollection.GetTotalAccount()))
            {
                setUpMonthlySpent(AccountCollection.GetInstance().getTotalMonthSpent(this.month),
                        AccountCollection.GetInstance().getTotalMonthSpendingCap(),
                        AccountCollection.GetInstance().getTotalMonthSpentDiff(this.month));
                setUpMonthlyEarned(AccountCollection.GetInstance().getTotalMonthEarned(this.month),
                        AccountCollection.GetInstance().getTotalMonthIncomeGoal(),
                        AccountCollection.GetInstance().getTotalMonthEarnedDiff(this.month));
                setUpSavings(AccountCollection.GetInstance().getCurrentTotalBalance(),
                        AccountCollection.GetInstance().getTotalSavingsGoal(),
                        AccountCollection.GetInstance().getTotalSavingsDiff());
            }
            //Sets up any other monthly Account
            else
            {
                setUpMonthlySpent(this.account.calcMonthSpent(this.month),
                        this.account.getMonthlySpendingCap(),
                        this.account.calcMonthBudgetDiffSpent(this.month));
                setUpMonthlyEarned(this.account.calcMonthEarned(this.month),
                        this.account.getMonthlyIncomeGoal(),
                        this.account.calcMonthBudgetDiffEarned(this.month));
                setUpSavings(this.account.getCurrentBalance(),
                        this.account.getTotalSavingsGoal(),
                        this.account.calcBudgetDiffSavings());
            }
        }
        //setUpMonthlySpent() method
        public void setUpMonthlySpent(double spent, double cap, double spentDiff)
        {
            this.monthlySpentTextView.setText(monthlySpentTextView.getContext().getString(R.string.dollar_symbol)
                    + MoneyFormat.format(spent));
            this.monthlySpendingCapTextView.setText(monthlySpentTextView.getContext().getString(R.string.dollar_symbol)
                    + MoneyFormat.format(cap));

            if (spentDiff > 0) {
                this.differenceSpentTextView.setText(writeOverBudgetMessage(spentDiff));
            } else if (spentDiff < 0) {
                this.differenceSpentTextView.setText(writeUnderBudgetMessage(-spentDiff));
            } else {
                this.differenceSpentTextView.setText(writeOnBudgetMessage());
            }
        }
        //setUpMonthlyEarned() method
        public void setUpMonthlyEarned(double earned, double goal, double earnedDiff)
        {
            this.monthlyEarnedTextView.setText(monthlySpentTextView.getContext().getString(R.string.dollar_symbol)
                    + MoneyFormat.format(earned));
            this.monthlyIncomeGoalTextView.setText(monthlySpentTextView.getContext().getString(R.string.dollar_symbol)
                    + MoneyFormat.format(goal));

            if (earnedDiff > 0) {
                this.differenceEarnedTextView.setText(writeEarnedMoreMessage(earnedDiff));
            } else if (earnedDiff < 0) {
                this.differenceEarnedTextView.setText(writeEarnedLessMessage(-earnedDiff));
            } else {
                this.differenceEarnedTextView.setText(writeEarnedExactMessage());
            }
        }

        //setUpSavings
        public void setUpSavings(double savings, double goal, double savingsDiff)
        {
            this.totalSavingsTextView.setText(monthlySpentTextView.getContext().getString(R.string.dollar_symbol)
                    + MoneyFormat.format(savings));
            this.totalSavingsGoalTextView.setText(monthlySpentTextView.getContext().getString(R.string.dollar_symbol)
                    + MoneyFormat.format(goal));

            if (savingsDiff > 0) {
                this.differenceSavingsTextView.setText(writeMoreSavingsMessage(savingsDiff));
            } else if (savingsDiff < 0) {
                this.differenceSavingsTextView.setText(writeLessSavingsMessage(-savingsDiff));
            } else {
                this.differenceSavingsTextView.setText(writeExactSavingsMessage());
            }
        }

        //Error Messages
        public String writeOverBudgetMessage(double amount)
        {
            return itemView.getContext().getString(R.string.over_budget_message_part_1) + amount + 
                    itemView.getContext().getString(R.string.over_budget_message_part_2);
        }

        public String writeUnderBudgetMessage(double amount)
        {
            return itemView.getContext().getString(R.string.under_budget_message_part_1) + amount +
                    itemView.getContext().getString(R.string.under_budget_message_part_2);
        }

        public String writeOnBudgetMessage()
        {
            return itemView.getContext().getString(R.string.on_budget_message);
        }

        public String writeEarnedMoreMessage(double amount)
        {
            return itemView.getContext().getString(R.string.earned_more_message_part_1) + amount
                    + itemView.getContext().getString(R.string.earned_more_message_part_2);
        }

        public String writeEarnedLessMessage(double amount)
        {
            return itemView.getContext().getString(R.string.earned_less_message_part_1) + amount
                    + itemView.getContext().getString(R.string.earned_less_message_part_2);
        }

        public String writeEarnedExactMessage()
        {
            return itemView.getContext().getString(R.string.earned_exact_message);
        }

        public String writeMoreSavingsMessage(double amount)
        {
            return itemView.getContext().getString(R.string.more_savings_message_part_1) + amount
                    + itemView.getContext().getString(R.string.more_savings_message_part_2);
        }

        public String writeLessSavingsMessage(double amount)
        {
            return itemView.getContext().getString(R.string.less_savings_message_part_1) + amount
                    + itemView.getContext().getString(R.string.less_savings_message_part_2);
        }

        public String writeExactSavingsMessage()
        {
            return itemView.getContext().getString(R.string.exact_savings_message);
        }

    }
}
