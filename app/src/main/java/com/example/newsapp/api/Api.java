package com.example.newsapp.api;

import com.example.newsapp.model.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
  @GET("top-headlines")
  Call<NewsList> getNewsList(@Query("country") String country, @Query("apiKey") String apiKey);
}
