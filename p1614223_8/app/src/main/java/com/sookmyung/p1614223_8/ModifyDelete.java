package com.sookmyung.p1614223_8;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyDelete extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText name, tel, birth;
    Cursor cursor;
    Button update, delete;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_delete);

        name = (EditText) findViewById(R.id.et_md_name);
        tel = (EditText) findViewById(R.id.et_md_phone);
        birth = (EditText) findViewById(R.id.et_md_birthday);

        update = (Button) findViewById(R.id.btn_modify);
        delete = (Button) findViewById(R.id.btn_delete);

        helper = new DBHelper(this);
        db = helper.getWritableDatabase();

        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        Log.d("logggggggggg", "int" + id);

        cursor = db.rawQuery("SELECT* FROM contacts WHERE _id='"
                + id + "';", null);

        cursor.moveToFirst();

        String st_name = cursor.getString(1);
        String st_tel = cursor.getString(2);
        String st_birth = cursor.getString(3);

        name.setText(st_name);
        tel.setText(st_tel);
        birth.setText(st_birth);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContacts(id, name.getText().toString(), tel.getText().toString(), birth.getText().toString());

                Toast.makeText(getApplicationContext(), "성공적으로 수정 되었음", Toast.LENGTH_SHORT).show();
                name.setText("");
                tel.setText("");
                birth.setText("");

                Intent intent = new Intent(v.getContext(), ListFriend.class);
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteContacts(id);

                Toast.makeText(getApplicationContext(), "성공적으로 삭제 되었음", Toast.LENGTH_SHORT).show();
                name.setText("");
                tel.setText("");
                birth.setText("");

                Intent intent = new Intent(v.getContext(), ListFriend.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public boolean updateContacts(Integer id, String name, String tel, String birth) {
        db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("tel", tel);
        contentValues.put("birth", birth);
        db.update("contacts", contentValues, "_id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteContacts(Integer id) {
        db = helper.getWritableDatabase();
        return db.delete("contacts",
                "_id = ? ",
                new String[]{Integer.toString(id)});
    }
}
