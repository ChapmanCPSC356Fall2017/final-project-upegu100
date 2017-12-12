package edu.chapman.cpsc356.spendingfriend.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.AccountActivity;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;

public class AccountFragment extends Fragment
{
    private AccountModel account;

    private EditText accountNameEditText;
    private EditText accountNumberEditText;
    private EditText accountStartingBalanceEditText;
    private TextView accountCurrentBalanceTextView;
    private RadioButton checkingRadioButton;
    private RadioButton savingsRadioButton;

    public AccountModel getAccount() { return this.account; }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String accountId = getArguments().getString(AccountActivity.EXTRA_ACCOUNT_ID);
        this.account = AccountCollection.GetInstance().getAccountById(accountId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        this.accountNameEditText = v.findViewById(R.id.et_frag_account_name);
        this.accountNameEditText.setText(account.getName());

        this.accountNumberEditText = v.findViewById(R.id.et_account_number);
        this.accountNumberEditText.setText(Integer.toString(account.getNumber()));

        this.accountStartingBalanceEditText = v.findViewById(R.id.et_account_starting_balance);
        this.accountStartingBalanceEditText.setText(Double.toString(account.getStartingBalance()));

        this.accountCurrentBalanceTextView = v.findViewById(R.id.et_account_current_balance);
        //TODO: How to calculate current balance and what class to do that in

        this.checkingRadioButton = v.findViewById(R.id.rb_checking);
        this.savingsRadioButton = v.findViewById(R.id.rb_savings);

        if (account.getType() == AccountModel.CHECKING)
        {
            this.checkingRadioButton.setChecked(true);
        }
        else
        {
            this.savingsRadioButton.setChecked(true);
        }

        this.accountNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                account.setName(editable.toString());
            }
        });

        this.accountNumberEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                //TODO: Error Handling
                account.setNumber(Integer.parseInt(editable.toString()));
            }
        });

        this.accountStartingBalanceEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                //TODO: Error handling for money amounts and control what they type
                account.setStartingBalance(Double.parseDouble(editable.toString()));
            }
        });

        this.checkingRadioButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                account.setType(AccountModel.CHECKING);
            }
        });
        this.savingsRadioButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                account.setType(AccountModel.SAVINGS);
            }
        });

        return v;
    }
}
