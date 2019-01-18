package com.sookmyung.r1614223_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LevelActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Button btn_1 = (Button) findViewById(R.id.btn_level_enter);
        btn_1.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LevelActivity.this, MainActivity.class);

                EditText et_1 = (EditText) findViewById(R.id.et_element);
                if (et_1 != null)
                    intent.putExtra("contact_element", et_1.getText().toString());

                EditText et_2 = (EditText) findViewById(R.id.et_middle);
                if (et_2 != null)
                    intent.putExtra("contact_middle", et_2.getText().toString());

                EditText et_3 = (EditText) findViewById(R.id.et_high);
                if (et_3 != null)
                    intent.putExtra("contact_high", et_3.getText().toString());

                EditText et_4 = (EditText) findViewById(R.id.et_university);
                if (et_4 != null)
                    intent.putExtra("contact_university", et_4.getText().toString());

                startActivity(intent);
                finish();
            }
        });


    }


}
