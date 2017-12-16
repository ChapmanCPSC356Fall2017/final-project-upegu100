package edu.chapman.cpsc356.spendingfriend.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.joda.time.DateTime;

import edu.chapman.cpsc356.spendingfriend.MoneyFormat;
import edu.chapman.cpsc356.spendingfriend.ParseHelper;
import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.TransactionActivity;
import edu.chapman.cpsc356.spendingfriend.collections.AccountCollection;
import edu.chapman.cpsc356.spendingfriend.collections.TransactionCollection;
import edu.chapman.cpsc356.spendingfriend.models.AccountModel;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;


public class TransactionFragment extends Fragment {

    private TransactionModel transaction;

    private EditText transactionNameEditText;
    private EditText transactionAmountEditText;
    private RadioButton depositRadioButton;
    private RadioButton withdrawalRadioButton;
    private DatePicker transactionDatePicker;
    private EditText accountEditText;

    public TransactionModel getTransaction() {return this.transaction;}

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_transaction, container, false);
        final String transactionId = getArguments().getString(TransactionActivity.EXTRA_TRANSACTION_ID);
        this.transaction = TransactionCollection.GetInstance().getTransaction(transactionId);

        this.transactionNameEditText = v.findViewById(R.id.et_transaction_name);
        this.transactionNameEditText.setText(transaction.getName());

        this.transactionAmountEditText = v.findViewById(R.id.et_transaction_amount);
        this.transactionAmountEditText.setText(MoneyFormat.format(transaction.getAmount()));

        this.depositRadioButton = v.findViewById(R.id.rb_deposit);
        this.withdrawalRadioButton = v.findViewById(R.id.rb_withdrawl);

        if (transaction.isDeposit())
        {
            this.depositRadioButton.setChecked(true);
        }
        else
        {
            this.withdrawalRadioButton.setChecked(true);

        }

        this.transactionDatePicker = v.findViewById(R.id.dp_transaction_date);
        DatePicker.OnDateChangedListener onDateChangedListener = new DatePicker.OnDateChangedListener()
        {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2)
            {
                DateTime date = new DateTime(i, i1+1, i2, 0, 0);
                transaction.setDate(date);
            }
        };
        this.transactionDatePicker.init(transaction.getDate().getYear(),
                transaction.getDate().getMonthOfYear() -1, transaction.getDate().getDayOfMonth(),
                onDateChangedListener);

        this.accountEditText = v.findViewById(R.id.et_trans_account);
        this.accountEditText.setText(transaction.getAccount().getName());

        this.transactionNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                transaction.setName(editable.toString());
            }
        });

        this.transactionAmountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                MoneyFormat.preventExtraDecimalNumbers(editable);
                if (ParseHelper.tryParseDouble(editable.toString()))
                {
                    transaction.setAmount(Double.parseDouble(editable.toString()));
                }
                else
                {
                    transaction.setAmount(0);
                }
            }
        });

        this.depositRadioButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                transaction.setDeposit(true);
            }
        });

        this.withdrawalRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                transaction.setDeposit(false);
            }
        });

        return v;
    }

    public boolean isValidAccountName()
    {
        String accountName = this.accountEditText.getText().toString();
        AccountModel account = AccountCollection.GetInstance().getAccountByName(accountName);
        if (account != null)
        {
            transaction.setAccount(account);
            return true;
        }

        return false;
    }

    public boolean isValidTransactionName()
    {
        if (this.transaction.getName().equals("") || ParseHelper.AllWhiteSpace(transaction.getName()))
        {
            return false;
        }
        return true;
    }

    public boolean isValidTransactionDate()
    {
        if (this.transaction.getDate().getYear() != 2017)
            return false;
        return true;
    }
}
