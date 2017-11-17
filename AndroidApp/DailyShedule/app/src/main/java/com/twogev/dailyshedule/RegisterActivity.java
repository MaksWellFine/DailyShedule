package com.twogev.dailyshedule;

import android.content.Intent;
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



    private  boolean last_check = true;
    private  boolean first_check = true;
    private  boolean show = false;
    private EditText last_focused_edit;
    private EditText email_text;
    private EditText password_text;
    private EditText name_text;
    private EditText surname_text;
    private EditText check;
    private TextView email ;
    private TextView name;
    private TextView surname;
    private TextView password;
    private   Button register;
    private   Button btn_show_password;



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
        register      = (Button)   findViewById(R.id.button);
        btn_show_password = (Button) findViewById(R.id.button3);

        btn_show_password.setOnClickListener(show_password);

        check = email_text;

        btn_show_password.setOnClickListener(show_password);
        register.setOnClickListener(check_all_and_register);

        name_text.setOnClickListener(check_touch);
        surname_text.setOnClickListener(check_touch);
        password_text.setOnClickListener(check_touch);
        email_text.setOnClickListener(check_touch);

        name_text.setOnFocusChangeListener(check_Focus);
        surname_text.setOnFocusChangeListener(check_Focus);
        password_text.setOnFocusChangeListener(check_Focus);
        email_text.setOnFocusChangeListener(check_Focus);

        email_text    = (EditText) findViewById(R.id.reg_text_emaill);
        email_text.setOnFocusChangeListener(check_Focus);

        //last_focused_edit = email_text;
    }


    private SearchView.OnClickListener check_all_and_register = new SearchView.OnClickListener(){

        @Override
        public void onClick(View v) {
            check_all(v, true);
        }
    };

    private View.OnClickListener check_touch = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            //((EditText)v).setText(((EditText) v).getText() + "0");
            if((EditText)v == last_focused_edit) {
                check_all(v, false);
            }
            last_focused_edit = (EditText)v;
        }


    };

    private View.OnFocusChangeListener check_Focus = new View.OnFocusChangeListener(){

        public void onFocusChange(View v, boolean hasFocus) {

            if(hasFocus){
                //((EditText)v).setText(((EditText) v).getText() + "1");
                if(!first_check)
                    last_focused_edit = (EditText) v;
                else first_check = false;
                //check_all(v, false);
            }else
                check_all(v, false);
        }
    };

    public void check_all(View v, boolean check_1){
        try{
            check = (EditText) v;
        }catch (Exception e){}


        if((check == email_text) || (check_1)) {
            if (!email_text.getText().toString().contains("@")) {
                email.setTextColor(Color.rgb(255, 50, 50));
                email.setText("E-mail   (Incorrect)");
                last_check = false;
            } else {
                email.setTextColor(Color.rgb(50, 220, 50));
                email.setText("E-mail");
            }
        }
        if((check == name_text) || (check_1)) {
            if (!(name_text.getText().toString().length() > 0)) {
                name.setTextColor(Color.rgb(255, 50, 50));
                name.setText("Name  (This is a required field)");
                last_check = false;
            } else {
                name.setTextColor(Color.rgb(50, 255, 50));
                name.setText("Name");
            }
        }
        if((check == surname_text) || check_1) {
            if (!(surname_text.getText().toString().length() > 0)) {
                surname.setTextColor(Color.rgb(255, 50, 50));
                surname.setText("Surname   (This is a required field)");
                last_check = false;
            } else {
                surname.setTextColor(Color.rgb(50, 255, 50));
                surname.setText("Surname");
            }
        }
        if((check == password_text) || check_1) {
            if (!(password_text.getText().toString().length()  > 9)) {
                password.setText("Password   (Too short password)");
                password.setTextColor(Color.rgb(255, 50, 50));
                last_check = false;

            } else {
                password.setTextColor(Color.rgb(50, 255, 50));
                password.setText("Password");

            }
        }
        if(last_check && check_1)
            Reg();
        last_check = true;


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    ShowMessages.ShowSnackbar(findViewById(R.id.register_layout), data.getStringExtra("result"));
            }
        }
    }

    public void Reg(){
        Intent waitingB = new Intent(this, WaitingActivity.class);
        waitingB.putExtra("Type", 1);
        waitingB.putExtra("Email", email_text.getText().toString());
        waitingB.putExtra("Name", name_text.getText().toString()+"&"+surname_text.getText().toString());
        waitingB.putExtra("Password", password_text.getText().toString());
        startActivityForResult(waitingB, 1);
    }



    private SearchView.OnClickListener show_password = new SearchView.OnClickListener(){
        @Override
        public void onClick(View v) {
            show = !show;
            if(show) {
                btn_show_password.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonShowedPassword)));
                password_text.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL | InputType.TYPE_CLASS_TEXT);
                password_text.setSelection(password_text.getText().length());


            }else{
                password_text.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                btn_show_password.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorButtonUnShowedPassword)));
                password_text.setSelection(password_text.getText().length());

            }
        }
    };
}
