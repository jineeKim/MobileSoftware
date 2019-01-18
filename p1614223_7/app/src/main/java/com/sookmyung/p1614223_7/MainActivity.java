package com.sookmyung.p1614223_7;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_input;
    EditText et_out2;
    EditText et_out3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         et_input = (EditText) findViewById(R.id.et_input);
         et_out2 = (EditText) findViewById(R.id.et_output_2);
         et_out3 = (EditText) findViewById(R.id.et_output_3);

    }


    public void onClick(View v) {

        new Thread(new Runnable() {
            public void run() {

                final String output2= Integer.toBinaryString(Integer.parseInt(et_input.getText().toString()));

                et_out2.post(new Runnable() {
                    public void run() {
                        et_out2.setText(output2);
                    }
                });
            }

        }).start();


        new Thread(new Runnable() {
            public void run() {

                final String output3= Integer.toString(Integer.parseInt(et_input.getText().toString(),3));

                et_out3.post(new Runnable() {
                    public void run() {
                        et_out3.setText(output3);
                    }
                });
            }

        }).start();
    }
}
