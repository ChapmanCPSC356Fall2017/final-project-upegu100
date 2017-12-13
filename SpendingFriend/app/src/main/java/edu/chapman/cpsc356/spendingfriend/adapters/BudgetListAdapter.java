package edu.chapman.cpsc356.spendingfriend.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.BudgetActivity;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;
import edu.chapman.cpsc356.spendingfriend.models.BudgetModel;

/**
 * Created by Nadiya on 12/13/2017.
 */

public class BudgetListAdapter extends RecyclerView.Adapter<BudgetListAdapter.BudgetViewHolder>
{

    @Override
    public BudgetViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_budget, parent, false);
        return new BudgetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BudgetViewHolder holder, int position)
    {
        AccountModel account = AccountCollection.GetInstance().getExtendedAccounts().get(position);
        holder.setUp(account);
    }

    @Override
    public int getItemCount()
    {
        return AccountCollection.GetInstance().getExtendedAccounts().size();
    }

    public class BudgetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private AccountModel account;
        private TextView budgetNameTextView;

        public BudgetViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            this.budgetNameTextView = itemView.findViewById(R.id.tv_cell_budget_name);
        }

        public void setUp(AccountModel account)
        {
            this.account = account;
            this.budgetNameTextView.setText(account.getName());
        }

        @Override
        public void onClick(View view)
        {
            Intent budgetIntent = new Intent(view.getContext(), BudgetActivity.class);
            view.getContext().startActivity(budgetIntent);
        }
    }
}
