package com.tot.dev.dailyschedule;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
