package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassActivity extends AppCompatActivity {
    Button requestOtpBt;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
    requestOtpBt = findViewById(R.id.requestCodeButton);
    login = findViewById(R.id.loginText);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ForgotPassActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    });
    requestOtpBt.setOnClickListener(new View.OnClickListener(){
       @Override
       public void onClick(View view){
           Toast toast = Toast.makeText(ForgotPassActivity.this,"An Otp was sent to your email please check your inbox or spam folder",Toast.LENGTH_LONG);
           toast.show();
           Intent intent = new Intent(ForgotPassActivity.this,OtpActivity.class);
           startActivity(intent);
       }

    });
    }
}