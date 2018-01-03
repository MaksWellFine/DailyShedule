package com.twogev.dailyshedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WriteCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_code_activity);

        ((TextView)findViewById(R.id.CodeActivity_inftext)).setText(
            "Success registration. Now, please, confirm you account by write 4-numbers code from you email");
    }
}
