package edu.chapman.cpsc356.spendingfriend.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.adapters.SummaryAdapter;

public class SummaryFragment extends Fragment
{
    private SummaryAdapter summaryAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_summary, container, false);
        RecyclerView summaryListView = v.findViewById(R.id.rv_summary);

        this.summaryAdapter = new SummaryAdapter();
        summaryListView.setAdapter(this.summaryAdapter);

        summaryListView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return v;
    }
}
