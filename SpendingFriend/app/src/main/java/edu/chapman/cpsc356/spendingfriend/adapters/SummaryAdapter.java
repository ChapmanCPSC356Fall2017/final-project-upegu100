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

        public SummaryViewHolder(View itemView)
        {
            super(itemView);
            this.summaryHeaderTextView = itemView.findViewById(R.id.tv_summary_header);
        }

        public void setUp(AccountModel account)
        {
            this.account = account;
            this.summaryHeaderTextView.setText(account.getName());
        }
    }
}
