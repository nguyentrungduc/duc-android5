package com.example.duc.ss18.network;

import com.example.duc.ss18.jsonmodels.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DUC on 11/2/2016.
 */

public interface GitHubService {
    @GET("users/{username}/repos")
    Call<List<Repo>> listRepo(@Path("username") String username);

}
