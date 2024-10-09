package service;

import java.util.List;

import model.Podcast;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PodcastService {
    @GET("tests/endpoint.json")
    Call<List<Podcast>> getPodcast();
}
