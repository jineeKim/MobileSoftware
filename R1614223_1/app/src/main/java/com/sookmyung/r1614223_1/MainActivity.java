package com.sookmyung.r1614223_1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_1 = (Button) findViewById(R.id.btn_level);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        LevelActivity.class);
                startActivity(intent);
                finish();
            }

        });


        Button btn_2 = (Button) findViewById(R.id.btn_gallery);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();

                String element = intent.getStringExtra("contact_element");
                String middle = intent.getStringExtra("contact_middle");
                String high = intent.getStringExtra("contact_high");
                String university = intent.getStringExtra("contact_university");


                SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
                SharedPreferences.Editor editor = test.edit();

                editor.putString("contact_element", element);
                editor.putString("contact_middle", middle);
                editor.putString("contact_high", high);
                editor.putString("contact_university", university);
                editor.apply();

                Intent intent1 = new Intent(
                        getApplicationContext(),
                        GalleryActivity.class);
                startActivity(intent1);
                finish();

            }
        });


        Button btn_3 = (Button) findViewById(R.id.btn_resume);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Integer image = intent.getIntExtra("image",0);

                SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);
                SharedPreferences.Editor editor = test.edit();
                editor.putInt("image",image);
                //Log.d(image,"sleepyyyyyyyy");

                editor.apply();

                Intent intent1 = new Intent(
                        getApplicationContext(),
                        ResumeActivity.class);
                startActivity(intent1);
                finish();
            }
        });


    }

}
