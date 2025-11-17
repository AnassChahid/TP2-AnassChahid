package com.example.clubmanagement;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CreateEventActivity extends AppCompatActivity {
    private TextInputEditText eventTitleInput;
    private TextInputEditText eventDateInput;
    private TextInputEditText eventTimeInput;
    private TextInputEditText eventLocationInput;
    private TextInputEditText eventCapacityInput;
    private TextInputEditText eventDescriptionInput;
    private MaterialButton createEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Create Event");

        // Initialize views
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        eventTitleInput = findViewById(R.id.eventTitleInput);
        eventDateInput = findViewById(R.id.eventDateInput);
        eventTimeInput = findViewById(R.id.eventTimeInput);
        eventLocationInput = findViewById(R.id.eventLocationInput);
        eventCapacityInput = findViewById(R.id.eventCapacityInput);
        eventDescriptionInput = findViewById(R.id.eventDescriptionInput);
        createEventButton = findViewById(R.id.createEventButton);
    }

    private void setupClickListeners() {
        createEventButton.setOnClickListener(v -> {
            if (validateInputs()) {
                // In a real app, this would send data to an API
                Toast.makeText(this, "Event created successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;

        if (eventTitleInput.getText().toString().trim().isEmpty()) {
            eventTitleInput.setError("Title is required");
            isValid = false;
        }

        if (eventDateInput.getText().toString().trim().isEmpty()) {
            eventDateInput.setError("Date is required");
            isValid = false;
        }

        if (eventTimeInput.getText().toString().trim().isEmpty()) {
            eventTimeInput.setError("Time is required");
            isValid = false;
        }

        if (eventLocationInput.getText().toString().trim().isEmpty()) {
            eventLocationInput.setError("Location is required");
            isValid = false;
        }

        if (eventCapacityInput.getText().toString().trim().isEmpty()) {
            eventCapacityInput.setError("Capacity is required");
            isValid = false;
        }

        if (eventDescriptionInput.getText().toString().trim().isEmpty()) {
            eventDescriptionInput.setError("Description is required");
            isValid = false;
        }

        return isValid;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 