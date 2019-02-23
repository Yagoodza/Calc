package com.example.ayagu.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String VIEW_INDEX = "view";
    private static final String DIGIT1_INDEX = "digit1";
    private static final String DIGIT2_INDEX = "digit2";
    private static final String SIGN_INDEX = "sign";
    private static final String CALC_INDEX = "calc";
    private static final String DOT_INDEX = "dot";
    private static final String DOT_TEN_INDEX = "dotTen";

    private Digits mDigits = new Digits();

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;

    private Button mButtonAdd;
    private Button mButtonSub;
    private Button mButtonResult;
    private Button mButtonMult;
    private Button mButtonDiv;
    private Button mButtonC;
    private Button mButtonChange;
    private Button mButtonDot;

//    private Button mButton;

    private TextView mMainView;

    private double result;
    private double currentView = 0f;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putDouble(VIEW_INDEX, currentView);
        savedInstanceState.putDouble(DIGIT1_INDEX, mDigits.getD1());
        savedInstanceState.putDouble(DIGIT2_INDEX, mDigits.getD2());
        if (!mDigits.isSignNull())
            savedInstanceState.putString(SIGN_INDEX, mDigits.getSign());

        savedInstanceState.putBoolean(CALC_INDEX, mDigits.isCalc());
        savedInstanceState.putInt(DOT_TEN_INDEX,mDigits.getDotTen());
        savedInstanceState.putBoolean(DOT_INDEX, mDigits.isDot());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            currentView = savedInstanceState.getDouble(VIEW_INDEX, 0);
            mDigits.setCalc(savedInstanceState.getBoolean(CALC_INDEX));

//            if (savedInstanceState.containsKey(DIGIT1_INDEX))
                mDigits.setD1(savedInstanceState.getDouble(DIGIT1_INDEX));

//            if (savedInstanceState.containsKey(DIGIT2_INDEX))
                mDigits.setD2(savedInstanceState.getDouble(DIGIT2_INDEX));

//            if (savedInstanceState.containsKey(SIGN_INDEX))
                mDigits.setSign(savedInstanceState.getString(SIGN_INDEX));

//            if (savedInstanceState.containsKey(DOT_INDEX))
            mDigits.setDot(savedInstanceState.getBoolean(DOT_INDEX));

//            if (savedInstanceState.containsKey(DOT_TEN_INDEX))
            mDigits.setDotTen(savedInstanceState.getInt(DOT_TEN_INDEX));

        }

        mMainView = findViewById(R.id.main_view);

        fillView(currentView);

        mButton0 = findViewById(R.id.button_0);
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterDigits(0f);

            }
        });

        mButton1 = findViewById(R.id.button_1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(1f);
            }
        });

        mButton2 = findViewById(R.id.button_2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(2f);
            }
        });

        mButton3 = findViewById(R.id.button_3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(3f);
            }
        });

        mButton4 = findViewById(R.id.button_4);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(4f);
            }
        });

        mButton5 = findViewById(R.id.button_5);
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(5f);
            }
        });

        mButton6 = findViewById(R.id.button_6);
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(6f);
            }
        });

        mButton7 = findViewById(R.id.button_7);
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(7f);
            }
        });

        mButton8 = findViewById(R.id.button_8);
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(8f);
            }
        });

        mButton9 = findViewById(R.id.button_9);
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(9f);
            }
        });

        mButtonAdd = findViewById(R.id.button_add);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign("+");
            }
        });

        mButtonSub = findViewById(R.id.button_sub);
        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign("-");
            }
        });

        mButtonMult = findViewById(R.id.button_mult);
        mButtonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign("*");
            }
        });

        mButtonDiv = findViewById(R.id.button_div);
        mButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSign("/");
            }
        });

        mButtonC = findViewById(R.id.button_C);
        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        mButtonChange = findViewById(R.id.button_change);
        mButtonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterDigits(-1f);
            }
        });

        mButtonResult = findViewById(R.id.button_result);
        mButtonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
            }
        });
//
//        mButton = findViewById(R.id.button);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println(mDigits.getD1()+ " " + mDigits.getD2());
//            }
//        });


        mButtonDot = findViewById(R.id.button_dot);
        mButtonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDigits.isCalc() && mDigits.isSignNull()) {
                    mDigits.clearD1();
                    fillView(mDigits.getD1());
                    mDigits.setCalc(false);
                }
//                if (mDigits.isCalc() && !mDigits.isSignNull()) {
                if (!mDigits.isSignNull()) {

//                    mDigits.clearD2();
                    fillView(mDigits.getD2());
                    mDigits.setCalc(false);
                }
                if (!mDigits.isDot()) {
                    mDigits.setDot(true);
                    mMainView.append(".");
                }
            }
        });

    }

    private void enterDigits(Float dg){
        if (mDigits.isCalc() && mDigits.isSignNull() && dg != -1) {
            mDigits.clearD1();
        }
        mDigits.setCalc(false);


        if (mDigits.isSignNull()) {

            mDigits.setD1(dg);
            if (mDigits.isDot() && dg == 0)
                mMainView.append("0");
            else
            fillView(mDigits.getD1());
        }
        else {
            mDigits.setD2(dg);
            if (mDigits.isDot() && dg == 0)
                mMainView.append("0");
            else
                fillView(mDigits.getD2());
        }
    }

    private void setSign(String sign){
        if (!mDigits.isSignNull() && !mDigits.isCalc())
            calc();
        mDigits.setSign(sign);
        mDigits.setDot(false);
        mDigits.nullifyDotTen();
    }

    private void calc(){
        if (mDigits.isSignNull() || mDigits.isCalc())
            return;
        switch (mDigits.getSign()){
            case ("+"):
                result = mDigits.getD1() + mDigits.getD2();
                break;
            case ("-"):
                result = mDigits.getD1() - mDigits.getD2();
                break;
            case ("*"):
                result = mDigits.getD1() * mDigits.getD2();
                break;
            case ("/"):
                result = mDigits.getD1() / mDigits.getD2();
                break;

        }
        mDigits.nullifyDotTen();
        mDigits.setDot(false);
        fillView(result);
        mDigits.setCalc(true);
        mDigits.clearD1();
        mDigits.setD1(result);
        mDigits.setSign(null);
        mDigits.clearD2();

    }

    private void fillView(double dg){
        currentView = dg;
        if (dg - ((long) dg) == 0)
            mMainView.setText(String.valueOf((long)currentView));
        else
            mMainView.setText(String.valueOf(currentView));
    }

    private void clear(){
        mDigits = new Digits();
        currentView = 0f;
        fillView(currentView);
    }

}