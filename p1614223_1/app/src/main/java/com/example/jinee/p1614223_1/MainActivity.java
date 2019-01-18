package com.example.jinee.p1614223_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.text.TextUtils.split;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, buttonAdd, buttonMul, buttonC, buttonEqual;
    EditText InputEditText, OutputEditText;

    boolean crunchifyAddition, crunchifyMultiplication;
    String text;
    String [] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.btn_0);
        button1 = (Button) findViewById(R.id.btn_1);
        button2 = (Button) findViewById(R.id.btn_2);
        buttonAdd = (Button) findViewById(R.id.btn_plus);
        buttonMul = (Button) findViewById(R.id.btn_muti);
        buttonEqual = (Button) findViewById(R.id.btn_result);
        buttonC = (Button) findViewById(R.id.btn_c);
        InputEditText = (EditText) findViewById(R.id.input_text);
        OutputEditText = (EditText) findViewById(R.id.output);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputEditText.setText(InputEditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputEditText.setText(InputEditText.getText() + "2");
            }
        });


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputEditText.setText(InputEditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (InputEditText == null) {
                    InputEditText.setText("");
                } else {
                    InputEditText.setText(InputEditText.getText() + "+");
                    crunchifyAddition = true;
                }
            }
        });


        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (InputEditText == null) {
                    InputEditText.setText("");
                } else {
                    crunchifyMultiplication = true;
                    InputEditText.setText(InputEditText.getText() + "*");
                }
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text = String.valueOf(InputEditText.getText() + "");
                arr = text.split("\\+|\\*");

                for (int i = 0; i<arr.length; i++)
                {
                    System.out.println("token = " + arr[i]);
                }


                if (crunchifyAddition == true) {
                    OutputEditText.setText(Integer.valueOf(arr[0],3) + Integer.valueOf(arr[1],3) + "");
                    crunchifyAddition = false;
                }


                if (crunchifyMultiplication == true) {
                    OutputEditText.setText(Integer.valueOf(arr[0],3) * Integer.valueOf(arr[1],3) + "");
                    crunchifyMultiplication = false;
                }

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputEditText.setText("");
                OutputEditText.setText("");
                crunchifyAddition = false;
                crunchifyMultiplication = false;
            }
        });

    }

}
