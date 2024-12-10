package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button signupBtn;
    TextView login;
    EditText firstname,lastname,username,phone,email,country,setPass,verPass,userBio;
    String firstName,lastName,userName,userPhone,userConutry,userEmail,userSetPass,userVerPass,bioUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login = findViewById(R.id.loginText);
        signupBtn = findViewById(R.id.SignupButton);
        signupBtn.animate();
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        username = findViewById(R.id.userName);
        phone = findViewById(R.id.phone);
//        email = findViewById(R.id.useremail);
        country = findViewById(R.id.country);
        setPass = findViewById(R.id.setPassword);
        verPass = findViewById(R.id.password);
        userBio = findViewById(R.id.bio);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog signupDialog = new ProgressDialog(RegisterActivity.this);
                signupDialog.setMessage("Please wait as we register you please!");
                signupDialog.setCanceledOnTouchOutside(false);
                signupDialog.show();
                firstName = firstname.getText().toString();
                lastName = lastname.getText().toString();
                userName = username.getText().toString();
                userPhone = phone.getText().toString();
                userConutry = country.getText().toString();
                bioUser = userBio.getText().toString();
                userSetPass= setPass.getText().toString();
                userVerPass = verPass.getText().toString();
                if(firstName.equals("") || lastName.equals("") || userName.equals("") || userPhone.equals("") || userConutry.equals("") || bioUser.equals("") || userSetPass.equals("") || userVerPass.equals("")){
                    Dialog dialog = new Dialog(RegisterActivity.this);
                    dialog.setContentView(R.layout.dialog);
                    TextView title = dialog.findViewById(R.id.dialogTitle);
                    title.setText("Error:");
                    title.setTextSize(18);
                    TextView dialogMessage = dialog.findViewById(R.id.textView3);
                    dialogMessage.setText("Make sure that all the fields are filled before submit");
                    Button cancelbtn,dismissBtn;
                    cancelbtn = dialog.findViewById(R.id.btnDialogCancel);
                    cancelbtn.setText("Ok");
                    dismissBtn = dialog.findViewById(R.id.btnDialog);
                    dismissBtn.setText("I know");
                    dismissBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    cancelbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_bg));
                    signupDialog.dismiss();
                    dialog.show();
                } else {
                    String url = "http://localhost/fgi/public/index.php";
                    StringRequest registerRequest = new StringRequest(Request.Method.POST,url,response ->{ Log.d("string_response", "Connection success");},error -> {signupDialog.dismiss(); Toast.makeText(RegisterActivity.this,"Sorry there was an error try again later",Toast.LENGTH_LONG).show();}){
                      @Override
                        protected Map<String,String> getParams() throws AuthFailureError {
                          Map<String ,String> params = new HashMap<>();
                          params.put("firstname",firstName);
                          params.put("lastname",lastName);
                          params.put("username",userName);
                          params.put("userphone",userPhone);
                          params.put("usercountry",userConutry);
                          params.put("userbio",bioUser);
                          params.put("userpassword",userSetPass);
                          return params;
                      }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
                    requestQueue.add(registerRequest);
                }
            }
        });

    }
}