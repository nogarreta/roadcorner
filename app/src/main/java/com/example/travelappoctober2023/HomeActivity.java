package com.example.travelappoctober2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button createAccountButton = findViewById(R.id.createAccountButton);
        Button generalInfoButton = findViewById(R.id.generalInfoButton);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userProfileIntent = new Intent(HomeActivity.this, UserProfileActivity.class);
                startActivity(userProfileIntent);
            }
        });

        generalInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(infoIntent);
            }
        });
    }
}
