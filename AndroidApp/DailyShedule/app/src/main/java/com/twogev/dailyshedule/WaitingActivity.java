package com.twogev.dailyshedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Process;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
//import android.support.design.widget.BaseTransientBottomBar;
import java.lang.Object;
//import android.support.design.widget.Snackbar;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class WaitingActivity extends AppCompatActivity {

    String accessCode = "d3J5s66G";
    TextView text;
    int type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiting_activity);

        getSupportActionBar().hide();

        ProgressBar spinner = (ProgressBar) findViewById(R.id.progress_waiting);
        spinner.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), android.graphics.PorterDuff.Mode.MULTIPLY);

        Intent intent = getIntent();

        TextView text = (TextView)findViewById(R.id.text_waiting);
        if(!intent.getBooleanExtra("Type", false))
        {
            text.setText("Wait a moment");
            type = 0;
            try {
                String key = URLEncoder.encode(accessCode, "UTF-8");
                String email = URLEncoder.encode(intent.getStringExtra("Email"), "UTF-8");
                String password = URLEncoder.encode(intent.getStringExtra("Password"), "UTF-8");
                new SendRequestTask().execute("https://daytalk.000webhostapp.com/sign_in.php?key=" + key + "&email=" + email + "&password=" + password);
            } catch (UnsupportedEncodingException e) {
            }
        }else
        {
            type = 1;
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

            int res = -1;
            try{res = Integer.parseInt(result); } catch (Exception e){}

            Intent intent = new Intent();
            if(type == 0)
            {
                switch(res)
                {
                    case(0):
                        result = "Success connect";
                        break;
                    case(1):
                        result = "This user not registered. You can create account now!";
                        break;
                    case(2):
                        result = "Can't connect. Wrong password or email";
                        break;
                    case(3):
                        result = "Can't connect. Wrong password or email";
                        break;
                    default:
                        result = "Some problems with login, try again";
                        break;
                }
            }else if(type == 1)
            {
                switch(res){
                    case(0):
                        result = "Success registration";
                        break;
                    case (1):
                        result = "Some problems with registration, try again";
                        break;
                    case (2):
                        result = "This user already exist";
                        break;
                }
            }


            intent.putExtra("result", result);
            setResult(RESULT_OK, intent);

            closeActivity();
//            snackbar.setDuration(8000); // 8 секунд

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
