package com.twogev.dailyshedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class WaitingActivity extends AppCompatActivity {

    String accessCode = "d3J5s66G";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_activity);

        ProgressBar spinner = (ProgressBar) findViewById(R.id.progress_waiting);
        spinner.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), android.graphics.PorterDuff.Mode.MULTIPLY);

        Intent intent = getIntent();

        TextView text = (TextView)findViewById(R.id.text_waiting);
        if(!intent.getBooleanExtra("Type", false))
        {
            text.setText("Wait a moment");
            try {
                String key = URLEncoder.encode(accessCode, "UTF-8");
                String email = URLEncoder.encode(intent.getStringExtra("Email"), "UTF-8");
                String password = URLEncoder.encode(intent.getStringExtra("Password"), "UTF-8");
                new SendRequestTask().execute("https://daytalk.000webhostapp.com/sign_in.php?key=" + key + "&email=" + email + "&password=" + password);
            } catch (UnsupportedEncodingException e) {
            }
        }else
        {
            text.setText("Registering");
            try {
                String key = URLEncoder.encode(accessCode, "UTF-8");
                String name = URLEncoder.encode(intent.getStringExtra("Name"), "UTF-8");
                String email = URLEncoder.encode(intent.getStringExtra("Email"), "UTF-8");
                String password = URLEncoder.encode(intent.getStringExtra("Password"), "UTF-8");
                new SendRequestTask().execute("https://daytalk.000webhostapp.com/sign_up.php?key=" + key + "&name=" + name + "&email=" + email + "&password=" + password);
            } catch (UnsupportedEncodingException e) {
            }
        }
    }



    private void closeActivity(){
        this.finish();
    }

    private void openActivity(){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

    private class SendRequestTask extends AsyncTask<String, Void, String> {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */
        protected String doInBackground(String... urls) {
            return SendRequest(urls[0]);
        }

        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(String result) {
            if(result == "0")
            {
                openActivity();
            }

            //Snackbar snackbar = Snackbar
            //        .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);

            //snackbar.show();/

            closeActivity();
            //Button but_register = (Button) findViewById(R.id.but_register);
            //but_register.setText(result);

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
        }catch (Exception e){SetServerString = "1";}

        return SetServerString;
    }

    public void ShowMain()
    {
        Intent mainA = new Intent(this, Main.class);
        startActivity(mainA);
        this.finish();
    }
}
