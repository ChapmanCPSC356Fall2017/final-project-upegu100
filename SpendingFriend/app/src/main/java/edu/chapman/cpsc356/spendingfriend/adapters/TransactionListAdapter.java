package edu.chapman.cpsc356.spendingfriend.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.TransactionActivity;
import edu.chapman.cpsc356.spendingfriend.collections.TransactionCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;

/**
 * Created by Nadiya on 12/9/2017.
 */

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.TransactionViewHolder>
{

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_transaction, parent, false);

        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position)
    {
        TransactionModel transaction = TransactionCollection.GetInstance().getTransactions().get(position);
        holder.setUp(transaction);
    }

    @Override
    public int getItemCount()
    {
        return TransactionCollection.GetInstance().getTransactions().size();
    }

    public void remove(int adapterPosition)
    {
        AccountModel account = TransactionCollection.GetInstance().getTransactions().get(adapterPosition).getAccount();
        TransactionCollection.GetInstance().getTransactions().remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        account.updateCurrentBalance();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TransactionModel transaction;
        private TextView transactionNameTextView;
        private TextView transactionAmountTextView;

        public TransactionViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            this.transactionNameTextView = itemView.findViewById(R.id.tv_cell_transaction_name);
            this.transactionAmountTextView = itemView.findViewById(R.id.tv_cell_transaction_amount);
        }

        public void setUp(TransactionModel transaction)
        {
            this.transaction = transaction;
            this.transactionNameTextView.setText(transaction.getName());
            this.transactionAmountTextView.setText(Double.toString(transaction.getAmount()));
        }

        @Override
        public void onClick(View view)
        {
            Intent transactionIntent = new Intent(view.getContext(), TransactionActivity.class);
            transactionIntent.putExtra(TransactionActivity.EXTRA_TRANSACTION_ID, this.transaction.getId());
            view.getContext().startActivity(transactionIntent);
        }
    }
}
