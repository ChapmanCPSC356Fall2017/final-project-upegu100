package edu.chapman.cpsc356.spendingfriend.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.adapters.BudgetListAdapter;

public class BudgetListFragment extends Fragment
{
    private BudgetListAdapter budgetListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_budget_list, container, false);
        RecyclerView budgetListView = v.findViewById(R.id.rv_budgets);

        this.budgetListAdapter = new BudgetListAdapter();
        budgetListView.setAdapter(this.budgetListAdapter);

        budgetListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;

    }

}
