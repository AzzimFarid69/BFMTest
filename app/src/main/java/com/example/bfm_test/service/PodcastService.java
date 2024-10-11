package com.example.bfm_test.service;

import java.util.List;

import com.example.bfm_test.model.Podcast;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PodcastService {
    @GET("tests/endpoint.json")
    Call<List<Podcast>> getPodcast();
}
