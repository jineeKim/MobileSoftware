package com.sookmyung.p1614223_6;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MusicService";
    Button start, stop;
    public Intent intent = null;
    public int m = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.btn_play);
        stop = (Button) findViewById(R.id.btn_stop);

    }

    public void onClick(View v) {

        RadioGroup rg = (RadioGroup) findViewById(R.id.rd_group);
        intent = new Intent(MainActivity.this, MusicService.class);

        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rd_m1:
                m = 1;
                intent.putExtra("rg", m);
                break;

            case R.id.rd_m2:
                m = 2;
                intent.putExtra("rg", m);
                break;

            case R.id.rd_m3:
                m = 3;
                intent.putExtra("rg", m);
                break;
        }


        switch (v.getId()) {
            case R.id.btn_play:
                Log.d(TAG, "onClick() start ");
                startService(intent);
                break;
            case R.id.btn_stop:
                Log.d(TAG, "onClick() stop");
                stopService(new Intent(this, MusicService.class));
                rg.clearCheck();
                break;
        }


    }
}
