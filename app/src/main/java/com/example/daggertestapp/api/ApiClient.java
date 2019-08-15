package com.example.daggertestapp.api;

import com.example.daggertestapp.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>>getReposForUser(@Path("user")String user);
}
