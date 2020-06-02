package com.example.emi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static com.example.emi_calc.R.id.monthly_payment_result;

public class MainActivity extends AppCompatActivity {
private EditText mLoanAmount, mInterestRate, mLoanPeriod;
private TextView mMonthlyPaymentResult, mTotalPaymentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoanAmount=(EditText)findViewById(R.id.loan_amount);
        mInterestRate=(EditText)findViewById(R.id.interest_rate);
        mLoanPeriod=(EditText)findViewById(R.id.loan_period);
        mMonthlyPaymentResult=(TextView) findViewById(monthly_payment_result);
        mTotalPaymentResult=(TextView) findViewById(R.id.total_payments_result);
    }
    public void showLoanPayments(View ClickedButton){

        double loanAmount= (Integer.parseInt(mLoanAmount.getText().toString()) );
        double interestRate= (Integer.parseInt(mLoanPeriod.getText().toString()));
        double loanPeriod= Integer.parseInt(mLoanPeriod.getText().toString());
        double r=interestRate/1200;
        double r1= Math.pow(r+1, loanPeriod);

        double monthlyPayment = (double) ((r+(r/(r1-1)))* loanAmount);
        double totalPayment= monthlyPayment * loanPeriod;

        mMonthlyPaymentResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
        mTotalPaymentResult.setText(new DecimalFormat("##.##").format(totalPayment));




    }

}
