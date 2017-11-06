/*<uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.READ_PROFILE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.INTERNET"></uses-permission>*/


package com.twogev.dailyshedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SignInActivity extends AppCompatActivity {

    EditText edit_login;
    TextView text_login;

    EditText edit_password;
    TextView text_password;

    Intent registerA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_window);
        getSupportActionBar().hide();

        Button but_log_in = (Button) findViewById(R.id.but_log_in);
        but_log_in.setOnClickListener(but_log_in_Click);

        Button but_register = (Button) findViewById(R.id.but_register);
        but_register.setOnClickListener(but_register_Click);

        edit_login = (EditText)findViewById(R.id.edit_login);
        text_login = (TextView)findViewById(R.id.text_login);

        edit_password = (EditText)findViewById(R.id.edit_password);
        text_password = (TextView)findViewById(R.id.text_password);

        registerA = new Intent(this, RegisterActivity.class);
//        edit_password.setOnTouchListener(new_text_password);
//
//        edit_login.setOnTouchListener(new_text_login);

        registerA = new Intent(this, RegisterActivity.class);
    }

//    Intent intent1;
//    private View.OnTouchListener new_text_password = new View.OnTouchListener()
//    {
//
//
//        public boolean onTouch(View v) {
//            TextView text_password = (TextView)findViewById(R.id.text_password);
//            text_password.setText("Password");
//            text_password.setTextColor(0xFF666666);
//            return false;
//        }
//    };
//
//
//
//    private View.OnTouchListener new_text_login = new View.OnTouchListener()
//    {
//
//
//        public boolean onTouch(View v) {
//            TextView text_login = (TextView)findViewById(R.id.text_login);
//            text_login.setText("Login (email)");
//            text_login.setTextColor(0xFF666666);
//            return false;
//        }
//    };



    private SearchView.OnClickListener but_log_in_Click = new SearchView.OnClickListener()
    {
        public void onClick(View v)
        {
            boolean incorectInput = false;
            switch (check_login(edit_login.getText().toString()))
            {
                case (0):
                    text_login.setTextColor(0xFF666666);
                    text_login.setText("Login (email)");
                    break;
                case (1):
                    text_login.setTextColor(Color.RED);
                    text_login.setText("Incorect email address");
                    incorectInput = true;
                    break;
                case (2):
                    text_login.setTextColor(Color.RED);
                    text_login.setText("Write your email");
                    incorectInput = true;
                    break;
            }

            switch (check_password(edit_password.getText().toString()))
            {
                case (0):
                    text_password.setTextColor(0xFF666666);
                    text_password.setText("Password");
                    break;
                case (1):
                    text_password.setTextColor(Color.RED);
                    text_password.setText("Write your password");
                    incorectInput = true;
                    break;
                case (2):
                    text_password.setTextColor(Color.RED);
                    text_password.setText("Too short password");
                    incorectInput = true;
                    break;
            }

            if(incorectInput) return;

            //SendRequest();
            ShowWaitingActivity();
            //ShowMain();
        }
    };

    private void ShowWaitingActivity()
    {
        Intent waitingA = new Intent(this, WaitingActivity.class);
        //waitingA.putExtra("Parent", this.getClass());
        waitingA.putExtra("Type", 0);
        waitingA.putExtra("Email", edit_login.getText().toString());
        waitingA.putExtra("Password", edit_password.getText().toString());
        startActivity(waitingA);
    }

    private int check_login(String s)
    {
        byte i = 0;
        if(!s.contains("@")) i = 1;
        if(!(s.length() > 0)) i = 2;
        return i;
    }

    private int check_password(String s)
    {
        byte i = 0;
        if(!(s.length() >= 8)) i = 2;
        if(!(s.length() > 0)) i = 1;
        return i;
    }

    private SearchView.OnClickListener but_register_Click = new SearchView.OnClickListener()
    {
        public void onClick(View v)
        {
            startActivity(registerA);
        }
    };

    /*public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == (KeyEvent.KEYCODE_BACK)) {
            //TextView text_login = (TextView)findViewById(R.id.text_login);
            //this.finish();
            //startActivity(intent);
            //android.os.Process.killProcess(android.os.Process.myPid());
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
