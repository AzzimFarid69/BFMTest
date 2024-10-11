package com.example.bfm_test;

import android.os.Bundle;

import com.example.bfm_test.client.RetrofitClient;
import com.example.bfm_test.model.Podcast;
import com.example.bfm_test.service.PodcastService;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfm_test.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private List<Podcast> podcasts = new ArrayList<>();

    private RecyclerView recyclerView;

    private PodcastAdapter podcastAdapter;

    private void fetchPodcastData() {
        PodcastService service = RetrofitClient.getRetrofitInstance().create(PodcastService.class);
        Call<List<Podcast>> call = service.getPodcast();
        call.enqueue(new Callback<List<Podcast>>() {
            @Override
            public void onResponse(Call<List<Podcast>> call, Response<List<Podcast>> response) {
                if (response.isSuccessful()) {
                    podcasts = response.body();
                    podcastAdapter = new PodcastAdapter(podcasts);
                    recyclerView.setAdapter(podcastAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Podcast>> call, Throwable t) {
                Log.e("MainActivity", "Error fetching data: " + t.getMessage());
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


        fetchPodcastData();
    }
}