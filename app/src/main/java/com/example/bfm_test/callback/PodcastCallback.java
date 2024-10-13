package com.example.bfm_test.callback;

import com.example.bfm_test.model.Podcast;

import java.util.List;

public interface PodcastCallback {
    void onSuccess(List<Podcast> podcasts);
    void onFailure();
}
