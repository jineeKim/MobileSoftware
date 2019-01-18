package com.sookmyung.r1614223_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    RadioGroup rg;
    int st1, st2, st3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        intent = new Intent(this, SubActivity.class);
        rg = (RadioGroup) findViewById(R.id.rg);

        st1 = 1;
        st2 = 2;
        st3 = 3;

        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rb_1:
                intent.putExtra("area", st1);
                break;

            case R.id.rb_2:
                intent.putExtra("area", st2);
                break;

            case R.id.rb_3:
                intent.putExtra("area", st3);
                break;
        }
        startActivity(intent);
        finish();
    }
}
