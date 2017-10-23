/*<uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.READ_PROFILE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.INTERNET"></uses-permission>*/


package com.twogev.dailyshedule;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.*;
import java.io.*;


public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_window);
        getSupportActionBar().hide();

        Button but_log_in = (Button) findViewById(R.id.but_log_in);
        but_log_in.setOnClickListener(but_log_in_Click);

        Button but_register = (Button) findViewById(R.id.but_register);
        but_register.setOnClickListener(but_register_Click);

        intent = new Intent(this, RegisterActivity.class);
    }

    Intent intent1;

    private SearchView.OnClickListener but_log_in_Click = new SearchView.OnClickListener()
    {
        public void onClick(View v)
        {
            EditText edit_login = (EditText)findViewById(R.id.edit_login);
            TextView text_login = (TextView)findViewById(R.id.text_login);

            EditText edit_password = (EditText)findViewById(R.id.edit_password);
            TextView text_password = (TextView)findViewById(R.id.text_password);
            switch (check_login(edit_login.getText().toString()))
            {
                case (0):
                    text_login.setTextColor(0xFF666666);
                    text_login.setText("Login (email)");
                    break;
                case (1):
                    text_login.setTextColor(Color.RED);
                    text_login.setText("Incorect email address");
                    break;
                case (2):
                    text_login.setTextColor(Color.RED);
                    text_login.setText("Write your email");
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
                    break;
                case (2):
                    text_password.setTextColor(Color.RED);
                    text_password.setText("Too short password");
                    break;
            }

            //SendRequest();
            try {
                String key = URLEncoder.encode("d3J5s66G", "UTF-8");
                String email = URLEncoder.encode(edit_login.getText().toString(), "UTF-8");
                String password = URLEncoder.encode(edit_password.getText().toString(), "UTF-8");
                new DownloadImageTask().execute("https://daytalk.000webhostapp.com/sign_in.php?key="+key+"&email="+email+"&password="+password);
            }catch (UnsupportedEncodingException e){}
            //ShowMain();
        }
    };

    private class DownloadImageTask extends AsyncTask<String, Void, String> {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */
        protected String doInBackground(String... urls) {
            return SendRequest(urls[0]);
        }

        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(String result) {
            Button but_register = (Button) findViewById(R.id.but_register);
            but_register.setText(result);
        }
    }

    public String SendRequest(String urlAddress)
    {
        String SetServerString = "";
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                byte[] mas = new byte[100];
                int len = in.read(mas);
                for (int i = 0; i < len; i++)
                {
                   SetServerString += (char)mas[i];
                }
            } finally {
                urlConnection.disconnect();
            }
        }catch (Exception e){SetServerString = "Fail";}

        return SetServerString;
    }

    public void ShowMain()
    {
        intent1 = new Intent(this, Main.class);
        startActivity(intent1);
        this.finish();
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

    Intent intent;

    private SearchView.OnClickListener but_register_Click = new SearchView.OnClickListener()
    {
        public void onClick(View v)
        {
            startActivity(intent);
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
