package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    LinearLayout LogOut,Home;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        LogOut = findViewById(R.id.LogoutBtn);
        Home = findViewById(R.id.homeBtn);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(ProfileActivity.this);
                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCanceledOnTouchOutside(false);
                dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_bg));
                dialog.show();
                Button dismissBtn,logoutBtn;
                dismissBtn = dialog.findViewById(R.id.btnDialogCancel);
                logoutBtn = dialog.findViewById(R.id.btnDialog);
                dismissBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                logoutBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ProfileActivity.this, "Log out successful", Toast.LENGTH_LONG).show();
//                        Here add the logics to logout the user from the system
                        dialog.dismiss();
                    }
                });
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,ActivityDashboard.class);
                startActivity(intent);
            }
        });

    }
}