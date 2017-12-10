package edu.chapman.cpsc356.spendingfriend.adapters;

import android.accounts.Account;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        public AccountViewHolder(View itemView)
        {
            super(itemView);
        }

        public void setUp(AccountModel account)
        {

        }

        @Override
        public void onClick(View view)
        {
            Intent accountIntent = new Intent(view.getContext(), AccountActivity.class);
            view.getContext().startActivity(accountIntent);
        }
    }
}
