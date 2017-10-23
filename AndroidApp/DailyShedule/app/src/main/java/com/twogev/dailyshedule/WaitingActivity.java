package com.twogev.dailyshedule;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

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

        Intent intent = getIntent();

        if(!intent.getBooleanExtra("Type", false))
        {
            try {
                String key = URLEncoder.encode(accessCode, "UTF-8");
                String email = URLEncoder.encode(intent.getStringExtra("Email"), "UTF-8");
                String password = URLEncoder.encode(intent.getStringExtra("Password"), "UTF-8");
                new SendRequestTask().execute("https://daytalk.000webhostapp.com/sign_in.php?key=" + key + "&email=" + email + "&password=" + password);
            } catch (UnsupportedEncodingException e) {
            }
        }
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
        Intent mainA = new Intent(this, Main.class);
        startActivity(mainA);
        this.finish();
    }
}
