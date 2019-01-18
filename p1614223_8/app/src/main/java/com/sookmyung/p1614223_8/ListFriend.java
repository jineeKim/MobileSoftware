package com.sookmyung.p1614223_8;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFriend extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        helper = new DBHelper(this);
        db = helper.getWritableDatabase();

        cursor = db.rawQuery("SELECT * FROM contacts", null);
        startManagingCursor(cursor);
        String[] from = {"name", "tel", "birth"};
        int[] to = {R.id.tv_name, R.id.tv_tel, R.id.tv_birth};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.friend_list, cursor, from, to);

        final ListView list = (ListView) findViewById(R.id.lv_friend);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                int i = cursor.getInt(0);
                Log.d("logggggggggg","List_int"+i);
                Intent intent = new Intent(getApplicationContext(), ModifyDelete.class);
                intent.putExtra("id", i);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
