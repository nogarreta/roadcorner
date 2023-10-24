package com.example.travelappoctober2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
                Intent discoverIntent = new Intent(HomeActivity.this, DiscoverContinentsActivity.class);
                startActivity(discoverIntent);
            }
        });

        generalInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
                Intent infoIntent = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(infoIntent);
            }
        });
    }
    public void test(){
        String graphqlEndpoint = "https://countries.trevorblades.com/graphql";
        OkHttpClient client = new OkHttpClient();

        String graphqlQuery = "query Query {\n" +
                "  country(code: \"BR\") {\n" +
                "    name\n" +
                "    native\n" +
                "    capital\n" +
                "    emoji\n" +
                "    currency\n" +
                "    languages {\n" +
                "      code\n" +
                "      name\n" +
                "    }\n" +
                "  }\n" +
                "}";

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"query\":\"" + graphqlQuery.replace("\"", "\\\"") + "\"}");

        Request request = new Request.Builder()
                .url(graphqlEndpoint)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseData = response.body().string();
            System.out.println("Response: " + responseData);
            Toast.makeText(HomeActivity.this, responseData, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
