package com.sookmyung.p1614223_8;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddFriend extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel, edit_birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
        edit_name = (EditText) findViewById(R.id.et_name);
        edit_tel = (EditText) findViewById(R.id.et_phone);
        edit_birth = (EditText) findViewById(R.id.et_birthday);
    }

    public void insert(View target) {
        String name = edit_name.getText().toString();
        String tel = edit_tel.getText().toString();
        String birth = edit_birth.getText().toString();

        db.execSQL("INSERT INTO contacts (name,tel,birth) VALUES ('" + name + "', '" + tel
                + "', '" + birth + "');");

        Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
        edit_name.setText("");
        edit_tel.setText("");
        edit_birth.setText("");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
