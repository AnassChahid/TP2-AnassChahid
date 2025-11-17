package com.example.clubmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView clubsRecyclerView;
    private RecyclerView eventsRecyclerView;
    private BottomNavigationView bottomNavigation;
    private String userRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Get user role from intent
        userRole = getIntent().getStringExtra("USER_ROLE");

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");

        // Initialize views
        clubsRecyclerView = findViewById(R.id.clubsRecyclerView);
        eventsRecyclerView = findViewById(R.id.eventsRecyclerView);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        // Setup RecyclerViews
        setupClubsRecyclerView();
        setupEventsRecyclerView();

        // Setup bottom navigation
        setupBottomNavigation();
    }

    private void setupClubsRecyclerView() {
        clubsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Club> clubs = getDummyClubs();
        ClubAdapter clubAdapter = new ClubAdapter(clubs, club -> {
            Intent intent = new Intent(this, ClubDetailsActivity.class);
            intent.putExtra("CLUB_ID", club.getId());
            startActivity(intent);
        });
        clubsRecyclerView.setAdapter(clubAdapter);
    }

    private void setupEventsRecyclerView() {
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Event> events = getDummyEvents();
        EventAdapter eventAdapter = new EventAdapter(events, event -> {
            Intent intent = new Intent(this, EventDetailsActivity.class);
            intent.putExtra("EVENT_ID", event.getId());
            startActivity(intent);
        });
        eventsRecyclerView.setAdapter(eventAdapter);
    }

    private void setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            } else if (itemId == R.id.navigation_logout) {
                // Navigate back to login
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                return true;
            }
            return false;
        });
    }

    // Dummy data methods
    private List<Club> getDummyClubs() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club(1, "Programming Club", "Code your way to success"));
        clubs.add(new Club(2, "Photography Club", "Capture the moment"));
        clubs.add(new Club(3, "Music Club", "Let the music play"));
        return clubs;
    }

    private List<Event> getDummyEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, "Hackathon 2024", "2024-03-15", "Main Hall"));
        events.add(new Event(2, "Photo Exhibition", "2024-03-20", "Art Gallery"));
        events.add(new Event(3, "Spring Concert", "2024-04-01", "Auditorium"));
        return events;
    }
} 