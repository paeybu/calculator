package com.kabu.kabi.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mButtonC, mButtonSwitch, mButtonDivide, mButtonPercent, mButton7, mButton8, mButton9,
            mButtonX, mButton4, mButton5, mButton6, mButtonMinus, mButton1, mButton2, mButton3, mButtonPlus,
            mButton0, mButtonDot, mButtonEqual;
    private TextView resultTv;
    private double mResult;
    private String mLeft, mRight, mOperator;
    private double mDoubleLeft, mDoubleRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
        resultTv = findViewById(R.id.tvResult);
    }

    private void setupButtons() {
        mButton7 = findViewById(R.id.Button7);
        mButton8 = findViewById(R.id.Button8);
        mButton9 = findViewById(R.id.Button9);
        mButton4 = findViewById(R.id.Button4);
        mButton5 = findViewById(R.id.Button5);
        mButton6 = findViewById(R.id.Button6);
        mButton1 = findViewById(R.id.Button1);
        mButton2 = findViewById(R.id.Button2);
        mButton3 = findViewById(R.id.Button3);
        mButton0 = findViewById(R.id.Button0);

        mButtonC = findViewById(R.id.ButtonC);
        mButtonSwitch = findViewById(R.id.ButtonSwitch);
        mButtonDivide = findViewById(R.id.ButtonDivide);
        mButtonPercent = findViewById(R.id.ButtonPercent);
        mButtonX = findViewById(R.id.ButtonX);
        mButtonMinus = findViewById(R.id.ButtonMinus);
        mButtonPlus = findViewById(R.id.ButtonPlus);
        mButtonDot = findViewById(R.id.ButtonDot);
        mButtonEqual = findViewById(R.id.ButtonEqual);

        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton0.setOnClickListener(this);

        mButtonC.setOnClickListener(this);
        mButtonSwitch.setOnClickListener(this);
        mButtonDivide.setOnClickListener(this);
        mButtonPercent.setOnClickListener(this);
        mButtonX.setOnClickListener(this);
        mButtonMinus.setOnClickListener(this);
        mButtonPlus.setOnClickListener(this);
        mButtonDot.setOnClickListener(this);
        mButtonEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button7:
                resultTv.append("7");
                break;
            case R.id.Button8:
                resultTv.append("8");
                break;
            case R.id.Button9:
                resultTv.append("9");
                break;
            case R.id.Button4:
                resultTv.append("4");
                break;
            case R.id.Button5:
                resultTv.append("5");
                break;
            case R.id.Button6:
                resultTv.append("6");
                break;
            case R.id.Button1:
                resultTv.append("1");
                break;
            case R.id.Button2:
                resultTv.append("2");
                break;
            case R.id.Button3:
                resultTv.append("3");
                break;
            case R.id.Button0:
                if (resultTv.getText().length() != 0) {
                    resultTv.append("0");
                }
                break;
            case R.id.ButtonC:
                resultTv.setText("");
                mResult = 0;
                break;
            case R.id.ButtonPlus:
                resultTv.append("+");
                break;
            case R.id.ButtonMinus:
                resultTv.append("-");
                break;
            case R.id.ButtonX:
                resultTv.append("x");
                break;
            case R.id.ButtonDivide:
                resultTv.append("/");
                break;
            case R.id.ButtonDot:
                resultTv.append(".");
                break;
            case R.id.ButtonEqual:
                String result = resultTv.getText().toString();
                if (result.contains("+")) {
                    getLeftRightOperator(result, "+");
                    mResult = mDoubleLeft + mDoubleRight;
                    resultTv.setText("" + mResult);
                }
                else if (result.contains("-")) {
                    getLeftRightOperator(result, "-");
                    mResult = mDoubleLeft - mDoubleRight;
                    resultTv.setText("" + mResult);
                }
                else if (result.contains("x")) {
                    getLeftRightOperator(result, "x");
                    mResult = mDoubleLeft * mDoubleRight;
                    resultTv.setText("" + mResult);
                }
                else if (result.contains("/")) {
                    getLeftRightOperator(result, "/");
                    mResult = mDoubleLeft / mDoubleRight;
                    resultTv.setText("" + mResult);
                }

            default:
                break;
        }
    }

    private void getLeftRightOperator(String result, String operator) {
        int position = result.indexOf(operator);
        mLeft = result.substring(0, position);
        mRight = result.substring(position + 1, result.length());
        mDoubleLeft = Double.parseDouble(mLeft);
        mDoubleRight = Double.parseDouble(mRight);
        mOperator = result.substring(position, position + 1);
        Log.d(TAG, "Left = " + mLeft);
        Log.d(TAG, "Right = " + mRight);
        Log.d(TAG, "Op = " + mOperator);
    }
}
