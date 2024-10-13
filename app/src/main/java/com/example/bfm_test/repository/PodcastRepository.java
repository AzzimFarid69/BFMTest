package com.example.bfm_test.repository;


import com.example.bfm_test.callback.PodcastCallback;
import com.example.bfm_test.client.RetrofitClient;
import com.example.bfm_test.model.Podcast;
import com.example.bfm_test.service.PodcastService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PodcastRepository {

    public void fetchPodcastData(PodcastCallback callback) {
        PodcastService service = RetrofitClient.getRetrofitInstance().create(PodcastService.class);
        Call<List<Podcast>> call = service.getPodcast();

        call.enqueue(new Callback<List<Podcast>>() {
            @Override
            public void onResponse(Call<List<Podcast>> call, Response<List<Podcast>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<Podcast>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
