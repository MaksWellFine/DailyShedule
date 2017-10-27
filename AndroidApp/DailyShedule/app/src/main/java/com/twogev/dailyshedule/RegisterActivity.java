package com.twogev.dailyshedule;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


    public Button    btn_show_password;
    public EditText  check;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_window);
        getSupportActionBar().hide();





        password_text = (EditText) findViewById(R.id.reg_text_password);
        name_text     = (EditText) findViewById(R.id.reg_text_name);
        surname_text  = (EditText) findViewById(R.id.reg_text_surname);
        email         = (TextView) findViewById(R.id.reg_email);
        name          = (TextView) findViewById(R.id.reg_name);
        surname       = (TextView) findViewById(R.id.reg_surname);
        password      = (TextView) findViewById(R.id.reg_password);
        email_text    = (EditText) findViewById(R.id.reg_text_emaill);

        Register      = (Button)   findViewById(R.id.button);
        btn_show_password = (Button) findViewById(R.id.button3);



        btn_show_password.setOnClickListener(show_password);




        check = email_text;



        btn_show_password.setOnClickListener(show_password);
        Register.setOnClickListener(check_all_and_register);

        name_text.setOnTouchListener(check_toush);
        surname_text.setOnTouchListener(check_toush);
        password_text.setOnTouchListener(check_toush);
        email_text.setOnTouchListener(check_toush);

        name_text.setOnFocusChangeListener(check_Focus);
        surname_text.setOnFocusChangeListener(check_Focus);
        password_text.setOnFocusChangeListener(check_Focus);
        email_text.setOnFocusChangeListener(check_Focus);
        email_text    = (EditText) findViewById(R.id.reg_text_emaill);
        email_text.setOnFocusChangeListener(check_Focus);
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
                name.setTextColor(Color.rgb(50, 220, 50));
                name.setText("name");
            }


            if (!(surname_text.getText().toString().length() > 0)) {
                surname.setTextColor(Color.rgb(255, 50, 50));
                surname.setText("surname   (this is a required field)");
            } else {
                surname.setTextColor(Color.rgb(50, 220, 50));
                surname.setText("surname");
            }

            if (!(password_text.getText().toString().length() > 8)) {
                password.setText("password   (too short password)");
                password.setTextColor(Color.rgb(255, 50, 50));
            } else {
                password.setTextColor(Color.rgb(50, 220, 50));
                password.setText("password");
            }


        }
    };




    private View.OnTouchListener check_toush = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(v.isFocused())
                check_all(v);
            return false;
        }


    };

    private View.OnFocusChangeListener check_Focus = new View.OnFocusChangeListener(){

        public void onFocusChange(View v, boolean hasFocus) {

            if(!hasFocus){
                check_all(v);
            }

        }
    };

    public void check_all(View v){
        check = (EditText) v;


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



    }




    private SearchView.OnClickListener show_password = new SearchView.OnClickListener(){
        @Override
        public void onClick(View v) {
            show = !show;
            if(show) {
                btn_show_password.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
                password_text.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL | InputType.TYPE_CLASS_TEXT);
                password_text.setSelection(password_text.getText().length());


            }else{
                password_text.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                btn_show_password.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButton)));
                password_text.setSelection(password_text.getText().length());

            }
        }
    };
}
