package com.example.calculator;

import androidx.annotation.IdRes;
import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_Add, btn_Sub, btn_Mul, btn_Div, btn_Calc, btn_Dec, btn_Clear;
    EditText inputText;
    float value_1,value_2 = -1;
    boolean bool_add,bool_sub,bool_mul,bool_div,bool_func;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.edText1);

        View.OnClickListener numberButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = v.getTag().toString();
                int inputNumber = (Integer.parseInt(inputStr));
                if(value_1 == -1){
                    value_1 = inputNumber;
                    inputText.setText("");
                }else if(value_2==-1){
                    if(bool_func==false){
                        int currInt = (int) value_1;
                        String currValue = String.valueOf(currInt);
                        currValue =  currValue.concat(inputStr);
                        value_1 = Float.valueOf(currValue);
                    }else{
                        value_2 = inputNumber;
                    }

                }else if(value_1!=-1&&value_2!=-1){
                    value_1 = calculate();
                    value_2 = inputNumber;
                }
                inputText.setText(inputText.getText()+""+ inputNumber + "");
            }
        };

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setTag("0");
        btn_1=(Button) findViewById(R.id.btn_1);
        btn_1.setTag("1");
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_2.setTag("2");
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setTag("3");
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_4.setTag("4");
        btn_5=(Button) findViewById(R.id.btn_5);
        btn_5.setTag("5");
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setTag("6");
        btn_7=(Button) findViewById(R.id.btn_7);
        btn_7.setTag("7");
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_8.setTag("8");
        btn_9=(Button) findViewById(R.id.btn_9);
        btn_9.setTag("9");
        btn_0.setOnClickListener(numberButtonListener);
        btn_1.setOnClickListener(numberButtonListener);
        btn_2.setOnClickListener(numberButtonListener);
        btn_3.setOnClickListener(numberButtonListener);
        btn_4.setOnClickListener(numberButtonListener);
        btn_5.setOnClickListener(numberButtonListener);
        btn_6.setOnClickListener(numberButtonListener);
        btn_7.setOnClickListener(numberButtonListener);
        btn_8.setOnClickListener(numberButtonListener);
        btn_9.setOnClickListener(numberButtonListener);

        View.OnClickListener functionButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getTag() + ""){
                    case "add": bool_add = true; bool_sub = false; bool_mul = false; bool_div = false; bool_func=true; inputText.setText(inputText.getText() +" + "); break;
                    case "sub": bool_add = false; bool_sub = true; bool_mul = false; bool_div = false; bool_func=true; inputText.setText(inputText.getText() +" - ");break;
                    case "mul": bool_add = false; bool_sub = false; bool_mul = true; bool_div = false; bool_func=true; inputText.setText(inputText.getText() +" * ");break;
                    case "div": bool_add = false; bool_sub = false; bool_mul = false; bool_div = true; bool_func=true; inputText.setText(inputText.getText() +" / ");break;
                    case "calc": if(value_1!= -1 && value_2!=-1){
                        float returnNumber = calculate();
                        inputText.setText(String.valueOf(returnNumber));
                        value_1 = -1;
                        value_2 = -1;
                        bool_add = false; bool_sub = false; bool_mul = false; bool_div = false; bool_func=false;
                    } break;
                    case "dec":break;
                    case "clear": bool_add = false; bool_sub = false; bool_mul = false; bool_div = false;bool_func=false;  inputText.setText(""); value_1 = -1; value_2 = -1;break;
                }
            }
        };


        btn_Add = (Button) findViewById(R.id.btn_Add);
        btn_Add.setTag("add");
        btn_Sub = (Button) findViewById(R.id.btn_Sub);
        btn_Sub.setTag("sub");
        btn_Mul = (Button) findViewById(R.id.btn_Mul);
        btn_Mul.setTag("mul");
        btn_Div = (Button) findViewById(R.id.btn_Div);
        btn_Div.setTag("div");
        btn_Calc = (Button) findViewById(R.id.btn_Calc);
        btn_Calc.setTag("calc");
        btn_Dec = (Button) findViewById(R.id.btn_Dec);
        btn_Dec.setTag("dec");
        btn_Clear = (Button) findViewById(R.id.btn_Clear);
        btn_Clear.setTag("clear");

        btn_Add.setOnClickListener(functionButtonListener);
        btn_Sub.setOnClickListener(functionButtonListener);
        btn_Mul.setOnClickListener(functionButtonListener);
        btn_Div.setOnClickListener(functionButtonListener);
        btn_Calc.setOnClickListener(functionButtonListener);
        btn_Dec.setOnClickListener(functionButtonListener);
        btn_Clear.setOnClickListener(functionButtonListener);
    }

    private float calculate(){
        if(bool_add){
            return value_1 + value_2;
        }else if(bool_sub){
            return value_1 - value_2;
        }else if(bool_mul){
            return value_1 * value_2;
        }else if(bool_div){
            return value_1 / value_2;
        }
        return 0;
    }
}
