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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button loginBt;
    TextView forgotpass, signup;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBt = findViewById(R.id.loginButton);
        forgotpass = findViewById(R.id.forgotPassword);
        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        signup = findViewById(R.id.signupButton);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassActivity.class);
                startActivity(intent);
            }
        });

        ProgressDialog loginProgress = new ProgressDialog(LoginActivity.this);
        loginProgress.setCanceledOnTouchOutside(false);
        loginProgress.setMessage("Logging you in. Please wait ....");

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail, Password;
                userEmail = email.getText().toString();
                Password = password.getText().toString();
                loginProgress.show();

                if (userEmail.equals("jalikoa@gmail.com") && Password.equals("jalikoa")) {
                    loginProgress.dismiss();
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ActivityDashboard.class);
                    startActivity(intent);
                } else if (userEmail.equals("admin@demo.com") && Password.equals("admin")) {
                    loginProgress.dismiss();
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AdminHome.class);
                    startActivity(intent);
                } else {
                    String url = "https://25fb-197-136-187-86.ngrok-free.app/fgi/public/index.php";
                    StringRequest loginReq = new StringRequest(Request.Method.POST, url, response -> {
                        loginProgress.dismiss();
                        Log.d("ReqRes", response);
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            String message = jsonResponse.getString("message");

                            if (success) {
                                String auth = jsonResponse.getString("auth");
                                String role = jsonResponse.getString("role");

                                // Show a success dialog
                                new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this)
                                        .setTitle("Login Successful")
                                        .setMessage("Welcome! Your role is: " + role)
                                        .setPositiveButton("OK", (dialog, which) -> {
                                            Intent intent = new Intent(LoginActivity.this, ActivityDashboard.class);
                                            intent.putExtra("auth", auth);
                                            intent.putExtra("role", role);
                                            startActivity(intent);
                                        })
                                        .show();
                            } else {
                                // Show an error dialog
                                new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this)
                                        .setTitle("Login Failed")
                                        .setMessage(message)
                                        .setPositiveButton("OK", null)
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this)
                                    .setTitle("Error")
                                    .setMessage("An error occurred while processing your request. Please try again.")
                                    .setPositiveButton("OK", null)
                                    .show();
                        }
                    }, error -> {
                        loginProgress.dismiss();
                        Log.d("ErrorMess", "Error: "+error.getMessage());
                        Toast.makeText(LoginActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_LONG).show();
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("useremail", userEmail);
                            params.put("login", "true");
                            params.put("userpassword", Password);
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
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
