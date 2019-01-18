package com.sookmyung.p1614223_9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btn;
    public Intent intent = null;
    int m = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_find);
    }

    public void onClick(View v) {

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        intent = new Intent(MainActivity.this, MapsActivity.class);

        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rb_1:
                intent.putExtra("url",
                        "http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?ServiceKey=VZk4EhfOFiAaRhqvId46im%2BuOcPd%2FzIiLaquayzXt6xEWy2G8n4hojoJnJel4KFwlDV5b5988PmYZZTx9mXWQw%3D%3D&busRouteId=100100522");
                break;

            case R.id.rb_2:
                intent.putExtra("url",
                        "http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?ServiceKey=VZk4EhfOFiAaRhqvId46im%2BuOcPd%2FzIiLaquayzXt6xEWy2G8n4hojoJnJel4KFwlDV5b5988PmYZZTx9mXWQw%3D%3D&busRouteId=100100596");
                break;

            case R.id.rb_3:
                m = 3;
                intent.putExtra("url", "http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?ServiceKey=VZk4EhfOFiAaRhqvId46im%2BuOcPd%2FzIiLaquayzXt6xEWy2G8n4hojoJnJel4KFwlDV5b5988PmYZZTx9mXWQw%3D%3D&busRouteId=100100537");
                break;
        }

        startActivity(intent);

    }
}
