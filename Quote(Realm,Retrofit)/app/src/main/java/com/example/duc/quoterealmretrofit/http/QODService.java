package com.example.duc.quoterealmretrofit.http;

import com.example.duc.quoterealmretrofit.models.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DUC on 11/4/2016.
 */

public interface QODService {
    @GET("wp-json/posts?filter[orderby]=rand&filter[posts_per_page]=1")
    Call<Quote[]> getQuote();
}
