package com.example.travelappoctober2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText ageEditText;
    private Button saveProfileButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_profile);

        firstNameEditText = findViewById(R.id.editTextFirstName);
        lastNameEditText = findViewById(R.id.editTextLastName);
        emailEditText = findViewById(R.id.editTextEmail);
        ageEditText = findViewById(R.id.editTextAge);
        saveProfileButton = findViewById(R.id.buttonSaveProfile);

        user = new User("", "", "", 0);

        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String ageStr = ageEditText.getText().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || ageStr.isEmpty()) {
                    Toast.makeText(UserProfileActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    int age = Integer.parseInt(ageStr);

                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setAge(age);

                    String userFirstName = user.getFirstName();
                    String userLastName = user.getLastName();
                    String userEmail = user.getEmail();
                    int userAge = user.getAge();

                    Intent intent = new Intent(UserProfileActivity.this, DestinationSelectionActivity.class);
                    startActivity(intent);

                    Toast.makeText(UserProfileActivity.this, "Profil enregistré avec succès", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retourner à la page d'accueil (HomeActivity)
                Intent homeIntent = new Intent(UserProfileActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
