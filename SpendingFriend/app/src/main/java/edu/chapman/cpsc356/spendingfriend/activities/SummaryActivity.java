package edu.chapman.cpsc356.spendingfriend.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.fragments.SummaryFragment;

public class SummaryActivity extends SingleFragmentActivity
{
    private SummaryFragment summaryFragment;

    @Override
    protected Fragment getFragment()
    {
        this.summaryFragment = new SummaryFragment();
        return this.summaryFragment;
    }
}
