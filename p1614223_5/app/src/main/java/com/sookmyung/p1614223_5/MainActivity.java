package com.sookmyung.p1614223_5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public EditText et;
    public String input;
    public Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View v) {
        et = (EditText) findViewById(R.id.et_input);
        input = et.getText().toString();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio);


        switch (rg.getCheckedRadioButtonId()) {
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+input));
                break;

            case R.id.call:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+input));
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }

        rg.clearCheck();
    }


}
