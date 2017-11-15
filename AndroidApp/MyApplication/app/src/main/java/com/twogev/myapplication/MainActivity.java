package com.twogev.myapplication;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {
    SQLiteOpenHelper

    public Button save, load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.button);
        load = (Button) findViewById(R.id.button2);
        save.setOnClickListener(save_1);
        load.setOnClickListener(save_1);
        dbHelper =

    }


    public View.OnClickListener save_1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues a = new ContentValues();

        }
    };

}
