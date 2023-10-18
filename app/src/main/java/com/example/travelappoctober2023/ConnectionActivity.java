package com.example.travelappoctober2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectionActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText pwdEditText;
    private Button connectionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        emailEditText = findViewById(R.id.editTextEmail);
        pwdEditText = findViewById(R.id.editTextPwd);

        ConnectionActivity connection = new ConnectionActivity();

        connectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String pwd = pwdEditText.getText().toString();

                if (email.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(ConnectionActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {



                    Intent intent = new Intent(ConnectionActivity.this, DestinationSelectionActivity.class);
                    startActivity(intent);

                    Toast.makeText(ConnectionActivity.this, "Profil enregistré avec succès", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
