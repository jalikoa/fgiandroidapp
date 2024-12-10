package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OtpActivity extends AppCompatActivity {
    Button verifyOtp;
    TextView nocode,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        nocode = findViewById(R.id.noCode);
        login = findViewById(R.id.loginText);
        verifyOtp = findViewById(R.id.verifyButton);
        nocode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast toast = Toast.makeText(OtpActivity.this,"Requesting new code please check you email again please",Toast.LENGTH_LONG);
                toast.show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}