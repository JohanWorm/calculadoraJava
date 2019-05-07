package com.example.calculadora;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView displayValue, displayOperation;
    public String stringValueOne, stringValueTwo;
    public double valueTotal;
    public int actionOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stringValueOne = "";
        this.stringValueTwo = "";
        this.actionOperation = 0;
        displayValue = (TextView) findViewById(R.id.Resultado);
        displayOperation = (TextView) findViewById(R.id.Operacion);
    }

    public void buttonActionOne(View view) {
        this.addValue("1");
    }

    public void buttonActionTwo(View view) {
        this.addValue("2");
    }

    public void buttonActionThree(View view) {
        this.addValue("3");
    }

    public void buttonActionFour(View view) {
        this.addValue("4");
    }

    public void buttonActionFive(View view) {
        this.addValue("5");
    }

    public void buttonActionSix(View view) {
        this.addValue("6");
    }

    public void buttonActionSeven(View view) {
        this.addValue("7");
    }

    public void buttonActionEight(View view) {
        this.addValue("8");
    }

    public void buttonActionNine(View view) {
        this.addValue("9");
    }

    public void buttonActionZero(View view) {
        this.addValue("0");
    }

    public void buttonActionEqual(View view) {
        this.setValueTwo();
    }

    public void buttonActionErase(View view) {
        displayValue.setText("");
        displayOperation.setText("");
    }

    public void buttonActionAddition(View view) {
        this.actionOperation = 1;
        this.setValueOne();
    }

    public void buttonActionSubtraction(View view) {
        this.actionOperation = 2;
        this.setValueOne();
    }

    public void buttonActionMultiplication(View view) {
        this.actionOperation = 3;
        this.setValueOne();
    }

    public void buttonActionDivision(View view) {
        this.actionOperation = 4;
        this.setValueOne();
    }

    public void addValue(String value) {
        String actualValue = displayValue.getText().toString();

        actualValue = actualValue + value;

        displayValue.setText(actualValue);
    }

    public void setValueOne() {
        try {
            this.stringValueOne = displayValue.getText().toString();
            displayValue.setText("");
            displayOperation.setText(this.stringValueOne + " " + this.getOperator() + " ");
        } catch (NumberFormatException nfe) {
        }
    }

    public void setValueTwo() {
        try {
            this.stringValueTwo = displayValue.getText().toString();
            displayValue.setText("");
            displayOperation.setText(this.stringValueOne + " " + this.getOperator() + " " + this.stringValueTwo);
            this.calculateTotal();
        } catch (NumberFormatException nfe) {
        }
    }

    public String getOperator(){
        String operatorString = "";
        switch (this.actionOperation) {
            case 1: {
                operatorString = "+";
            }
            case 2: {
                operatorString = "-";
                break;
            }
            case 3: {
                operatorString = "*";
                break;
            }case 4: {
                operatorString = "/";
                break;
            }
        }

        return operatorString;
    }

    public void calculateTotal(){
        double valueOne = Double.parseDouble(this.stringValueOne);
        double valueTwo = Double.parseDouble(this.stringValueTwo);
        switch (this.actionOperation) {
            case 1: {
               this.valueTotal = valueOne + valueTwo;
                break;
            }
            case 2: {
                this.valueTotal = valueOne - valueTwo;
                break;
            }
            case 3: {
                this.valueTotal = valueOne * valueTwo;
                break;
            }
            case 4: {
                this.valueTotal = valueOne / valueTwo;
                break;
            }
        }
        this.displayValue.setText(String.valueOf(this.valueTotal));
    }

}
