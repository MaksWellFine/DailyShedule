package com.twogev.dailyshedule;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.sign_in_window);
        //getSupportActionBar().hide();

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        this.finish();
    }
}
