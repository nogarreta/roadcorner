package com.travelappoctober2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.travelappoctober2023.R;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button createAccountButton = findViewById(R.id.createAccountButton);
        Button generalInfoButton = findViewById(R.id.generalInfoButton);
        Button connectionButton = findViewById(R.id.connectionButton);
        Button discoverButton = findViewById(R.id.discoverButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userProfileIntent = new Intent(HomeActivity.this, AccCreationActivity.class);
                startActivity(userProfileIntent);
            }
        });

        connectionButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent userConnectionIntent = new Intent(HomeActivity.this, ConnectionActivity.class);
               startActivity(userConnectionIntent);
           }
        });

        discoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent discoverContinentsIntent = new Intent(HomeActivity.this, DiscoverContinentsActivity.class);
                startActivity(discoverContinentsIntent);
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
