package com.example.bfm_test;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfm_test.model.Podcast;
import com.example.bfm_test.utils.DateUtils;

import java.util.List;
import java.util.Objects;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {

    private List<Podcast> podcastList;
    private Context context;

    public PodcastAdapter(List<Podcast> podcastList) {
        this.podcastList = podcastList;
    }

    @NonNull
    @Override
    public PodcastAdapter.PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.podcast_item, parent, false);
        return new PodcastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastAdapter.PodcastViewHolder holder, int position) {
        Podcast podcast = podcastList.get(position);
        if (Objects.equals(podcast.getType(), "podcast")) {
            holder.liveStreamHolder.setVisibility(View.GONE);
            holder.podcastHolder.setVisibility(View.VISIBLE);
            holder.title.setText(podcast.getTitle());
            holder.subtitle.setText(podcast.getSubtitle().toString());
            holder.dateTime.setText(podcast.getData().getPublishedon());
            holder.lsButton.setImageResource(R.drawable.play_button);
            holder.dateTime.setText(DateUtils.formatUnixTimestamp(Long.parseLong(podcast.getData().getPublishedon())));
            Log.d("Test podcast " + position, podcast.getSubtitle().toString());
        } else {
            holder.liveStreamHolder.setVisibility(View.VISIBLE);
            holder.podcastHolder.setVisibility(View.GONE);
            holder.lsTitle.setText(podcast.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    public static class PodcastViewHolder extends RecyclerView.ViewHolder {
        LinearLayout liveStreamHolder, podcastHolder, subtitleHolder;
        TextView lsTitle, title,  subtitle, dateTime;

        ImageButton lsButton;
        public PodcastViewHolder(@NonNull View itemView) {
            super(itemView);
            liveStreamHolder = itemView.findViewById(R.id.liveStreamHolder);
            podcastHolder = itemView.findViewById(R.id.podcastHolder);
            subtitleHolder = itemView.findViewById(R.id.subtitleHolder);
            lsTitle = itemView.findViewById(R.id.lsTitle);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            dateTime = itemView.findViewById(R.id.dateTime);
            lsButton = itemView.findViewById(R.id.lsButton);
        }
    }
}
