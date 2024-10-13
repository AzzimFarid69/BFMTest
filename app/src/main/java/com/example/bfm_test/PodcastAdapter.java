package com.example.bfm_test;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfm_test.model.Podcast;
import com.example.bfm_test.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {

    private List<Podcast> podcastList;

    private MediaPlayer mediaPlayer;

    private boolean isPlaying = false;
    private int currentlyPlayingPosition = -1;

    public PodcastAdapter(List<Podcast> podcastList) {
        this.podcastList = podcastList;
        this.mediaPlayer = new MediaPlayer();
    }

    @NonNull
    @Override
    public PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.podcast_item, parent, false);
        return new PodcastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastViewHolder holder, int position) {
        Podcast podcast = podcastList.get(position);

        if (position == currentlyPlayingPosition && mediaPlayer.isPlaying()) {
            holder.playButton.setImageResource(R.drawable.pause_button);
        } else {
            holder.playButton.setImageResource(R.drawable.play_button);
        }

        if (Objects.equals(podcast.getType(), "podcast")) {
            holder.liveStreamHolder.setVisibility(View.GONE);
            holder.podcastHolder.setVisibility(View.VISIBLE);
            holder.title.setText(podcast.getTitle());
            holder.subtitle.setText(podcast.getSubtitle().toString());
            holder.dateTime.setText(DateUtils.formatUnixTimestamp(Long.parseLong(podcast.getData().getPublishedon())));
            if (podcast.getData().getFbimage() != null) {
                Picasso.get()
                        .load(podcast.getData().getFbimage())
                        .placeholder(R.drawable.musical_note)
                        .error(R.drawable.error)
                        .into(holder.thumbnail);
            }  else {
                holder.thumbnail.setImageResource(R.drawable.musical_note); // Default image if URL is null
            }
            holder.playButton.setOnClickListener(v -> {
                handlePlayPause(holder, podcast, position);
            });
        } else {
            holder.liveStreamHolder.setVisibility(View.VISIBLE);
            holder.podcastHolder.setVisibility(View.GONE);
            holder.lsTitle.setText(podcast.getTitle());
            holder.lsButton.setImageResource(R.drawable.play_button);
            holder.lsButton.setOnClickListener(v -> {
                if (isPlaying) {
                    pauseLivestream(holder);
                } else {
                    playLivestream(podcast.getSource(), holder
                    );
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    private void handlePlayPause(PodcastViewHolder holder, Podcast podcast, int position) {
        if (currentlyPlayingPosition != position) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();

            currentlyPlayingPosition = position;
            playPodcast(podcast.getData().getMp3(), holder);
        } else {
            if (mediaPlayer.isPlaying()) {
                pausePodcast(holder);
            } else {
                resumePodcast(holder);
            }
        }
    }

    private void playPodcast(String podcastUrl, PodcastViewHolder holder) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(podcastUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(mp -> {
                mp.start();
                holder.playButton.setImageResource(R.drawable.pause_button);
                holder.lsButton.setImageResource(R.drawable.play_button);
            });
            mediaPlayer.setOnCompletionListener(mp -> {
                holder.playButton.setImageResource(R.drawable.play_button); // Reset button to play icon when stream ends
                currentlyPlayingPosition = -1; // Reset the currently playing position
            }); // Set to pause icon
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resumePodcast(PodcastViewHolder holder) {
        mediaPlayer.start();
        holder.playButton.setImageResource(R.drawable.pause_button); // Set to pause icon
    }

    private void pausePodcast(PodcastViewHolder holder) {
        mediaPlayer.pause();
        holder.playButton.setImageResource(R.drawable.play_button); // Set to play icon
    }

    private void playLivestream(String url, PodcastViewHolder holder) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();

            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync(); // Prepare asynchronously to avoid blocking the UI
            mediaPlayer.setOnPreparedListener(mp -> {
                mp.start();
                isPlaying = true;
                holder.lsButton.setImageResource(R.drawable.pause_button);
                holder.playButton.setImageResource(R.drawable.pause_button);// Change to pause icon
            });

            mediaPlayer.setOnCompletionListener(mp -> {
                isPlaying = false;
                holder.lsButton.setImageResource(R.drawable.play_button);
                currentlyPlayingPosition = -1;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pauseLivestream(PodcastViewHolder podcastViewHolder) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            podcastViewHolder.lsButton.setImageResource(R.drawable.play_button); // Change back to play icon
        }
    }

    public static class PodcastViewHolder extends RecyclerView.ViewHolder {
        LinearLayout liveStreamHolder, podcastHolder, subtitleHolder;
        TextView lsTitle, title,  subtitle, dateTime;
        ImageView thumbnail;

        ImageButton lsButton, playButton;
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
            thumbnail = itemView.findViewById(R.id.thumbnail);
            lsButton = itemView.findViewById(R.id.lsButton);
            playButton = itemView.findViewById(R.id.playButton);
        }
    }
}
