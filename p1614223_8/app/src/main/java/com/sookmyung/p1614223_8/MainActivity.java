package com.sookmyung.p1614223_8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_list:
                Intent intent = new Intent(MainActivity.this,ListFriend.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_add:
                Intent intent2 = new Intent(MainActivity.this,AddFriend.class);
                startActivity(intent2);
                finish();
                break;
        }

    }
}
