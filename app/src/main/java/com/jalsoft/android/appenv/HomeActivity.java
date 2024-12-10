package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
     Button joinCommunity,joinEducation,joinDonate,joinCarbon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        joinCommunity = findViewById(R.id.joinCommunity);
        joinEducation = findViewById(R.id.joinEdu);
        joinDonate = findViewById(R.id.joinDonation);
        joinCarbon = findViewById(R.id.joinCarbon);
        joinEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,LearnActivity.class);
                startActivity(intent);
            }
        });
        joinCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,DiscussActivity.class);
                startActivity(intent);
            }
        });
        joinDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,DonateActivity.class);
                startActivity(intent);
            }
        });
        joinCarbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}