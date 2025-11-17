package com.example.clubmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clubmanagement.adapters.EventAdapter;
import com.example.clubmanagement.models.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class ClubEventsActivity extends AppCompatActivity {
    private RecyclerView eventsRecyclerView;
    private FloatingActionButton createEventFab;
    private String userRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_events);

        // Get user role from intent
        userRole = getIntent().getStringExtra("USER_ROLE");

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Club Events");

        // Initialize views
        eventsRecyclerView = findViewById(R.id.eventsRecyclerView);
        createEventFab = findViewById(R.id.createEventFab);

        // Setup RecyclerView
        setupEventsList();

        // Setup FAB visibility based on user role
        setupFabVisibility();

        // Setup FAB click listener
        createEventFab.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateEventActivity.class);
            intent.putExtra("CLUB_ID", getIntent().getIntExtra("CLUB_ID", -1));
            startActivity(intent);
        });
    }

    private void setupEventsList() {
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Event> events = getDummyEvents();
        EventAdapter adapter = new EventAdapter(events, event -> {
            Intent intent = new Intent(this, EventDetailsActivity.class);
            intent.putExtra("EVENT_ID", event.getId());
            startActivity(intent);
        });
        eventsRecyclerView.setAdapter(adapter);
    }

    private void setupFabVisibility() {
        // Only show FAB for club responsible users
        createEventFab.setVisibility(
            "RESPONSIBLE".equals(userRole) ? View.VISIBLE : View.GONE
        );
    }

    private List<Event> getDummyEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, "Weekly Coding Session", "2024-03-15", "Room 101"));
        events.add(new Event(2, "Hackathon Workshop", "2024-03-20", "Main Hall"));
        events.add(new Event(3, "Guest Speaker: AI in 2024", "2024-03-25", "Auditorium"));
        return events;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 