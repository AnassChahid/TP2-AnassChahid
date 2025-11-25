package com.example.clubmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class ClubDetailsActivity extends AppCompatActivity {
    private ImageView clubLogo;
    private TextView clubName;
    rivate TextView clubnthing;
    private TextView clubSlogan;
    private TextView clubDescription;
    private RecyclerView membersRecyclerView;
    private MaterialButton joinButton;
    private MaterialButton viewEventsButton;
    private boolean isMember = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Club Details");

        // Initialize views
        initializeViews();
        setupClickListeners();
        loadClubDetails();
        setupMembersList();
    }

    private void initializeViews() {
        clubLogo = findViewById(R.id.clubLogo);
        clubName = findViewById(R.id.clubName);
        clubSlogan = findViewById(R.id.clubSlogan);
        clubDescription = findViewById(R.id.clubDescription);
        membersRecyclerView = findViewById(R.id.membersRecyclerView);
        joinButton = findViewById(R.id.joinButton);
        viewEventsButton = findViewById(R.id.viewEventsButton);
    }

    private void setupClickListeners() {
        joinButton.setOnClickListener(v -> {
            isMember = !isMember;
            updateJoinButton();
            Toast.makeText(this, 
                isMember ? "Joined the club!" : "Left the club", 
                Toast.LENGTH_SHORT).show();
        });

        viewEventsButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ClubEventsActivity.class);
            intent.putExtra("CLUB_ID", getIntent().getIntExtra("CLUB_ID", -1));
            startActivity(intent);
        });
    }

    private void loadClubDetails() {
        // In a real app, this would load from an API
        // For demo, we'll use static data
        int clubId = getIntent().getIntExtra("CLUB_ID", -1);
        
        // Load club details based on ID
        clubName.setText("Programming Club");
        clubSlogan.setText("Code your way to success");
        clubDescription.setText("Join our programming club to learn coding, participate in hackathons, and build amazing projects with fellow students.");
        
        // Load club logo
        Picasso.get()
                .load("https://via.placeholder.com/150")
                .placeholder(R.drawable.ic_launcher)
                .error(R.drawable.ic_launcher)
                .into(clubLogo);
    }

    private void setupMembersList() {
        membersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> members = getDummyMembers();
        MemberAdapter adapter = new MemberAdapter(members);
        membersRecyclerView.setAdapter(adapter);
    }

    private void updateJoinButton() {
        joinButton.setText(isMember ? "Leave Club" : "Join Club");
        joinButton.setBackgroundTintList(getColorStateList(
            isMember ? R.color.design_default_color_error : R.color.design_default_color_primary));
    }

    private List<String> getDummyMembers() {
        List<String> members = new ArrayList<>();
        members.add("John Doe");
        members.add("Jane Smith");
        members.add("Mike Johnson");
        members.add("Sarah Williams");
        members.add("David Brown");
        return members;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 