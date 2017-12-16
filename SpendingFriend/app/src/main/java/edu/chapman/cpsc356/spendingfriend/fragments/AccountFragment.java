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

import edu.chapman.cpsc356.spendingfriend.MoneyFormat;
import edu.chapman.cpsc356.spendingfriend.ParseHelper;
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
    private TextView accountTypeTextView;
    private TextView cashTextView;

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
        this.accountNumberEditText = v.findViewById(R.id.et_account_number);
        this.accountStartingBalanceEditText = v.findViewById(R.id.et_account_starting_balance);
        this.accountCurrentBalanceTextView = v.findViewById(R.id.et_account_current_balance);
        this.checkingRadioButton = v.findViewById(R.id.rb_checking);
        this.savingsRadioButton = v.findViewById(R.id.rb_savings);
        this.accountTypeTextView = v.findViewById(R.id.tv_account_type);
        this.cashTextView = v.findViewById(R.id.tv_cash);

        this.accountStartingBalanceEditText.setText(MoneyFormat.format(account.getStartingBalance()));
        this.accountCurrentBalanceTextView.setText(MoneyFormat.format(this.account.getCurrentBalance()));

        //Cash Account
        if (this.account.equals(AccountCollection.GetCashAccount()))
        {
            this.cashTextView.setVisibility(View.VISIBLE);
            this.accountNameEditText.setVisibility(View.INVISIBLE);
            this.accountNumberEditText.setVisibility(View.INVISIBLE);
            this.checkingRadioButton.setVisibility(View.INVISIBLE);
            this.savingsRadioButton.setVisibility(View.INVISIBLE);
            this.accountTypeTextView.setVisibility(View.INVISIBLE);
        }
        //Any other account
        else
        {
            this.cashTextView.setVisibility(View.INVISIBLE);
            this.accountNameEditText.setVisibility(View.VISIBLE);
            this.accountNumberEditText.setVisibility(View.VISIBLE);
            this.checkingRadioButton.setVisibility(View.VISIBLE);
            this.savingsRadioButton.setVisibility(View.VISIBLE);
            this.accountTypeTextView.setVisibility(View.VISIBLE);

            //Set Account Name
            this.accountNameEditText.setText(account.getName());
            this.accountNumberEditText.setText(Long.toString(account.getNumber()));

            //Set Account type
            if (account.getType() == AccountModel.CHECKING) {
                this.checkingRadioButton.setChecked(true);
            } else {
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
                public void afterTextChanged(Editable editable) {
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
                public void afterTextChanged(Editable editable) {
                    if (ParseHelper.tryParseLong(editable.toString())) {
                        account.setNumber(Long.parseLong(editable.toString()));
                    } else {
                        account.setNumber(0);
                    }
                }
            });
        }

        this.accountStartingBalanceEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                MoneyFormat.preventExtraDecimalNumbers(editable);
                if (ParseHelper.tryParseDouble(editable.toString())) {
                    account.setStartingBalance(Double.parseDouble(editable.toString()));
                } else {
                    account.setStartingBalance(0);
                }
            }
        });

        this.checkingRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account.setType(AccountModel.CHECKING);
            }
        });
        this.savingsRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account.setType(AccountModel.SAVINGS);
            }
        });

        return v;
    }

    /*isValidAccountName()
    * Ensures Account name is not all white space, non empty and unique
    */
    public boolean isValidAccountName()
    {
        if (AccountCollection.isUniqueAccountName(account.getName(), account.getId()) &&
                !account.getName().equals("") && !ParseHelper.AllWhiteSpace(account.getName()))
        {
            return true;
        }

        return false;
    }
}
