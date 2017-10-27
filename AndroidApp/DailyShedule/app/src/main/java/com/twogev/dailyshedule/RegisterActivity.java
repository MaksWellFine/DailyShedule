package com.twogev.dailyshedule;

import android.graphics.Color;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    public boolean   show = false;
    public EditText  email_text;
    public EditText  password_text;
    public EditText  name_text;
    public EditText  surname_text;
    public Button    Register;
    public TextView  email ;
    public TextView  name;
    public TextView  surname;
    public TextView  password;

    public ImageView btn_show_password;
    public EditText  check;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_window);
        getSupportActionBar().hide();

        email_text    = (EditText)  findViewById(R.id.reg_text_emaill);
        password_text = (EditText)  findViewById(R.id.reg_text_password);
        name_text     = (EditText)  findViewById(R.id.reg_text_name);
        surname_text  = (EditText)  findViewById(R.id.reg_text_surname);
        Register      = (Button)    findViewById(R.id.button);
        email         = (TextView)  findViewById(R.id.reg_email);
        name          = (TextView)  findViewById(R.id.reg_name);
        surname       = (TextView)  findViewById(R.id.reg_surname);
        password      = (TextView)  findViewById(R.id.reg_password);
        btn_show_password   = (ImageView) findViewById(R.id.imageView2);


        check = email_text;



        btn_show_password.setOnClickListener(show_password);
        Register.setOnClickListener(check_all_and_register);

        email_text.setOnEditorActionListener(check_email);
        name_text.setOnEditorActionListener(check_email);
        surname_text.setOnEditorActionListener(check_email);
        password_text.setOnEditorActionListener(check_email);

        email_text.setOnTouchListener(check1);
        name_text.setOnTouchListener(check1);
        surname_text.setOnTouchListener(check1);
        password_text.setOnTouchListener(check1);
    }


    private SearchView.OnClickListener check_all_and_register = new SearchView.OnClickListener(){

        @Override
        public void onClick(View v) {

            if (!email_text.getText().toString().contains("@")) {
                email.setTextColor(Color.rgb(255, 50, 50));
                email.setText("e-mail   (incorrect)");
            } else {
                email.setTextColor(Color.rgb(50, 220, 50));
                email.setText("e-mail");
            }


            if (!(name_text.getText().toString().length() > 0)) {
                name.setTextColor(Color.rgb(255, 50, 50));
                name.setText("name  (this is a required field)");
            } else {
                name.setTextColor(Color.rgb(50, 255, 50));
                name.setText("name");
            }


            if (!(surname_text.getText().toString().length() > 0)) {
                surname.setTextColor(Color.rgb(255, 50, 50));
                surname.setText("surname   (this is a required field)");
            } else {
                surname.setTextColor(Color.rgb(50, 255, 50));
                surname.setText("surname");
            }

            if (!(password_text.getText().toString().length() > 8)) {
                password.setText("password   (too short password)");
                password.setTextColor(Color.rgb(255, 50, 50));
            } else {
                password.setTextColor(Color.rgb(50, 255, 50));
                password.setText("password");
            }


        }
    };




    private View.OnTouchListener check1 = new View.OnTouchListener(){



        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(check == email_text) {
                if (!check.getText().toString().contains("@")) {
                    email.setTextColor(Color.rgb(255, 50, 50));
                    email.setText("e-mail   (incorrect)");
                } else {
                    email.setTextColor(Color.rgb(50, 220, 50));
                    email.setText("e-mail");
                }
            }
            if(check == name_text) {
                if (!(check.getText().toString().length() > 0)) {
                    name.setTextColor(Color.rgb(255, 50, 50));
                    name.setText("name  (this is a required field)");
                } else {
                    name.setTextColor(Color.rgb(50, 255, 50));
                    name.setText("name");
                }
            }
            if(check == surname_text) {
                if (!(check.getText().toString().length() > 0)) {
                    surname.setTextColor(Color.rgb(255, 50, 50));
                    surname.setText("surname   (this is a required field)");
                } else {
                    surname.setTextColor(Color.rgb(50, 255, 50));
                    surname.setText("surname");
                }
            }
            if(check == password_text) {
                if (!(check.getText().toString().length()  > 8)) {
                    password.setText("password   (too short password)");
                    password.setTextColor(Color.rgb(255, 50, 50));
                } else {
                    password.setTextColor(Color.rgb(50, 255, 50));
                    password.setText("password");
                }
            }


            check = (EditText) v;
            return  false;
        }
    };

    private TextView.OnEditorActionListener check_email = new TextView.OnEditorActionListener(){


        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(v == email_text) {
                if (!v.getText().toString().contains("@")) {
                    email.setTextColor(Color.rgb(255, 50, 50));
                    email.setText("e-mail   (incorrect)");
                } else {
                    email.setTextColor(Color.rgb(50, 220, 50));
                    email.setText("e-mail");
                }
            }
            if(v == name_text) {
                if (!(v.getText().toString().length() > 0)) {
                    name.setTextColor(Color.rgb(255, 50, 50));
                    name.setText("name  (this is a required field)");
                } else {
                    name.setTextColor(Color.rgb(50, 255, 50));
                    name.setText("name");
                }
            }
            if(v == surname_text) {
                if (!(v.getText().toString().length() > 0)) {
                    surname.setTextColor(Color.rgb(255, 50, 50));
                    surname.setText("surname   (this is a required field)");
                } else {
                    surname.setTextColor(Color.rgb(50, 255, 50));
                    surname.setText("surname");
                }
            }
            if(v == password_text) {
                if (!(v.getText().toString().length()  > 8)) {
                    password.setText("password   (too short password)");
                    password.setTextColor(Color.rgb(255, 50, 50));
                } else {
                    password.setTextColor(Color.rgb(50, 255, 50));
                    password.setText("password");
                }
            }


            return false;
        }
    };



    private SearchView.OnClickListener show_password = new SearchView.OnClickListener(){

        @Override
        public void onClick(View v) {


            if(show) {
                password_text.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL | InputType.TYPE_CLASS_TEXT);
            }else{
                password_text.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
            }

        }
    };

}
