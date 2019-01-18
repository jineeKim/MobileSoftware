package com.sookmyung.r1614223_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);

        SharedPreferences test = getSharedPreferences("test", MODE_PRIVATE);

        String element = test.getString("contact_element", "");
        String middle = test.getString("contact_middle", "");
        String high = test.getString("contact_high", "");
        String university = test.getString("contact_university", "");
        Integer image =  test.getInt("image", 0);

        TextView tv_1 = (TextView) findViewById(R.id.tv_element);
        tv_1.setText(element);

        TextView tv_2 = (TextView) findViewById(R.id.tv_middle);
        tv_2.setText(middle);

        TextView tv_3 = (TextView) findViewById(R.id.tv_high);
        tv_3.setText(high);

        TextView tv_4 = (TextView) findViewById(R.id.tv_university);
        tv_4.setText(university);


        ImageView select_image = (ImageView) findViewById(R.id.profile);
        select_image.setImageResource(galleryImageAdapter.mImageIds[image]);

        Button btn_1 = (Button) findViewById(R.id.btn_resume_enter);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
