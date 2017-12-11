package edu.chapman.cpsc356.spendingfriend.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.AccountActivity;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

/**
 * Created by Nadiya on 12/9/2017.
 */

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.AccountViewHolder>
{
    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_account, parent, false);
        return new AccountViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AccountViewHolder holder, int position)
    {
        AccountModel account = AccountCollection.GetInstance().getAccounts().get(position);
        holder.setUp(account);
    }

    @Override
    public int getItemCount()
    {
        return AccountCollection.GetInstance().getAccounts().size();
    }

    public class AccountViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private AccountModel account;
        private TextView accountNameTextView;
        private TextView accountBalanceTextView;

        public AccountViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);
            this.accountNameTextView = itemView.findViewById(R.id.tv_cell_account_name);
            this.accountBalanceTextView = itemView.findViewById(R.id.tv_cell_account_balance);
        }

        public void setUp(AccountModel account)
        {
            this.account = account;
            this.accountNameTextView.setText(account.getName());
            this.accountBalanceTextView.setText("$" + Double.toString(account.getStartingBalance()));
        }

        @Override
        public void onClick(View view)
        {
            Intent accountIntent = new Intent(view.getContext(), AccountActivity.class);
            accountIntent.putExtra(AccountActivity.EXTRA_ACCOUNT_ID, this.account.getId());
            view.getContext().startActivity(accountIntent);
        }
    }
}
