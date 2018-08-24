package com.example.ari.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    private enum Oparators {plus, minus, multiply, divide, equal}

    ;
    private TextView editEquation, editNumber;
    private String currentNumber, numberAtRight, numberAtLeft, currentEquation;
    private long result;
    private Oparators currentOparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        currentEquation = "";
        result = 0;

        editEquation = (TextView) findViewById(R.id.editEquation);
        editNumber = (TextView) findViewById(R.id.editNumber);

        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.equal:
                OparatorTapped(Oparators.equal);
                break;
            case R.id.one:
                NumberTapped("1");
                break;
            case R.id.two:
                NumberTapped("2");
                break;
            case R.id.three:
                NumberTapped("3");
                break;
            case R.id.four:
                NumberTapped("4");
                break;
            case R.id.five:
                NumberTapped("5");
                break;
            case R.id.six:
                NumberTapped("6");
                break;
            case R.id.seven:
                NumberTapped("7");
                break;
            case R.id.eight:
                NumberTapped("8");
                break;
            case R.id.nine:
                NumberTapped("9");
                break;
            case R.id.zero:
                NumberTapped("0");
                break;
            case R.id.plus:
                OparatorTapped(Oparators.plus);
                break;
            case R.id.minus:
                OparatorTapped(Oparators.minus);
                break;
            case R.id.divide:
                OparatorTapped(Oparators.divide);
                break;
            case R.id.multiply:
                OparatorTapped(Oparators.multiply);
                break;
            case R.id.cancel:
                result = 0;
                currentNumber = "";
                currentEquation = "";
                currentOparator = null;
                result = 0;
                editNumber.setText("0");
                editEquation.setText("0");
                break;
        }
    }

    private void NumberTapped(String s) {
        if(currentOparator == Oparators.equal){
            currentOparator = null;
            currentEquation = "";
        }
        currentNumber = currentNumber + s;
        currentEquation = currentEquation + s;
        editEquation.setText(currentEquation);
        editNumber.setText(currentNumber);
    }

    private void OparatorTapped(Oparators oparatorTapped){



            if (currentOparator != null && !numberAtLeft.isEmpty()) {
                if (!currentNumber.isEmpty()) {
                    numberAtRight = currentNumber;
                    currentNumber="";
                    switch (currentOparator) {
                        case plus:
                            result = Long.parseLong(numberAtLeft) + Long.parseLong(numberAtRight);
                            break;
                        case minus:
                            result = Long.parseLong(numberAtLeft) - Long.parseLong(numberAtRight);
                            break;
                        case multiply:
                            result = Long.parseLong(numberAtLeft) * Long.parseLong(numberAtRight);
                            break;
                        case divide:
                            result = Long.parseLong(numberAtLeft) / Long.parseLong(numberAtRight);
                            break;
                    }
                    numberAtLeft = String.valueOf(result);
                    currentEquation = numberAtLeft;
                    editNumber.setText(String.valueOf(result));editEquation.setText(currentEquation);
                }
            }
            else{
                numberAtLeft = currentNumber;
                currentNumber = "";
            }
        if(currentEquation.length() >= 1) {
            if (currentEquation.charAt(currentEquation.length() - 1) == '+'
                    || currentEquation.charAt(currentEquation.length() - 1) == '-'
                    || currentEquation.charAt(currentEquation.length() - 1) == '*'
                    || currentEquation.charAt(currentEquation.length() - 1) == '/') {

                currentEquation = currentEquation.substring(0, currentEquation.length() - 1);
            }

            switch (oparatorTapped) {
                case plus:
                    currentEquation += "+";
                    break;
                case minus:
                    currentEquation += "-";
                    break;
                case multiply:
                    currentEquation += "*";
                    break;
                case divide:
                    currentEquation += "/";
                    break;
            }

            editEquation.setText(currentEquation);
        }
        currentOparator = oparatorTapped;
    }

}
