package edu.chapman.cpsc356.spendingfriend.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import edu.chapman.cpsc356.spendingfriend.R;
import edu.chapman.cpsc356.spendingfriend.activities.TransactionActivity;
import edu.chapman.cpsc356.spendingfriend.collections.TransactionCollection;
import edu.chapman.cpsc356.spendingfriend.models.TransactionModel;


public class TransactionFragment extends Fragment {

    private TransactionModel transaction;

    private EditText transactionNameEditText;
    private EditText transactionAmountEditText;
    private RadioButton depositRadioButton;
    private RadioButton withdrawalRadioButton;
    private DatePicker transactionDatePicker;
    private EditText accountEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_transaction, container, false);
        String transactionId = getArguments().getString(TransactionActivity.EXTRA_TRANSACTION_ID);
        this.transaction = TransactionCollection.GetInstance().getTransaction(transactionId);

        this.transactionNameEditText = v.findViewById(R.id.et_transaction_name);
        this.transactionNameEditText.setText(transaction.getName());

        this.transactionAmountEditText = v.findViewById(R.id.et_transaction_amount);
        this.transactionAmountEditText.setText(Double.toString(transaction.getAmount()));

        this.depositRadioButton = v.findViewById(R.id.rb_deposit);
        this.withdrawalRadioButton = v.findViewById(R.id.rb_withdrawl);

        if (transaction.isDeposit())
        {
            this.depositRadioButton.setChecked(true);
        }
        else
        {
            this.depositRadioButton.setChecked(false);

        }

        this.transactionDatePicker = v.findViewById(R.id.dp_transaction_date);
        //TODO: Figure out how to get it to display the correct date

        this.accountEditText = v.findViewById(R.id.et_trans_account);
        this.accountEditText.setText(transaction.getAccount().getName());

        return v;
    }
}
