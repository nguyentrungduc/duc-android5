package com.example.duc.loginretrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by DUC on 11/5/2016.
 */

public interface LoginService {
    @POST("/api/login")
    Call<ResultLoginJsonModel> login(@Body RequestBody body);
}
