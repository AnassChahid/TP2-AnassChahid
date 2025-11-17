package com.example.clubmanagement;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;

public class ProfileActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView roleTextView;
    private MaterialButton editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");

        // Initialize views
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        roleTextView = findViewById(R.id.roleTextView);
        editButton = findViewById(R.id.editButton);

        // Load profile data (for demo, using static data)
        loadProfileData();

        // Setup edit button click listener
        editButton.setOnClickListener(v -> {
            Toast.makeText(this, "Edit profile functionality not implemented yet", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadProfileData() {
        // In a real app, this would load from an API or local storage
        nameTextView.setText("John Doe");
        emailTextView.setText("john.doe@example.com");
        roleTextView.setText("Student");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 