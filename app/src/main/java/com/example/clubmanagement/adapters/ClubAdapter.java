package com.example.clubmanagement.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clubmanagement.R;
import com.example.clubmanagement.models.Club;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {
    private List<Club> clubs;
    private OnClubClickListener listener;

    public interface OnClubClickListener {
        void onClubClick(Club club);
    }

    public ClubAdapter(List<Club> clubs, OnClubClickListener listener) {
        this.clubs = clubs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_club, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        Club club = clubs.get(position);
        holder.bind(club);
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {
        private ImageView logoImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;

        ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            logoImageView = itemView.findViewById(R.id.clubLogo);
            nameTextView = itemView.findViewById(R.id.clubName);
            descriptionTextView = itemView.findViewById(R.id.clubDescription);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onClubClick(clubs.get(position));
                }
            });
        }

        void bind(Club club) {
            nameTextView.setText(club.getName());
            descriptionTextView.setText(club.getDescription());
            Picasso.get()
                    .load(club.getLogoUrl())
                    .placeholder(R.drawable.ic_launcher)
                    .error(R.drawable.ic_launcher)
                    .into(logoImageView);
        }
    }
} 