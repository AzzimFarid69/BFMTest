package com.example.bfm_test.ui;

import android.os.Bundle;

import com.example.bfm_test.R;
import com.example.bfm_test.callback.PodcastCallback;
import com.example.bfm_test.model.Podcast;
import com.example.bfm_test.repository.PodcastRepository;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfm_test.databinding.ActivityMainBinding;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private List<Podcast> podcasts = new ArrayList<>();

    private RecyclerView recyclerView;

    private PodcastAdapter podcastAdapter;

    private LinearLayout errorHolder, loadingHolder;

    private Button refreshButton;

    private PodcastRepository podcastRepository = new PodcastRepository();

    private void displayLoading() {
        loadingHolder.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        errorHolder.setVisibility(View.GONE);
    }

    private void displayPodcast(List<Podcast> podcasts) {
        loadingHolder.setVisibility(View.GONE);
        errorHolder.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        podcastAdapter = new PodcastAdapter(podcasts);
        recyclerView.setAdapter(podcastAdapter);
    }

    private void displayError() {
        errorHolder.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        loadingHolder.setVisibility(View.GONE);
    }

    private void fetchPodcastData() {
        displayLoading();
        podcastRepository.fetchPodcastData(new PodcastCallback() {
            @Override
            public void onSuccess(List<Podcast> podcasts) {
                displayPodcast(podcasts);
            }

            @Override
            public void onFailure() {
                displayError();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        errorHolder = findViewById(R.id.errorHolder);
        loadingHolder = findViewById(R.id.loadingHolder);
        refreshButton = findViewById(R.id.refreshBtn);

        refreshButton.setOnClickListener(v -> {
            fetchPodcastData();
        });


        fetchPodcastData();
    }
}