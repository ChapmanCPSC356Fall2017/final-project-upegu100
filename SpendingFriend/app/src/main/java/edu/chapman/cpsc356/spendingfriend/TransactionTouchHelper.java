package edu.chapman.cpsc356.spendingfriend;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import edu.chapman.cpsc356.spendingfriend.adapters.TransactionListAdapter;

/**
 * Created by Nadiya on 12/10/2017.
 */

public class TransactionTouchHelper extends ItemTouchHelper.SimpleCallback
{
    private TransactionListAdapter transactionListAdapter;

    public TransactionTouchHelper(TransactionListAdapter transactionListAdapter)
    {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT |
                ItemTouchHelper.RIGHT);
        this.transactionListAdapter = transactionListAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target)
    {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
    {
        this.transactionListAdapter.remove(viewHolder.getAdapterPosition());
    }
}
