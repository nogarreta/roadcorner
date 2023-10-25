package com.example.travelappoctober2023;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travelappoctober2023.utils.RequestCenter;

import java.util.List;

public class DiscoverContinentsActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_discover_continents);
        }
    public List test() {
        return RequestCenter.continentsQuery();
    }
}
