package com.jalsoft.android.appenv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHome extends AppCompatActivity {
    CardView usersCard,resourceCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        usersCard = findViewById(R.id.usersCard);
        resourceCard = findViewById(R.id.resourceCard);
        usersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this, AdminUsersActivity.class);
                startActivity(intent);
            }
        });
        resourceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this, FilesList.class);
                startActivity(intent);
            }
        });
    }
}