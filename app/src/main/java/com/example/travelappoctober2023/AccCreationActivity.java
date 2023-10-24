package com.example.travelappoctober2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travelappoctober2023.models.UserM;

public class AccCreationActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText emailEditText;
    private EditText pwdEditText;
    private EditText pwdcEditText;
    private EditText phoneEditText;
    private Button saveProfileButton;
    private UserM user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_profile);
        userNameEditText = findViewById(R.id.editTextUserName);
        emailEditText = findViewById(R.id.editTextEmail);
        pwdEditText = findViewById(R.id.editTextPwd);
        pwdcEditText = findViewById(R.id.editTextPwdc);
        phoneEditText = findViewById(R.id.editTextPhone);
        saveProfileButton = findViewById(R.id.buttonSaveProfile);


        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String pwd = pwdEditText.getText().toString();
                String pwdc = pwdcEditText.getText().toString();
                String phone = phoneEditText.getText().toString();

                if (!pwdc.equals(pwd)) {
                    Toast.makeText(AccCreationActivity.this, "Veuillez-rentrer deux fois le même mot de passe", Toast.LENGTH_SHORT).show();
                } else if (userName.isEmpty() || email.isEmpty() || pwd.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(AccCreationActivity.this, "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_SHORT).show();
                } else {
                    user = new UserM(userName, email, phone, pwd);


                    Intent intent = new Intent(AccCreationActivity.this, ConnectionActivity.class);
                    startActivity(intent);

                    Toast.makeText(AccCreationActivity.this, "Profil enregistré avec succès", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retourner à la page d'accueil (HomeActivity)
                Intent homeIntent = new Intent(AccCreationActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
