package com.example.clubmanagement;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clubmanagement.adapters.GalleryAdapter;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView eventTitle;
    private TextView eventDate;
    private TextView eventLocation;
    private TextView eventStatus;
    private RecyclerView galleryRecyclerView;
    private MaterialButton registerButton;
    private boolean isRegistered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event Details");

        // Initialize views
        initializeViews();
        setupClickListeners();
        loadEventDetails();
        setupGallery();
    }

    private void initializeViews() {
        eventTitle = findViewById(R.id.eventTitle);
        eventDate = findViewById(R.id.eventDate);
        eventLocation = findViewById(R.id.eventLocation);
        eventStatus = findViewById(R.id.eventStatus);
        galleryRecyclerView = findViewById(R.id.galleryRecyclerView);
        registerButton = findViewById(R.id.registerButton);
    }

    private void setupClickListeners() {
        registerButton.setOnClickListener(v -> {
            isRegistered = !isRegistered;
            updateRegisterButton();
            Toast.makeText(this,
                isRegistered ? "Registered for event!" : "Unregistered from event",
                Toast.LENGTH_SHORT).show();
        });
    }

    private void loadEventDetails() {
        // In a real app, this would load from an API
        // For demo, we'll use static data
        int eventId = getIntent().getIntExtra("EVENT_ID", -1);
        
        // Load event details based on ID
        eventTitle.setText("Weekly Coding Session");
        eventDate.setText("March 15, 2024 - 2:00 PM");
        eventLocation.setText("Room 101, Computer Science Building");
        eventStatus.setText("Upcoming");
    }

    private void setupGallery() {
        galleryRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        List<String> images = getDummyImages();
        GalleryAdapter adapter = new GalleryAdapter(images);
        galleryRecyclerView.setAdapter(adapter);
    }

    private void updateRegisterButton() {
        registerButton.setText(isRegistered ? "Unregister" : "Register for Event");
        registerButton.setBackgroundTintList(getColorStateList(
            isRegistered ? R.color.design_default_color_error : R.color.design_default_color_primary));
    }

    private List<String> getDummyImages() {
        List<String> images = new ArrayList<>();
        images.add("https://via.placeholder.com/300");
        images.add("https://via.placeholder.com/300");
        images.add("https://via.placeholder.com/300");
        images.add("https://via.placeholder.com/300");
        return images;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 