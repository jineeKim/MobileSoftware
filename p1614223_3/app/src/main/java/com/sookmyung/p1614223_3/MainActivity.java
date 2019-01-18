package com.sookmyung.p1614223_3;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SingleTouchView drawView;
    private ImageButton currPaint;
    private ImageButton brush_size, cancle;
    public int click = 10, oclick = 10, check = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = (SingleTouchView) findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintLayout.getChildAt(0);
        brush_size = (ImageButton) findViewById(R.id.draw_btn);
        cancle = (ImageButton) findViewById(R.id.erase_btn);


        brush_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check+=5;
                drawView.setCurrentWidth(check);
//                Toast.makeText(MainActivity.this, "클릭 값"+check, Toast.LENGTH_SHORT).show();

            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawView.clear();

            }
        });
    }

    public void clicked(View view) {
        if (view != currPaint) {
            String color = view.getTag().toString();
            drawView.setColor(color);
            currPaint = (ImageButton) view;
        }
    }
}
