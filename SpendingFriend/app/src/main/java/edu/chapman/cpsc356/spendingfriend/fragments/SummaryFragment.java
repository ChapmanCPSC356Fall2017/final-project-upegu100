package edu.chapman.cpsc356.spendingfriend.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import edu.chapman.cpsc356.spendingfriend.MoneyFormat;
import edu.chapman.cpsc356.spendingfriend.ParseHelper;
import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.adapters.SummaryAdapter;

public class SummaryFragment extends Fragment
{
    private SummaryAdapter summaryAdapter;
    private int month;
    private Button janButton;
    private Button febButton;
    private Button marButton;
    private Button aprButton;
    private Button mayButton;
    private Button junButton;
    private Button julButton;
    private Button augButton;
    private Button sepButton;
    private Button octButton;
    private Button novButton;
    private Button decButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_summary, container, false);
        RecyclerView summaryListView = v.findViewById(R.id.rv_summary);

        this.summaryAdapter = new SummaryAdapter();
        this.summaryAdapter.setMonth(1);
        summaryListView.setAdapter(this.summaryAdapter);

        summaryListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Set up month buttons
        this.janButton = v.findViewById(R.id.btn_jan);
        this.febButton = v.findViewById(R.id.btn_feb);
        this.marButton = v.findViewById(R.id.btn_mar);
        this.aprButton = v.findViewById(R.id.btn_apr);
        this.mayButton = v.findViewById(R.id.btn_may);
        this.junButton = v.findViewById(R.id.btn_jun);
        this.julButton = v.findViewById(R.id.btn_jul);
        this.augButton = v.findViewById(R.id.btn_aug);
        this.sepButton = v.findViewById(R.id.btn_sep);
        this.octButton = v.findViewById(R.id.btn_oct);
        this.novButton = v.findViewById(R.id.btn_nov);
        this.decButton = v.findViewById(R.id.btn_dec);

        this.janButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onButtonClick(janButton.getText().toString());
            }
        });

        this.febButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onButtonClick(febButton.getText().toString());
            }
        });
        this.marButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onButtonClick(marButton.getText().toString());

            }
        });
        this.aprButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onButtonClick(aprButton.getText().toString());

            }
        });
        this.mayButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(mayButton.getText().toString());
            }
        });
        this.junButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                onButtonClick(junButton.getText().toString());
            }
        });
        this.julButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(julButton.getText().toString());
            }
        });
        this.augButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(augButton.getText().toString());
            }
        });
        this.sepButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(sepButton.getText().toString());
            }
        });
        this.octButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(octButton.getText().toString());
            }
        });
        this.novButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(novButton.getText().toString());
            }
        });
        this.decButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onButtonClick(decButton.getText().toString());
            }
        });

        return v;
    }

    //monthStringToInt() method
    public int monthStringToInt(String s)
    {
        if (s.equals("Jan"))
        {
            return 1;
        }
        else if (s.equals("Feb"))
        {
            return 2;
        }
        else if (s.equals("Mar"))
        {
            return 3;
        }
        else if (s.equals("Apr"))
        {
            return 4;
        }
        else if (s.equals("May"))
        {
            return 5;
        }
        else if (s.equals("Jun"))
        {
            return 6;
        }
        else if (s.equals("Jul"))
        {
            return 7;
        }
        else if (s.equals("Aug"))
        {
            return 8;
        }
        else if (s.equals("Sep"))
        {
            return 9;
        }
        else if (s.equals("Oct"))
        {
            return 10;
        }
        else if (s.equals("Nov"))
        {
            return 11;
        }
        else
        {
            return 12;
        }
    }

    //OnButtonClick() method
    public void onButtonClick(String sMonth)
    {
        summaryAdapter.setMonth(monthStringToInt(sMonth));
        summaryAdapter.notifyDataSetChanged();
    }


}
