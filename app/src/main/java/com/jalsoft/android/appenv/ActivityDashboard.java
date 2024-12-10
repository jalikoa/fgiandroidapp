package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivityDashboard extends AppCompatActivity {
    LinearLayout LogOut,Profile;
    Dialog dialog;
    CardView reportCard,carbonCard,educationCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        reportCard = findViewById(R.id.reportCard);
        carbonCard = findViewById(R.id.carbonCard);
        educationCard = findViewById(R.id.education);
        LogOut = findViewById(R.id.LogoutBtn);
        Profile = findViewById(R.id.ProfileBtn);
        reportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDashboard.this,ReportsActivity.class);
                startActivity(intent);
            }
        });
        educationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDashboard.this,LearnActivity.class);
                startActivity(intent);
            }
        });
        carbonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDashboard.this,CarbonActivity.class);
                startActivity(intent);
            }
        });
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(ActivityDashboard.this);
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
                        Toast.makeText(ActivityDashboard.this, "Log out successful", Toast.LENGTH_LONG).show();
//                        Here add the logics to logout the user from the system
                        dialog.dismiss();
                    }
                });
            }
        });
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDashboard.this,ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}