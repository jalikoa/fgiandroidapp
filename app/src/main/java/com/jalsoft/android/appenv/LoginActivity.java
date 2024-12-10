package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button loginBt;
    TextView forgotpass,signup;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBt = findViewById(R.id.loginButton);
        forgotpass = findViewById(R.id.forgotPassword);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        signup = findViewById(R.id.signupButton);
        forgotpass.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(LoginActivity.this,ForgotPassActivity.class);
                    startActivity(intent);
                }
        });
        ProgressDialog loginProgress = new ProgressDialog(LoginActivity.this);
        loginProgress.setCanceledOnTouchOutside(false);
        loginProgress.setMessage("Logging you in.Please wait ....");

        loginBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userEmail,Password;
                userEmail = email.getText().toString();
                Password = password.getText().toString();
                loginProgress.show();
                if(userEmail.equals("jalikoa@gmail.com") && Password.equals("jalikoa")){
                    loginProgress.dismiss();
                    Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ActivityDashboard.class);
                    startActivity(intent);
                }
                    if(userEmail.equals("admin@demo.com") && Password.equals("admin")){
                        loginProgress.dismiss();
                        Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, AdminHome.class);
                        startActivity(intent);
                    }
                    else {
                        String url = "http://localhost/fgi/public/index.php";
                        StringRequest loginReq = new StringRequest(Request.Method.POST,url,response -> {

                        },error ->{ Toast.makeText(LoginActivity.this, "An error occurred while loging you in try again later", Toast.LENGTH_LONG).show();
                        loginProgress.dismiss();}){

                            @Override
                            protected Map<String,String> getParams() throws AuthFailureError {
                                Map<String,String> params = new HashMap<>();
                                params.put("useremail",userEmail);
                                params.put("userpasword",Password);
                                return params;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                        requestQueue.add(loginReq);
                        Log.d("string_response", loginReq.toString());
                    }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}