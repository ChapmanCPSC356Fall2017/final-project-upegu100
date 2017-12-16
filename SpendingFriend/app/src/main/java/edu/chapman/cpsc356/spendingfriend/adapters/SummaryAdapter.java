package edu.chapman.cpsc356.spendingfriend.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.joda.time.DateTime;

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

        public void setUpMonthlySpent(double spent, double cap, double spentDiff)
        {
            this.monthlySpentTextView.setText(Double.toString(spent));
            this.monthlySpendingCapTextView.setText(Double.toString(cap));

            if (spentDiff > 0) {
                this.differenceSpentTextView.setText(writeOverBudgetMessage(spentDiff));
            } else if (spentDiff < 0) {
                this.differenceSpentTextView.setText(writeUnderBudgetMessage(-spentDiff));
            } else {
                this.differenceSpentTextView.setText(writeOnBudgetMessage());
            }
        }
        public void setUpMonthlyEarned(double earned, double goal, double earnedDiff)
        {
            this.monthlyEarnedTextView.setText(Double.toString(earned));
            this.monthlyIncomeGoalTextView.setText(Double.toString(goal));

            if (earnedDiff > 0) {
                this.differenceEarnedTextView.setText(writeEarnedMoreMessage(earnedDiff));
            } else if (earnedDiff < 0) {
                this.differenceEarnedTextView.setText(writeEarnedLessMessage(-earnedDiff));
            } else {
                this.differenceEarnedTextView.setText(writeEarnedExactMessage());
            }
        }

        public void setUpSavings(double savings, double goal, double savingsDiff)
        {
            this.totalSavingsTextView.setText(Double.toString(savings));
            this.totalSavingsGoalTextView.setText(Double.toString(goal));

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
            return "Uh oh, you are currently $" + amount + " over budget.";
        }

        public String writeUnderBudgetMessage(double amount)
        {
            return "You are currently $" + amount + " under budget. Keep it up!";
        }

        public String writeOnBudgetMessage()
        {
            return "Talk about being exact, you are right on your budget. Good job!";
        }

        public String writeEarnedMoreMessage(double amount)
        {
            return "Look at you, you've earned $" + amount + " more than your goal!";
        }

        public String writeEarnedLessMessage(double amount)
        {
            return "Oh no, you are $" + amount + " behind your income goal";
        }

        public String writeEarnedExactMessage()
        {
            return "Well fancy that, you earned exactly what you wanted to!";
        }

        public String writeMoreSavingsMessage(double amount)
        {
            return "How cool is that, you have saved $" + amount + " more than you planned.";
        }

        public String writeLessSavingsMessage(double amount)
        {
            return "Sadly, you're $" + amount + " behind your savings goals this month.";
        }

        public String writeExactSavingsMessage()
        {
            return "A penny saved is a penny earned and you have saved the exact amount that you wanted!";
        }

    }
}
